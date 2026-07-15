class Solution {
    public boolean checkIfPangram(String sentence) {
       HashSet<Character> set = new HashSet<>();
       int arr[] = new int[26];
       for(int i =0; i< sentence.length(); i++){
            char ch = sentence.charAt(i);
            set.add(ch);
        } 
        return set.size() == 26;
    }
}