class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer , Boolean> map = new HashMap<>();
       for(int num : nums1){
        map.put(num, true);
       } 
       ArrayList<Integer> list = new  ArrayList<>();
      for(int num : nums2){
        if(map.containsKey(num)){
        list.add(num);
        map.remove(num);
       }
      }
      int[] arr = new int[list.size()];
      for(int i = 0; i< list.size(); i++){
            arr[i] = list.get(i);
      }
       return arr;
    }
}