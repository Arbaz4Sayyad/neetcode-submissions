class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        // Current amount of gas available
        int currentGas = 0;

        // Candidate starting station
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            // Calculate total gas and total cost
            totalGas += gas[i];
            totalCost += cost[i];

            // Gas gained/lost at current station
            currentGas += gas[i] - cost[i];

            // We cannot reach the next station
            if (currentGas < 0) {

                // Therefore, current start cannot be the answer.
                // Also, none of the stations between start and i
                // can be the answer.
                start = i + 1;

                // Reset the tank for the new starting point
                currentGas = 0;
            }
        }

        // If total gas is less than total cost,
        // completing the circuit is impossible.
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }
}