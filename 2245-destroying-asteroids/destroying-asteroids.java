class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr = mass;
        for (int ast : asteroids) {
            if (curr < ast)
                return false;
            curr += ast;
        }
        return true;
    }
}