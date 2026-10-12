package introtocsHW4;

import java.util.ArrayList;

public class HW4 {
    public static int findSecondMax(int[] arr) {
        // Validate that the array contains at least two elements
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("The array must contain at least two elements.");
        }

        // Find the maximum value in the array
        int max = findMax(arr);

        // Find the second maximum value by ignoring the maximum value
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            // If the number is not equal to the maximum and is larger than the second maximum
            if (num != max && num > secondMax) {
                secondMax = num;  // Update second maximum
            }
        }

        // If all elements are the same, return the maximum
        return (secondMax == Integer.MIN_VALUE) ? max : secondMax;
    }
    // Helper function to find the maximum value in the array
    private static int findMax(int[] arr) {
        int max = arr[0];  // Assume the first element is the maximum
        for (int num : arr) {
            // If we find a number greater than the current max, update max
            if (num > max) {
                max = num;
            }
        }
        return max;  // Return the maximum value found
    }

    public static boolean isPalindrome(String str) {
        // Call the recursive helper function to check if the string is a palindrome
        return checkPalindrome(str, 0, str.length() - 1);
    }

    // Recursive helper function to check if the string is a palindrome
    private static boolean checkPalindrome(String str, int left, int right) {
        // Base case: If the left index is greater than or equal to the right index, it's a palindrome
        if (left >= right) {
            return true;
        }

        // If characters at the left and right positions are not equal, it's not a palindrome
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursively check the next characters
        return checkPalindrome(str, left + 1, right - 1);
    }

    // Function to search for the word in the text
    public static boolean searchWord(String text, String word) {
        // Convert text and word to lowercase for case-insensitive comparison
        String lowerText = text.toLowerCase();
        String lowerWord = word.toLowerCase();

        // Split the text into words
        String[] words = lowerText.split("\\W+"); // Split by non-word characters

        // Check each word in the text
        for (String w : words) {
            if (w.equals(lowerWord)) {
                return true; // The word is found
            }
        }

        // If the word is not found, return false
        return false;
    }

    // Wrapper function
    public static String getOddIndexLetters(String str) {
        // Call the recursive function with an initial index of 1 and an empty result
        return getEvenIndexLettersRecursive(str, 1, "");
    }

    // Recursive function to extract characters at even indices starting from 1
    private static String getEvenIndexLettersRecursive(String str, int index, String result) {
        // Base case: if the index is out of bounds, return the result
        if (index >= str.length()) {
            return result;
        }

        // Add the character at the current index to the result
        result += str.charAt(index);

        // Recursive call for the next even index (index + 2)
        return getEvenIndexLettersRecursive(str, index + 2, result);
    }

    // Function to check if m is a power of n
    public static boolean isPower(int n, int m) {
        // Handle edge cases
        if (m == 1) {
            return true; // Any number raised to power 0 is 1
        }
        if (n == 1) {
            return m == 1; // 1^i is always 1
        }

        // Keep dividing m by n until m is no longer divisible by n
        while (m > 1) {
            if (m % n != 0) {
                return false; // m is not divisible by n, so m is not a power of n
            }
            m /= n; // Divide m by n
        }

        return true; // m is reduced to 1, so m is a power of n
    }

    // Function to check if there exists a subset that sums up to the given sum
    public static boolean subsetSum(int[] matrix, int sum) {
        // Convert the 2D matrix to a 1D array
        int[] arr = matrix;

        // Call the recursive function to check if a subset with the sum exists
        return subsetSumRecursive(arr, arr.length, sum);
    }

    // Recursive function to check if a subset with the sum exists
    private static boolean subsetSumRecursive(int[] arr, int n, int sum) {
        // Base case: if sum is 0, then return true (empty subset sums to 0)
        if (sum == 0) {
            return true;
        }

        // If no elements left or sum becomes negative, return false
        if (n == 0 || sum < 0) {
            return false;
        }

        // Include the current element and check if the subset sum exists
        if (arr[n - 1] <= sum) {
            if (subsetSumRecursive(arr, n - 1, sum - arr[n - 1])) {
                return true;
            }
        }

        // Exclude the current element and check the remaining elements
        return subsetSumRecursive(arr, n - 1, sum);
    }

    // Helper function to convert the matrix string into a 2D array
    private static int[][] convertToMatrix(String matrixInput) {
        // Removing the curly braces and splitting the matrix into rows
        matrixInput = matrixInput.replace("{{", "").replace("}}", "");
        String[] rows = matrixInput.split("},\\{");

        // Initialize the 2D array
        int[][] matrix = new int[rows.length][];

        // Convert each row into an integer array
        for (int i = 0; i < rows.length; i++) {
            String[] row = rows[i].split(",");
            matrix[i] = new int[row.length];
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = Integer.parseInt(row[j].trim());
            }
        }

        return matrix;
    }

    // Helper function to convert a 2D array to a 1D array
    private static int[] convertTo1DArray(int[][] matrix) {
        int[] arr = new int[matrix.length * matrix[0].length];
        int index = 0;

        // Fill the 1D array with values from the 2D matrix
        for (int[] row : matrix) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        return arr;
    }

    // Function that returns the Tribonacci sequence up to n
    public static int[] tribonacciSequence(int n) {
        // Create an array to store the results of the sequence
        int[] sequence = new int[n];

        // Call the recursive helper function to fill the sequence array
        tribonacciHelper(n - 1, sequence);

        return sequence;
    }

    // Recursive function to calculate each element of the Tribonacci sequence
    public static int tribonacciHelper(int n, int[] sequence) {
        // Base cases
        if (n == 0 || n == 1) {
            sequence[n] = 0;
        } else if (n == 2) {
            sequence[n] = 1;
        } else {
            // If the element is already calculated, return the stored value
            if (sequence[n] != 0) {
                return sequence[n];
            }

            // Otherwise, calculate the element using the 3 previous ones
            sequence[n] = tribonacciHelper(n - 1, sequence)
                    + tribonacciHelper(n - 2, sequence)
                    + tribonacciHelper(n - 3, sequence);
        }

        // Return the calculated or memorized value
        return sequence[n];
    }

    // Function to calculate the determinant of the matrix
    public static int determinant(int[][] matrix) {
        // Check if the matrix is 1x1
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        // Check if the matrix is 2x2
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // For larger matrices, calculate the determinant using recursion
        int det = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor(matrix, 0, i));
        }
        return det;
    }

    // Function to get the minor of the matrix
    public static int[][] minor(int[][] matrix, int row, int column) {
        int n = matrix.length;
        int[][] minorMatrix = new int[n - 1][n - 1];
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (i == row) continue;

            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == column) continue;

                minorMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return minorMatrix;
    }
    // Function to get the prime factors of a number
    public static int primeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>(); // List to store the prime factors

        // Check if 2 is a factor
        while (n % 2 == 0) {
            factors.add(2); // Add 2 to the list of factors
            n /= 2; // Divide n by 2
        }

        // Check for odd factors starting from 3
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i); // Add the factor to the list
                n /= i; // Divide n by the factor
            }
        }

        // If n is greater than 2, it means n itself is a prime number
        if (n > 2) {
            factors.add(n); // Add the prime factor to the list
        }

        // Print the prime factors
        System.out.print("Prime factors of " + n + " are: ");
        for (int i = 0; i < factors.size(); i++) {
            System.out.print(factors.get(i));
            if (i < factors.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Print a new line after the list of factors

        // Return the number of prime factors
        return factors.size();
    }

    // Function to calculate the nth element of the Tribonacci sequence
    public static int tribonacciElement(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        // Initialize the first three elements of the Tribonacci sequence
        int a0 = 0, a1 = 0, a2 = 1;
        int result = 0;

        // Calculate the nth element
        for (int i = 3; i <= n; i++) {
            result = a0 + a1 + a2;
            a0 = a1;
            a1 = a2;
            a2 = result;
        }

        return result;
    }

    // Function to parse a matrix string into a 2D integer array
    public static int[][] parseMatrix(String input) {
        try {
            // Remove curly braces and split rows
            input = input.replaceAll("\\{\\{", "").replaceAll("\\}\\}", "");
            String[] rows = input.split("\\},\\{");

            int size = rows.length;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                // Split each row by commas
                String[] values = rows[i].split(",");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(values[j].trim());
                }
            }
            return matrix;
        } catch (Exception e) {
            return null; // Return null if the input format is invalid
        }

    }
    public static void main(String[] args){
        System.out.println("Running tests...");
        HW4tests.main(args);
        System.out.println("All tests completed.");
    }
}
