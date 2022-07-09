# hashing:

-map keys or values into a hash table by using hashing function
-used for faster access to elements
-efficiency depends on the hash function used

## introduction:

question) store employee records keyed using phone numbers. it should efficiently perform three queries-
1) insert phone no and info
2) search phone no and info
3) delete phone no and info

this can be processed by using
-array or linked list for O(n) time in linear fashion: if we sort info and store in array we can *search* in O(log n) by using binary search but insert and deletion will be costly as we have to maintain sorted order
-balanced binary search tree for O(log n) time: insert, search and deletion all in same moderate time
-direct access table: make a huge ass array and store phone numbers as index in array. But if the number is huge then storing an int that big is not feasible. We might be able to all the operations in O(1) but huge space and storage problem

Through hashing we get O(1) search time and O(n) worst case. 

The main aim is always to use a hash function to convert the phone number into a smaller yet unique number which can be used as an index in a table called hash table

### hash function:

A hash function maps a big number or a string to a small integer that can be used as index in hash table

the mapped integer value is used as an index in hash table

1. efficiently computable
2. should uniformly distribute the keys (each table position equally likely for each key)

### hash table:

an array that stores pointers to records corresponding to a given key

an entry in hash table is null if no existing key has a hash function value equal to the index for the entry

### collision handling:

sometimes there are possibilities that two keys result in same value

hence the newly inserted key maps to an already occupied slot in hash table 

and this is called collision

hence to handle these situations we have a few techniques:

1. **chaining**: make each cell of hash table point to a linked list records that have same hash function value. it’s simple but requires extra memory outside the table
2. **open addressing**: all elements are stored in hash table itself. No key is generated. Each table contains either a record or NIL. We examine the table slots one by one until the desired element is found or it is clear that the element is not in the table

[Hashtable, HashMap, HashSet , hash table concept in Java collection framework - Stack Overflow](https://stackoverflow.com/questions/47838841/hashtable-hashmap-hashset-hash-table-concept-in-java-collection-framework)

hence we’ll look into hash map only

# hash map:

hash map can be initialize in this manner

```java
HashMap<data type of key, data type of value> hm = new HashMap<>();
```

every key has a value associated with it.

a key feature of hash map is that it runs functions like get, put, contains, keySet in constant time.

hashmap is similar to hashtable but it is unsynchronized i.e. things are not in order

hashmap allows only one key object but many null keys

*public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable*

The **Load factor** is a measure that decides when to increase the **HashMap** capacity to maintain the get() and put() operation complexity of O(1). The default **load factor** of **HashMap** is 0.75f (75% of the map size).

### hashmap functions:

- hm.put(key,value);
  - if the key is not in the hashmap then it will insert the new key
  - else if there is already a key as the input,  then it will update the value of the key
- hm.containsKey(key)
  - the return type is boolean
  - if the exists already then it will return true
  - else if it doesn’t exist then it will return false
- hm.get()
  - the return type is the value type
  - if the key exists in the hash map then it will return the value of the key
  - else if the key doesn’t exist then the hash map will return null

- keySet( )
  - gives you the value of all the keys
  - Set<key> e = hm.keySet() and then sout(e)

- remove()
  - takes the key value and removes the mapping for the key if present

- to traverse the hashmap, we can use Iterator interface. But iterator works with only one type of data. Hence we first use
  Map.Entry<key,value> e to resolve the two seperate types into a compatible format
  and then e.getValue() and e.getKey()

### to traverse the hashmap

```java
for (String key : map.keySet()) {
    System.out.println(key + ":" + map.get(key));
}

//OR

for (Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry);
}

//using keySet() for iteration over keys
for (String name : gfg.keySet()) 
    System.out.println("key: " + name);

//using values() for iteration over values
for (String url : gfg.values()) 
    System.out.println("value: " + url);
```

by using keyset() you’ll have to sout the string portion.
whereas the entrySet() is equal to implementing the toString() method

Yes we can use the Iterator but once the value is used it will go next() and then you’ll have to save the value somewhere.

### hash map V/S hash table

|                  hashmap                   |                 hashtalbe                 |
| :----------------------------------------: | :---------------------------------------: |
|    non - synchronous (not thread safe)     |         synchronous (thread safe)         |
| doesn’t store values in the input sequence |      stores value in input sequence       |
| allow only 1 null key and many null values | doesn’t allow any null key and null value |

#### synchronous and non-synchronous

HashMap is non synchronized. It is not-thread safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads. 

In the simplest of terms threadsafe means that it is safe to be accessed from multiple threads. When you are using multiple threads in a program and they are each attempting to access a common data structure or location in memory several bad things can happen. So, you add some extra code to prevent those bad things. For example, if two people were writing the same document at the same time, the second person to save will overwrite the work of the first person. To make it thread safe then, you have to force person 2 to wait for person 1 to complete their task before allowing person 2 to edit the document.

#### Why HashTable doesn’t allow null and HashMap do? 

To successfully store and retrieve objects from a HashTable, the objects used as keys must implement the hashCode method and the equals method. Since null is not an object, it can’t implement these methods. HashMap is an advanced version and improvement on the Hashtable. HashMap was created later.

**hash set**: single value
**hash map**: double value, non synchronous, not-in-order, null value and key allowed
**hash table**: double value, synchronous, in-order, no null values allowed.



 



