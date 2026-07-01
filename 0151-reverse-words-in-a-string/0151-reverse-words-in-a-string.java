class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] s1=s.split("\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            sb.append(s1[i]);
            if(i !=0){
                sb.append(" ");
            }
        }
        s=sb.toString();
        return s;
    }
}