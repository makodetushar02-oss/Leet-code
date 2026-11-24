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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) { 
        List<List<Integer>> ans = new ArrayList<>(); 
        solve(root , targetSum , 0 , new ArrayList<>() , ans);
        return ans;
    }
    public void solve(TreeNode root, int target,int sum,List<Integer> curr ,List<List<Integer>> ans){
        if(root == null) return;
        curr.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == target ) {
            ans.add(new ArrayList<>(curr));
        }
        solve(root.left,target,sum,curr,ans); 
        solve(root.right,target,sum,curr,ans);
        curr.remove(curr.size()-1);
    }
}