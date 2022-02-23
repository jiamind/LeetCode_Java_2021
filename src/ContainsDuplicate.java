import java.util.HashSet;

/**
 * 217. Contains Duplicate
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (numSet.contains(num)) return true;
            numSet.add(num);
        }

        return false;
    }
}
