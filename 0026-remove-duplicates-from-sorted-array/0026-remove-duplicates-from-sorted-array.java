class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int k=1;
        while(i<nums.length){
            if(nums[i]!=nums[k-1]){
                nums[k]=nums[i];
                k++;
            }else{
                i++;
            }
        }
        return k;
    }
}