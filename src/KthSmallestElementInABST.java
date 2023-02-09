import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findKthSmallest(root, k, result);
        return result.get(k - 1);
    }

    private void findKthSmallest(TreeNode root, int k, List<Integer> result) {
        if (result.size() == k) {
            return;
        }

        if (root.left != null)
            findKthSmallest(root.left, k, result);
        result.add(root.val);
        if (root.right != null)
            findKthSmallest(root.right, k, result);
    }
}