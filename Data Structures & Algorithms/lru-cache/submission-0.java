class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

        if (!cache.containsKey(key) && cache.size() >= capacity) {
            Integer leastRecentlyUsedKey = cache.keySet().iterator().next();
            cache.remove(leastRecentlyUsedKey);
        }

        cache.put(key, value);
    }
}