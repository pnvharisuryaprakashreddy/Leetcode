import java.util.Arrays;
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        String foundResult = null;
        for (int i = 0; i < n; i++) {
            int[] countsAfterPrefixMatch = Arrays.copyOf(charCounts, 26);
            StringBuilder currentPrefix = new StringBuilder();
            boolean possiblePrefix = true;
            for (int j = 0; j < i; j++) {
                char charToMatch = target.charAt(j);
                if (countsAfterPrefixMatch[charToMatch - 'a'] > 0) {
                    countsAfterPrefixMatch[charToMatch - 'a']--;
                    currentPrefix.append(charToMatch);
                } else {
                    possiblePrefix = false;
                    break;
                }
            }
            if (!possiblePrefix) {
                continue;
            }
            for (char c_val_char = (char) ('a'); c_val_char <= 'z'; c_val_char++) {
                if (c_val_char <= target.charAt(i)) {
                    continue;
                }
                if (countsAfterPrefixMatch[c_val_char - 'a'] > 0) {
                    int[] remainingCountsForSuffix = Arrays.copyOf(countsAfterPrefixMatch, 26);
                    remainingCountsForSuffix[c_val_char - 'a']--;
                    StringBuilder candidateBuilder = new StringBuilder(currentPrefix);
                    candidateBuilder.append(c_val_char);
                    for (char fill_char = 'a'; fill_char <= 'z'; fill_char++) {
                        while (remainingCountsForSuffix[fill_char - 'a'] > 0) {
                            candidateBuilder.append(fill_char);
                            remainingCountsForSuffix[fill_char - 'a']--;
                        }
                    }
                    String candidate = candidateBuilder.toString();
                    if (foundResult == null || candidate.compareTo(foundResult) < 0) {
                        foundResult = candidate;
                    }
                }
            }
        }
        return foundResult == null ? "" : foundResult;
    }
}
                   