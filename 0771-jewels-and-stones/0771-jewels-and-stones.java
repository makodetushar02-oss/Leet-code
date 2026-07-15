class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (set.contains(s)) {
                count++;
            }
        }
        
        return count;
    }
}