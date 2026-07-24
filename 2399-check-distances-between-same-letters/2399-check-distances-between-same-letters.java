class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(int i = 0 ; i < distance.length; i++){
            char ch = (char)(i + 97);
            if(s.indexOf(ch) != -1) {
                if((s.lastIndexOf(ch) - s.indexOf(ch) - 1) != distance[i]){
                    return false; 
                }
            }
        }
        return true; 
    }
}