class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            map.add(candyType[i]);
        }

        if (map.size() < candyType.length / 2) {
            return map.size();
        } else {
            return candyType.length / 2;
        }
    }
}