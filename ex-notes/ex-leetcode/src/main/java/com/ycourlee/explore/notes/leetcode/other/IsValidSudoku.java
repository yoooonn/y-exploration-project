package com.ycourlee.explore.notes.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2f9gg/">有效的数独</a>
 *
 * @author yongjiang
 * @date 2022.05.22
 */
public class IsValidSudoku {


    static class Solution {

        public boolean isValidSudoku(char[][] board) {
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                chars.clear();
                for (int j = 0; j < 9; j++) {
                    chars.add(board[i][j]);
                }
                if (abnormal(chars)) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                chars.clear();
                for (int j = 0; j < 9; j++) {
                    chars.add(board[j][i]);
                }
                if (abnormal(chars)) {
                    return false;
                }
            }
            for (int i = 0; i < 9; i++) {
                int m = (i / 3) * 3;
                int n = (i % 3) * 3;
                chars.clear();
                for (int k = m; k < m + 3; k++) {
                    for (int l = n; l < n + 3; l++) {
                        chars.add(board[k + 1][l + 1]);
                    }
                }
                if (abnormal(chars)) {
                    return false;
                }
            }
            return true;
        }

        private boolean abnormal(List<Character> chars) {
            int[] mark = new int[10];
            for (Character c : chars) {
                if (c.equals('.')) {
                    continue;
                }
                int offset = c - '0';
                mark[offset]++;
                if (mark[offset] > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
