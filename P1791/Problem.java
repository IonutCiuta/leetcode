class Solution {
    public int findCenter(int[][] edges) {
        var conns = new HashMap<Integer, Integer>();

        for (var edge : edges) {
            var src = edge[0];
            var srcConns = conns.get(src);

            if (srcConns == null) {
                conns.put(src, 1);
            } else {
                conns.put(src, srcConns + 1);
            }

            var dst = edge[1];
            var dstConns = conns.get(dst);

            if (dstConns == null) {
                conns.put(dst, 1);
            } else {
                conns.put(dst, dstConns + 1);
            }
        }

        for (var entry : conns.entrySet()) {
            if (entry.getValue() == edges.length) {
                return entry.getKey();
            }
        }

        return -1;
    }
}