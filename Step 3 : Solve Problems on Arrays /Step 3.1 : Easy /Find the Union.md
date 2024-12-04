
# Problem: Union of Two Sorted Arrays with Duplicate Elements

Given two sorted arrays `a[]` and `b[]`, where each array may contain duplicate elements, the task is to return the elements in the union of the two arrays in sorted order.

**Definition:**  
The union of two arrays is defined as the set containing distinct common elements that are present in either of the arrays.

---

### Examples

1. **Input:**  
   `a[] = [1, 2, 3, 4, 5]`  
   `b[] = [1, 2, 3, 6, 7]`  
   **Output:**  
   `1 2 3 4 5 6 7`  
   **Explanation:**  
   Distinct elements including both arrays are: `1 2 3 4 5 6 7`.

2. **Input:**  
   `a[] = [2, 2, 3, 4, 5]`  
   `b[] = [1, 1, 2, 3, 4]`  
   **Output:**  
   `1 2 3 4 5`  
   **Explanation:**  
   Distinct elements including both arrays are: `1 2 3 4 5`.

3. **Input:**  
   `a[] = [1, 1, 1, 1, 1]`  
   `b[] = [2, 2, 2, 2, 2]`  
   **Output:**  
   `1 2`  
   **Explanation:**  
   Distinct elements including both arrays are: `1 2`.

---

## 1. Brute-Force Approach

### Steps:
1. Create a new array that contains all elements of both arrays.
2. Sort the resulting array.
3. Remove duplicates by iterating through the sorted array.

### Implementation:
```java
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
```

### Time Complexity:
- Sorting the array takes \(O((m+n)\log(m+n))\).
- Removing duplicates takes \(O(m+n)\).
- **Overall Time Complexity:** \(O((m+n)\log(m+n))\).

### Space Complexity:
- \(O(m+n)\) for the combined list.

---

## 2. Better Approach (Using Set)

### Steps:
1. Insert all elements of both arrays into a `Set`.
2. Convert the set back to a sorted list.

### Implementation:
```java
import java.util.*;

public class UnionArrays {
    public static List<Integer> unionUsingSet(int[] a, int[] b) {
        Set<Integer> set = new TreeSet<>();  // TreeSet automatically sorts elements
        
        // Add all elements of both arrays to the set
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        
        // Convert the set to a list
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 5};
        int[] b = {1, 1, 2, 3, 4};
        System.out.println(unionUsingSet(a, b)); // Output: [1, 2, 3, 4, 5]
    }
}
```

### Time Complexity:
- Inserting elements into a `TreeSet` takes \(O(\log n)\) for each element.
- **Overall Time Complexity:** \(O((m+n)\log(m+n))\).

### Space Complexity:
- \(O(m+n)\) for the `TreeSet`.

---

## 3. Optimal Approach (Two Pointers)

### Steps:
1. Initialize two pointers, one for each array.
2. Compare the elements at the current positions of the two pointers:
   - Insert the smaller element into the result and move the pointer.
   - If both are equal, insert the element once and move both pointers.
3. Continue until both arrays are exhausted.

### Implementation:
```java
import java.util.*;

public class UnionArrays {
    static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer> union = new ArrayList<>();
        
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) { // Case 1 and 2
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i])
                    union.add(arr1[i]);
                i++;
            } else { // Case 3
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j])
                    union.add(arr2[j]);
                j++;
            }
        }
        
        // If any elements are left in arr1
        while (i < n) {
            if (union.get(union.size() - 1) != arr1[i])
                union.add(arr1[i]);
            i++;
        }
        
        // If any elements are left in arr2
        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j])
                union.add(arr2[j]);
            j++;
        }
        
        return union;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 5};
        int[] b = {1, 1, 2, 3, 4};
        System.out.println(findUnion(a, b, a.length, b.length)); // Output: [1, 2, 3, 4, 5]
    }
}
```

### Time Complexity:
- Traversing both arrays takes \(O(m + n)\).
- **Overall Time Complexity:** \(O(m + n)\).

### Space Complexity:
- \(O(m+n)\) for the result list.

--- 

## Summary:

| Approach                | Time Complexity            | Space Complexity |
|-------------------------|----------------------------|------------------|
| Brute-Force             | \(O((m+n)\log(m+n))\)      | \(O(m+n)\)       |
| Better (Using Set)      | \(O((m+n)\log(m+n))\)      | \(O(m+n)\)       |
| Optimal (Two Pointers)  | \(O(m+n)\)                 | \(O(m+n)\)       |
