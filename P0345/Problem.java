class Solution {

    boolean isV(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseVowels(String str) {
        var cs = str.toCharArray();
        int i = 0;
        int j = cs.length - 1;

        while (i < j) {
            var s = cs[i];
            var e = cs[j];
            var sV = isV(s);
            var eV = isV(e);

            if (sV && eV) {
                var aux = s;
                cs[i] = e;
                cs[j] = aux;
                i += 1;
                j -= 1;
            } else {
                if (!sV) i += 1;
                if (!eV) j -= 1;
            }
        }

        return new String(cs);
    }
}