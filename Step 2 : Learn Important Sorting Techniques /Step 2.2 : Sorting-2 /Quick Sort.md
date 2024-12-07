# Quick Sort Algorithm

## Problem Statement
Implement Quick Sort, a Divide and Conquer algorithm, to sort an array `arr[]` in ascending order. The algorithm uses the last element as the pivot, ensuring that all elements less than or equal to the pivot come before it, and elements greater than the pivot follow it.

## Examples

### Example 1
**Input:** `arr[] = [4, 1, 3, 9, 7]`
**Output:** `[1, 3, 4, 7, 9]`
**Explanation:** After sorting, all elements are arranged in ascending order.

### Example 2
**Input:** `arr[] = [2, 1, 6, 10, 4, 1, 3, 9, 7]`
**Output:** `[1, 1, 2, 3, 4, 6, 7, 9, 10]`
**Explanation:** Duplicate elements (1) are retained in sorted order.

### Example 3
**Input:** `arr[] = [5, 5, 5, 5]`
**Output:** `[5, 5, 5, 5]`
**Explanation:** All elements are identical, so the array remains unchanged.

## Constraints
- 1 <= arr.size() <= 10³
- 1 <= arr[i] <= 10⁴

## Algorithm Overview

Quick Sort is a Divide and Conquer algorithm that works by:
1. Selecting a 'pivot' element from the array
2. Partitioning the array around the pivot
3. Recursively sorting the sub-arrays

### Key Functions

1. **`quickSort()`**:
   - Recursively divides the array
   - Calls the `partition()` function
   - Sorts sub-arrays independently

2. **`partition()`**:
   - Chooses a pivot element (typically the first or last element)
   - Rearranges the array so that:
     - Elements smaller than the pivot are moved before it
     - Elements larger than the pivot are moved after it

## Implementation 1 (Array-based)

```java
class Solution {
    // Main Quick Sort function
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Partition the array
            int partitionIndex = partition(arr, low, high);
            
            // Recursively sort left and right sub-arrays
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    // Partition function
    static int partition(int arr[], int low, int high) {
        // Choose the first element as pivot
        int pivot = arr[low];
        int i = low;
        int j = high;
        
        while (i < j) {
            // Find element larger than pivot from left
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            
            // Find element smaller than pivot from right
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            
            // Swap elements if indices haven't crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place pivot in correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
}
```

## Implementation 2 (List-based)

```java
class Solution {
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            // Find element larger than pivot from left
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            // Find element smaller than pivot from right
            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }

            // Swap elements if indices haven't crossed
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // Place pivot in correct position
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);

        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
}
```

## Example Usage

```java
public class QuickSortDemo {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3);
        int n = arr.size();

        System.out.println("Before Quick Sort: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        arr = Solution.quickSort(arr);

        System.out.println("\nAfter Quick Sort: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

## Complexity Analysis

### Time Complexity
- **Best Case:** O(N log N)
  - Occurs when pivot divides array into roughly equal halves
- **Average Case:** O(N log N)
  - Typical scenario with random distribution
- **Worst Case:** O(N²)
  - Occurs when array is already sorted or reverse sorted

### Space Complexity
- **O(1)** auxiliary space
- **O(N)** recursive call stack space

## Recurrence Relation
`F(n) = F(k) + F(n-1-k)`
- `k`: number of elements smaller or equal to pivot
- `n-1-k`: number of elements greater than pivot

## Pivot Selection Strategies
1. First element
2. Last element
3. Middle element
4. Random element
5. Median-of-three

## Advantages
- In-place sorting
- Good cache locality
- Efficient for large datasets
- Average time complexity of O(N log N)

## Disadvantages
- Unstable sorting algorithm
- Poor performance on already sorted arrays
- Worst-case time complexity of O(N²)

## When to Use
- Large, unsorted datasets
- Memory-constrained environments
- When average-case performance is crucial

## Optimization Techniques
- Randomized pivot selection
- Switching to insertion sort for small subarrays
- Three-way partitioning for arrays with many duplicates



