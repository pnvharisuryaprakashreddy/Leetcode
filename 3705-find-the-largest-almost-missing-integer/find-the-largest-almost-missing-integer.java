class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) 
        {
            int count = 0;
            for (int j = 0; j <= nums.length - k; j++) 
            {
                for (int z = j; z < j + k; z++) 
                {
                    if (nums[i] == nums[z]) 
                    {
                        count++;
                        break;
                    }
                }
            }
            if (count == 1) 
            {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }
}