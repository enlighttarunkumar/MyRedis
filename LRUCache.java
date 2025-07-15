import java.util.HashMap;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Helper: Add node right after head
    private void addNode(Node node) {
        Node temp = head.next;

        head.next = node;
        node.prev = head;

        node.next = temp;
        temp.prev = node;
    }

    // Helper: Remove any node from list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Get value from cache, make it recently used
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            // Remove from old position and move to front
            removeNode(node);
            addNode(node);

            return node.value;
        }
        return -1;
    }

    // Put key-value into cache
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Remove old node
            Node existing = map.get(key);
            removeNode(existing);
            map.remove(key);
        }

        // If cache is full, remove least recently used
        if (map.size() == capacity) {
            Node lru = tail.prev;  // node before tail
            removeNode(lru);
            map.remove(lru.key);
        }

        // Add new node to front
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}
