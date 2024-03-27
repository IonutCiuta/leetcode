class Solution {
    public int countEven(int num) {
        var sums = new HashMap<Integer, Integer>();
        sums.put(0, 0);

        int r = 0;
        for (int i = 1; i <= num; i++) {
            sums.put(i, i);
            if (i < 10 && i % 2 == 0) {
                r++;
            }
            if (i >= 10 && i < 100) {
                int first = i / 10;
                int second = i % 10;
                int sum = first + second;
                sums.put(i, sum);
                if (sum % 2 == 0) {
                    r++;
                }
            }
            if (i >= 100 && i < 1000) {
                int first = i % 100;
                int lastTwo = i / 100;
                int sum = first + sums.get(lastTwo);
                if (sum % 2 == 0) {
                    r++;
                }
            }
        }

        return r;
    }
}
