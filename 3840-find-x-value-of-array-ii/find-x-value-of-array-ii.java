class Solution {

    static class Node {
        int prod;
        int[] pref;

        Node(int k) {
            pref = new int[k];
        }
    }

    private int n;
    private int k;
    private int[] nums;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.nums = nums;
        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            nums[index] = value;
            update(1, 0, n - 1, index, value);

            // Get information for nums[start...n-1]
            Node result = query(
                    1,
                    0,
                    n - 1,
                    start,
                    n - 1);

            ans[i] = result.pref[x];
        }

        return ans;
    }

    private void build(int node, int left, int right) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = nums[left] % k;

            tree[node].prod = rem;
            tree[node].pref[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]);
    }

    private void update(
            int node,
            int left,
            int right,
            int index,
            int value) {

        if (left == right) {

            tree[node] = new Node(k);

            int rem = value % k;

            tree[node].prod = rem;
            tree[node].pref[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(
                tree[node * 2],
                tree[node * 2 + 1]);
    }

    private Node query(
            int node,
            int left,
            int right,
            int ql,
            int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(
                    node * 2,
                    left,
                    mid,
                    ql,
                    qr);
        }

        if (ql > mid) {
            return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    ql,
                    qr);
        }

        Node leftNode = query(
                node * 2,
                left,
                mid,
                ql,
                qr);

        Node rightNode = query(
                node * 2 + 1,
                mid + 1,
                right,
                ql,
                qr);

        return merge(leftNode, rightNode);
    }

    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        result.prod = (left.prod * right.prod) % k;

        for (int r = 0; r < k; r++) {
            result.pref[r] += left.pref[r];
        }

        for (int r = 0; r < k; r++) {

            if (right.pref[r] == 0) {
                continue;
            }

            int newRemainder = (left.prod * r) % k;

            result.pref[newRemainder] += right.pref[r];
        }

        return result;
    }
}