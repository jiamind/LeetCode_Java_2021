import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 3Sum
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            int complement = nums[left] * -1;
            int mid = left + 1, right = nums.length - 1;
            while (mid < right) {
                if (nums[mid] + nums[right] == complement) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    mid++;
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (nums[mid] + nums[right] < complement) {
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
