class Solution {
public:
    int missingInteger(std::vector<int>& nums) {
        int prefix_sum = nums[0];
        
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                prefix_sum += nums[i];
            } else {
                break;
            }
        }
        std::unordered_set<int> num_set(nums.begin(), nums.end());
        while (num_set.count(prefix_sum)) {
            prefix_sum++;
        }
        return prefix_sum;
    }
};