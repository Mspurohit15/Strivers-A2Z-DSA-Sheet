
# Insertion Sort Algorithm

## Problem

The task is to complete the `insert()` function which is used to implement **Insertion Sort**.

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

Complete the functions `insert()` and `insertionSort()` where:
- `insert()` takes the array, its size, and an index `i` and inserts the element at `i` into its correct position in the sorted portion of the array.
- `insertionSort()` uses the `insert()` function to sort the array in ascending order.

### Constraints:
- Expected Time Complexity: \(O(n^2)\)
- Expected Auxiliary Space: \(O(1)\)

---

## Code

```java
// Function to insert an element at its correct position in the sorted portion of the array
static void insert(int arr[], int i) {
    int temp = arr[i];  // Save the current element
    int j = i;
    
    // Shift elements of the sorted portion that are greater than `temp` to the right
    while (j > 0 && arr[j - 1] > temp) {
        arr[j] = arr[j - 1];  // Shift the element
        j--;
    }
    
    // Place the saved element at its correct position
    arr[j] = temp;
}

// Function to sort the array using insertion sort algorithm
public void insertionSort(int arr[], int n) {
    // Traverse through the entire array starting from index 1
    for (int i = 1; i < n; i++) {
        insert(arr, i);  // Insert each element into the sorted portion
    }
}
```

---

## Explanation

### How Insertion Sort Works
Insertion sort works similarly to the way you would sort playing cards in your hands. The algorithm divides the array into a "sorted" part (initially just the first element) and an "unsorted" part. It then picks elements one by one from the unsorted part and inserts them into the correct position in the sorted part.

### Steps to Perform Insertion Sort:
1. **Initialize**: Start with the first element, considering it as already sorted.
2. **Outer Loop**: For each element from the second one (\(i = 1\) to \(n-1\)), insert it into the sorted portion of the array (elements to the left of \(i\)).
3. **Inner Loop (Insert)**: Compare the current element with elements in the sorted portion, shift larger elements to the right, and insert the current element in its correct position.
4. **Repeat**: Continue until the whole array is sorted.

---

## Complexity Analysis

- **Time Complexity:**
  - Worst-case: \(O(n^2)\), where \(n\) is the number of elements.
  - Best-case: \(O(n)\), if the array is already sorted.
- **Space Complexity:** \(O(1)\), since it is an in-place sort.




  

