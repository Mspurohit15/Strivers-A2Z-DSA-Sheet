The task is to complete the insert() function which is used to implement Insertion Sort.


Examples:

Input: n = 5, arr[] = { 4, 1, 3, 9, 7}
Output: 1 3 4 7 9
Input: n = 10, arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output: 1 2 3 4 5 6 7 8 9 10

Your Task: 
You don't have to read input or print anything. Your task is to complete the function insert() and insertionSort() where insert() takes the array, it's size and an index i and insertionSort() uses insert function to sort the array in ascending order using insertion sort algorithm. 

Expected Time Complexity: O(n*n).
Expected Auxiliary Space: O(1).


  code : static void insert(int arr[], int i) {
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


Insertion Sort Explanation
Insertion sort works similarly to the way you would sort playing cards in
your hands. The algorithm divides the array into a "sorted" part 
(initially just the first element) and an "unsorted" part. 
It then picks elements one by one from the unsorted part and inserts 
them into the correct position in the sorted part.


Steps to Perform Insertion Sort:
1. Initialize: Start with the first element, considering it as already sorted.
2. Outer loop: For each element from the second one (i = 1 to n-1), insert it into the sorted portion of the array (elements to the left of i).
3. Inner loop (Insert): Compare the current element with elements in the sorted portion, shift larger elements to the right, and insert the current element in its correct position.
4. Repeat until the whole array is sorted.




  

