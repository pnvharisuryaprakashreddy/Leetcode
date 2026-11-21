import java.util.*;

class Solution {
    List<Integer>[] adj;
    List<Integer>[] tree;
    int[] ans;
    int[] nearest = new int[26];

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList[n];
        tree = new ArrayList[n];
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        Arrays.fill(nearest, -1);

        changeTree(0, parent, s);

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        calculate(0);

        return ans;
    }

    void changeTree(int node, int[] parent, String s) {
        int ch = s.charAt(node) - 'a';
        int old = nearest[ch];

        nearest[ch] = node;

        for (int child : adj[node]) {
            int c = s.charAt(child) - 'a';

            if (nearest[c] != -1) {
                parent[child] = nearest[c];
            }

            changeTree(child, parent, s);
        }

        nearest[ch] = old;
    }

    int calculate(int node) {
        ans[node] = 1;

        for (int child : tree[node]) {
            ans[node] += calculate(child);
        }

        return ans[node];
    }
}