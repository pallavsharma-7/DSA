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
    public int maxDepth(TreeNode root) {
         
      int ans = maxdepth(root );
        return ans ;
    }

    int maxdepth(TreeNode root ){

        if(root == null){
            return 0 ; 
        }

       int leftmax =  maxdepth(root.left );
       int rightmax =  maxdepth(root.right );

        

        return 1 +  Math.max(leftmax, rightmax);


    }
}