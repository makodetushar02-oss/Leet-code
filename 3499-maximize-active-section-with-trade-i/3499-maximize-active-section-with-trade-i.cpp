class Solution {
public:
    int maxActiveSectionsAfterTrade(string s) {
        int n = (int)s.size();
        int original_ones = 0;
        for (char c : s) if (c == '1') original_ones++;
        vector<int> O, Z;
        O.push_back(1); 

        int idx = 0;
        while (idx < n && s[idx] == '1') { O.back()++; idx++; }

        while (idx < n) {
            int len = 0;
            while (idx < n && s[idx] == '0') { len++; idx++; }
            Z.push_back(len);

            int olen = 0;
            while (idx < n && s[idx] == '1') { olen++; idx++; }
            O.push_back(olen);
        }
        O.back()++; 

        int k = (int)Z.size();
        if (k < 2) return original_ones;
        array<pair<int,int>, 3> top{{{-1,-1}, {-1,-1}, {-1,-1}}};
        for (int j = 0; j < k; ++j) {
            int v = Z[j];
            if (v > top[0].first)      { top[2] = top[1]; top[1] = top[0]; top[0] = {v, j}; }
            else if (v > top[1].first) { top[2] = top[1]; top[1] = {v, j}; }
            else if (v > top[2].first) { top[2] = {v, j}; }
        }

        int max_delta = 0;
        for (int j = 1; j < k; ++j) {
            int O_len = O[j];
            int local_max = Z[j - 1] + Z[j];

            for (auto& p : top) {
                if (p.second != -1 && p.second != j - 1 && p.second != j) {
                    local_max = max(local_max, p.first - O_len);
                    break;
                }
            }
            max_delta = max(max_delta, local_max);
        }
        return original_ones + max_delta;
    }
};