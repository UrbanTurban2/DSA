class SegmentTree {
        public long[] nodes;
        int n;

        
        public SegmentTree(int max) {
            nodes = new long[4 * (max)];
            n = max;
        }
        public void add(int num, int val) {
            addUtil(num, val, 0, n, 0);
        }

        private void addUtil(int num, int val, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]+=val;
                return;
            }
            int mid = (l + r) / 2;
            addUtil(num, val, l, mid, 2 * node + 1);
            addUtil(num, val, mid + 1, r, 2 * node + 2);
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }
        // sum
        public long getSum(int l, int r) {
            return getUtil(l, r, 0, n, 0);
        }

        private long getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) {
                return (long)nodes[node];
            }

            int mid = (l + r) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    
}
