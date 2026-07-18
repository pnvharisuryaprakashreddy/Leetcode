class Solution {
    public int findGCD(int[] nums) {
        int sm = nums[0];
        int bi = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sm = Math.min(sm, nums[i]);
            bi = Math.max(bi, nums[i]);
        }

        return gcd(sm, bi);
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}