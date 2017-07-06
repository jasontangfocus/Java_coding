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

1. 
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

2.
Methods
- Constructor
有了内部类，我们就可以利用它来实现LinkedList了，我们只须对每一个实例保存该list的第一个node，也就是head node，就可以实现它的所有方法
````java
    public MySinglyLinkedList() {
        head = null;
    }
````

- addFirst
像addFirst这样的方法，实现方式是非常直观的，只要完成“重新连接”的过程就可以了。
````java
    public void addFirst(AnyType data) {
        head = new Node<AnyType>(data, head);
    }
````

- insertBefore
一个比较难实现的方法是insertBefore, 就是要先找到一个元素，再往它前面添加一个元素。难度在于，当我们找到这个元素时，我们已经失去了它自己的链接，只有它自带的next链接。那么，我们在找它的时候，就需要能够一次“看到”两个元素，当第二个元素符合搜索条件时，在第一和第二个元素中间插入新元素
````java
    public void insertBefore(AnyType key, AnyType toInsert) {
        Node<AnyType> tmp = head;
        if (head == null) {
            return;
        }

        //Edge case for head containing key, insert a new node before head
        if (head.data.equals(key)) {
            head = new Node<AnyType>(toInsert, head);
            return;
        }

        //Continue to find the next one if the next value of the current node is not the one we are looking for
        while(tmp.next != null && !tmp.next.data.equals(keys)) {
            tmp = tmp.next;
        }

        //once jumped out of the while loop up, meaning that the toInsert key has been found, and the tmp key position is the position to insert after, which is also the position before the wanted key.
        if (tmp.next != null) {
            tmp.next = new Node<AnyType>(toInsert, tmp.next);
        }
    }
````

- remove一个特定元素，也就是搜索之后再删除
````java
    public vodi remove(AnyType key) {
        //Edge case 
        if (head == null) {
            return;
        }

        if (head.data.equals(key)) {
            head = null;
        } else {
            Node<AnyType> tmp = head;
            while (tmp.next != null && !tmp.next.data.equaps(key)) {
                tmp = tmp.next;
            }

            //found the key to delete, then jumped out of the while loop. 
            //To delete, jsut need to point the next pointer to the next.next key, so that the wanted value will be skipped.
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
        }
    }
````

- ReversedLinked List
给定一个head, 把list的连接关系反过来，返回一个linkedlist的新head。有recrusive和iterative两种写法：

1. Iterative
````java
    public ListNode reverseList(ListNode head) {
        //Edge case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        //Normal case
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
````

















