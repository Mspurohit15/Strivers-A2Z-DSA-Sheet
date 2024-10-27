7. Reverse Integer : Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

First Approach : 1

You can solve this problem by following these steps:

Extract the last digit of the number repeatedly using modulus (%) and division (/).
Build the reversed number by multiplying the result by 10 and adding the extracted digit.
Check for overflow or underflow before adding the next digit to the result.
Handle negative numbers by reversing the absolute value and applying the sign at the end.

Soluton : 
  
  public class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;  // Extract the last digit
            x /= 10;           // Remove the last digit from x

            // Check for overflow before multiplying reversed by 10
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow condition
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Underflow condition
            }

            reversed = reversed * 10 + pop;
        }

        return reversed;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        // Test cases
        System.out.println(solution.reverse(123));   // Output: 321
        System.out.println(solution.reverse(-123));  // Output: -321
        System.out.println(solution.reverse(120));   // Output: 21
        System.out.println(solution.reverse(0));     // Output: 0
    }
}

Explanation:

pop is the last digit of the input integer x (extracted using x % 10).
The integer x is then divided by 10 to remove the last digit.
Overflow/Underflow Check: Before multiplying the current reversed result by 10, check if the result will overflow or underflow by comparing with Integer.MAX_VALUE and Integer.MIN_VALUE.
Returning 0: If an overflow or underflow is detected, return 0 as specified.
  
Key Points:
The 32-bit integer range is [-2^31, 2^31 - 1], i.e., [-2147483648, 2147483647].
The overflow check ensures that adding the next digit does not exceed this range.
  
Time Complexity:

O(log(x)): The number of digits in x is proportional to log(x), so the while loop runs log(x) times.
Space Complexity:
O(1): Only a fixed amount of space is used for variables regardless of input size.

Signed 32-bit Integer Range
In Java, the range of a signed 32-bit integer (int) is from:

Minimum Value (Integer.MIN_VALUE): -2,147,483,648 (i.e., -2^31)
Maximum Value (Integer.MAX_VALUE): 2,147,483,647 (i.e., 2^31 - 1)


Overflow Check:

if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7))
  
reversed > Integer.MAX_VALUE / 10:

Before multiplying reversed by 10, we compare reversed with Integer.MAX_VALUE / 10 (which is 214748364).
If reversed is already greater than 214748364, multiplying it by 10 would definitely exceed Integer.MAX_VALUE (2147483647), so we return 0 to indicate overflow.
reversed == Integer.MAX_VALUE / 10 && pop > 7:

If reversed equals 214748364, multiplying it by 10 results in 2147483640.
Now, adding any digit greater than 7 (i.e., pop > 7) would cause overflow, because 2147483647 is the maximum allowable value.
So, we check whether the current digit pop is greater than 7 to determine if the operation would cause overflow.
  
Underflow Check:

if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8))
reversed < Integer.MIN_VALUE / 10:

Before multiplying reversed by 10, we compare reversed with Integer.MIN_VALUE / 10 (which is -214748364).
If reversed is already less than -214748364, multiplying it by 10 would exceed Integer.MIN_VALUE (-2147483648), so we return 0 to indicate underflow.
reversed == Integer.MIN_VALUE / 10 && pop < -8:

If reversed equals -214748364, multiplying it by 10 results in -2147483640.
Now, adding any digit less than -8 (i.e., pop < -8) would cause underflow because -2147483648 
is the minimum allowable value.
We check whether pop is less than -8 to determine if the operation would cause underflow.
  
Why These Specific Values?
  
The reason for checking 7 and -8 is because the maximum positive 32-bit integer is 2147483647,
and the minimum negative 32-bit integer is -2147483648. When multiplying the current reversed
number by 10 (which shifts digits left), adding these digits could push the result out of the valid 32-bit range.



Approach 2: String Manipulation
Concept:
Instead of working directly with digits through modulus and division, you can treat the number as a string, reverse the string, and handle the sign separately. After reversing the string, you convert it back to an integer and check if it falls within the 32-bit integer range.

Here’s the breakdown:

Convert the integer to a string.
Reverse the string (ignoring the negative sign if present).
Convert the reversed string back to an integer.
Check for overflow using the 32-bit integer limits (Integer.MIN_VALUE and Integer.MAX_VALUE).
Return 0 if overflow is detected, otherwise return the reversed integer with the correct sign.
  
Code Implementation :

public class ReverseIntegerStringApproach {
    public int reverse(int x) {
        // Handle negative sign separately
        boolean isNegative = x < 0;
        
        // Convert to string and remove any negative sign
        String str = Integer.toString(Math.abs(x));
        
        // Reverse the string
        String reversedStr = new StringBuilder(str).reverse().toString();
        
        // Convert the reversed string back to an integer
        try {
            int reversed = Integer.parseInt(reversedStr);
            
            // If the original number was negative, make the reversed number negative
            return isNegative ? -reversed : reversed;
            
        } catch (NumberFormatException e) {
            // This catch block is necessary because if reversing causes overflow, Integer.parseInt() will throw an exception
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseIntegerStringApproach solution = new ReverseIntegerStringApproach();
        
        // Test cases
        System.out.println(solution.reverse(123));   // Output: 321
        System.out.println(solution.reverse(-123));  // Output: -321
        System.out.println(solution.reverse(120));   // Output: 21
        System.out.println(solution.reverse(0));     // Output: 0
    }
}


Explanation:

Handling the sign: We first check if the number is negative. If it is, we store that information in a boolean (isNegative).
Then we take the absolute value of x to remove the negative sign and convert the absolute value to a string.
  
Reversing the digits: We convert the number to a string (Integer.toString()) and reverse the string using
StringBuilder().reverse(). This avoids having to manually reverse the digits via modulus and division.
Converting the reversed string back to an integer:

After reversing the string, we attempt to convert it back to an integer using Integer.parseInt().
  
Handling overflow/underflow: If reversing the number causes it to exceed the 32-bit signed integer range, Integer.parseInt() will 
throw a NumberFormatException, which we catch and return 0 as specified in the problem.
Return the result:

If the number is negative, we return the negative version of the reversed integer; otherwise, we return the positive reversed integer.

Time Complexity: O(n), where n is the number of digits in the number. The most time-consuming operations 
here are converting the number to a string and reversing the string, both of which run in O(n).
  
Space Complexity: O(n), since we use additional space for the string representation of the number, where n is the number of digits in x.

Advantages of This Approach:
  
It's simpler to implement and understand, especially for those familiar with string manipulations.
By relying on built-in functions, it minimizes the risk of manually handling corner cases such as 
removing the negative sign or trailing zeroes.



Comparison with First Approach:

First approach (digit manipulation) uses mathematical operations (% and /) to reverse the digits and manually 
check for overflow. This approach has the advantage of directly working with numbers without converting to strings, 
but it involves more arithmetic checks.

Second approach (string manipulation) simplifies the reversal process by using built-in string reversal and 
conversion methods. However, it introduces the overhead of string operations and an extra exception handling 
step for overflow.




  
