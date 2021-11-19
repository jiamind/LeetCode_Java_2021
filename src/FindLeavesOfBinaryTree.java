import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 */
public class FindLeavesOfBinaryTree {

    public class TreeNode {
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

    List<List<Integer>> leaveList = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        AddLeaves(root);
        return leaveList;
    }

    private int AddLeaves(TreeNode node) {
        if (node == null) return -1;

        if (node.left == null && node.right == null) {
            while (leaveList.size() < 1) {
                leaveList.add(new ArrayList<>());
            }
            leaveList.get(0).add(node.val);
            return 0;
        }

        int leftNode = AddLeaves(node.left) + 1;
        int rightNode = AddLeaves(node.right) + 1;

        int value = Math.max(leftNode, rightNode);
        while (leaveList.size() < value + 1) {
            leaveList.add(new ArrayList<>());
        }
        leaveList.get(value).add(node.val);

        return value;
    }
}
