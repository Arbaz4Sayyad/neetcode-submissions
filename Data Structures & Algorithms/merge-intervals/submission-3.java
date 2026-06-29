class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> list = new ArrayList<>();
        
        list.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            int[] previous = list.get(list.size() - 1);
            int[] current = intervals[i];

            if(current[0] <= previous[1]) {
                // merge
                previous[0] = Math.min(previous[0], current[0]);
                previous[1] = Math.max(previous[1], current[1]);
            }else {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i); 
        }

        return res;
    }
}

// Brute Force TC: O(N^3)

// class Solution {
//     public boolean isOverlap(int[] int1, int[] int2) {
//         return int1[1] >= int2[0] && int2[1] >= int1[0];
//     }

//     public int[][] merge(int[][] intervals) {
        
//         List<int[]> list = new ArrayList<>();
//         for(int[] interval : intervals) {
//             list.add(interval);
//         }

//         boolean isMergeHappened = true;

//         while(isMergeHappened) {

//             isMergeHappened = false;

//             for(int i = 0; i < list.size(); i++) {
               
//                 int j = i + 1;
                
//                 while(j < list.size()) {
//                     int[] int1 = list.get(i);
//                     int[] int2 = list.get(j);
                    
//                     if(isOverlap(int1, int2)) {
//                         int1[0] = Math.min(int1[0], int2[0]);
//                         int1[1] = Math.max(int1[1], int2[1]);

//                         list.remove(j);

//                         isMergeHappened = true;
//                     }else{
//                         j++;
//                     }
//                 }
//             }
//         }

//         int[][] res = new int[list.size()][2];

//         for(int i=0; i<list.size(); i++){
//             res[i] = list.get(i); 
//         }

//         return res;
//     }
// }
