class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(target == nums[i]) list.add(i);
        }
        return list;
    }
}