class Solution {
    public int maxDepth(TreeNode root) {
       return height(root);
    }
    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    }
