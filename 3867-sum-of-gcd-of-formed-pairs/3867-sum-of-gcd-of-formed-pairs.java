class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxValue = 0;
        for(int i= 0; i<n; i++){
            maxValue = Math.max(maxValue , nums[i]);
            nums[i] = gcd(nums[i], maxValue);
        }
        java.util.Arrays.sort(nums);
        long sum = 0;
        int left = 0;
        int right = n-1;
        while(left< right){
            sum += gcd(nums[left], nums[right]);
            left++;
            right--;
        }
        return sum;
    }
        private int gcd(int a , int b){
            while(b!=0){
            int temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }
}