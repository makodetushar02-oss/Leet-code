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
    int index = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i],i);
        }
        return solve(preorder , 0,inorder.length-1);
    }
    private TreeNode solve(int[] preorder ,int start,int end){
        if(start > end) return null;
        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        int mid = map.get(val);
        root.left = solve(preorder ,  start,mid-1);
        root.right = solve(preorder ,  mid+1,end);
        return root;
    }
}