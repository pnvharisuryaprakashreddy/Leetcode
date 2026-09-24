class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentNum = nums[i];
            int digitSum = 0;
            int temp = currentNum;

            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }

            if (currentNum == 0) {
                digitSum = 0;
            }

            if (digitSum == i) {
                return i;
            }
        }
        return -1;
        }
}