class Solution {
    // public int[] topKFrequent(int[] nums, int k) {
    //     // Step 1: Frequency map
    //     Map<Integer, Integer> freqMap = new HashMap<>();
    //     for (int num : nums) {
    //         freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    //     }

    //     // Step 2: Max Heap based on frequencies
    //     PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
    //         (a, b) -> b.getValue() - a.getValue()
    //     );
    //     maxHeap.addAll(freqMap.entrySet());

    //     // Step 3: Extract top k elements
    //     int[] res = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         res[i] = maxHeap.poll().getKey();
    //     }
        
    //     return res;
    // }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()){
            result[index] = minHeap.poll().getKey();
            index++;
        }
        return result;
    }
}