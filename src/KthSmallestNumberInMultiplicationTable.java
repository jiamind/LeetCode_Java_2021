/**
 * 668. Kth Smallest Number in Multiplication Table
 */
public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numOfCellsLessThanOrEqualsToValue(mid, m, n) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return  left;
    }

    private int numOfCellsLessThanOrEqualsToValue(int value, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(value / i, n);
        }

        return count;
    }
}
