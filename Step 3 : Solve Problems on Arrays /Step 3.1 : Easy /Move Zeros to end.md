
# 283. Move Zeroes

## Problem Statement

Given an integer array `nums`, move all `0`s to the end of it while maintaining the relative order of the non-zero elements.

**Note:** You must do this **in-place** without making a copy of the array.

---

### Examples

#### Example 1:
**Input:** nums = [0,1,0,3,12]  
**Output:** [1,3,12,0,0]

#### Example 2:
**Input:** nums = [0]  
**Output:** [0]

---

### Constraints:
- \( 1 \leq 	ext{nums.length} \leq 10^4 \)
- \( -2^{31} \leq 	ext{nums[i]} \leq 2^{31} - 1 \)

---

### Follow-up:
Could you minimize the total number of operations done?

---

## Approach: Two Pointers (Optimal Solution)

### Algorithm:
1. Use a pointer `j` to keep track of the first zero in the array.
2. Iterate through the array using another pointer `i`:
   - If `nums[i]` is non-zero and `j` has been set (indicating a zero has been found earlier):
     - Swap `nums[i]` and `nums[j]`.
     - Increment `j` to the next zero position.
3. This ensures all non-zero elements are shifted to the front while maintaining their relative order.

---

### Code:
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1; // Pointer to track the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i; // Mark the position of the first zero
                break;
            }
        }
        if (j != -1) { // If a zero exists in the array
            for (int i = j + 1; i < nums.length; i++) {
                if (nums[i] != 0) {
                    // Swap the zero at j with the non-zero element at i
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++; // Move j to the next zero position
                }
            }
        }
    }
}
```

---

### Complexity Analysis:
- **Time Complexity:** \( O(n) \)  
  The array is traversed twice—once to find the first zero and once to rearrange non-zero elements.
- **Space Complexity:** \( O(1) \)  
  The algorithm operates in-place, using constant extra space.

---

