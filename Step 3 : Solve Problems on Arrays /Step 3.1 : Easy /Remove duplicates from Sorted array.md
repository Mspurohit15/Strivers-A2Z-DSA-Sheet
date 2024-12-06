# Remove Duplicates from Sorted Array

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:

- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially.
- The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

## Custom Judge

The judge will test your solution with the following code:

```java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be accepted.

---

## Example 1

**Input:** `nums = [1,1,2]`  
**Output:** `2, nums = [1,2,_]`  
**Explanation:**  
Your function should return `k = 2`, with the first two elements of `nums` being `1` and `2` respectively.  
It does not matter what you leave beyond the returned `k` (hence they are underscores).

---

## Example 2

**Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`  
**Output:** `5, nums = [0,1,2,3,4,_,_,_,_,_]`  
**Explanation:**  
Your function should return `k = 5`, with the first five elements of `nums` being `0`, `1`, `2`, `3`, and `4` respectively.  
It does not matter what you leave beyond the returned `k` (hence they are underscores).

---

## Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order.

---

## Approach: Two Pointers (Optimal Solution)

### Algorithm:

1. Use a slow pointer (`i`) that keeps track of the position of unique elements in the array.
2. Use a fast pointer (`j`) to iterate over the array.
3. Whenever the fast pointer encounters a new unique element (i.e., `nums[j] != nums[i]`), move the slow pointer one step forward and update `nums[i]` with `nums[j]`.
4. After the loop, the slow pointer will indicate the number of unique elements.

### Code Implementation:

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
```

---

### Time Complexity:

- **O(n):** We traverse the array once using the fast pointer, so the time complexity is linear in terms of the size of the input array `n`.

### Space Complexity:

- **O(1):** No extra space is used aside from the two pointers, making this an in-place algorithm.





  

  
