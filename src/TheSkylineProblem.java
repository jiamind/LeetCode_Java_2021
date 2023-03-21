import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 218. The Skyline Problem
 * Idea: view vertically at each x position. 
 * If we consider the left vertex as the start of the height, right as the end
 * the results are the highest points at each x position
 * Time complexity:
 * |- Iterate each building: O(N)
 * |- Sort x positions: O(NlogN)
 * |- For each x, total add N ys and remove N ys. O(NlogN + N?)
 * |- Therefore: O(NlogN + N) = O(NlogN)
 * Space complexity:
 * |- <Map> xToYs: O(N)
 * |- <List> xPositions: O(N)
 * |- <PQ> heights: O(N)
 * |- Therefore: O(N)
 */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // a map from x position to y positions.
        // positive y value means left vertex of the building
        // negative y value means right vertex of the building
        Map<Integer, List<Integer>> xToYs = new HashMap<>();
        for (int i = 0; i < buildings.length; i++) {
            if (!xToYs.containsKey(buildings[i][0])) {
                xToYs.put(buildings[i][0], new ArrayList<>());
            }

            if (!xToYs.containsKey(buildings[i][1])) {
                xToYs.put(buildings[i][1], new ArrayList<>());
            }

            xToYs.get(buildings[i][0]).add(buildings[i][2]);
            xToYs.get(buildings[i][1]).add(buildings[i][2] * -1);
        }

        // get all x positions and sort in ascending order
        List<Integer> xPositions = new ArrayList<>(xToYs.keySet());
        Collections.sort(xPositions);

        // use a maxheap (PQ in descending order) to store all heights
        // so that we can get the max height at any time
        PriorityQueue<Integer> heights = new PriorityQueue<Integer>(Collections.reverseOrder());
        // height starts with 0 (no building)
        heights.add(0);
        List<List<Integer>> result = new ArrayList<>();
        // for each x positions
        for (int i = 0; i < xPositions.size(); i++) {
            // get y values at current positions
            List<Integer> currentYs = xToYs.get(xPositions.get(i));
            // get the max height at this point
            int prevHeight = heights.peek();
            
            // if y is positive (left), start a new height
            // otherwise (negative), close (remove) the height
            for (Integer y : currentYs) {
                if (y > 0) {
                    heights.add(y);
                } else {
                    heights.remove(y * -1);
                }
            }

            // if the current max height is not the previous height
            // add it to the result as it should be visible 
            if (heights.peek() != prevHeight) {
                List<Integer> pts = new ArrayList<>();
                pts.add(xPositions.get(i));
                pts.add(heights.peek());
                result.add(pts);
            }
        }

        return result;
    }
}