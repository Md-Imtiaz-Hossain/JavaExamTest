package problem_04;

import java.util.Stack;

public class SnakeSequence {
    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 2, 4},
                {4, 3, 1, -1},
                {4, 3, 1, -1},
                {2, 2, 0, -1},
                {6, 0, 1, 0}
        };
        printLongestSnakeSequence(grid);
    }

    public static void printLongestSnakeSequence(int[][] grid) {
        int maxLen = 0;
        int maxRow = -1;
        int maxCol = -1;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 && Math.abs(grid[i][j] - grid[i - 1][j]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
                if (j != 0 && Math.abs(grid[i][j] - grid[i][j - 1]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
        }
        System.out.println("Longest snake sequence has length: " + (maxLen + 1));
        Stack<Integer> stack = new Stack<>();
        int i = maxRow;
        int j = maxCol;
        while (i >= 0 && j >= 0) {
            stack.push(grid[i][j]);
            if (i > 0 && dp[i][j] - 1 == dp[i - 1][j]) {
                i--;
            } else if (j > 0 && dp[i][j] - 1 == dp[i][j - 1]) {
                j--;
            } else {
                break;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
