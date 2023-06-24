import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
  private static class Item {
    int value, localMax;

    Item(int value, int localMax) {
      this.value = value;
      this.localMax = localMax;
    }
  }

  private Deque<Item> items;

  public MinStack() {
    this.items = new ArrayDeque<Item>();
  }
  
  public void push(int val) {
      if (items.isEmpty()) {
        items.add(new Item(val, val));
      } else {
        var prevMax = items.peekLast().localMax;
        var newItem = new Item(val,  Integer.min(val, prevMax));
        items.add(newItem);
      }
  }
  
  public void pop() {
    items.pollLast();
  }
  
  public int top() {
    return items.peekLast().value;
  }
  
  public int getMin() {
    return items.peekLast().localMax;
  }
}