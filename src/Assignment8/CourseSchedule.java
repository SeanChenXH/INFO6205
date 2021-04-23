package Assignment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses -
 * 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    public static void main(String[] args) {
        //Test 1: numCourses = 2, prerequisites = [[1,0],[0,1]]
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println("Test 1: " + canFinish(numCourses, prerequisites)); //False

        //Test 2: numCourses = 2, prerequisites = [[1,0]]
        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1, 0}};
        System.out.println("Test 2: " + canFinish(numCourses1, prerequisites1)); //true

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();

        int[] degrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            degrees[pre[0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;

        while (!queue.isEmpty()) {
            Integer temp = queue.poll();

            visited++;

            for (Integer i : edges.get(temp)) {
                degrees[i] -= 1;
                if (degrees[i] == 0) {
                    queue.add(i);
                }
            }

        }
        return visited == numCourses;
    }


}
