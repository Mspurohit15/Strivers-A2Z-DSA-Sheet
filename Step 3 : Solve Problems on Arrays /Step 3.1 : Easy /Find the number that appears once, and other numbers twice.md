# Single Number Problem

## Problem Statement
Given a non-empty array of integers `nums`, every element appears twice except for one. Find that single element. You must implement a solution with a **linear runtime complexity** and use only **constant extra space**.

### Examples

#### Example 1:
- **Input:** `nums = [2,2,1]`
- **Output:** `1`

#### Example 2:
- **Input:** `nums = [4,1,2,1,2]`
- **Output:** `4`

#### Example 3:
- **Input:** `nums = [1]`
- **Output:** `1`


### Constraints:
1. `1 <= nums.length <= 3 * 10^4`
2. `-3 * 10^4 <= nums[i] <= 3 * 10^4`
3. Each element in the array appears twice except for one element which appears only once.

---

## Solutions

### 1. **Naive Approach: Using Nested Loops**

#### Description
For each element, we count its occurrences by iterating through the array. If the count is `1`, we return that element.

#### Implementation
```java
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0; 
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count == 1) return num;
        }
        return num;
    }
}
```

#### Complexity
- **Time Complexity**: \(O(n^2)\), where \(n\) is the length of the array.  
  Reason: For every element, we perform a linear search to count its occurrence, which takes \(O(n)\). Since there are \(n\) elements, the total time complexity is \(O(n^2)\).
- **Space Complexity**: \(O(1)\), as no extra space is used.

---

### 2. **Basic Approach: Using a HashMap**
#### Description
We use a HashMap to store the count of each element. Then, iterate through the map to find the element with a count of `1`.

- Traverse the array and store the count of each number in a hash map.
- Iterate through the hash map to find the number that appears only once.

#### Implementation
```java
import java.util.HashMap;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1; // Should never reach here
    }
}
```

#### Complexity
- **Time Complexity**: \(O(n)\), where \(n\) is the length of the array.  
  Iterating through the array and the map takes linear time.  
- **Space Complexity**: \(O(n)\), for storing elements in the HashMap.

---

### 2. **Better Approach 2 Hashing using the map data structure**

The steps are as follows:

First, we will declare a map.
Now, using a loop we will store the elements of the array along with their frequency in the map data structure.
Using another loop we will iterate over the map, and try to find the element for which the frequency is 1, and finally, we will return that particular element.

```java
public static int getSingleElement(int []arr) {
        //size of the array:
        int n = arr.length;

        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        //Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }

```
#### Complexity

Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
Reason: We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map). 
So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. 
In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, 
the time complexity will be O(N) + O(M).

Note: The time complexity will be changed depending on which map data structure we are using. If we use 
unordered_map in C++, the time complexity will be O(N) for the best and average case instead of O(N*logM). 
But in the worst case(which rarely happens), it will be nearly O(N2).

Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.

---

### 3. **Optimal Approach: Using XOR**

#### Description :  The most efficient way to solve this problem is using the XOR operation. XOR has some unique properties:
- a ^ a = 0 (XOR of two same numbers is 0).
- a ^ 0 = a (XOR of any number with 0 is the number itself).
- XOR is both commutative and associative, meaning the order of operations doesn't matter.
- By XOR-ing all the elements in the array, all numbers that appear twice will cancel out (i.e., their XOR will be 0), and we’ll be left with the number that appears only once.

#### Implementation

```java
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }
}
```

#### Complexity
- **Time Complexity**: \(O(n)\), where \(n\) is the length of the array.  
- **Space Complexity**: \(O(1)\), as no additional data structures are used.

---


## Summary of Approaches

| Approach         | Time Complexity | Space Complexity | Notes                                  |
|-------------------|-----------------|------------------|----------------------------------------|
| Basic (HashMap)   | \(O(n)\)        | \(O(n)\)         | Straightforward but uses extra space. |
| Better (Sorting)  | \(O(n \log n)\) | \(O(1)\)         | Sorting might be unnecessary overhead.|
| Optimal (XOR)     | \(O(n)\)        | \(O(1)\)         | Most efficient solution.              |

--- 

**Note**: The XOR approach is optimal and adheres to the constraints of constant space and linear time complexity.












