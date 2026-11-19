/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxDefth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         maxdepth(root);
         return maxDefth;
    }
    private int maxdepth(TreeNode root){
        if(root == null) return 0;
        int lh = maxdepth(root.left);
        int rh = maxdepth(root.right);
        maxDefth = Math.max(lh + rh , maxDefth);
        return Math.max(lh,rh) +1;
    }
}