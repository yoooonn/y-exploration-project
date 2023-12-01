package com.ycourlee.explore.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yooonn
 * @date 2023.03.14
 */
public class Main {

    /**
     * 4
     * 1    2   3
     * 2 3  1 3   1  2
     * 3  2
     *
     * @param args args
     */
    public static void main(String[] args) {
        for (List<Integer> integers : new Solution().permute(new int[]{1, 2, 3, 4})) {
            System.out.println(integers);
        }
    }
}

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        permute(nums, visited, current, result);
        return result;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                permute(nums, visited, current, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}