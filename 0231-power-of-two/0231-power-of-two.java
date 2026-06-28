class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n >= Integer.MIN_VALUE && n<= Integer.MAX_VALUE){
        return (n>0 && (n & (n-1)) == 0);
       } 
       return true;
    }
}