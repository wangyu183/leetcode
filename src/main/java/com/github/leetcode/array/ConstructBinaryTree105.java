package com.github.leetcode.array;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
    
    For example, given
    
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:
    
        3
       / \
      9  20
        /  \
       15   7
 * @author wangyu
 *
 */
public class ConstructBinaryTree105 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if(left != null && right != null){
                return "TreeNode [val=" + val + ", left=" + left.toString() + ", right=" + right.toString() + "]";
            }else{
                return "TreeNode [val=" + val +  "]";  
            }
        }
        
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
           return buildTree(preorder,0,inorder,0,inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder,int preStart,int[] inorder,int inStart,int inEnd){
        if(inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = 0;
        for(int i = inStart; i <= inEnd; i ++){
            if(inorder[i] == root.val){
                inRoot = i;
                break;
            }
        }
        
        root.left = buildTree(preorder,preStart + 1, inorder,inStart, inRoot - 1);
        root.right = buildTree(preorder,preStart + inRoot - inStart + 1, inorder, inRoot + 1 ,inEnd);
        return root;
        
    }
    
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBinaryTree105 test = new ConstructBinaryTree105();
        TreeNode root = test.buildTree(preorder, inorder);
        System.out.println(root);
    }
    
}
