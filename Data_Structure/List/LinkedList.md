# LinkedList Notes

LinkedList就是将一个个元素装入一个Node，再把Node用内部引用（绳子）链接起来，同样可以线性存储和访问数据

## DS LinkedList (Unordered)
- Addition: O(1)
- Removal:  O(1)
- Searching:O(N)
- Get Index:O(N)
- Sort:     O(Nlog(N))
Java的LinkedList的排序方法使用了一个workaround，就是将list转换为Arraylist，然后使用了List的排序。因为转换过程是O(N), 在分析复杂度时可以忽略，所以复杂度还是Nlog(N).

