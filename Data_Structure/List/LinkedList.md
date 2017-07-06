# LinkedList Notes

LinkedList就是将一个个元素装入一个Node，再把Node用内部引用（绳子）链接起来，同样可以线性存储和访问数据

## DS LinkedList (Unordered)
- Addition: O(1)
- Removal:  O(1)
- Searching:O(N)
- Get Index:O(N)
- Sort:     O(Nlog(N))

**Java的LinkedList的排序方法使用了一个workaround**，就是将list转换为Arraylist，然后使用了List的排序。

*因为转换过程是O(N)*, 在分析复杂度时可以忽略，所以复杂度还是Nlog(N).

##常见方法：
1. O(1):    addFirst(element: Object), void addLast(element:Object), void getFirst(), Object getLast(), Object removeFirst(), Object removeLast(), Object
2. O(N):    insertAfter(AnyType key, AnyType tolnsert), void insertBefore(AnyType key, AnyType toinsert)(triky), void iterator(), iterator.

insertAfter/insertBefore, 就是搜索到一个元素，然后在它前面或后面添加一个元素。缇娜家的部分复杂度为O(1), 搜索的部分复杂度为O(N).

## LinkedList的实现

1. 实现它的基本结构，内含node的结构
2. 使用Node内部类，实现List的各种方法及LinkedList独特的方法

### Node

内部的Node结构使用嵌套类来实现。
嵌套类根据声明时是否使用static关键字，分为两类
- static嵌套类是附着在大类上面的，所以不能访问外面的外部类(outer class)的内容
- non-static嵌套类则是附着在大类的具体实例上面的，所以可以访问外部内容，即使private也可以。

这里我们的Node类不需要访问外部类的内容， 所以是static嵌套类。

````java
class OuterClass {
    class NestedClass {
        .....
    }
}
````

#### Node的实现
````java
private static class Node<AnyType> {
    private AnyType data;
    private Node<AnyType> next;

    public Node(AnyType, Node<AnyType> next) {
        this.data = data;
        this.next = next;
    }
}
````
















