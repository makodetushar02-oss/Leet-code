class Solution {
    private int[] newParent;
    private int[] lastSeen = new int[26];
    private List<List<Integer>> origAdj;
    private List<List<Integer>> finalAdj;
    private int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        newParent = Arrays.copyOf(parent, n);
        Arrays.fill(lastSeen, -1);
        origAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            origAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            origAdj.get(parent[i]).add(i);
        }
        dfsRewire(0, s);
        finalAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            finalAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalAdj.get(newParent[i]).add(i);
        }
        ans = new int[n];
        computeSizes(0);
        return ans;
    }
    private void dfsRewire(int u, String s) {
        int idx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[idx];

        if (u != 0 && prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        lastSeen[idx] = u;
        for (int v : origAdj.get(u)) {
            dfsRewire(v, s);
        }
        lastSeen[idx] = prevAncestor;
    }
    private int computeSizes(int u) {
        int size = 1;
        for (int v : finalAdj.get(u)) {
            size += computeSizes(v);
        }
        ans[u] = size;
        return size;
    }
}
