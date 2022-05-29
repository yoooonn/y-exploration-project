package com.ycourlee.explore.notes.algorithm;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yooonn
 * @date 2022.05.28
 */
public class DlxAlgorithm {

    Node          head;
    List<Node>    data;
    List<Integer> ans = new ArrayList<>();

    public boolean dancing() {
        if (head.right == head) {
            return true;
        }
        Node colHead = head.right;
        removeColumnHead(colHead);

        Node node = colHead.down;
        while (node != colHead) {
            ans.add(node.row);

            removeRowColumnHead(node);

            if (dancing()) {
                return true;
            }

            restoreRowColumnHead(node);
            ans.remove(ans.lastIndexOf(node.row));
            node = node.down;
        }

        restoreColumnHead(colHead);
        return false;
    }

    private void restoreRowColumnHead(Node node) {
        Node leftNode = node.left;
        while (leftNode != node) {
            restoreColumnHead(getColHead(leftNode));
            leftNode = leftNode.left;
        }
    }

    private void removeRowColumnHead(Node node) {
        Node rightNode = node.right;
        while (rightNode != node) {
            removeColumnHead(getColHead(rightNode));
            rightNode = rightNode.right;
        }
    }

    private void removeColumnHead(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;

        Node down = node.down;
        while (down != node) {
            Node right = down.right;
            while (right != down) {
                right.up.down = right.down;
                right.down.up = right.up;
                right = right.right;
            }
            down = down.down;
        }
    }

    private void restoreColumnHead(Node node) {
        node.left.right = node;
        node.right.left = node;

        Node up = node.up;
        while (up != node) {
            Node right = up.right;
            while (right != up) {
                right.up.down = right;
                right.down.up = right;
                right = right.right;
            }
            up = up.up;
        }
    }

    /**
     * Get first node of node's column. AKA column head.
     *
     * @param node one node
     * @return column head node.
     */
    @Nonnull
    private Node getColHead(Node node) {
        return data.get(node.col);
    }

    public DlxAlgorithm initWith(List<String> lines) {
        int col = lines.get(0).split("[,]").length;
        data = new ArrayList<>(col);
        initColumnHeads(col);

        initRows(lines);
        head = new Node();
        head.right = data.get(0);
        head.left = data.get(0).left;

        data.get(0).left.right = head;
        data.get(0).left = head;

        // printRel();
        return this;
    }

    private void printRel() {
        System.out.println("            :   上   ,  下    ,  左   ,    右 ");
        String format = "node(%s, %s): (%s, %s), (%s, %s), (%s, %s), (%s, %s)";

        int row = 0;
        for (Node node : data) {
            if (node.row != row) {
                System.out.println();
                row = node.row;
            }
            System.out.println(String.format(format,
                    node.row, node.col,
                    node.up.row, node.up.col,
                    node.down.row, node.down.col,
                    node.left.row, node.left.col,
                    node.right.row, node.right.col));
        }
    }

    private void initRows(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String[] numbers = lines.get(i).split(",");
            boolean firstElement = true;
            for (int j = 0; j < numbers.length; j++) {
                if (!numbers[j].equals("1")) {
                    continue;
                }
                Node node = new Node(i + 1, j);

                node.down = data.get(j);
                node.up = data.get(j).up;

                data.get(j).up.down = node;
                data.get(j).up = node;

                if (firstElement) {
                    node.left = node;
                    node.right = node;
                    firstElement = false;
                } else {
                    node.left = data.get(data.size() - 1);
                    node.right = data.get(data.size() - 1).right;

                    data.get(data.size() - 1).right.left = node;
                    data.get(data.size() - 1).right = node;
                }
                data.add(node);
            }
        }
    }

    private void initColumnHeads(int col) {
        for (int i = 0; i < col; i++) {
            Node node = new Node(0, i);
            node.up = node;
            node.down = node;
            if (i == 0) {
                node.left = node;
                node.right = node;
            } else {
                node.left = data.get(data.size() - 1);
                node.right = data.get(data.size() - 1).right;

                data.get(data.size() - 1).right.left = node;
                data.get(data.size() - 1).right = node;
            }
            data.add(node);
        }
    }

    static class Node {

        Node left;
        Node right;
        Node up;
        Node down;
        int  row;
        int  col;

        public Node() {
        }

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
