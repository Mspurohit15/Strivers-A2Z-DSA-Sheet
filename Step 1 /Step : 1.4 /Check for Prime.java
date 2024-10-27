Problem statement
A prime number is a positive integer that is divisible by exactly 2 integers, 1 and the number itself.



You are given a number 'n'.



Find out whether 'n' is prime or not.



Example :
Input: 'n' = 5

Output: YES

Explanation: 5 is only divisible by 1 and 5. 2, 3 and 4 do not divide 5.

  code : 
public static String isPrime(int num) {
		int count = 0;
		for( int i = 1 ; i*i <= num ; i++){
			if( num % i == 0){
				count = count + 1;

				if((num/i)!= i){
                   count++;
				}
			}
		}
		return count ==2 ? "YES" : "NO ";
	}
