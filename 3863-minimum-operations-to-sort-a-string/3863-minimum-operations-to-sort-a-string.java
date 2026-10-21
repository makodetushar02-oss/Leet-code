class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;
        char mn = 'z', mx = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        char first = s.charAt(0), last = s.charAt(n - 1);
        if (first == mn || last == mx) return 1;
        int cntMn = 0, cntMx = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == mn) cntMn++;
            if (c == mx) cntMx++;
        }
        if (first == mx && cntMx == 1 && last == mn && cntMn == 1) return 3;
        return 2;
    }
}