189. Rotate Array : Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?   

Approach 1: Using a Temporary Array (Brute Force)
Algorithm:

Create a temporary array temp of the same size as nums.
For each element at index i, calculate its new position as (i + k) % n, where n is the length of the array.
Copy the rotated elements from temp back to the original nums array.

  class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // handle cases where k > n
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}

Time Complexity: O(n), where n is the length of the array.
Space Complexity: O(n), due to the use of the extra array temp.


Approach 2: In-Place Reversal (Optimized with O(1) Extra Space)

This approach rotates the array in-place by performing three reversals:

Reverse the entire array.
Reverse the first k elements.
Reverse the remaining elements from k to the end of the array.
Algorithm:

Reverse the entire array.
Reverse the first k elements.
Reverse the remaining n-k elements.

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // handle cases where k > n
        
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }
    
    // Helper function to reverse a portion of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


Time Complexity: O(n), where n is the length of the array (3 reversals, each taking O(n)).
Space Complexity: O(1), as it uses no extra space beyond a few variables.

  
Approach 3: Cyclic Replacements (In-Place with O(1) Extra Space)
Algorithm:

Loop through each element and place it at its new rotated position.
Keep track of how many elements have been placed. If we've moved all elements, we stop.

 class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // handle cases where k > n
        int count = 0;  // To keep track of number of elements rotated

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);  // Keep rotating until we get back to the start point
        }
    }
}
 
Time Complexity: O(n), where n is the length of the array. Each element is moved once.
Space Complexity: O(1), since no additional space is required except for a few variables.
  
