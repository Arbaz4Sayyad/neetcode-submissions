/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // No meetings means no rooms are required
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // Sort meetings based on their start time
        intervals.sort((a, b) -> a.start - b.start);

        // Min Heap stores the end time
        // of meetings currently using rooms
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process every meeting
        for (Interval interval : intervals) {

            // If the earliest-ending meeting has already ended,
            // we can reuse that room
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }

            // Add current meeting's end time
            // to represent occupying a room
            minHeap.offer(interval.end);
        }
        
        // Number of meetings currently in the heap
        // represents the maximum number of rooms required
        return minHeap.size();
    }
}