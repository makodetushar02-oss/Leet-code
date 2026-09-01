class Solution {
    public double myPow(double x, int n) {
        boolean isNeg = false;
        if(n<0){
            isNeg = true;
            n = Math.abs(n);
        }
        double ans = Pow(x , n);
        return isNeg ? 1/ans : ans ;
    }
        public double Pow(double x, int n){
        if(n == 1) return x ;
        if(n == 0) return 1;;
        double ans = Pow(x , n/2);
        return (n % 2 == 0) ? ans*ans : ans*ans*x;
        }
}