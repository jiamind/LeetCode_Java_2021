import java.util.Arrays;
import java.util.Comparator;

/*
 * 435. Non-overlapping Intervals
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[0] - arg1[0];
            }
            
        });

        int removed = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                prev = intervals[i][1] < prev[1] ? intervals[i]: prev;
                removed++;
            } else {
                prev = intervals[i];
            }
        }

        return removed;
    }
}
