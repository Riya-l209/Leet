class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // dp[i][c]: max count of color c (0-25) ending at node i
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
            // Initialize the color count for each node's own color
            dp[i][colors.charAt(i) - 'a'] = 1;
        }

        int visited = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited++;
            for (int v : graph.get(u)) {
                // Update DP for each color
                for (int c = 0; c < 26; c++) {
                    int add = (colors.charAt(v) - 'a' == c) ? 1 : 0;
                    dp[v][c] = Math.max(dp[v][c], dp[u][c] + add);
                }
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
            // Update result with max color count at node u
            for (int c = 0; c < 26; c++) {
                result = Math.max(result, dp[u][c]);
            }
        }

        // If not all nodes are visited, there is a cycle
        return visited == n ? result : -1;
    }
}