Problem : 
Given a number n. Count the number of digits in n which evenly divide n. Return an integer, total 
number of digits of n which divides n evenly.
 
Note :- Evenly divides means whether n is divisible by a digit i.e. leaves a remainder 0 when divided.

 1. Approach: Iterative Method (without String conversion)

 static int evenlyDivides(int N) {
    int count = 0;         
    int temp = N;
    
    while (temp > 0) {
        int digit = temp % 10; // Extract the last digit
        temp /= 10; // Remove the last digit
        
        // Check if digit is non-zero and divides N evenly
        if (digit != 0 && N % digit == 0) {
            count++;
        }
    }
    return count;
}
Explanation:
temp % 10 extracts the last digit of the number.
temp /= 10 removes the last digit from temp.
For each digit, we check if it's not zero and if it evenly divides n (i.e., n % digit == 0).
If both conditions are met, we increment the count.
The function returns the total count of such digits.

Time Complexity:
Time complexity: O(d), where d is the number of digits in N.
Each iteration in the loop processes one digit. The loop runs until 
temp becomes 0, meaning it runs exactly as many times as the number of digits in N.

 Space complexity: 
O(1) (constant space) because we only use a few variables (e.g., count, temp, digit) and don't need any extra space proportional to the input size.


Approach 1: Using String conversion

 public class DigitCount {
    public static int countDigits(int n) {
        // Convert number to string and get its length
        return String.valueOf(n).length();
    }

    public static void main(String[] args) {
        int n = 120;
        System.out.println("Number of digits in " + n + ": " + countDigits(n));
    }
}

Explanation:
String.valueOf(n): Converts the number n to a string.
length(): Returns the length of the string, which corresponds to the number of digits in n.

Time Complexity:
Time complexity: O(d), where d is the number of digits in N.
Converting an integer to a string takes O(d) time because Java must process each digit of N.
length() is O(1), as it just returns the precomputed length of the string.
Space complexity: O(d) due to the creation of a string of length d.

 A downside compared to the iterative method is the extra space required for the string.

 
 
Approach 2: Using mathematical operations (logarithmic approach)
This method takes advantage of logarithmic properties to determine the number of digits:


public class DigitCountLog {
    public static int countDigits(int n) {
        // Special case for n = 0, which has 1 digit
        if (n == 0) {
            return 1;
        }
        // Use logarithmic method to find the number of digits
        return (int) Math.log10(Math.abs(n)) + 1;
    }

    public static void main(String[] args) {
        int n = 120;
        System.out.println("Number of digits in " + n + ": " + countDigits(n));
    }
}

Explanation:
Math.log10(Math.abs(n)): This calculates the logarithm base 10 of the absolute value of n. The result gives us the number of digits minus 1.
+1: We add 1 to adjust the result and get the correct number of digits.
This approach works for both positive and negative numbers.

Time Complexity:
Time complexity: O(1).
The Math.log10() function runs in constant time, irrespective of the number of digits in N. It directly calculates the number of digits based on the mathematical properties of logarithms.
Space complexity: O(1) because only a few variables (such as n) are used.


 



 
