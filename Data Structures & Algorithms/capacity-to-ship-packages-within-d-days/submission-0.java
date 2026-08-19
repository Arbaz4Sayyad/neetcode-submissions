class Solution {

    public int shipWithinDays(int[] weights, int days) {

        // Minimum possible capacity:
        // We must be able to carry the heaviest package.
        int low = 0;

        // Maximum possible capacity:
        // We can ship all packages in one day.
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Binary search for the minimum valid capacity
        while (low < high) {

            // Calculate middle capacity
            int capacity = low + (high - low) / 2;

            // Check how many days are needed
            int requiredDays = daysRequired(weights, capacity);

            if (requiredDays <= days) {
                // This capacity works.
                // Try a smaller capacity.
                high = capacity;
            } else {
                // Capacity is too small.
                // We need a larger capacity.
                low = capacity + 1;
            }
        }

        // low == high is the minimum valid capacity
        return low;
    }

    // Calculates how many days are required
    // to ship all packages with the given capacity.
    private int daysRequired(int[] weights, int capacity) {

        int days = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            // If adding this package exceeds
            // today's capacity, start a new day.
            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = 0;
            }

            // Add package to the current day
            currentLoad += weight;
        }

        return days;
    }
}