#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> gcdValues(vector<int>& nums, vector<long long>& queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = max(maxVal, num);
        }
        vector<int> count(maxVal + 1, 0);
        for (int num : nums) {
            count[num]++;
        }
        vector<long long> exactCount(maxVal + 1, 0);
        for (int i = maxVal; i >= 1; i--) {
            long long multiplesCount = 0;
            for (int j = i; j <= maxVal; j += i) {
                multiplesCount += count[j];
            }
            long long pairs = (multiplesCount * (multiplesCount - 1)) / 2;
            for (int j = 2 * i; j <= maxVal; j += i) {
                pairs -= exactCount[j];
            }
            
            exactCount[i] = pairs;
        }
        vector<long long> prefixSum(maxVal + 1, 0);
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + exactCount[i];
        }
        vector<int> result(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            auto it = upper_bound(prefixSum.begin() + 1, prefixSum.end(), queries[i]);
            result[i] = distance(prefixSum.begin(), it);
        }
        return result;
    }
};