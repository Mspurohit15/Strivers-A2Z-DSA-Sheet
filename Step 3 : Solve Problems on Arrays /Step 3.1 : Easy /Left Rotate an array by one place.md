# Problem: Rotate Array

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

## Examples

### Example 1:
**Input:** `nums = [1,2,3,4,5,6,7], k = 3`  
**Output:** `[5,6,7,1,2,3,4]`  
**Explanation:**  
Rotate 1 step to the right: `[7,1,2,3,4,5,6]`  
Rotate 2 steps to the right: `[6,7,1,2,3,4,5]`  
Rotate 3 steps to the right: `[5,6,7,1,2,3,4]`  

### Example 2:
**Input:** `nums = [-1,-100,3,99], k = 2`  
**Output:** `[3,99,-1,-100]`  
**Explanation:**  
Rotate 1 step to the right: `[99,-1,-100,3]`  
Rotate 2 steps to the right: `[3,99,-1,-100]`  

## Constraints:
- `1 <= nums.length <= 10^5`  
- `-2^{31} <= nums[i] <= 2^{31} - 1`  
- `0 <= k <= 10^5`  

## Follow-Up:
- Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
- Could you do it in-place with O(1) extra space?

---

## Approach 1: Using a Temporary Array (Brute Force)
### Algorithm:
1. Create a temporary array `temp` of the same size as `nums`.
2. For each element at index `i`, calculate its new position as `(i + k) % n`, where `n` is the length of the array.
3. Copy the rotated elements from `temp` back to the original `nums` array.

### Implementation:
```java
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
```

### Complexity:
- **Time Complexity:** `O(n)`  
- **Space Complexity:** `O(n)`  

---

## Approach 2: In-Place Reversal (Optimized with O(1) Extra Space)
### Algorithm:
1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n-k` elements.

### Implementation:
```java
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
```

### Complexity:
- **Time Complexity:** `O(n)`  
- **Space Complexity:** `O(1)`  

---

## Approach 3: Cyclic Replacements (In-Place with O(1) Extra Space)
### Algorithm:
1. Loop through each element and place it at its new rotated position.
2. Keep track of how many elements have been placed. If all elements are moved, stop.

### Implementation:
```java
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
```

### Complexity:
- **Time Complexity:** `O(n)`  
- **Space Complexity:** `O(1)`  
