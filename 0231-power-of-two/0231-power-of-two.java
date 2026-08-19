class Solution {
    public boolean isPowerOfTwo(int n) {

      return(n>0 && (n &(n-1)) == 0);  
    }   
}

// return(n>0 && (n &(n-1) == 0)) here the 2 perfect element and previous element bits are contradiction.