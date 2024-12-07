





# Merge Sort Algorithm

## Problem Statement
Sort an array using the merge sort algorithm, given an array `arr[]`, its starting position `l`, and its ending position `r`.

## Examples

### Example 1
**Input:** `arr[] = [4, 1, 3, 9, 7]`
**Output:** `[1, 3, 4, 7, 9]`

### Example 2
**Input:** `arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]`
**Output:** `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`

### Example 3
**Input:** `arr[] = [1, 3, 2]`
**Output:** `[1, 2, 3]`

## Constraints
- 1 <= arr.size() <= 10^5
- 1 <= arr[i] <= 10^5

## Intuition

Merge Sort is a divide-and-conquer algorithm that follows these key principles:

1. **Divide:** Split the given array into equal parts
2. **Conquer:** Recursively sort the sub-arrays
3. **Merge:** Combine the sorted sub-arrays

### Key Functions

1. **`merge()`**: 
   - Merges two sorted halves of an array
   - Assumes both parts are already sorted
   - Combines them in a sorted manner

2. **`mergeSort()`**:
   - Divides the array into two parts:
     - Left half: from `low` to `mid`
     - Right half: from `mid+1` to `high`
   - Recursively splits the array until sub-array size becomes 1

## Implementation 1 (Java)

```java
class Solution {
    void mergeSort(int arr[], int l, int r) {
        if (l >= r) return;
        
        int midIndex = (l + r) / 2;
        
        // Recursively divide and sort
        mergeSort(arr, l, midIndex);
        mergeSort(arr, midIndex + 1, r);
        
        // Merge the sorted halves
        ArrayList<Integer> temp = new ArrayList<>();
        
        int left = l;
        int right = midIndex + 1;
        
        // Compare and merge elements from both halves
        while (left <= midIndex && right <= r) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        
        // Add remaining elements from left half
        while (left <= midIndex) {
            temp.add(arr[left]);
            left++;
        }
        
        // Add remaining elements from right half
        while (right <= r) {
            temp.add(arr[right]);
            right++;
        }
        
        // Copy back to original array
        for (int i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
    }
}
```

## Implementation 2 (Java with Separate Merge Function)

```java
class Solution {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge elements in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining left half elements
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining right half elements
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        
        int mid = (low + high) / 2;
        
        mergeSort(arr, low, mid);        // Sort left half
        mergeSort(arr, mid + 1, high);   // Sort right half
        merge(arr, low, mid, high);      // Merge sorted halves
    }
}
```

## Example Usage

```java
public class MergeSortDemo {
    public static void main(String args[]) {
        int[] arr = { 9, 4, 7, 6, 3, 1, 5 };
        int n = arr.length;
        
        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        
        Solution.mergeSort(arr, 0, n - 1);
        
        System.out.println("\nAfter sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
```

## Complexity Analysis

### Time Complexity
- **O(n log n)**
- Reason: 
  - Dividing the array takes log n steps
  - Merging takes n steps at each level
  - Overall complexity is n * log n

### Space Complexity
- **O(n)**
- Reason: 
  - Uses a temporary array to store elements in sorted order
  - Auxiliary space is O(n)

## Key Advantages
1. Guaranteed O(n log n) time complexity
2. Stable sorting algorithm
3. Works well for linked lists and large datasets
4. Predictable performance

## Key Disadvantages
1. Additional space required
2. Not in-place sorting
3. Slightly slower for small datasets compared to algorithms like insertion sort

## Variations
- External merge sort
- Natural merge sort
- Bottom-up merge sort

## When to Use
- Sorting linked lists
- When stable sorting is required
- When guaranteed O(n log n) performance is needed
- External sorting of large datasets
