class Solution {
    public int totalNumbers(int[] digits) {
        int[] digitCount = new int[10];
        for (int digit : digits) {
            digitCount[digit]++;
        }
        
        int validNumbers = 0;
        for (int num = 100; num < 1000; num += 2) {
            int[] currentNumCount = new int[10];
            int temp = num;
            while (temp > 0) {
                currentNumCount[temp % 10]++;
                temp /= 10;
            }
            boolean isValid = true;
            for (int i = 0; i < 10; i++) {
                if (currentNumCount[i] > digitCount[i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                validNumbers++;
            }
        }
        return validNumbers;
    }
}