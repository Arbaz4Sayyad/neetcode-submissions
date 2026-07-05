// class Solution {

//     int[][] jobs;

//     public int solve(int index) {

//         // No jobs left
//         if (index == jobs.length)
//             return 0;

//         // Option 1 : Skip current job
//         int skip = solve(index + 1);

//         // Find next non-overlapping job
//         int nextIndex = findNext(index);

//         // Option 2 : Take current job
//         int take = jobs[index][2] + solve(nextIndex);

//         return Math.max(skip, take);
//     }

//     // Binary search to find first job whose start time >= current end time
//     public int findNext(int index) {

//         int low = index + 1;
//         int high = jobs.length - 1;
//         int ans = jobs.length;

//         while (low <= high) {

//             int mid = low + (high - low) / 2;

//             if (jobs[mid][0] >= jobs[index][1]) {
//                 ans = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         return ans;
//     }

//     public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

//         int n = startTime.length;

//         jobs = new int[n][3];

//         for (int i = 0; i < n; i++) {
//             jobs[i][0] = startTime[i];
//             jobs[i][1] = endTime[i];
//             jobs[i][2] = profit[i];
//         }

//         Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

//         return solve(0);
//     }
// }

class Solution {

    int[][] jobs;
    Integer[] dp;

    public int solve(int index) {

        if (index == jobs.length)
            return 0;

        if (dp[index] != null)
            return dp[index];

        int skip = solve(index + 1);

        int nextIndex = findNext(index);

        int take = jobs[index][2] + solve(nextIndex);

        return dp[index] = Math.max(skip, take);
    }

    public int findNext(int index) {

        int low = index + 1;
        int high = jobs.length - 1;
        int ans = jobs.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (jobs[mid][0] >= jobs[index][1]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        dp = new Integer[n];

        return solve(0);
    }
}