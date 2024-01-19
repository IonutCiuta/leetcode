class Solution {
    public boolean isPalindrome(int x) {
        var c = String.valueOf(x).toCharArray();
        var i = 0;
        var j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}