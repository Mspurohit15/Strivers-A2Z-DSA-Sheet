Given a number n. Count the number of digits in n which evenly divide n. Return an integer, total number of digits of n which divides n evenly.

Note :- Evenly divides means whether n is divisible by a digit i.e. leaves a remainder 0 when divided.

 static int evenlyDivides(int N){
    int count = 0 ;         
    int temp = N ;
    while( temp > 0 ){
        int digit = temp %10;
        temp/=10;
        
        if(digit != 0 && N % digit == 0){
            count++;
        }

    }
    return count;
    }
