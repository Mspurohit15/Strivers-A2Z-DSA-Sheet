
# Check if the Array Is Sorted and Rotated

## Problem Statement
Given an array `nums`, return `true` if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return `false`.

There may be duplicates in the original array.

### Example
#### Input: 
`nums = [3,4,5,1,2]`  
**Output:** `true`  
**Explanation:** `[1,2,3,4,5]` is the original sorted array. Rotating it by `x = 3` positions results in `[3,4,5,1,2]`.  

#### Input:
`nums = [2,1,3,4]`  
**Output:** `false`  
**Explanation:** There is no sorted array once rotated that can make nums.

#### Input:
`nums = [1,2,3]`  
**Output:** `true`  
**Explanation:** The array is already sorted, and rotating by `x = 0` positions retains `[1,2,3]`.  

### Constraints
- 1 <= `nums.length` <= 100  
- 1 <= `nums[i]` <= 100  

---

## Approach 1: Brute Force Approach (Check All Rotations)
### Algorithm:
1. Generate all possible rotations of the array.
2. Check if any of the rotations is sorted.
3. If any rotation is sorted, return `true`; otherwise, return `false`.

### Code:
```java
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
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
```

### Complexity:
- **Time Complexity:** O(n²)  
- **Space Complexity:** O(1)

---

## Approach 2: Single Pass Check with Count of Descending Pairs
### Algorithm:
1. Traverse the array and count the number of times an element is greater than the next one.
2. If this count is 0 or 1, return `true`. Otherwise, return `false`.

### Code:
```java
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
```

### Complexity:
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

## Approach 3: Compare Array to its Sorted Version
### Algorithm:
1. Identify the index where the sorted order "breaks".
2. Check that the array before and after this point is sorted relative to each other.
3. Ensure the last element of the array is less than or equal to the first element.

### Code:
```java
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int splitIndex = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                splitIndex = i;
                break;
            }
        }

        if (splitIndex == -1) {
            return true;
        }

        for (int i = splitIndex + 1; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return nums[n - 1] <= nums[0];
    }
}
```

### Complexity:
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)
