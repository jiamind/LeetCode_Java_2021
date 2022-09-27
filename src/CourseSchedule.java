import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. Course Schedule
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // courseTaken[i] = 0 means course i can be taken
        // courseTaken[i] = -1 means course is cannot be taken
        int[] courseTaken = new int[numCourses];
        // number of courses can be taken. 
        int num = numCourses;
        // map from a course to a list of its prerequisites
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        // initialize courseTaken and prereqMap
        for (int i = 0; i < prerequisites.length; i++) {
            // if a course has prerequisites
            // it cannot be taken at the moment.
            int[] prereq = prerequisites[i];
            if (courseTaken[prereq[0]] == 0) {
                courseTaken[prereq[0]] = -1;
                num--;
            }

            if (prereqMap.containsKey(prereq[0])) {
                prereqMap.get(prereq[0]).add(prereq[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prereq[1]);
                prereqMap.put(prereq[0], list);
            }
        }

        // Terminate the loop when all courses are taken
        // or no more course can be taken
        boolean newCourseTaken = true;
        while (num < numCourses && newCourseTaken) {
            newCourseTaken = false;
            for (int i = 0; i < courseTaken.length; i++) {
                // Don't process courses that already taken
                if (courseTaken[i] >= 0) continue;
                boolean canTake = true;
                List<Integer> list = prereqMap.get(i);
                for (int prereq : list) {
                    // Some prerequisite is not taken
                    // cannot taken the current course
                    if (courseTaken[prereq] < 0) {
                        canTake = false;
                        break;
                    }
                }

                if (canTake) {
                    courseTaken[i] = 0;
                    num++;
                    newCourseTaken = true;
                }
            }
        }

        return num == numCourses;
    }
}
