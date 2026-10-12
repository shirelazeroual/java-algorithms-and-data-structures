package introtocsHW4;

public class HW4tests {

    public static void main(String[] args) {
        // Task 1: Second Largest Number
        int[] arr1 = {8, 4, 12, 32, 3};
        int[] arr2 = {15, 25, 10, 25};
        int[] arr3 = {5, 5, 5, 5};
        System.out.println("Task 1: Second Largest Number");
        System.out.println(HW4.findSecondMax(arr1) == 12);
        System.out.println(HW4.findSecondMax(arr2) == 25);
        System.out.println(HW4.findSecondMax(arr3) == 5);

        // Task 2: Palindrome
        System.out.println("\nTask 2: Palindrome");
        System.out.println(HW4.isPalindrome("racecar") == true);
        System.out.println(HW4.isPalindrome("hello") == false);
        System.out.println(HW4.isPalindrome("12321") == true);
        System.out.println(HW4.isPalindrome("a") == true);
        System.out.println(HW4.isPalindrome("") == true);

        // Task 3: Word Search (Case Insensitive)
        System.out.println("\nTask 3: Word Search");
        System.out.println(HW4.searchWord("Hello World", "world") == true);
        System.out.println(HW4.searchWord("Java is fun!", "JAVA") == true);
        System.out.println(HW4.searchWord("Programming with Python", "python") == true);
        System.out.println(HW4.searchWord("case sensitivity", "sensitivity") == true);
        System.out.println(HW4.searchWord("", "test") == false);

        // Task 4: Odd Index Letters
        System.out.println("\nTask 4: Odd Index Letters");
        System.out.println(HW4.getOddIndexLetters("world Hello").equals("ol el"));
        System.out.println(HW4.getOddIndexLetters("abcdef").equals("bdf"));
        System.out.println(HW4.getOddIndexLetters("123456789").equals("2468"));

        // Task 5: Power Check
        System.out.println("\nTask 5: Power Check");
        System.out.println(HW4.isPower(8, 2) == true);
        System.out.println(HW4.isPower(6, 3) == false);
        System.out.println(HW4.isPower(125, 5) == true);

        // Task 6: Determinant Calculation
        int[][] matrix1 = {{3, 1}, {5, 2}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        System.out.println("\nTask 6: Determinant");
        System.out.println(HW4.determinant(matrix1) == 1);
        System.out.println(HW4.determinant(matrix2) == 0);

        // Task 7: Subset Sum
        int[] subsetArr1 = {6, 97, 15, 8, 3};
        int[] subsetArr2 = {3, 12, 2, 87, 5, 4};
        System.out.println("\nTask 7: Subset Sum");
        System.out.println(HW4.subsetSum(subsetArr1, 9) == true);
        System.out.println(HW4.subsetSum(subsetArr2, 13) == false);

        // Task 8: Tribonacci Element
        System.out.println("\nTask 8: Tribonacci Element");
        System.out.println(HW4.tribonacciElement(10) == 81);
        System.out.println(HW4.tribonacciElement(5) == 4);

        // Task 9: Tribonacci Sequence
        System.out.println("\nTask 9: Tribonacci Sequence");
        int[] tribSeq = HW4.tribonacciSequence(10);
        int[] expectedSeq = {0, 0, 1, 1, 2, 4, 7, 13, 24, 44};
        System.out.println(java.util.Arrays.equals(tribSeq, expectedSeq));

        // Task 10: Prime Factors
        System.out.println("\nTask 10: Prime Factors");
        System.out.println(HW4.primeFactors(60) == 4);
        System.out.println(HW4.primeFactors(17) == 1);
        System.out.println(HW4.primeFactors(100) == 4);
        }

}
