Problem: Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.


Example 1:

Input:
N = 5
arr[] = {4, 1, 3, 9, 7}
Output:
1 3 4 7 9
Explanation:
Maintain sorted (in bold) and unsorted subarrays.
Select 1. Array becomes 1 4 3 9 7.
Select 3. Array becomes 1 3 4 9 7.
Select 4. Array becomes 1 3 4 9 7.
Select 7. Array becomes 1 3 4 7 9.
Select 9. Array becomes 1 3 4 7 9.
Example 2:

Input:
N = 10
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output:
1 2 3 4 5 6 7 8 9 10

Your Task:  
You don't need to read input or print anything. Complete the functions select() and selectionSort() ,where select() takes arr[] and starting point of unsorted array i as input parameters and returns the selected element for each iteration in selection sort, and selectionSort() takes the array and it's size and sorts the array.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1) 
  
Approach 1: Basic Selection Sort (The Standard Approach)

Steps:
1. Traverse the array starting from index 0.
2. For each position i, find the smallest element in the unsorted portion (i.e., from i to N-1).
3. Swap the found minimum element with the element at index i.
4. Repeat this process until the entire array is sorted.
5. Time complexity O(N^2) and space complexity O(1).
  
Code 1: 
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j; // Find the index of the minimum element
            }
        }
        // Swap the found minimum element with the first element of the unsorted part
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}

Code :  2

  class Solution
{
 // Function to select the minimum element from unsorted subarray
	int select(int arr[], int i)
	{
        // Set the initial minimum index as i (start of unsorted part)
        int minIndex = i;
        
        // Loop through the unsorted part to find the actual minimum element
        for(int j = i + 1; j < arr.length; j++)
        {
            // Update minIndex if a smaller element is found
            if(arr[j] < arr[minIndex])
            {
                minIndex = j;
            }
        }
        
        // Return the index of the minimum element found
        return minIndex;
	}
	// Function to perform selection sort
	void selectionSort(int arr[], int n)
	{
	    // Traverse the array to place each element at its correct position
	    for(int i = 0; i < n - 1; i++)
	    {
	        // Find the index of the minimum element in the unsorted part
	        int minIndex = select(arr, i);
	        
	        // Swap the found minimum element with the first element of the unsorted part
	        if(minIndex != i) // Swap only if the minIndex is different
	        {
	            int temp = arr[i];
	            arr[i] = arr[minIndex];
	            arr[minIndex] = temp;
	        }
	    }
	}
	
}


We have another approach as well like 

Approach 2: Bidirectional Selection Sort (Double-ended Selection Sort) 

Idea: In this variation, we can optimize selection sort by finding both 
the minimum and the maximum element in a single pass over the array,
and then placing them at their correct positions at the beginning
and the end of the array, respectively.

Steps:

1. Use two pointers, one starting from the beginning (left) and one from the end (right).
2. In each iteration, find both the minimum element (to be placed at left) and the maximum element (to be placed at right).
3. Reduce the unsorted part of the array by shrinking the left and right bounds.

  void bidirectionalSelectionSort(int arr[], int n) {
    int left = 0, right = n - 1;

    while (left < right) {
        int minIndex = left, maxIndex = right;

        // Traverse the unsorted array to find both minimum and maximum
        for (int i = left; i <= right; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        // Swap the minimum element with the leftmost element
        int temp = arr[left];
        arr[left] = arr[minIndex];
        arr[minIndex] = temp;

        // Handle case where maxIndex gets affected by previous swap
        if (maxIndex == left) {
            maxIndex = minIndex;  // Adjust maxIndex if it was swapped
        }

        // Swap the maximum element with the rightmost element
        temp = arr[right];
        arr[right] = arr[maxIndex];
        arr[maxIndex] = temp;

        // Move towards the center
        left++;
        right--;
    }
}

Approach 3: Recursive Selection Sort
Idea: Implement the selection sort using recursion instead of a loop.

Steps:

1. Find the index of the minimum element in the unsorted part of the array.
2. Swap the minimum element with the first element of the unsorted part.
3. Recursively call the sorting function on the rest of the array.

  void recursiveSelectionSort(int arr[], int n, int index) {
    // Base case: If we reach the end of the array
    if (index == n)
        return;

    // Find the minimum element in the unsorted array
    int minIndex = index;
    for (int i = index + 1; i < n; i++) {
        if (arr[i] < arr[minIndex]) {
            minIndex = i;
        }
    }

    // Swap the found minimum element with the element at index
    int temp = arr[index];
    arr[index] = arr[minIndex];
    arr[minIndex] = temp;

    // Recursively call for the remaining part of the array
    recursiveSelectionSort(arr, n, index + 1);
}

// Wrapper function to start from the 0th index
void selectionSort(int arr[], int n) {
    recursiveSelectionSort(arr, n, 0);
}

Conclusion:
1. Standard Selection Sort is the most commonly used approach with O(N^2) time complexity.
2. Bidirectional Selection Sort reduces the number of comparisons by sorting from both ends.
3. Recursive Selection Sort demonstrates the recursive nature of the algorithm.
4. Stable Selection Sort maintains the relative order of equal elements, which can be useful in certain scenarios.
5. Optimized Selection Sort breaks early if the array is already sorted or nearly sorted.
  
