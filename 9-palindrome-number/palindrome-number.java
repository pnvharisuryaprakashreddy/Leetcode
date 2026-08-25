class Solution {
    public boolean isPalindrome(int x) {
        int dup = x;
        int dum = 0;
            while(x>0)
            {
                int dig = x%10;
                dum = dum * 10 + dig;
                x = x/10;
            }
        return dum == dup;
    }
}