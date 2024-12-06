Max Consecutive Ones: Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

Code 1 : 

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0 ;
        int count = 0 ;
        for(int i = 0 ; i< nums.length; i++){
            if(nums[i] == 1){
                count ++;
                maxCount = Math.max( maxCount ,count);
            }else{
                count = 0 ;
            }
        }
        return maxCount;
    }
} 


Code : 2  
  class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
return max > count ? max:count;    }
}

Time Complexity: O(N) since the solution involves only a single pass.

Space Complexity: O(1) because no extra space is used.
