Problem : Union of Two Sorted Arrays with Duplicate Elements
  
Given two sorted arrays a[] and b[], where each array may contain duplicate elements , 
the task is to return the elements in the union of the two arrays in sorted order.

Union of two arrays can be defined as the set containing distinct common elements
that are present in either of the arrays.

Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
Output: 1 2 3 4 5 6 7
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
Output: 1 2 3 4 5
Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.
Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
Output: 1 2
Explanation: Distinct elements including both the arrays are: 1 2.

1. Brute-Force Approach:


Steps:
Create a new array that contains all elements of both arrays.
Sort the resulting array.
Remove duplicates by iterating through the sorted array.



import java.util.*;

public class UnionArrays {
    public static List<Integer> unionBruteForce(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        
        // Add all elements of array 'a' and 'b' to the list
        for (int num : a) result.add(num);
        for (int num : b) result.add(num);
        
        // Sort the list
        Collections.sort(result);
        
        // Remove duplicates using a new list
        List<Integer> union = new ArrayList<>();
        union.add(result.get(0));  // Add first element
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) != result.get(i - 1)) {
                union.add(result.get(i));
            }
        }
        
        return union;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 5};
        int[] b = {1, 1, 2, 3, 4};
        System.out.println(unionBruteForce(a, b)); // Output: [1, 2, 3, 4, 5]
    }
}


2. Better Approach (Using Set):

A better approach would be to use a Set to ensure distinct elements. A set in Java automatically handles duplicates.

Steps:
Insert all elements of both arrays into a set.
Convert the set back to a sorted list.

 public static List<Integer> unionUsingSet(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();  // TreeSet automatically sorts elements
        
        // Add all elements of both arrays to the set
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        
        // Convert the set to a list
        return new ArrayList<>(set);
    }



Time Complexity:
Inserting elements into a TreeSet takes 𝑂(log 𝑛) for each insertion, so the overall complexity is  O((m+n)log(m+n)).

Space Complexity: O(m+n) is used to store the set.


3. Optimal Approach (Two Pointers):


Steps:
Initialize two pointers, one for each array.
Compare the elements at the current positions of the two pointers.
Insert the smaller element into the result and move the pointer. If both are equal, insert the element once and move both pointers.
Continue until both arrays are exhausted.

static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
   int i = 0, j = 0; // pointers
  ArrayList<Integer > Union=new ArrayList<>(); 
  while (i < n && j < m) {
    if (arr1[i] <= arr2[j]) // Case 1 and 2
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
        Union.add(arr1[i]);
      i++;
    } else // case 3
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
        Union.add(arr2[j]);
      j++;
    }
  }
  while (i < n) // IF any element left in arr1
  {
    if (Union.get(Union.size()-1) != arr1[i])
      Union.add(arr1[i]);
    i++;
  }
  while (j < m) // If any elements left in arr2
  {
    if (Union.get(Union.size()-1) != arr2[j])
      Union.add(arr2[j]);
    j++;
  }
  return Union;
}




  


  




