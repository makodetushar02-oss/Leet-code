class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            }   
        }
        int mostFreq = -1;
        int maxCout = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int currentNum = entry.getKey();
            int currentCount = entry.getValue();
            if(currentCount > maxCout || (currentCount == maxCout && currentNum < mostFreq)){
                maxCout = currentCount;
                mostFreq = currentNum;
            }
        }
        return mostFreq;
    }
}