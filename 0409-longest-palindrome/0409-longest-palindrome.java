class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i< s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        boolean isOdd = false;
        int sum = 0;
        for(char i : map.keySet()){
            if(map.get(i)%2 == 0){
                sum += map.get(i);
            }else{
                sum += (map.get(i) - 1) ;
                isOdd = true;
            }
        }
        return isOdd ? sum +1 : sum;
    }
}