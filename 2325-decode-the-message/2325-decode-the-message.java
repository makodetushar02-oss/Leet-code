class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character , Character > map = new HashMap<>();
        char alph = 'a';
        for(int i = 0; i<key.length() ; i++){
            char ch = key.charAt(i);
            if(!map.containsKey(ch) && ch != 32){
                map.put(ch , alph);
                alph++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< message.length(); i++){
            char ch = message.charAt(i);
            if(ch == 32) sb.append(" ");
            else sb.append(map.get(ch));
        }
        return sb.toString();
    }
}