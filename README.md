# Mini Redis 🧠💾

A lightweight in-memory key-value store with **LRU (Least Recently Used) eviction policy**, built from scratch using **Java**. Inspired by Redis, this project demonstrates core system design and DSA concepts like **HashMap** and **Doubly Linked List** to manage recent usage and perform operations in O(1) time.

---

## 🚀 Features

- ⚡️ In-memory key-value storage
- ♻️ LRU eviction when cache is full
- 🧠 O(1) operations for `get()` and `put()`
- 🔧 Custom implementation of HashMap + Doubly Linked List
- ✅ Simple, testable Java code

---

## 📂 File Structure

```
MiniRedis/
├── LRUCache.java   # Core LRU Cache logic
├── Main.java       # Example usage
├── README.md       # This file
```

---

## 📦 How It Works

- When a key is accessed via `get()` or added via `put()`, it becomes the **most recently used**.
- When capacity is full, the **least recently used** key is evicted automatically.
- Doubly Linked List stores the order of usage.
- HashMap gives O(1) access to nodes.

---

## 📋 Usage Example

```java
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));  // Output: 10
        cache.put(3, 30);                  // Evicts key 2
        System.out.println(cache.get(2));  // Output: -1
    }
}
```

---

## 🛠 Built With

- **Java**
- **Data Structures**: HashMap, Doubly Linked List
- **Concepts**: LRU eviction, O(1) access, system memory simulation

---

## 🧠 Learnings

- Implemented core system design behavior (like Redis) without using built-in libraries.
- Practiced managing memory manually with object references and pointer logic.
- Strengthened knowledge of HashMap + Doubly Linked List integration.

---

## 📈 Future Enhancements

> Coming Soon (optional):
- TTL (Time-To-Live) expiry logic using heap/timer
- Persistent storage layer (optional)
- Trie-based prefix search
- Command-line interface (CLI) to mimic Redis CLI

---

## 📄 License

This project is for educational purposes and not affiliated with the official [Redis](https://redis.io) project.

---

## 🙌 Author

Made with 💡 by [Tarun Kumar Basera](https://github.com/enlighttarunkumar)
