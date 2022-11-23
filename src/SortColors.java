/**
 * 75. Sort Colors
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i > redIndex) {
                swap(redIndex, i, nums);
                redIndex++;
                i--;
            } else if (nums[i] == 2 && i < blueIndex) {
                swap(blueIndex, i, nums);
                blueIndex--;
                i--;
            }
        }
    }

    private void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
