class Solution {
    public int kthFactor(int n, int k) {
        int c = 0;
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                c++;
                if (c == k) {
                    return i;
                }
            }
        }
        if (sqrtN * sqrtN == n) {
            sqrtN--;
        }
        for (int i = sqrtN; i > 0; i--) {
            if (n % i == 0) {
                c++;
                if (c == k) {
                    return n / i; 
                }
            }
        }
        
        return -1;
    }
}