class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max=0;
        int sum=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(set.contains(nums[right])){
                sum-=nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            max=Math.max(max,sum);

        }
        return max;
    }
}