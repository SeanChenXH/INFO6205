package Assignment6;

import java.util.Stack;

/**
 * 735. Asteroid Collision
 * <p>
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents
 * its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision:
            {
                while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {

                    if (stack.peek() < Math.abs(ast)) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == Math.abs(ast)) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

}
