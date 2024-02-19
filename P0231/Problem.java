class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        int r;
        while (n > 2) {
            r = n % 2;
            if (r != 0) return false;
            n = n / 2;
        }
        return true;
    }
}