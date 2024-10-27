Question: You are given a 3-digit number n, Find whether it is an Armstrong number or not.
An Armstrong number of three digits is a number such that the sum of the cubes of its digits 
is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 

Note: Return "true" if it is an Armstrong number else return "false".    

  Approach : 1 

  public class ArmstrongNumber {

    static String armstrongNumber(int n) {
        int original = n;
        int sum = 0;
        
        // Calculate the sum of the cubes of the digits
        while (n > 0) {
            int lastDigit = n % 10;
            sum += (lastDigit * lastDigit * lastDigit);
            n /= 10;
        }
        
        // Return "true" if the number is Armstrong, otherwise "false"
        return original == sum ? "true" : "false";
    }

    public static void main(String[] args) {
        int num = 371; // Example number
        System.out.println(armstrongNumber(num)); // Output: "true"
    }
}


Approach: 2
Recursive Approach:
Instead of using a loop, we can define a recursive method to extract and cube each digit 
until there are no more digits left in the number.

Recursive Solution Code:


public class ArmstrongNumber {

    // Recursive method to calculate the sum of cubes of digits
    static int sumOfCubes(int n) {
        if (n == 0) {
            return 0;
        }
        int lastDigit = n % 10;
        return (lastDigit * lastDigit * lastDigit) + sumOfCubes(n / 10);
    }

    static String armstrongNumber(int n) {
        // Call the recursive method to calculate the sum of cubes
        return n == sumOfCubes(n) ? "true" : "false";
    }

    public static void main(String[] args) {
        int num = 371; // Example number
        System.out.println(armstrongNumber(num)); // Output: "true"
    }
}







