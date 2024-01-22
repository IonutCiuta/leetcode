class Solution {
    public int lengthOfLastWord(String s) {
        var words = s.trim().split("\s");
        return words[words.length - 1].length();
    }
}