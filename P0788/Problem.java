class Solution {
    public int rotatedDigits(int n) {
        int r = 0;

        int i = 1;
        while (i <= n) {
            var chars = String.valueOf(i).toCharArray();
            var sb = new StringBuilder();
            var skip = false;

            for (var c : chars) {
                if (c == '0' || c == '1' || c == '8') {
                    sb.append(c);
                    continue;
                }
                if (c == '2') {
                    sb.append('5');
                    continue;
                }
                if (c == '5') {
                    sb.append('2');
                    continue;
                }
                if (c == '6') {
                    sb.append('9');
                    continue;
                }
                if (c == '9') {
                    sb.append('6');
                    continue;
                }
                if (c == '4' || c == '3' || c == '7') {
                    skip = true;
                    break;
                }
            }

            if (!skip && !sb.isEmpty()) {
                var rotated = Integer.parseInt(sb.toString());
                if (rotated != i) {
                    // System.out.printf("n vs. rotated: %d vs. %d\n", i, rotated);
                    r++;
                }
            }
            i++;
        }

        return r;
    }
}