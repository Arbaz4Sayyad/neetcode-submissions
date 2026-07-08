class MyHashSet {

    // Array where index represents the key
    boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    // Mark key as present
    public void add(int key) {
        set[key] = true;
    }

    // Mark key as absent
    public void remove(int key) {
        set[key] = false;
    }

    // Check whether key exists
    public boolean contains(int key) {
        return set[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */