public class Main {
    public static void main(String[] args) {
        // Example 1: Addition
        BigNum num1 = new BigNum("123456789123456789");
        BigNum num2 = new BigNum("987654321987654321");
        BigNum sum1 = num1.add(num2);
        System.out.println("Sum 1: " + sum1);  // Expected output: 1111111111111111110

        // Example 2: Addition
        BigNum num3 = new BigNum("111111111111111111");
        BigNum num4 = new BigNum("999999999999999999");
        BigNum sum2 = num3.add(num4);
        System.out.println("Sum 2: " + sum2);  // Expected output: 1111111111111111110

        // Example 3: Addition
        BigNum num5 = new BigNum("555555555555555555");
        BigNum num6 = new BigNum("444444444444444444");
        BigNum sum3 = num5.add(num6);
        System.out.println("Sum 3: " + sum3);  // Expected output: 999999999999999999

        // Example 4: Addition (Handling zeros)
        BigNum num7 = new BigNum("0");
        BigNum num8 = new BigNum("987654321");
        BigNum sum4 = num7.add(num8);
        System.out.println("Sum 4: " + sum4);  // Expected output: 987654321

        // Example 5: Addition
        BigNum num9 = new BigNum("12345");
        BigNum num10 = new BigNum("67890");
        BigNum sum5 = num9.add(num10);
        System.out.println("Sum 5: " + sum5);  // Expected output: 80235

        // Example 1: Multiplication
        BigNum num11 = new BigNum("123456789");
        BigNum num12 = new BigNum("987654321");
        BigNum product1 = num11.multiply(num12);
        System.out.println("Product 1: " + product1);  // Expected output: 121932631112635269

        // Example 2: Multiplication
        BigNum num13 = new BigNum("111111111");
        BigNum num14 = new BigNum("999999999");
        BigNum product2 = num13.multiply(num14);
        System.out.println("Product 2: " + product2);  // Expected output: 111111110888888889

        // Example 3: Multiplication
        BigNum num15 = new BigNum("12345");
        BigNum num16 = new BigNum("67890");
        BigNum product3 = num15.multiply(num16);
        System.out.println("Product 3: " + product3);  // Expected output: 838102050

        // Example 4: Multiplication (Handling zeros)
        BigNum num17 = new BigNum("0");
        BigNum num18 = new BigNum("123456789");
        BigNum product4 = num17.multiply(num18);
        System.out.println("Product 4: " + product4);  // Expected output: 0

        // Example 5: Multiplication
        BigNum num19 = new BigNum("222222222");
        BigNum num20 = new BigNum("333333333");
        BigNum product5 = num19.multiply(num20);
        System.out.println("Product 5: " + product5);  // Expected output: 74074073925925926

        // Example 1: Simple subtraction
        BigNum num21 = new BigNum("12345");
        BigNum num22 = new BigNum("2345");
        BigNum diff1 = num21.subtract(num22);
        System.out.println("Difference 1: " + diff1);  // Expected output: 10000

        // Example 2: Subtraction resulting in zero
        BigNum num23 = new BigNum("99999");
        BigNum num24 = new BigNum("99999");
        BigNum diff2 = num23.subtract(num24);
        System.out.println("Difference 2: " + diff2);  // Expected output: 0

        // Example 3: Subtraction with different lengths
        BigNum num25 = new BigNum("102030405");
        BigNum num26 = new BigNum("90807060");
        BigNum diff3 = num25.subtract(num26);
        System.out.println("Difference 3: " + diff3);  // Expected output: 11223345
    }
}
