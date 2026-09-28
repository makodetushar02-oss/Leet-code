class Solution {
    public int shipWithinDays(int[] arr, int k) {
        long s=0, e=0, ans = -1;
        //start - max(arr), e = sum(arr)
        if(arr.length < k) return -1;
        
        for(int ele : arr){
            s = Math.max(ele, s);
            e += ele;
        }
        
        while(s <= e){
            long mid = s+(e-s)/2;
            
            if(isPos(arr, k, mid)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return (int)ans;
    }
     
    public boolean isPos(int pages[], int k, long capa){
        int curSum=0, curSt = 1;
        
        for(int page : pages){
            if(curSum + page > capa){
                curSt++;
                curSum = page;
                if(curSt > k) return false;
            }else{
                curSum += page;
            }
        }
        return true;
    }
    
}
