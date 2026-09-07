class Solution {
    public int removeDuplicates(int[] nums) {
        int k=2;
        int i=2;
        while(i<nums.length){
            if(nums[i] !=nums[k-2]){
                nums[k]=nums[i];
                k++;    
            }
            i++;
        }
        return k;
    }
}