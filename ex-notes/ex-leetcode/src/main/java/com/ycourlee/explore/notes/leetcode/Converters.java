package com.ycourlee.explore.notes.leetcode;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author yooonn
 * @date 2022.05.21
 */
public class Converters {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        while (node != null) {
            result.append(node.val).append(", ");
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static boolean stringToBool(String input) {
        return input.equalsIgnoreCase("true");
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder output = new StringBuilder();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output.append("null, ");
                continue;
            }

            output.append(node.val).append(", ");
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    @Nullable
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static ArrayList<Integer> stringToIntegerArrayList(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (String s : parts) {
            String part = s.trim();
            output.add(Integer.parseInt(part));
        }
        return output;
    }

    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void prettyPrintTree(TreeNode node) {
        prettyPrintTree(node, "", true);
    }

    public static void prettyPrintLinkedList(ListNode node) {
        while (node != null && node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("Empty LinkedList");
        }
    }

    public static String char2dArrayToString(char[][] array) {
        if (array == null) {
            return "null";
        }

        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (char[] row : array) {
            sb.append(charToString(row));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String charArrayToString(char[] chars, int length) {
        if (chars == null) {
            return "null";
        }

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < length; i++) {
            jsonArray.add(String.valueOf(chars[i]));
        }
        return jsonArray.toString();
    }

    public static String charArrayToString(char[] chars) {
        if (chars == null) {
            return "null";
        }

        return charArrayToString(chars, chars.length);
    }

    public static String stringToString(String input) {
        return Json.array("[" + input + "]").get(0).asString();
    }

    public static String charToString(char c) {
        return stringToString(String.valueOf(c));
    }

    public static String charToString(char[] c) {
        return stringToString(String.valueOf(c));
    }

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static String int2dArrayToString(int[][] array) {
        if (array == null) {
            return "null";
        }
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append(Arrays.toString(item));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String doubleArrayToString(double[] input) {
        JsonArray jsonArray = Json.array(input);
        double[] arr = new double[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asDouble();
        }
        return Arrays.toString(arr);
    }

    public static List<Double> stringToDoubleList(String input) {
        JsonArray jsonArray = Json.array(input);
        List<Double> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.get(i).asDouble());
        }
        return list;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = Json.array(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String[][] stringToString2dArray(String line) {
        JsonArray jsonArray = Json.array(line);
        if (jsonArray.size() == 0) {
            return new String[0][0];
        }
        String[][] arr = new String[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToStringArray(cols.toString());
        }
        return arr;
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = Json.array(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static List<List<String>> stringToString2dList(String input) {
        JsonArray jsonArray = Json.array(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToStringList(cols.toString()));
        }
        return list;
    }

    public static List<String> stringToStringList(String line) {
        JsonArray jsonArray = Json.array(line);
        List<String> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.get(i).asString());
        }
        return arr;
    }

    public static List<Integer> stringToIntegerList(String input) {
        JsonArray jsonArray = Json.array(input);
        List<Integer> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.get(i).asInt());
        }
        return arr;
    }

    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = Json.array(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result.append(number).append(", ");
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
