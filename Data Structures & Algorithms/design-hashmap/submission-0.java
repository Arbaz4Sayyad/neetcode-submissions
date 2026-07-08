class MyHashMap {

    int[] map;

    public MyHashMap() {

        map = new int[1000001];

        Arrays.fill(map, -1);
    }

    // Insert or update
    public void put(int key, int value) {

        map[key] = value;
    }

    // Return value if present
    public int get(int key) {

        return map[key];
    }

    // Remove key
    public void remove(int key) {

        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */