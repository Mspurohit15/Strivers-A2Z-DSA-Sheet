Problem statement
Given an integer ‘N’, your task is to write a program that returns all the divisors of ‘N’ in ascending order.



For example:
'N' = 5.
The divisors of 5 are 1, 5.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10
Sample Output 1 :
1 2 5 10
Explanation of Sample Input 1:
The divisors of 10 are 1,2,5,10.
Sample Input 2 :
6
Sample Output 2 :
1 2 3 6
Explanation of Sample Input 2:
The divisors of 6 are 1, 2, 3, and 6.
Constraints :
1 <= 'N' <= 10^5 

Solution : 

import java.util.List;
import java.util.ArrayList; 
public class Solution{
    public static List< Integer > printDivisors(int n) {

     List<Integer> divisors = new ArrayList<>();
     for( int i  = 1 ; i <= n ; i++ ){
         if( n % i == 0){
             divisors.add(i);
         }
     }
       // Return the list of divisors
        return divisors;
    }
}

List is an interface, so you cannot instantiate it directly using new List<>(). Instead, 
you should use an implementation of List, such as ArrayList.
  
The method signature should include a return statement, and you should also import the necessary classes.


Optimized Approach: 

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Solution {
    public static List<Integer> printDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        // Loop from 1 to sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i); // Add the divisor
                
                // If i is not the square root of n, add the complement divisor n / i
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        
        // Sort the divisors in ascending order
        Collections.sort(divisors);
        
        return divisors;
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        List<Integer> result = printDivisors(n);
        
        // Print the result
        for (int divisor : result) {
            System.out.print(divisor + " ");
        }
    }
}

Explanation:
This reduces the number of checks we need to perform, significantly optimizing performance.
Sorting the divisors: Since the divisors are not naturally in order when collected this way, 
we use Collections.sort() to ensure they are sorted.


  





  
