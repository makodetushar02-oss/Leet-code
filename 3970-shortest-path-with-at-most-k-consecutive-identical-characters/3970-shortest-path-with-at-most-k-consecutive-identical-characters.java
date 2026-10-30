import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (n == 1) return 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        char[] chars = labels.toCharArray();
        long[][] dist = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        int[] minPoppedCount = new int[n];
        Arrays.fill(minPoppedCount, k + 1);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (u == n - 1) {
                return (int) d;
            }
            if (d > dist[u][count] || count >= minPoppedCount[u]) {
                continue;
            }
            minPoppedCount[u] = count;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];
                int nextCount = (chars[u] == chars[v]) ? count + 1 : 1;

                if (nextCount <= k) {
                    long nextDist = d + w;
                    if (nextCount < minPoppedCount[v] && nextDist < dist[v][nextCount]) {
                        dist[v][nextCount] = nextDist;
                        pq.offer(new long[]{nextDist, v, nextCount});
                    }
                }
            }
        }
        return -1;
    }
}