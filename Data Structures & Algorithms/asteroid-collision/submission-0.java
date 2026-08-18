class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Stack to store asteroids that are still alive
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            // Assume current asteroid survives
            boolean alive = true;

            /*
             * Collision happens only when:
             *
             * stack top is moving RIGHT  -> positive
             * current asteroid is moving LEFT -> negative
             */
            while (alive &&
                   !stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                int top = stack.peek();

                // Current asteroid is larger
                if (Math.abs(asteroid) > top) {

                    // Top asteroid explodes
                    stack.pop();

                    // Current asteroid may still collide
                    // with the next asteroid in the stack
                }

                // Both asteroids have the same size
                else if (Math.abs(asteroid) == top) {

                    // Both explode
                    stack.pop();

                    // Current asteroid is also destroyed
                    alive = false;
                }

                // Top asteroid is larger
                else {

                    // Current asteroid is destroyed
                    alive = false;
                }
            }

            // Add current asteroid if it survived
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Convert Stack<Integer> to int[]
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}