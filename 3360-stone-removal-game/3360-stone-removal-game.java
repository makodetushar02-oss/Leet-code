class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean alice = true;
        while(remove > 0){
            if(n < remove){
                return !alice;
            }
            n -= remove;
            remove--;
            alice = !alice;
        }
        return false;
    }
}