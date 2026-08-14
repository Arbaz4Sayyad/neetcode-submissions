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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // If there are 0 or 1 meetings,
        // there cannot be any overlap
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // Sort meetings based on their start time
        intervals.sort((a, b) -> a.start - b.start);

        // Check every meeting with the previous meeting
        for (int i = 1; i < intervals.size(); i++) {

            // Current meeting starts before the previous
            // meeting ends -> overlap exists
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        // No overlapping meetings found
        return true;
    }
}
