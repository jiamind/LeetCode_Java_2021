/**
 * 152. Maximum Product Subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int start = 0;
        int max = -10;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, 0);
                max = Math.max(max, maxProductWithoutZero(nums, start, i - 1));
                start = i + 1;
            }
        }
        max = Math.max(max, maxProductWithoutZero(nums, start, nums.length - 1));

        return max;
    }

    private int maxProductWithoutZero(int[] nums, int start, int end) {
        if (start > end) return -10;

        int product = 1;
        for (int i = start; i <= end; i++) {
            product *= nums[i];
        }

        if (product < 0) {
            int maxProduct = product, temp = product;
            for (int i = start; i < end; i++) {
                temp /= nums[i];
                if (temp > 0) {
                    maxProduct = Math.max(maxProduct, temp);
                    break;
                }
            }

            temp = product;
            for (int i = end; i > start; i--) {
                temp /= nums[i];
                if (temp > 0) {
                    maxProduct = Math.max(maxProduct, temp);
                    break;
                }
            }

            return maxProduct;
        } else {
            return product;
        }
    }
}
