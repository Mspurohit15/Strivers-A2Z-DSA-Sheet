Single Number :  Given a non-empty array of integers nums, every element appears twice except for one. 
Find that single one. You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

1. 
  class Solution {
    public int singleNumber(int[] nums) {
        int num = 0; 
        for( int i = 0 ; i < nums.length ;  i++){
            num = nums[i];
            int count  = 0 ;
            for(int j = 0 ; j < nums.length ; j++){
               if(nums[j] == num){
                count ++;
               }
            }
           if(count == 1) return num;
        }
        return num;
    }
}
Time Complexity: O(N2), where N = size of the given array.
Reason: For every element, we are performing a linear search to count its occurrence. The linear search takes O(N) 
time complexity. And there are N elements in the array. So, the total time complexity will be O(N2).

  

Better Approach 1 :  Better Approach(Using Hashing): 

Approach:

Use a hash map (or dictionary) to count the occurrences of each number. Return the number with a count of 1.
Steps:

Traverse the array and store the count of each number in a hash map.
Iterate through the hash map to find the number that appears only once.

public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> countMap = new HashMap<>();
    
    for (int num : nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);  // Store count of each number
    }
    
    for (int key : countMap.keySet()) {
        if (countMap.get(key) == 1) {  // Find the number that appears once
            return key;
        }
    }
    return -1;  // Default return if no single number found
}
  


Time Complexity:

O(n) to traverse the array and another O(n) to check the hash map.
Space Complexity:

O(n) for storing the counts.

Better Approach 2 Hashing using the map data structure:  


The steps are as follows:

First, we will declare a map.
Now, using a loop we will store the elements of the array along with their frequency in the map data structure.
Using another loop we will iterate over the map, and try to find the element for which the frequency is 1, and finally, we will return that particular element.


public static int getSingleElement(int []arr) {
        //size of the array:
        int n = arr.length;

        // Declare the hashmap.
        // And hash the given array:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }

        //Find the single element and return the answer:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }

        //This line will never execute
        //if the array contains a single element.
        return -1;
    }


Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
Reason: We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map). 
So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. 
In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, 
the time complexity will be O(N) + O(M).

Note: The time complexity will be changed depending on which map data structure we are using. If we use 
unordered_map in C++, the time complexity will be O(N) for the best and average case instead of O(N*logM). 
But in the worst case(which rarely happens), it will be nearly O(N2).

Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.



Optimal Approach(Using XOR): 


Approach:

The most efficient way to solve this problem is using the XOR operation. XOR has some unique properties:
a ^ a = 0 (XOR of two same numbers is 0).
a ^ 0 = a (XOR of any number with 0 is the number itself).
XOR is both commutative and associative, meaning the order of operations doesn't matter.
By XOR-ing all the elements in the array, all numbers that appear twice will cancel out (i.e., their XOR will be 0), 
and we’ll be left with the number that appears only once.


  public int singleNumber(int[] nums) {
    int result = 0;
    
    for (int num : nums) {
        result ^= num;  // XOR all numbers
    }
    
    return result;  // The single number remains
}















