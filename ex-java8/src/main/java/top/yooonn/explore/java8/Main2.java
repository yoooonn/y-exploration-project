package top.yooonn.explore.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yooonn
 * @date 2023.03.16
 */
public class Main2 {

    public static void main(String[] args) {

    }
}

class Solution2 {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.fre - o1.fre;
            }
        });
        Map<Integer, Node> map = new HashMap<>();
        for (int num : nums) {
            Node node = map.get(num);
            if (node == null) {
                Node e = new Node(num, 1);
                queue.add(e);
                map.put(num, e);
            } else {
                node.fre = node.fre + 1;
                queue.remove(node);
                queue.add(node);
            }
        }
        int len = 0;
        int[] ans = new int[k];
        while (len < k && !queue.isEmpty()) {
            ans[len++] = queue.poll().x;
        }
        return ans;
    }
}

class Node {

    int x;
    int fre;

    public Node(int x, int fre) {
        this.x = x;
        this.fre = fre;
    }
}