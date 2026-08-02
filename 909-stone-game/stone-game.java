class Solution {
    public boolean stoneGame(int[] piles) {
        for(int i=0;i<piles.length;i++)
        {
            for(int j=piles.length-1;i<piles.length;i++)
            {
                if(piles[i]==piles[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}