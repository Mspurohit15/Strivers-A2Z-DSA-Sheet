
# Bubble Sort Algorithm

## Problem

Given an integer `n` and a list `arr`, sort the array using the **bubble sort** algorithm.

### Key Points:
- Bubble sort is a comparison-based sorting method.

### Examples

**Input:**  
```
n = 5  
arr = {4, 1, 3, 9, 7}
```  
**Output:**  
```
1 3 4 7 9
```  

**Input:**  
```
n = 10  
arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
```  
**Output:**  
```
1 2 3 4 5 6 7 8 9 10
```  

## Task

Complete the function `bubbleSort()` which takes the array and its size as input and sorts the array using the bubble sort algorithm.

### Constraints:
- \(1 \leq n \leq 10^3\)
- \(1 \leq arr[i] \leq 10^3\)

---

## Code

```java
public static void bubbleSort(int arr[], int n) {
    // code here
    for (int i = n - 1; i >= 1; i--) {
        boolean isSwapped = false; 
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isSwapped = true;
            }
        }
        if (!isSwapped) {
            break;
        }
    }
}
```

---

## Algorithm

1. **Iterate over the array**: In each pass, the largest element "bubbles" up to its correct position.
2. **Compare adjacent elements**: Swap them if they are in the wrong order.
3. **Optimize by breaking early**: If no elements were swapped in a particular pass, the array is already sorted, and we can stop.

---

## Complexity Analysis

- **Time Complexity:**
  - Worst-case: \(O(N^2)\), where \(N\) is the number of elements.
  - Best-case: \(O(N)\), if the array is already sorted (with the optimization).
- **Space Complexity:** \(O(1)\), since it is an in-place sort.
