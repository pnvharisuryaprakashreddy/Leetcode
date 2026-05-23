class Solution {
    public boolean check(int[] nums) {
        // Arrays.sort(nums);
         int x = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>nums[(i+1)%nums.length])
            {
                x++;
            }
            if(x>1)
            {
                return false;
            }
        }
        return true;
    }
}