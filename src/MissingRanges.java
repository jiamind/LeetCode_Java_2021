import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(printRange(lower, upper));
            return result;
        }

        int numIndex = 0;
        int leftValue = lower;
        for (int i = lower; i <= upper; i++) {
            if (numIndex < nums.length && i == nums[numIndex]) {
                addIfNotEmpty(result, printRange(leftValue, i - 1));
                leftValue = i + 1;
                numIndex++;
            } else if (numIndex >= nums.length){
                break;
            } else {
                i = nums[numIndex] - 1;
            }
        }

        if (leftValue <= upper) {
            addIfNotEmpty(result, printRange(leftValue, upper));
        }

        return result;
    }

    private void addIfNotEmpty(List<String> list, String str) {
        if (!str.isEmpty()) {
            list.add(str);
        }
    }

    private String printRange(int lower, int upper) {
        if (lower > upper) return "";
        if (lower == upper) return String.valueOf(lower);
        return lower + "->" + upper;
    }
}
