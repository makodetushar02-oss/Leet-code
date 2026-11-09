class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add(busy.poll()[1]);
            }

            if (free.isEmpty()) continue; 
            Integer server = free.ceiling(i % k);
            if (server == null) server = free.first(); 
            free.remove(server);
            count[server]++;
            busy.offer(new int[]{start + load[i], server});
        }

        int max = 0;
        for (int c : count) max = Math.max(max, c);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) res.add(i);
        }
        return res;
    }
}