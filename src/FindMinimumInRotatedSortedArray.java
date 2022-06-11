/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        int pivot = (start + end) / 2;
        if (pivot == start) return Math.min(nums[start], nums[end]);
        if (nums[pivot - 1] > nums[pivot] && nums[pivot + 1] > nums[pivot]) return nums[pivot];
        if (nums[pivot] > nums[end]) {
            return findMin(nums, pivot, end);
        } else {
            return findMin(nums, start, pivot);
        }
    }
}
