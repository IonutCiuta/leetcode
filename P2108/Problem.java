class Solution {
    public String firstPalindrome(String[] words) {
        for (var w : words) {
            var chars = w.toCharArray();
            int i = 0;
            int j = chars.length - 1;

            boolean isPalindrome = true;
            while (i < j) {
                if (chars[i] != chars[j]) {
                    isPalindrome = false;
                    break;
                }
                i++;
                j--;
            }

            if (isPalindrome) {
                return w;
            }
        }
        return "";
    }
}