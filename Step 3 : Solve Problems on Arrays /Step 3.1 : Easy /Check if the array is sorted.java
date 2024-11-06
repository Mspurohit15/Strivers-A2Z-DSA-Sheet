Check if the Array Is Sorted and Rotated
Given an array nums, return true if the array was originally sorted in non-decreasing order, 
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such 
  that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


Approach 1: Brute Force Approach (Check All Rotations)
Algorithm:

Generate all possible rotations of the array.
Check if any of the rotations is sorted.
If any rotation is sorted, return true; otherwise, return false.
  


class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Check if the array starting from this index is sorted
            boolean sorted = true;
            for (int j = 0; j < n - 1; j++) {
                if (nums[(i + j) % n] > nums[(i + j + 1) % n]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                return true;
            }
        }
        return false;
    }
}

Time Complexity: O(n²), where n is the length of the array.
We generate and check all n rotations, and for each rotation, we check if the array is sorted, which takes O(n) time.

Space Complexity: O(1), since we are not using extra space other than some variables.



Approach 2: Single Pass Check with Count of Descending Pairs


Algorithm:

Traverse the array and count the number of times an element is greater than the next one.
If this count is 0 or 1, return true; otherwise, return false.

  class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}

Time Complexity: O(n), where n is the length of the array.
We only traverse the array once.

Space Complexity: O(1), as we only use a few variables for counting.


Approach 3: Compare Array to its Sorted Version

Algorithm:

Find the number of times the current element is greater than the next one (as in Approach 2).
If it's greater than once, return false.
If it's greater exactly once, check if the last element of the array is less than or equal to the first element.




class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int splitIndex = -1;

        // Identify the place where array "breaks" its sorted order
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                splitIndex = i;
                break;
            }
        }

        // If there is no break in the order, return true (already sorted)
        if (splitIndex == -1) {
            return true;
        }

        // Check if the second part and first part are sorted relative to each other
        for (int i = splitIndex + 1; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        // Ensure the split point connects properly
        return nums[n - 1] <= nums[0];
    }
}


