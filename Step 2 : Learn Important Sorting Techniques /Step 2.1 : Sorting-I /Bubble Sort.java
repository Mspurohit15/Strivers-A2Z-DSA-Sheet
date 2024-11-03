Problem: Given an Integer n and a list arr. Sort the array using the bubble sort algorithm.

it's a comparison sort method 
  
Examples :

Input: n = 5, arr[] = {4, 1, 3, 9, 7}
Output: 1 3 4 7 9
Input: n = 10, arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
Output: 1 2 3 4 5 6 7 8 9 10

Your Task : 
You don't have to read input or print anything. Your task is to complete the function bubblesort() which takes the array and it's size as input and sorts the array using bubble sort algorithm.
Constraints:
1 <= n <= 103
1 <= arr[i] <= 103

  Code : 


	public static void bubbleSort(int arr[], int n)
    {
        //code here
        for(int i = n -1 ;  i >= 1 ; i--){
            boolean isSwapped  = false; 
            for( int j = 0 ; j < i ;  j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){break; }
        }
    }


Algorithm:

Iterate over the array: In each pass, the largest element "bubbles" up to its correct position.
Compare adjacent elements: Swap them if they are in the wrong order.
Optimize by breaking early: If no elements were swapped in a particular pass, the array is already sorted, and we can stop.

  Time Complexity:
Worst-case: O(N²), where N is the number of elements.
Best-case: O(N), if the array is already sorted (with the optimization).
Space Complexity: O(1), since it is an in-place sort.
