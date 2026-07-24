class Solution {
    public int pivotIndex(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
        int rig = 0;
        int lef = 0;
            for(int j=0;j<i;j++)
            {
                lef += nums[j];
            }
            for(int  j = i+1;j<nums.length;j++)
            {
                rig += nums[j];
            }
            if(lef == rig) 
            {
                return i;
            }
        }
        return -1;
    }
}