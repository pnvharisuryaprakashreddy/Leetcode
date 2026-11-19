class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length-1] - nums[2];
        int b = nums[nums.length-2] - nums[1];
        int c = nums[nums.length-3] - nums[0];
        return Math.min(a,Math.min(b,c));
        // nums[0] = 6;
        // nums[1] = 6;
        // int max = 0;
        // int res = nums[0] - nums[1];
        // for(int i=2; i<nums.length;i++)
        // {
        //     for(int j=i+1; j<nums.length;j++)
        //     {
        //         if(nums[i] != 0)
        //         {
        //             int fin = nums[i]-nums[j];
        //             max = Math.max(max, fin);
        //         }
        //     }
        // }
        // return max - res;
    }
}