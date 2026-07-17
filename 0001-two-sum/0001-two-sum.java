class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums.length ;i++){
            int sec = target - nums[i];
            if(map.containsKey(sec)){
                int first= i;
                int second= map.get(sec);
                return new int[] {first, second};
            }
            map.put(nums[i], i);
        }
       return new int[] {-1,-1};
    }
}