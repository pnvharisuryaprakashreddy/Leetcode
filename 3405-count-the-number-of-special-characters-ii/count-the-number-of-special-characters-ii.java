class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;

        for(char ch = 'a'; ch <= 'z'; ch++) {
            int small = word.indexOf(ch);
            int capital = word.indexOf(Character.toUpperCase(ch));

            if(small != -1 && capital != -1) {
                if(word.lastIndexOf(ch) < capital) {
                    ans++;
                }
            }
        }

        return ans;
    }
}