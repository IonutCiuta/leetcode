class Solution {

    public boolean isHappy(int n) {
        var occ = new HashSet<Integer>();

        while (true) {
            if (n == 1) return true;

            var str = String.valueOf(n);
            var chars = str.toCharArray();
            int sum = 0;
            for (char c : chars) {
                var digit = c - '0';
                sum += Math.pow(digit, 2);
            }

            if (occ.contains(sum)) {
                return false;
            } else {
                occ.add(sum);
            }

            n = sum;
        }
    }
}