class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Store [position, speed] for each car
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position in descending order
        // Closest to target comes first.
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;

        // Time required for the previous car/fleet
        double previousTime = 0;

        for (int i = 0; i < n; i++) {

            int pos = cars[i][0];
            int speedOfCar = cars[i][1];

            // Time needed to reach target
            double time = (double) (target - pos) / speedOfCar;

            /*
             * If this car takes MORE time than the fleet ahead,
             * it cannot catch that fleet.
             *
             * Therefore, it forms a new fleet.
             */
            if (time > previousTime) {

                fleets++;

                // This becomes the time of the new fleet
                previousTime = time;
            }

            /*
             * If time <= previousTime:
             *
             * This car will catch the fleet ahead.
             * Therefore, it becomes part of that fleet.
             */
        }

        return fleets;
    }
}