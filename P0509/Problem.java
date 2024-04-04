class Solution {
    public int fib(int n) {
        var cache = new HashMap<Integer, Integer>();
        return fib(n, cache);
    }

    int fib(int n, Map<Integer, Integer> cache) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        var cached = cache.get(n);
        if (cached != null) {
            return cached;
        }

        var r = fib(n - 1, cache) + fib(n - 2, cache);
        cache.put(n, r);
        return r;
    }
}