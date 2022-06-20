/**
 * 11. Container With Most Water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            int vol = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(max, vol);
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        return max;
    }
}
