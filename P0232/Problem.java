class MyQueue {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> backup = new Stack<Integer>();

    public MyQueue() {
    }

    public void push(int x) {
        data.push(x);
    }

    public int pop() {
        while (!data.isEmpty()) {
            backup.push(data.pop());
        }
        var r = backup.pop();
        while (!backup.isEmpty()) {
            data.push(backup.pop());
        }
        return r;
    }

    public int peek() {
        while (!data.isEmpty()) {
            backup.push(data.pop());
        }
        var r = backup.pop();
        backup.push(r);
        while (!backup.isEmpty()) {
            data.push(backup.pop());
        }
        return r;
    }

    public boolean empty() {
        return data.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */