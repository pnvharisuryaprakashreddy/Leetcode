class Solution {
    public int largestAltitude(int[] gain) {
        int dup = 0;
        int max = 0;
        for(int i=0;i<gain.length;i++)
        {
            dup += gain[i];
            max = Math.max(max, dup);
        }
        return max;
    }
}