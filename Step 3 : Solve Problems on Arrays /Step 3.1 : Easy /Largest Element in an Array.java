Problem : Given an array arr[]. The task is to find the largest element and return it.

Examples:

Input: arr = [1, 8, 7, 56, 90]
Output: 90
Explanation: The largest element of the given array is 90.
Input: arr = [5, 5, 5, 5]
Output: 5
Explanation: The largest element of the given array is 5.
Input: arr = [10]
Output: 10
Explanation: There is only one element which is the largest.
Constraints:
1 <= arr.size()<= 106
0 <= arr[i] <= 106  

1. Brute Force Approach:

Traverse through the array element by element, comparing each one to find the largest.
Time Complexity: O(n), where n is the size of the array.

class Solution {
    public static int largest(int[] arr) {
        int largeElement = arr[0];
        for( int i = 1 ; i < arr.length ; i++){
            
            if(arr[i] >= largeElement ){
                largeElement = arr[i];
            }
            
        }
        return largeElement;
    }
}



3. Optimal Approach (Using Java Streams):

Java 8 introduced streams which allow operations on collections, including arrays, in a more declarative way.
This approach uses IntStream to find the maximum element.
Time Complexity: O(n), since internally it also traverses the array once.
Space Complexity: O(1), but additional overhead might occur with stream usage.



import java.util.Arrays;
import java.util.Scanner;

public class LargestElementStream {
    // Using Java Streams to find the largest element
    public static int findLargestStream(int[] arr) {
        return Arrays.stream(arr).max().getAsInt(); // Find the maximum element using Streams
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Largest Element (Stream): " + findLargestStream(arr));
    }
}









  
