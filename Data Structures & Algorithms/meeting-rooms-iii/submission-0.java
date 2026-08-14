class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by their start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Available rooms:
        // Always choose the room with the smallest number
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Initially, all rooms are available
        for (int room = 0; room < n; room++) {
            availableRooms.offer(room);
        }

        // Busy rooms:
        // [endTime, roomNumber]
        //
        // First compare by end time.
        // If end times are equal, choose smaller room number.
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        // Count how many meetings each room handles
        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {

            long start = meeting[0];
            long end = meeting[1];

            // Move all rooms whose meetings have finished
            // back into the available rooms heap
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] room = busyRooms.poll();

                // room[1] is the room number
                availableRooms.offer((int) room[1]);
            }

            if (!availableRooms.isEmpty()) {

                // At least one room is available.
                // Choose the smallest room number.
                int room = availableRooms.poll();

                // This room handles this meeting
                meetingCount[room]++;

                // Add the room to busy rooms
                busyRooms.offer(new long[]{end, room});

            } else {

                // No room is currently available.
                //
                // Choose the room whose meeting finishes first.
                long[] roomInfo = busyRooms.poll();

                long earliestEnd = roomInfo[0];
                int room = (int) roomInfo[1];

                // The meeting has to wait until this room becomes free.
                //
                // Original duration:
                // end - start
                //
                // New ending time:
                // earliestEnd + duration
                long newEnd = earliestEnd + (end - start);

                // This room handles the meeting
                meetingCount[room]++;

                // Add the room back with its new ending time
                busyRooms.offer(new long[]{newEnd, room});
            }
        }

        // Find the room with the highest meeting count.
        // If there is a tie, return the smallest room number.
        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (meetingCount[room] > meetingCount[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}