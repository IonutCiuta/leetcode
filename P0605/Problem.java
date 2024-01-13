class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        if (n == 0) return true;

        int right = 0;
        int mid = f[0];
        int left = 0;

        for (int i = 1; i < f.length; i++) {
            if (n == 0) return true;

            left = f[i];
            if (right + mid + left == 0) {
                f[i - 1] = 1;
                n--;
            }

            right = f[i - 1];
            mid = f[i];
        }

        if (right + mid + left == 0) n--;

        if (n == 0) return true;
        return false;
    }
}