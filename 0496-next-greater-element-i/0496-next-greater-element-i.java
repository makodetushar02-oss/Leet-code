class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st  = new Stack<>();
        Map<Integer ,Integer> map = new HashMap<>();
        int n = nums2.length -1 ;
        int next = -1;
        for(int i = n ; i>= 0; i--){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i], next);
            }
            else{
                map.put(nums2[i], st.peek());
            }
            st.push(nums2[i]);
        }
        int[] arr = new int[nums1.length];
        for(int i= 0; i < nums1.length; i++){
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}