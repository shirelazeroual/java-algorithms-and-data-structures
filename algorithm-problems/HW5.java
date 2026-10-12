// HW5.java
package HW5;

import java.util.*;

public class HW5 {
    // ex1
    public static int[] sumIndex(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // ex2
    public static int rearrangeArray(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = val;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return k;
    }

    // ex3
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Set<Character> seen = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            while (seen.contains(current)) {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(current);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // ex4
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                if (prefix.length() == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    // ex5
    public static boolean findIndexSortedMat(int[][] mat, int val) {
        int n = mat.length;
        int left = 0;
        int right = n * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n;
            int col = mid % n;
            int current = mat[row][col];
            if (current == val) {
                return true;
            } else if (current < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // ex6
    public static boolean findMultiSortedArray(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] * arr[i + 1] == k) {
                return true;
            }
        }
        return false;
    }

    // ex7
    public static void mergeSort(char[] array) {
        int n = array.length;
        char[] temp = new char[n];
        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size, n);
                int rightEnd = Math.min(leftStart + 2 * size, n);
                int i = leftStart, j = mid, k = leftStart;
                while (i < mid && j < rightEnd) {
                    if (array[i] > array[j]) {
                        temp[k++] = array[i++];
                    } else {
                        temp[k++] = array[j++];
                    }
                }
                while (i < mid) temp[k++] = array[i++];
                while (j < rightEnd) temp[k++] = array[j++];
            }
            for (int i = 0; i < n; i++) {
                array[i] = temp[i];
            }
        }
    }

    // ex8
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean changed = false;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.add(new int[]{r, c});
                        fresh--;
                        changed = true;
                    }
                }
            }
            if (changed) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}
