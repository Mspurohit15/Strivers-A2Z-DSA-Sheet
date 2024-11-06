Second Largest
Given an array arr, return the second largest element from an array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the first largest.

Examples:

Input: arr = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr = [10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist..
Constraints:
2 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105


1. Brute Force Approach:
The brute force approach involves finding the largest element first, then iterating again to find the largest element less than the maximum.
Time Complexity: O(n + n) = O(n), where n is the size of the array.
Space Complexity: O(1), since no additional storage is used apart from a few variables.

code : 

  import java.util.Scanner;

public class SecondLargestElement {
    // Brute force approach to find the second largest element
    public static int findSecondLargestBrute(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        // Find the largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        // Find the largest element less than the maximum
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }
        
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax; // If no second largest, return -1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Second Largest Element (Brute Force): " + findSecondLargestBrute(arr));
    }
}


2. Optimized Approach:
Instead of two separate loops, we can find both the largest and second largest in a single loop.
Time Complexity: O(n), as we only traverse the array once.
Space Complexity: O(1), as we're only using a few variables.
  

code : class Solution {
    public int getSecondLargest(int[] arr) {
       int largeElement = arr[0];
       int secondlargestNuumber  =  -1 ;
        for( int i = 1 ; i < arr.length ; i++){
            if(arr[i] > largeElement ){
                secondlargestNuumber = largeElement ; 
                largeElement = arr[i];
            }else if( arr[i] < largeElement && arr[i] >secondlargestNuumber ){
                secondlargestNuumber = arr[i];
            }
            
        }
        return secondlargestNuumber;
    }
}


3. Sorting Approach:
Sort the array in descending order, then find the first element smaller than the largest one.
Time Complexity: O(n log n), due to sorting the array.
Space Complexity: O(1) (if using in-place sorting, though sorting typically involves auxiliary space).

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElementSorting {
    // Sorting approach to find the second largest element
    public static int findSecondLargestSorting(int[] arr) {
        Arrays.sort(arr); // Sort the array in ascending order

        // Traverse from the second last element to find the second largest
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i]; // Return the first element smaller than the largest
            }
        }

        return -1; // Return -1 if no second largest element exists
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Second Largest Element (Sorting): " + findSecondLargestSorting(arr));
    }
}

Explanation:
Brute Force Approach: First, we find the largest element, then we iterate again to find the largest element that is smaller than the maximum. This takes O(n) for each pass, making the total time complexity O(2n) = O(n).

Optimized Approach: In one pass, we compare each element with both the largest and second largest. If an element is larger than the current largest, we update both the largest and second largest. If it's only larger than the second largest and not equal to the largest, we update the second largest.

Sorting Approach: We sort the array in ascending order and then find the first element from the end that is smaller than the largest. This is a less efficient approach due to the sorting step, which has a time complexity of O(n log n).

  










  
