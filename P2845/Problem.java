class Solution {
    public int pivotInteger(int n) {
        if (n == 1) return 1;

        int x = n - 1;
        int leftSum = (x * n) / 2;
        int rightSum = x + n;

        while (x > 0) {
            if (leftSum == rightSum) {
                return x;
            }
            leftSum -= x;
            x--;
            rightSum += x;
        }

        return -1;
    }
}