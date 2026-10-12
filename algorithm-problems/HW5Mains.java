// HW5Mains.java
package HW5;

import java.util.Arrays;

public class HW5Mains {
    public static void main(String[] args) {
        // ex1:
        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = HW5.sumIndex(nums1, 9);
        System.out.println("Test 1: " + Arrays.toString(result1));

        // ex2:
        int[] nums = {5, 3, 3, 8, 3, 2, 1};
        int val = 3;
        int k = HW5.rearrangeArray(nums, val);
        System.out.println("k = " + k);
        System.out.println("nums = " + Arrays.toString(nums));

        // ex3:
        System.out.println(HW5.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(HW5.lengthOfLongestSubstring("bbbbb"));

        // ex4:
        String[] strs1 = {"flower", "flow", "fly"};
        System.out.println(HW5.longestCommonPrefix(strs1));
        String[] strs2 = {"dog", "runner", "rumpus"};
        System.out.println(HW5.longestCommonPrefix(strs2));

        // ex5:
        int[][] mat = {
                {0, 1, 1},
                {2, 4, 5},
                {7, 8, 8}
        };
        System.out.println(HW5.findIndexSortedMat(mat, 4));
        System.out.println(HW5.findIndexSortedMat(mat, 20));

        // ex6:
        int[] arr1 = {1, 2, 2, 3, 4, 6, 6};
        System.out.println(HW5.findMultiSortedArray(arr1, 24));
        int[] arr2 = {1, 2, 3, 5, 7};
        System.out.println(HW5.findMultiSortedArray(arr2, 15));

        // ex7:
        char[] arr = {'d', 'a', 'z', 'b', 'e', 'c'};
        HW5.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        // ex8:
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(HW5.orangesRotting(grid1));
    }
}