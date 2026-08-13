class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(s.contains(nums[i]))
            {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }
}
// HashSet<Integer> set= new HashSet<>();
        // boolean res=false;
        // for(int num : nums)
        // {
        //     if(set.contains(num))
        //     {
        //         res= true;
        //         break;
        //     }
        //     set.add(num);
        // }
        // return res;