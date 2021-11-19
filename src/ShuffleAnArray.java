import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array
 */
public class ShuffleAnArray {

    int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] result = Arrays.copyOf(nums, nums.length);
        Random ran = new Random();
        for (int i = 0; i < result.length; i++) {
            int newPos = i + ran.nextInt(result.length - i);
            swap(result, i, newPos);
        }

        return result;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
