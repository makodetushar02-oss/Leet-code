class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i =1; i <= n; i++){
            list.add(i);
        }
       return find(list,k,0);
    }
    private int find(List<Integer> list , int k, int i){
         if(list.size() == 1 ) return list.get(0);
         i = (i + k - 1) % list.size(); 
         list.remove(i);
         return find(list,k,i); 
    }
}