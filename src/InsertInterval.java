import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int intervalSize = intervals.length;
        int i = 0;
        // Add intervals whose end time is smaller than the new interval's start time
        // as they do not overlap with the new interval
        for (; i < intervalSize; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                break;
            }
        }

        // Merge intervals whose start time is smaller than the merged interval's end time
        // as those intervals overlap with the merge intervals
        int[] mergedInterval = newInterval;
        while (i < intervalSize && (mergedInterval[1] >= intervals[i][0])) {
            mergedInterval = mergeIntervals(intervals[i], mergedInterval);
            i++;
        }
        result.add(mergedInterval);

        // Add any remaining intervals as they are non-overlap
        for (; i < intervalSize; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(int[][]::new);
    }

    private int[] mergeIntervals(int[] interval1, int[] interval2) {
        int min = interval1[0], max = interval1[1];
        min = Math.min(min, interval2[0]);
        max = Math.max(max, interval2[1]);
        return new int[]{min, max};
    }
}
