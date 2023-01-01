/*

A hash map is a data structure that is used to store key-value pairs. It provides efficient insertion, deletion, 
and lookup operations. One of the primary advantages of using a hash map is that it has constant-time complexity 
for these basic operations, which means that the time taken to perform these operations does not depend on the size 
of the hash map. This makes hash maps very efficient for storing and accessing large amounts of data.

In contrast, an array is a data structure that stores a fixed-size sequential collection of elements, and it provides 
constant-time access to individual elements by their index. However, inserting or deleting elements from an array can be
time-consuming, especially if the array is large and you need to shift a lot of elements to make room for the new element
or to fill the gap left by the deleted element.

In terms of time complexity, a hash map is generally a better choice than an array if you need to store and access a large 
amount of data and you don't need to maintain the data in a particular order. However, if you need to maintain the data in 
a specific order and you need to be able to access individual elements quickly by their index, an array may be a better choice.


*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        //convert string into char 
        String[] words=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        HashMap<Character,String>map=new HashMap<>();
        HashMap<String,Boolean >used=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(map.containsKey(ch)==false){
                if(used.containsKey(words[i])==true){
                    return false ;    
                }else{
                    used.put(words[i],true);
                    map.put(ch,words[i]);
                }

            }else { 
                String matchwith=map.get(ch);
                if(matchwith.equals(words[i])==false){
                    return false ;
                }

            }
        }
        return true ;

    }
}
