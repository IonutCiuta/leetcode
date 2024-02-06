class Solution {
    public boolean isIsomorphic(String s, String t) {
        var morph = new HashMap<Character, Character>();
        var morphed = new HashSet<Character>();

        var sChars = s.toCharArray();
        var tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            var sChar = sChars[i];
            var tChar = tChars[i];

            var transformed = morph.get(sChar);
            if (transformed == null) {
                // if this value has already been morphed into, return false
                if (morphed.contains(tChar)) {
                    return false;
                }
                // else morph sChar into tChar and track tChar as a value
                // that has been already used
                morph.put(sChar, tChar);
                morphed.add(tChar);
            } else {
                // if sChar has already been morphed into a value different
                // than tChar, return false
                if (transformed != tChar) {
                    return false;
                }
            }
        }

        return true;
    }
}