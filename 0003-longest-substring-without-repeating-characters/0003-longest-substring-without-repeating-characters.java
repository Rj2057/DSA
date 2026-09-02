class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> map = new HashSet<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            while(map.contains(s.charAt(right))){
                map.remove(s.charAt(left));
                left++;
            }
            
            map.add(s.charAt(right));

            max=Math.max(max,right-left+1);
        }
        return max;
    }
}