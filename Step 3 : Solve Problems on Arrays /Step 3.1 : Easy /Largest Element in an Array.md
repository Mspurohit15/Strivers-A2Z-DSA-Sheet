
# Find the Largest Element in an Array

## Problem Statement
Given an array `arr[]`, the task is to find the largest element and return it.

### Examples

#### Input: 
`arr = [1, 8, 7, 56, 90]`  
**Output:** `90`  
**Explanation:** The largest element in the given array is 90.

#### Input:
`arr = [5, 5, 5, 5]`  
**Output:** `5`  
**Explanation:** The largest element in the given array is 5.

#### Input:
`arr = [10]`  
**Output:** `10`  
**Explanation:** There is only one element, which is the largest.

### Constraints
- 1 <= `arr.size()` <= 10⁶  
- 0 <= `arr[i]` <= 10⁶  

---

## Approach 1: Brute Force

### Algorithm:
1. Initialize a variable `largeElement` with the first element of the array.
2. Traverse the array from the second element to the end.
3. Compare each element with `largeElement`. If the current element is larger, update `largeElement`.
4. Return `largeElement`.

### Code:
```java
class Solution {
    public static int largest(int[] arr) {
        int largeElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= largeElement) {
                largeElement = arr[i];
            }
        }
        return largeElement;
    }
}
```

### Complexity:
- **Time Complexity:** O(n), where `n` is the size of the array.
- **Space Complexity:** O(1)

---

## Approach 2: Optimal Approach (Using Java Streams)

### Algorithm:
1. Use Java 8 streams to process the array.
2. Utilize `Arrays.stream(arr).max()` to find the maximum element in the array.

### Code:
```java
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
```

### Complexity:
- **Time Complexity:** O(n), since streams internally traverse the array once.
- **Space Complexity:** O(1) (but streams may add additional overhead).

---

## Comparison of Approaches
| Approach         | Time Complexity | Space Complexity | Notes                                         |
|-------------------|-----------------|------------------|-----------------------------------------------|
| Brute Force       | O(n)           | O(1)             | Simple and direct approach using a loop.      |
| Java Streams      | O(n)           | O(1)             | Declarative style introduced in Java 8.       |







  
