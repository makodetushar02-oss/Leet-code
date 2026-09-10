/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    int matchCount = 0;
    std::pair<int, int> postOrder(TreeNode* node) {
        if (node == nullptr) {
            return {0, 0};
        }
        std::pair<int, int> left = postOrder(node->left);
        std::pair<int, int> right = postOrder(node->right);
        int currentSum = left.first + right.first + node->val;
        int currentCount = left.second + right.second + 1;
        if (currentSum / currentCount == node->val) {
            matchCount++;
        }
        
        return {currentSum, currentCount};
    }

public:
    int averageOfSubtree(TreeNode* root) {
        postOrder(root);
        return matchCount;
    }
};