class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }
        boolean isInc = true;
        for (int k = 0; k < n; k++) {
            if (nums[(zeroIdx + k) % n] != k) {
                isInc = false;
                break;
            }
        }

        if (isInc) {
            if (zeroIdx == 0) return 0;
            int op1 = zeroIdx;
            int op2 = 1 + (n - zeroIdx) + 1;
            return Math.min(op1, op2);
        }
        boolean isDec = true;
        for (int k = 0; k < n; k++) {
            if (nums[(zeroIdx - k + n) % n] != k) {
                isDec = false;
                break;
            }
        }

        if (isDec) {
            int op1 = 1 + (n - 1 - zeroIdx);
            int op2 = ((zeroIdx + 1) % n) + 1;

            return Math.min(op1, op2);
        }

        return -1;
    }
}