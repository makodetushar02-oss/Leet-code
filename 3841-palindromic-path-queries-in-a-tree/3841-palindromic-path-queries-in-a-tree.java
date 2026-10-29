import java.util.*;

class Solution {
    private int timer = 0;
    private int[] tin, tout, depth;
    private int[][] up;
    private int LOG;
    private int[] bit;
    private int n;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        this.LOG = 17; 
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[2 * (n - 1)];
        int[] next = new int[2 * (n - 1)];
        int edgeIdx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            to[edgeIdx] = v;
            next[edgeIdx] = head[u];
            head[u] = edgeIdx++;
            
            to[edgeIdx] = u;
            next[edgeIdx] = head[v];
            head[v] = edgeIdx++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        up = new int[n][LOG];
        bit = new int[n + 2];

        dfsIterative(0, head, to, next);

        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            masks[i] = 1 << (s.charAt(i) - 'a');
            rangeXor(tin[i], tout[i], masks[i]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                char c = q.charAt(secondSpace + 1);

                int newMask = 1 << (c - 'a');
                int diff = masks[u] ^ newMask;
                if (diff != 0) {
                    masks[u] = newMask;
                    rangeXor(tin[u], tout[u], diff);
                }
            } else {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                int v = Integer.parseInt(q.substring(secondSpace + 1));

                int lca = getLCA(u, v);
                int pathMask = pointQuery(tin[u]) ^ pointQuery(tin[v]) ^ masks[lca];
                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        return ans;
    }

    private void dfsIterative(int root, int[] head, int[] to, int[] next) {
        int[] stack = new int[n];
        int[] edgePtr = new int[n];
        int top = 0;

        stack[0] = root;
        edgePtr[0] = head[root];
        tin[root] = ++timer;

        while (top >= 0) {
            int u = stack[top];
            int e = edgePtr[top];

            if (e != -1) {
                edgePtr[top] = next[e];
                int v = to[e];
                if (top == 0 || v != stack[top - 1]) {
                    depth[v] = depth[u] + 1;
                    up[v][0] = u;
                    for (int j = 1; j < LOG; j++) {
                        up[v][j] = up[up[v][j - 1]][j - 1];
                    }
                    tin[v] = ++timer;
                    top++;
                    stack[top] = v;
                    edgePtr[top] = head[v];
                }
            } else {
                tout[u] = timer;
                top--;
            }
        }
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) != 0) {
                u = up[u][j];
            }
        }
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    private void add(int idx, int val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private void rangeXor(int l, int r, int val) {
        add(l, val);
        add(r + 1, val);
    }

    private int pointQuery(int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res ^= bit[idx];
        }
        return res;
    }
}