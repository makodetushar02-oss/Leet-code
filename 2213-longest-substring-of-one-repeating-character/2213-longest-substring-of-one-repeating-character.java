class Solution {
    class Node {
        int max;
        int pref, suff;
        char prefChar, suffChar;
        int len;
    }
    Node[] tree;
    String s;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        this.s = s;
        tree = new Node[4 * n];
        build(1, 0, n - 1);
        int k = queryCharacters.length();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].max;
        }
        return ans;
    }
    void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node();
            tree[node].max = tree[node].pref = tree[node].suff = 1;
            tree[node].prefChar = tree[node].suffChar = s.charAt(start);
            tree[node].len = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].prefChar = tree[node].suffChar = c;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    Node merge(Node left, Node right) {
        Node res = new Node();
        res.len = left.len + right.len;
        res.prefChar = left.prefChar;
        res.suffChar = right.suffChar;
        res.pref = left.pref;
        if (left.pref == left.len && left.suffChar == right.prefChar) {
            res.pref += right.pref;
        }
        res.suff = right.suff;
        if (right.suff == right.len && right.prefChar == left.suffChar) {
            res.suff += left.suff;
        }
        res.max = Math.max(left.max, right.max);
        if (left.suffChar == right.prefChar) {
            res.max = Math.max(res.max, left.suff + right.pref);
        }
        return res;
    }
}