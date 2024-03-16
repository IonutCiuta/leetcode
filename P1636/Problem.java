class Solution {
    public int[] frequencySort(int[] nums) {
        // map each element to its freq        
        var fq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            var f = fq.get(n);
            if (f == null) {
                fq.put(n, 1);
            } else {
                fq.put(n, f + 1);
            }
        }

        // inverse the map above
        // map each freq to the numbers appear the same number of times
        // and save all the unique freqs
        var fqToN = new HashMap<Integer, ArrayList<Integer>>();
        var fqs = new ArrayList<Integer>();
        for (var kv : fq.entrySet()) {
            var n = kv.getKey();
            var f = kv.getValue();

            var nWithF = fqToN.get(f);
            if (nWithF == null) {
                var v = new ArrayList<Integer>();
                v.add(n);
                fqToN.put(f, v);
                fqs.add(f);
            } else {
                nWithF.add(n);
            }
        }

        // sort the freq
        Collections.sort(fqs);

        // process freq (f) in asc order
        // for each freq, sort the numbers that have the same f
        // and add them in reverse order f times
        var len = nums.length;
        var r = new int[len];
        var i = 0;
        for (var f : fqs) {
            var ns = fqToN.get(f);
            Collections.sort(ns);
            for (int j = ns.size() - 1; j >= 0; j--) {
                var ff = f;
                while (ff > 0) {
                    r[i++] = ns.get(j);
                    ff--;
                }
            }
        }

        return r;
    }
}