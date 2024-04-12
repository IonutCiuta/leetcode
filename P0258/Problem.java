class Solution {
    public int addDigits(int num) {
        while (true) {
            if (num < 10) {
                return num;
            }
            var sum = 0;
            var chars = String.valueOf(num).toCharArray();
            for (var c : chars) {
                sum += (c - '0');
            }
            num = sum;
        }
    }
}