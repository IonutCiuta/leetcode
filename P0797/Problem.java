class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var g = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                var nodes = g.get(i);
                if (nodes == null) {
                    nodes = new ArrayList<Integer>();
                    g.put(i, nodes);
                }
                nodes.add(graph[i][j]);
            }
        }

        // System.out.println(g);

        var paths = new ArrayList<List<Integer>>();
        findPaths(0, graph.length - 1, g, null, paths);
        return paths;
    }

    void findPaths(int src, int dst, HashMap<Integer, List<Integer>> g, List<Integer> path, List<List<Integer>> paths) {
        if (path == null) {
            path = new ArrayList<Integer>();
        }

        path.add(src);
        // System.out.printf("%d -> %d, path: %s\n", src, dst, path);

        if (src == dst) {
            paths.add(path);
            return;
        }

        var next = g.get(src);
        if (next != null) {
            for (var n : next) {
                findPaths(n, dst, g, new ArrayList<>(path), paths);
            }
        }
    }
}