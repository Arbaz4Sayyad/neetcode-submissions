// class MedianFinder {
//     List<Integer> list;
   
//     public MedianFinder() {
//         list = new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         list.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(list);

//         int size = list.size();

//         if(size % 2 == 0){
//             return (list.get(size / 2) + list.get(size / 2 - 1)) / 2.0;
//         }else{
//             return list.get(size / 2);
//         }
//     }
// }


class MedianFinder {
   PriorityQueue<Integer> maxHeap;
   PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // maxHeap = n/2, if n is even
        // maxHeap = n/2 + 1, if n is odd
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */