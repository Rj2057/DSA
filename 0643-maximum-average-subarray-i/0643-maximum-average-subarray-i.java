class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        double sum=0;
        double max;
        double average;

        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        max=sum;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[i-k]+nums[i];
            max=Math.max(max,sum);
        }
        

        average=max/k;    

    return average;
    }
}