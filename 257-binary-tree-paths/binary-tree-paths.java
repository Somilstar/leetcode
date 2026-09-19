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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root!=null){
            explore(root,"",result);
        }
        return result;
    }
    private void explore(TreeNode node, String currentPath, List<String> result){
        currentPath += node.val;

        if(node.left == null && node.right==null){
            result.add(currentPath);
            return;
        }
        if(node.left!=null){
            explore(node.left, currentPath + "->", result);
        }
        if(node.right!=null){
            explore(node.right,currentPath + "->",result);
        }
    }
}