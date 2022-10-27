import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 56. Merge Intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
            
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = stack.pop();
            if (canMergeSortedIntervals(prev, intervals[i])) {
                int[] merged = mergeSortedIntervals(prev, intervals[i]);
                stack.push(merged);
            } else {
                stack.push(prev);
                stack.push(intervals[i]);
            }
        }
        
        int[][] result = new int[stack.size()][];

        return stack.toArray(result);
    }

    private boolean canMergeSortedIntervals(int[] interval1, int[] interval2) {
        return interval2[0] <= interval1[1];
    }

    private int[] mergeSortedIntervals(int[] interval1, int[] interval2) {
        return new int[]{interval1[0], Math.max(interval1[1], interval2[1])};
    }
}
