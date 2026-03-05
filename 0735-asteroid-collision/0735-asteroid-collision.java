import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (top < -a) {   // top asteroid explodes
                    stack.pop();
                    continue;
                } 
                else if (top == -a) { // both explode
                    stack.pop();
                }

                destroyed = true; // current asteroid explodes
                break;
            }

            if (!destroyed) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}