package com.ycourlee.explore.notes.algorithm.tree;

/**
 * <a href="https://www.luogu.com.cn/problem/P3373">【模板】线段树 2</a>
 *
 * @author yooonn
 * @date 2022.06.20
 */
public class SegmentTree {

    Node[] node;

    int n;

    public SegmentTree(int n) {
        this.n = n;
        node = new Node[(n + 1) << 2];
        build(1, n, 1);
    }

    private void build(int l, int r, int k) {
        node[k] = new Node();
        node[k].l = l;
        node[k].r = r;
        if (l == r) {
            node[k].sum = 1;
            return;
        }
        int mid = (l + r) >> 1;
        build(l, mid, k << 1);
        build(mid + 1, r, k << 1 | 1);
        pup(k);
    }

    /**
     * 标记回档
     *
     * @param k
     */
    private void pup(int k) {
        node[k].sum = node[k << 1].sum + node[k << 1 | 1].sum;
    }

    /**
     * 标记下放
     *
     * @param k
     */
    private void pdown(int k) {
        // 叶节点add标记 = 自己本身 + 上层父节点add标记
        node[k << 1].add += node[k].add;
        node[k << 1 | 1].add += node[k].add;

        // 叶节点sum标记 = 自己本身 + 上层父节点sum标记 * 自己辖内叶节点个数
        node[k << 1].sum += node[k].add * (node[k << 1].r - node[k << 1].l + 1);
        node[k << 1 | 1].sum += node[k].add * (node[k << 1 | 1].r - node[k << 1 | 1].l + 1);

        node[k].add = 0;
    }

    void update(int l, int r, int x, int k) {
        if (l <= node[k].l && node[k].r <= r) {
            node[k].add += x;
            node[k].sum += x * (node[k].r - node[k].l + 1);
            return;
        }
        if (node[k].add > 0) {
            pdown(k);
        }
        int mid = (node[k].l + node[k].r) >> 1;
        if (r <= mid) {
            update(l, r, x, k << 1);
        } else if (l > mid) {
            update(l, r, x, k << 1 | 1);
        } else {
            update(l, r, x, k << 1);
            update(l, r, x, k << 1 | 1);
        }
        pup(k);
    }

    int query(int l, int r, int k) {
        if (l <= node[k].l && node[k].r <= r) {
            return node[k].sum;
        }
        if (node[k].add > 0) {
            pdown(k);
        }
        int mid = (node[k].l + node[k].r) >> 1;
        if (r <= mid) {
            return query(l, r, k << 1);
        } else if (l > mid) {
            return query(l, r, k << 1 | 1);
        } else {
            return query(l, r, k << 1) + query(l, r, k << 1 | 1);
        }
    }

    static class Node {

        int l, r;
        int sum;

        /**
         * 加法标记
         */
        int add = 0;
    }
}
