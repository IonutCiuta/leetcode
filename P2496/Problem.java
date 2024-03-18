class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;

        for (var s : strs) {
            var chars = s.toCharArray();
            var isNumber = true;
            for (var c : chars) {
                if (c >= 'a' && c <= 'z') {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                max = Math.max(max, Integer.parseInt(s));
            } else {
                max = Math.max(max, s.length());
            }
        }

        return max;
    }


    int maxVal(String[] strs) {
        int max = 0;

        for (var s : strs) {
            try {
                max = Math.max(max, Integer.parseInt(s));
            } catch (Exception e) {
                max = Math.max(max, s.length());
            }
        }

        return max;
    }
}