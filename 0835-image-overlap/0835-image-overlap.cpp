class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        vector<pair<int, int>> ones1, ones2;
        int n = img1.size();
        
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                if (img1[r][c] == 1) ones1.push_back({r, c});
                if (img2[r][c] == 1) ones2.push_back({r, c});
            }
        }
        unordered_map<int, int> shiftCounts;
        int maxOverlap = 0;
        for (auto& p1 : ones1) {
            for (auto& p2 : ones2) {
                int dx = p2.first - p1.first + 30;
                int dy = p2.second - p1.second + 30;
                int key = dx * 100 + dy; 
                
                shiftCounts[key]++;
                maxOverlap = max(maxOverlap, shiftCounts[key]);
            }
        }
        
        return maxOverlap;
    }
};