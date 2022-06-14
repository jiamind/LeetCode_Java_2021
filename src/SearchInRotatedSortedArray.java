/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int pivot = (start + end) / 2;
        if (nums[pivot] == target) {
            return pivot;
        }

        // Due to the way we pick pivot, the pivot can be start
        // In such cases, just search to the right of the pivot
        if (start == pivot) {
            return search(nums, target, pivot + 1, end);
        }

        if (nums[start] < nums[pivot]) {
            if (nums[start] <= target && target < nums[pivot]) {
                return search(nums, target, start, pivot - 1);
            } else {
                return search(nums, target, pivot + 1, end);
            }
        } else {
            if (nums[pivot] < target && target <= nums[end]) {
                return search(nums, target, pivot + 1, end);
            } else {
                return search(nums, target, start, pivot - 1);
            }
        }
    }
}
