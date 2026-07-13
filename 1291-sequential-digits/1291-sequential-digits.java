class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";
        for(int length = 2 ; length <=9; length++){
            for(int i = 0; i<= digits.length() - length;i++){
                String sub = digits.substring(i , i + length);
                int num = Integer.parseInt(sub);
                if(num >= low && num <= high){
                    result.add(num);
                }
            }
        }
        return result ;
    }
}