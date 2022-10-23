import java.util.Arrays;

/**
 * 973. K Closest Points to Origin
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        sortK(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);    
    }

    private void sortK(int[][] array, int start, int end, int k) {
        int pivot = (end - start) / 2 + start;
        int pivotDist = distanceSquare(array[pivot]);
        swap(array, start, pivot);

        int i = start + 1, j = end;
        while (i <= j) {
            if (distanceSquare(array[i]) > pivotDist) {
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(array, start, j);

        if (j - start + 1 < k) {
            sortK(array, j+1, end, k - (j - start + 1));
        } else if (j - start + 1 > k) {
            sortK(array, start, j-1, k);
        }
    }

    private void swap(int[][] array, int i, int j) {
        int[] temp_i = new int[]{array[i][0], array[i][1]};
        array[i][0] = array[j][0];
        array[i][1] = array[j][1];
        array[j][0] = temp_i[0];
        array[j][1] = temp_i[1];
    }

    private int distanceSquare(int[] position) {
        return position[0] * position[0] + position[1] * position[1];
    }
}
