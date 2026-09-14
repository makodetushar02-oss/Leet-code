class Solution {
public:
    bool isRectangleOverlap(vector<int>& rec1, vector<int>& rec2) {
        bool isLeft = rec1[2] <= rec2[0];  
        bool isRight = rec1[0] >= rec2[2]; 
        bool isBelow = rec1[3] <= rec2[1]; 
        bool isAbove = rec1[1] >= rec2[3]; 
        if (isLeft || isRight || isBelow || isAbove) {
            return false;
        }
        return true;
    }
};