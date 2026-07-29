class Solution {
public:
    string smallestPalindrome(string s, int k) {
        vector<int> freq(26 , 0);
        for(char c : s){
            freq[c - 'a']++;
        }
        vector<int> half_freq(26 , 0);
        char mid_char = 0;
        for(int i =0 ; i< 26; ++i){
            half_freq[i] = freq[i] / 2;
            if(freq[i] % 2 != 0){
                mid_char = i + 'a';
            }
        }
        int n = s.length();
        int m = n/2;
        auto get_perms = [&](const vector<int> & f, int target_k) -> long long{
            long long res = 1;
            int total_len = 0 ;
            for(int count : f){
                for(int j = 1 ;j<= count ; ++j ){
                    total_len++;
                    res = (res * total_len) /j;
                    if(res > target_k) return target_k +1 ;
                }
            }
            return res ;
        } ;
        long long total_perms = get_perms(half_freq , k);
        if(total_perms < k ){
            return "";
        }
        string first_half = "";
        for(int i = 0 ; i < m; ++i){
            for(int c = 0; c< 26 ; ++c){
                if( half_freq[c] > 0){
                    half_freq[c]-- ;
                    long long p = get_perms(half_freq , k);
                    if(k <= p){
                        first_half += (char)(c + 'a');
                        break ;
                    }else{
                        k -= p ;
                        half_freq[c]++ ; 
                    }
                }
            }
        }
        string result = first_half;
        if(n%2 != 0){
            result += mid_char;
        }
        string second_half = first_half;
        reverse(second_half.begin() , second_half.end());
        result += second_half;
        return result;
    }
};