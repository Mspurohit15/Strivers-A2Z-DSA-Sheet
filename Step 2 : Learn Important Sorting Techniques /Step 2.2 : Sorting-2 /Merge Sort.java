Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Input: arr[] = [1, 3 , 2]
Output: [1, 2, 3]
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 105

Intuition: 

1. Merge Sort is a divide and conquers algorithm, it divides the given array 
into equal parts and then merges the 2 sorted parts. 

2. There are 2 main functions :
 
  merge(): This function is used to merge the 2 halves of the array. It assumes that both parts of the array are sorted and merges both of them.
  mergeSort(): This function divides the array into 2 parts. low to mid and mid+1 to high where,
3. We recursively split the array, and go from top-down until all sub-arrays size becomes 1.
 low = leftmost index of the array
 high = rightmost index of the array
 mid = Middle index of the array 

  
Code : 1

  class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if( l >= r) return ;
        int  midIndex = ( l + r) / 2 ;
        mergeSort( arr , l , midIndex);
        mergeSort( arr , midIndex + 1 , r);
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        int left =  l;
        int right = midIndex + 1 ; 
        
        while ( left <=  midIndex &&  right <= r){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left ++ ;
                
            }else {
                temp.add(arr[right]);
                right++ ;
            }
        }
        
        while (left <= midIndex){
             temp.add(arr[left]);
                left ++ ;
        }
        
        while (right <= r){
             temp.add(arr[right]);
             right ++ ;
        }
        
        for ( int i = l ; i <= r ; i++){
            arr[i] = temp.get(i-l);
        } 
    }
}
  

Code : 2
import java.util.*;

class Solution {
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2 ;
        mergeSort(arr, low, mid);  // left half
        mergeSort(arr, mid + 1, high); // right half
        merge(arr, low, mid, high);  // merging sorted halves
    }
}
public class tUf {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Solution.mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}



Time complexity: O(nlogn) 

Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken to get a sorted array, so overall time complexity will be nlogn

Space complexity: O(n)  

Reason: We are using a temporary array to store elements in sorted order.

Auxiliary Space Complexity: O(n)






