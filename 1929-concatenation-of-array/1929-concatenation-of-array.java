class Solution {
    public int[] getConcatenation(int[] nums) {
        int j=nums.length;
        int[] ans = new int[j*2];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
            ans[i+(nums.length)] = nums[i];
        }
    return ans;
    }
}