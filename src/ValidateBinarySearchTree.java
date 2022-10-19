/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Integer[] result = analyzeBinaryTree(root);
        return result[0] > 0;
    }

    /**
     * return an Integer array result[] of size 3:
     * result[0]: 1 if tree is valid BST, -1 otherwise
     * result[1]: min of all child nodes
     * result[2]: max of all child nodes 
     */
    private Integer[] analyzeBinaryTree(TreeNode node) {
        Integer[] result =  new Integer[3];
        result[1] = null;
        result[2] = null;

        if (node == null) {
            result[0] = 1;
            return result;
        }

        Integer[] left = analyzeBinaryTree(node.left);
        Integer[] right = analyzeBinaryTree(node.right);
        // if either left subtree or right subtree is invalid
        // return invalid
        if (left[0] < 0 || right[0] < 0) {
            result[0] = -1;
            return result;
        }

        // more invalid cases
        if ((left[2] != null && left[2] >= node.val) || 
                (right[1] != null && right[1] <= node.val)) {
            result[0] = -1;
            return result;
        }

        result[0] = 1;
        result[1] = left[1] == null ? node.val : left[1];
        result[2] = right[2] == null ? node.val : right[2];

        return result;
    }
}