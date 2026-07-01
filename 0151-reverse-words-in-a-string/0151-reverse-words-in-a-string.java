class Solution {
    public String reverseWords(String s) {
      s=s.trim();  
      StringBuilder sb = new StringBuilder();
      int right=s.length()-1;
      while(right >=0 ){
       while(s.charAt(right) ==' ' ){
        right--;
       }
       int left=right;
       while(left >=0 && s.charAt(left) !=' '){
        left--;
       }
       String s1 = s.substring(left+1,right+1);
       if(sb.length() == 0){
        sb.append(s1);
       }else{
        sb.append(" ");
        sb.append(s1);
       }
       right=left;
       

      }
      return sb.toString(); 
    }
} //151 slution.