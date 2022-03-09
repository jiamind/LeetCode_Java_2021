/**
 * 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) return null;

        int[] prefixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        int[] suffixProduct = new int[nums.length];
        suffixProduct[nums.length - 1] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }

        return result;
    }
}
