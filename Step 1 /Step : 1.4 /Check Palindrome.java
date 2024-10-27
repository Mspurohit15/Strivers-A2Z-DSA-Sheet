9. Palindrome Number : Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?

Approach 1: Using String Conversion (Simple Solution)

Convert the integer to a string.
Check if the string reads the same forwards and backwards.
Return true if it does, false otherwise.


  public boolean isPalindrome(int x) {
    // If the number is negative, it's not a palindrome
    if (x < 0) {
        return false;
    }
    
    // Convert the integer to a string
    String str = Integer.toString(x);
    
    // Reverse the string and check if it's equal to the original string
    return str.equals(new StringBuilder(str).reverse().toString());
}


Explanation:

Negative numbers are not palindromes because of the - sign.
Convert the number to a string, reverse it, and compare the original and reversed strings.
This approach is simple but does not meet the requirement of avoiding string conversion. 
  
Let’s now discuss a mathematical approach that avoids converting to a string.


Approach 2: Mathematical Reversal (Without String Conversion)


To solve this without converting the number to a string, we can reverse the digits of 
the number mathematically and compare the reversed half with the original half.

Key Idea:

A palindrome number reads the same from left to right and right to left. For example, 121 is a palindrome because its digits are the same when reversed.
Instead of reversing the whole number, we can reverse half of the digits and then compare the first half with the second half.

Steps:
1. If the number is negative, return false immediately, as negative numbers cannot be palindromes (because of the - sign).
2. Numbers ending in 0 cannot be palindromes unless the number is 0.
3. Reverse the digits of the second half of the number and compare them to the first half.
4. Stop when the reversed half becomes equal to or greater than the remaining half.
5. If the two halves match, the number is a palindrome.


  Code : 1
  public boolean isPalindrome(int x) {
    // Negative numbers cannot be palindromes
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }
    
    int reversedHalf = 0;
    
    // Reverse half of the number
    while (x > reversedHalf) {
        // Add the last digit of x to reversedHalf
        reversedHalf = reversedHalf * 10 + x % 10;
        // Remove the last digit of x
        x /= 10;
    }
    
    // Check if the first half (x) is equal to the reversed second half
    // In the case of an odd number of digits, we remove the middle digit by reversedHalf / 10
    return x == reversedHalf || x == reversedHalf / 10;
}

Explanation:

Negative Check: Any negative number cannot be a palindrome because of the minus sign.
  
Trailing Zero Check: Any number that ends in 0 cannot be a palindrome unless the number is 0. For example, 10 is not a palindrome, but 0 is.

  Reversing Half the Digits: In the while loop, we reverse the last half of the digits of the number and store it in reversedHalf.
  We stop when reversedHalf becomes greater than or equal to the remaining digits of x. This works because, 
  in a palindrome, the first half must equal the second half.

  Return Condition:
If the reversed half equals the remaining part (x), then the number is a palindrome.
In the case of an odd number of digits (e.g., 121), we ignore the middle digit by doing reversedHalf / 10 (which would remove the 1 in 121).

Code : 2
  class Solution {
    public boolean isPalindrome(int x) {
        int reverse= 0 ;
        int orginalNumber = Math.abs(x); 
        while (x != 0){
            int lastDigit = x % 10 ;
            x /= 10;
            if(reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE / 10  && lastDigit > 7  ){
                return false ;
            }
            if (reverse < Integer.MIN_VALUE / 10 || reverse == Integer.MIN_VALUE / 10 && lastDigit < -8 ){
                return false ;
            }
            reverse =  (reverse * 10 ) + lastDigit;
        }
        return reverse == orginalNumber;

    }
}



Time Complexity:
O(log₁₀(n)), where n is the input number. This is because we divide x by 10 at every step, which reduces the number of digits by 1 in each iteration, making it logarithmic in the number of digits.
Space Complexity:
O(1). We only use a few integer variables for the reversed half of the number, so the space complexity is constant.


Conclusion:
This mathematical approach is more efficient than the string-based approach. By only reversing half of the digits, 
we can save both time and space, avoiding unnecessary operations or conversions. It also directly addresses 
the follow-up challenge by not converting the integer to a string.








  
