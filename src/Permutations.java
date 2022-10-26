import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums[0]);
            result.add(permutation);
            return result;
        }

        int current = nums[0];
        List<List<Integer>> subPerms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> subPerm : subPerms) {
            for (int i = 0; i <= subPerm.size(); i++) {
                List<Integer> perm = new ArrayList<>(subPerm);
                perm.add(i, current);
                result.add(perm);
            }
        }

        return result;
    }
}
