class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        var p3 = 0; // prev prev prev
        var p2 = 1; // prev prev
        var p1 = 1; // prev

        for (int i = 3; i <= n; i++) {
            var t = p1 + p2 + p3;
            p3 = p2;
            p2 = p1;
            p1 = t;
        }

        return p1;
    }
}