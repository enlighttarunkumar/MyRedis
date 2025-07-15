public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));  // returns 10
        cache.put(3, 30);                 // evicts key 2
        System.out.println(cache.get(2));  // returns -1 (not found)
    }
}
