import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<long[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });
        for (int i = 0; i < n; i++) {
            freeServers.offer(new long[]{servers[i], i});
        }
        
        int[] ans = new int[m];
        long currentTime = 0;
        
        for (int j = 0; j < m; j++) {
            currentTime = Math.max(currentTime, j);
            if (freeServers.isEmpty() && busyServers.peek()[0] > currentTime) {
                currentTime = busyServers.peek()[0];
            }
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currentTime) {
                long[] server = busyServers.poll();
                freeServers.offer(new long[]{server[1], server[2]});
            }
            long[] assigned = freeServers.poll();
            ans[j] = (int) assigned[1];
            busyServers.offer(new long[]{currentTime + tasks[j], assigned[0], assigned[1]});
        }
        
        return ans;
    }
}