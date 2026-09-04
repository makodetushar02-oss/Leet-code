class Solution {
public:
    string lexPalindromicPermutation(string s, string target) {
        int n = s.length();
        vector<int> freq(26, 0);
        for (char c : s) {
            freq[c - 'a']++;
        }
        int odd_count = 0;
        int odd_char = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd_count++;
                odd_char = i;
            }
        }
        if (odd_count > 1) {
            return "";
        }
        vector<int> half_freq(26, 0);
        for (int i = 0; i < 26; i++) {
            half_freq[i] = freq[i] / 2;
        }
        int m = (n + 1) / 2;
        for (int i = m; i >= 0; i--) {
            vector<int> temp_half_freq = half_freq;
            bool can_form = true;
            for (int j = 0; j < i; j++) {
                int c = target[j] - 'a';
                if (n % 2 == 1 && j == n / 2) {
                    if (odd_char != c) {
                        can_form = false;
                        break;
                    }
                } else {
                    if (temp_half_freq[c] > 0) {
                        temp_half_freq[c]--;
                    } else {
                        can_form = false;
                        break;
                    }
                }
            }
            if (!can_form) continue;
            if (i == m) {
                string res(n, ' ');
                for (int j = 0; j < n / 2; j++) {
                    res[j] = target[j];
                    res[n - 1 - j] = target[j];
                }
                if (n % 2 == 1) res[n / 2] = target[n / 2];
                if (res > target) {
                    return res;
                }
            } else {
                int target_c = target[i] - 'a'; 
                if (n % 2 == 1 && i == n / 2) {
                    if (odd_char > target_c) {
                        string res(n, ' ');
                        for (int j = 0; j < i; j++) {
                            res[j] = target[j];
                            res[n - 1 - j] = target[j];
                        }
                        res[n / 2] = odd_char + 'a';
                        return res;
                    }
                } else {
                    int place_c = -1;
                    for (int c = target_c + 1; c < 26; c++) {
                        if (temp_half_freq[c] > 0) {
                            place_c = c;
                            break;
                        }
                    }
                    if (place_c != -1) {
                        temp_half_freq[place_c]--;
                        string res(n, ' ');
                        for (int j = 0; j < i; j++) {
                            res[j] = target[j];
                            res[n - 1 - j] = target[j];
                        }
                        res[i] = place_c + 'a';
                        res[n - 1 - i] = place_c + 'a';
                        int idx = i + 1;
                        for (int c = 0; c < 26; c++) {
                            while (temp_half_freq[c] > 0) {
                                res[idx] = c + 'a';
                                res[n - 1 - idx] = c + 'a';
                                idx++;
                                temp_half_freq[c]--;
                            }
                        }
                        if (n % 2 == 1) res[n / 2] = odd_char + 'a';
                        return res;
                    }
                }
            }
        }
        return "";
    }
};