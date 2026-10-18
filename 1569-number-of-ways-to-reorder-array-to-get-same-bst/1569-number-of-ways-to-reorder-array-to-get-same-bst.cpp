class Solution {
public:
    static constexpr long long MOD = 1'000'000'007;
    vector<vector<long long>> comb;

    long long ways(const vector<int>& nums) {
        if (nums.size() <= 2) return 1;

        vector<int> left, right;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < nums[0]) left.push_back(nums[i]);
            else right.push_back(nums[i]);
        }

        long long leftWays = ways(left);
        long long rightWays = ways(right);

        int L = left.size(), R = right.size();
        long long interleave = comb[L + R][L];

        return (((interleave * leftWays) % MOD) * rightWays) % MOD;
    }

    int numOfWays(vector<int>& nums) {
        int n = nums.size();
        comb.assign(n + 1, vector<long long>(n + 1, 0));
        for (int i = 0; i <= n; ++i) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        return (ways(nums) - 1 + MOD) % MOD;
    }
};