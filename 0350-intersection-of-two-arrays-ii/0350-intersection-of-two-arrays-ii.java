class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      if(nums1.length > nums2.length){
        return intersect(nums2 , nums1);
      }
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0)+1);
      }  
      List<Integer> intersection = new ArrayList<>();
      for(int num : nums2){
        int count = map.getOrDefault(num ,0);
        if(count > 0){
            intersection.add(num);
            map.put(num , count-1);
        }
      }
      int[] arr = new int[intersection.size()];
      int i = 0 ;
      for(int num : intersection){
        arr[i++] = num;
      }
      return arr ;
    }
}