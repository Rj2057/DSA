class Solution {
    public int reverse(int x) {
        int number = x;
        int reverse = 0;
        while(number != 0){
            int digit = number % 10;
            //check for overflowing
            if( reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
            //check for underflowing
            if( reverse < Integer.MIN_VALUE /10 || (reverse == Integer.MIN_VALUE /10 && 
            digit < -8)){
                return 0;
            }
            reverse = reverse*10 + digit;
            number /=10;
        }

        return reverse;
    }
}