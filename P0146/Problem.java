import java.util.HashMap;
import java.util.Map;

class LRUCache {
  final Map<Integer, Node> cache;
  final Node root;
  final int capacity;
  Node head;
  int size = 0;

  public LRUCache(int capacity) {
      this.cache = new HashMap<>();
      this.root = new Node(0, 0, null, null);
      this.head = root;
      this.capacity = capacity;
  }

  public int get(int key) {
      var node = cache.get(key);

      if (node == head) {
          return node.value;
      }

      if (node != null) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
          head.next = node;
          node.prev = head;
          node.next = null;
          head = node;
          cache.put(key, head);
          return head.value;
      }
      return -1;
  }

  public void put(int key, int value) {
      var node = cache.get(key);

      if (node == head) {
          node.value = value;
          return;
      }

      if (node != null) {
          node.value = value;
          node.prev.next = node.next;
          node.next.prev = node.prev;
          head.next = node;
          node.prev = head;
          node.next = null;
          head = node;
      } else {
          var newNode = new Node(key, value, head, null);
          head.next = newNode;
          head = newNode;
          cache.put(key, newNode);
          if (size < capacity) {
              size += 1;
          } else {
              var lruNode = root.next;
              root.next = lruNode.next;
              lruNode.next.prev = root;
              lruNode.prev = null;
              lruNode.next = null;
              cache.remove(lruNode.key);
          }
      }
  }
}

class Node {
  int key;
  int value;
  Node prev;
  Node next;

  Node(int key, int value, Node prev, Node next) {
      this.key = key;
      this.value = value;
      this.prev = prev;
      this.next = next;
  }
}