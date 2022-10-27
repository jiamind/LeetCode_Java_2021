import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorOfABinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else if (root.val == p.val) {
            return p;
        } else if (root.val == q.val) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null && 
            ((left.val == p.val && right.val == q.val)|| (left.val == q.val && right.val == p.val))) {
            return root;
        } else if ((left != null && left.val == p.val) || (right != null && right.val == p.val)) {
            return p;
        } else if ((left != null && left.val == q.val) || (right != null && right.val == q.val)) {
            return q;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}