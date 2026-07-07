class Solution {

    public boolean makesquare(int[] matchsticks) {

        int sum = 0;

        // Calculate total length of all matchsticks
        for (int stick : matchsticks) {
            sum += stick;
        }

        // If total length is not divisible by 4,
        // it is impossible to form a square
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        // Sort in ascending order
        Arrays.sort(matchsticks);

        // Reverse the array so that larger matchsticks are placed first.
        // This greatly reduces unnecessary backtracking.
        reverse(matchsticks);

        // Stores current length of each side
        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, target);
    }

    private boolean backtrack(int[] matchsticks,
                              int index,
                              int[] sides,
                              int target) {

        // Base Case:
        // All matchsticks have been used successfully
        if (index == matchsticks.length) {

            // Check if all four sides are equal to target
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int currentStick = matchsticks[index];

        // Try placing current matchstick into each side
        for (int i = 0; i < 4; i++) {

            // Skip if adding current stick exceeds target
            if (sides[i] + currentStick > target) {
                continue;
            }

            // Choose
            sides[i] += currentStick;

            // Explore
            if (backtrack(matchsticks, index + 1, sides, target)) {
                return true;
            }

            // Undo (Backtrack)
            sides[i] -= currentStick;

            // Optimization:
            // If this side was empty and placing the stick didn't work,
            // no need to try other empty sides (they are symmetric).
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    // Reverse array after sorting so that
    // larger matchsticks are placed first.
    private void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}