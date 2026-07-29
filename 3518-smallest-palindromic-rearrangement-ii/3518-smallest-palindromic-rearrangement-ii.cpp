class Solution {
public:
    string smallestPalindrome(string s, int k) {
        array<int, 26> freq{};
        for (char c : s) freq[c - 'a']++;
        array<int, 26> half_freq{};
        char mid_char = 0;
        for (int i = 0; i < 26; ++i) {
            half_freq[i] = freq[i] / 2;
            if (freq[i] & 1) mid_char = static_cast<char>(i + 'a');
        }
        const int n = static_cast<int>(s.size());
        const int m = n / 2;
        long long K = k;
        auto get_perms = [](const array<int, 26>& f, long long target_k) -> long long {
            long long res = 1;
            long long total_len = 0;
            for (int count : f) {
                if (count == 0) continue;
                if (total_len == 0) {
                    total_len = count;   
                    continue;
                }
                long long N = total_len + count;
                long long r = min<long long>(count, total_len);
                for (long long i = 1; i <= r; ++i) {
                    res = res * (N - r + i) / i;  
                    if (res > target_k) return target_k + 1;
                }
                total_len = N;
            }
            return res;
        };
        long long total_perms = get_perms(half_freq, K);
        if (total_perms < K) return "";
        string first_half;
        first_half.reserve(m);
        for (int i = 0; i < m; ++i) {
            for (int c = 0; c < 26; ++c) {
                if (half_freq[c] == 0) continue;
                half_freq[c]--;
                long long p = get_perms(half_freq, K);
                if (K <= p) {
                    first_half += static_cast<char>(c + 'a');
                    break;
                }
                K -= p;
                half_freq[c]++;
            }
        }
        string result;
        result.reserve(n);
        result += first_half;
        if (n & 1) result += mid_char;
        result.append(first_half.rbegin(), first_half.rend());
        return result;
    }
};