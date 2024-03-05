class Solution {
    public String largestGoodInteger(String num) {
        char max = '/';
        char[] c = num.toCharArray();

        int i = 0;
        while (i < num.length() - 2) {
            if (c[i] >= '0' && c[i] <= '9') {
                if (c[i] == c[i + 1] && c[i + 1] == c[i + 2]) {
                    if (c[i] > max) {
                        max = c[i];
                    }
                    i += 3;
                    continue;
                }
            }
            i++;
        }

        return max == '/' ? "" : new StringBuilder().append(max).append(max).append(max).toString();
    }
}