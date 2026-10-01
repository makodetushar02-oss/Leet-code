class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int longest = 0 ;
        int sum = 0 ;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;
            if(!map.containsKey(sum)){
                map.put(sum , i);
            }
            if(map.containsKey(sum)){
                longest = Math.max(longest,i-map.get(sum) );
            }
        }
        return longest;
    }
}