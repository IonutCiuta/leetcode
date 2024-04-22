class Solution {
    public boolean validPath(int vert, int[][] edges, int s, int x) {
        if (s == x) {
            return true;
        }

        var g = new HashMap<Integer, List<Integer>>();

        for (var v : edges) {
            var n = g.get(v[0]);
            if (n != null) {
                n.add(v[1]);
            } else {
                n = new ArrayList<Integer>();
                n.add(v[1]);
                g.put(v[0], n);
            }
            var m = g.get(v[1]);
            if (m != null) {
                m.add(v[0]);
            } else {
                m = new ArrayList<Integer>();
                m.add(v[0]);
                g.put(v[1], m);
            }
        }

        var q = new ArrayDeque<Integer>();
        var visited = new HashSet<Integer>();

        var sourceNext = g.get(s);
        if (sourceNext == null) {
            return false;
        }

        q.addAll(sourceNext);
        visited.add(s);

        while(!q.isEmpty()) {
            var node = q.poll();

            if (visited.contains(node)) {
                continue;
            }

            if (node == x) {
                return true;
            } else {
                var next = g.get(node);
                if (next != null) {
                    q.addAll(next);
                }
                visited.add(node);
            }
        }

        return false;
    }
}