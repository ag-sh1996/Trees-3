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
 //TC: O(N^2)
 //SC: O(h)
 class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        this.result = new ArrayList<>();
        helper(root, 0 , new ArrayList<>());
        return result;
    }
    private void helper(TreeNode root, int currSum, List<Integer> path){
        //base
        if(root == null) return;
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(currSum == target) 
                //result.add(path);
                result.add(new ArrayList<>(path));
        }
        //helper(root.left, currSum, new ArrayList<>(path));
        //helper(root.right, currSum, new ArrayList<>(path));
        helper(root.left, currSum, path);
        helper(root.right, currSum, path);
        path.remove(path.size() - 1);
    }
}