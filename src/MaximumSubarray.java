/**
 * 53. Maximum Subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int[] sumArray = new int[nums.length + 1];
        sumArray[0] = 0;

        for (int i = 1; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i-1] + nums[i-1];
        }

        int max = -10000;
        for (int i = 0; i < sumArray.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(max, sumArray[i] - sumArray[j]);
            }
        }

        return max;
    }
}
