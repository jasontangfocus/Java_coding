# Graph

<img src="Graphpic/Snip20170711_41.png">
<br>

+ HashMap is implemented as a hash table, and there is no orderding on keys or values
+ TreeMap is implemented based on red-black tree structure, and it is ordered by the key
+ LinkedHashMap preserves the insertin order
+ Hashtable is synchonized, in contrast to HashMap. It has an overhead for synchronization

This is the reason that HashMap should be used if the program is thread-safe.

# HashMap功能，方法，复杂度

1. 功能：添加，删除，搜索(提取)全部O(1)

````java
 V put(K key, V value)
 V get(Object key)
 V remove(Object key)
 Boolean containKey(Object key)
````
不能做到：定位，排序

2. Traverse方法：没有顺序怎么遍历？
   Traverse Map有四种方法
<br>
   [Traverse Map 4 method](http://blog.csdn.net/tjcyjd/article/details/11111401)
<br>











