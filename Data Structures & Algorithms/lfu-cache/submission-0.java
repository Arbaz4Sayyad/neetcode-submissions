/**
 * LFU Cache
 *
 * get()  -> O(1)
 * put()  -> O(1)
 *
 * If multiple keys have the same frequency,
 * remove the least recently used key.
 */
class LFUCache {

    // Stores key -> Node
    private final Map<Integer, Node> keyToNode;

    // Stores frequency -> Doubly Linked List of nodes
    private final Map<Integer, DoublyLinkedList> freqToList;

    // Maximum capacity of cache
    private final int capacity;

    // Minimum frequency currently present in cache
    private int minFreq;

    // Node represents one cache entry
    private static class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1; // Every new node starts with frequency 1
        }
    }

    /**
     * Doubly linked list.
     *
     * Most recently used node is near the head.
     * Least recently used node is near the tail.
     */
    private static class DoublyLinkedList {

        // Dummy nodes make insertion/deletion easier
        Node head;
        Node tail;

        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node immediately after head
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove a particular node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.prev = null;
            node.next = null;

            size--;
        }

        // Remove least recently used node
        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
        this.minFreq = 0;
    }

    /**
     * Get value for a key.
     */
    public int get(int key) {

        // Key doesn't exist
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        // Increase frequency because key was accessed
        increaseFrequency(node);

        return node.value;
    }

    /**
     * Insert or update a key-value pair.
     */
    public void put(int key, int value) {

        // Capacity = 0 means nothing can be stored
        if (capacity == 0) {
            return;
        }

        // If key already exists
        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            // Update value
            node.value = value;

            // Updating/accessing increases frequency
            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (keyToNode.size() == capacity) {

            // Get list containing minimum frequency nodes
            DoublyLinkedList list = freqToList.get(minFreq);

            // Remove LRU node from that frequency
            Node removedNode = list.removeLast();

            // Remove from key map
            keyToNode.remove(removedNode.key);
        }

        // Create new node
        Node newNode = new Node(key, value);

        // Every new node has frequency = 1
        minFreq = 1;

        // Add node to key map
        keyToNode.put(key, newNode);

        // Get frequency 1 list
        DoublyLinkedList list =
                freqToList.computeIfAbsent(
                        1,
                        k -> new DoublyLinkedList()
                );

        // New node is most recently used
        list.addFirst(newNode);
    }

    /**
     * Increase frequency of a node.
     */
    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        // Remove node from old frequency list
        DoublyLinkedList oldList = freqToList.get(oldFreq);

        oldList.remove(node);

        // If this was the minimum frequency
        // and no nodes remain at this frequency,
        // increase minFreq.
        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        // Increase node frequency
        node.freq++;

        // Get/create new frequency list
        DoublyLinkedList newList =
                freqToList.computeIfAbsent(
                        node.freq,
                        k -> new DoublyLinkedList()
                );

        // Add as most recently used
        newList.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

