class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var magMap = new HashMap<Character, Integer>();
        var magChars = magazine.toCharArray();
        for (char c : magChars) {
            var occ = magMap.get(c);
            if (occ == null) {
                magMap.put(c, 1);
            } else {
                magMap.put(c, occ + 1);
            }
        }

        var noteChars = ransomNote.toCharArray();
        for (var c : noteChars) {
            var occ = magMap.get(c);
            if (occ == null || occ == 0) {
                return false;
            }
            magMap.put(c, occ - 1);
        }

        return true;
    }
}