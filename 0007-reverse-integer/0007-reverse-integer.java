class Solution {
    public int reverse(int x) {
        int number = x;
        int reverse = 0;
        while(number != 0){
            int digit = number % 10;
            //check for overflowing and under flow
            if ((reverse > Integer.MAX_VALUE / 10) || (reverse < Integer.MIN_VALUE / 10)){
                return 0;
            }
            reverse = reverse*10 + digit;
            number /=10;
        }

        return reverse;
    }
}