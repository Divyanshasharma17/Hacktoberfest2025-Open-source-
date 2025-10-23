class MyHashMap {
private final int SIZE = 1009;
    private List<int[]>[] buckets;
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    private int hash(int key) {
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = hash(key);
        for (int[] pair : buckets[index]) {
            if (pair[0] == key) {
                pair[1] = value; 
                return;
            }
        }
        buckets[index].add(new int[]{key, value}); 
    }
    public int get(int key) {
        int index = hash(key);
        for (int[] pair : buckets[index]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }
    public void remove(int key) {
        int index = hash(key);
        Iterator<int[]> it = buckets[index].iterator();
        while (it.hasNext()) {
            int[] pair = it.next();
            if (pair[0] == key) {
                it.remove();
                return;
            }
        }
    }
}
