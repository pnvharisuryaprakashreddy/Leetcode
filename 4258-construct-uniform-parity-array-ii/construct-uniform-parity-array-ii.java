class Solution {
    public boolean uniformArray(int[] nums1) {
        int od = 0;
        int s=Integer.MAX_VALUE;
        for(int num : nums1){
            if(num%2!=0)
            {
                od++;
            }
            if(num<s)
            {
                s=num;
            }
        }
        if(od==0 || od == nums1.length)
        {
            return true;
        }
        if(s % 2!= 0)
        {
            return true;
        }
        return false;
    }
}