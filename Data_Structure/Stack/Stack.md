
<div align=center><img src="StakcNotesPic/Snip20170706_14.png"></div>

<div align=center><img src="StakcNotesPic/Snip20170706_13.png"></div>

````ddddddddddddddddddddddddddddddddddddddddddddddddddddd
````

# Stack

- LIFO: Last In First Out

## 功能，方法，复杂度

- DS:   O(1)
- Push: O(1)
- Pop:  O(1)
- Peek: O(1)
- Empty Check:  O(1)

## Stack有四个核心功能：
1. Push: 把元素放入栈的顶端，就像把盘子放进弹槽
2. Pop: 把栈顶端的元素弹出来并返回它的引用，就像拿走顶端的盘子
3. peek: 返回栈顶端的元素的引用("看到顶端的盘子")， 但不弹出来
4. isEmpty: 查看栈是否为空，即是否没有盘子了

JAVA的栈还可以Search，但是复杂度为O(N)

对应的方法是；
1. Void push(AnyType e);
2. AnyType pop();
3. AnyType peek();
4. boolean isEmpty();
5. int search(AntType e); //O(N)

###JAVA中的栈是线程安全的数据结构，不必担心操作过程中被其他的线程干扰

## 栈的实现

1. 栈是用Vector实现的。
2. Vector就是一种线程安全的动态数组(java中就是线程安全的ArrayList), 所以用Vector实现栈的思路很简单，push即加入Vector的末尾, Pop即remove末尾元素，peek即返回末尾元素但不removel isEmpty直接查看Vector的size是否为0.

````java
    public E push(E item) {
        addElement(item);
        return item;
    }

    public synchronized E pop() {
        E obj;
        int len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    public synchronized E peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        return elementAt(len - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }
````

### 使用Vector实现Stack是java的设计缺点之一，因为很慢，线程安全的性质不必要！！！

### 所以我们要自己来实现栈

1. Stack也可以用LinkedList来实现，在java中，对一个LinkedList进行addFirst操作就可以加入元素，removeFirst就可以弹出元素。(Cache not firendly)

2. 很多时候我们使用Array比较原始的方式来实现Stack.
    - 简单的实现，我们确定元素个数不会超过Array的初始长度。
    - 思路：
        + 维护一个顶端index为top, 初始值为-1, 这里很tricky, 当stack为空时，顶端元素不存在，所以top为-1.
        + 标识顶层元素中的尾端元素，每push一个元素，先检查top是否等于arr.length - 1, 如果等于，就拋异常表示底层数组已满。如果没有满，将arr[++top]设定为该元素
        + isEmpty直接检查top是否为-1， 我们想要的其实不是数组长度，而是数组里面有多少个元素。弹出最后一个元素的时候，top--. 就变成了-1.

````java
    @override
    public void push(AnyType e) {
        if(top == array.length - 1) {
            throw new StackException("Stack is full");
        }
        array[++top] = e;
    }

    @override
    public AnyType pop() {
        if(isEmpty()) {
            return null;
        }

        AnyType e = array[top];
        array[top] = null;
        top--;
        return e;
    }

    public AnyType peek() {
        if (isEmpty()) {
            throw new StackException("Stack is full");
        }
        return array[top];
    }

    @override
    public boolean isEmpty() {
        return top == -1;
    }
````

栈的基本功能
- push
- pop
- peek
- isEmpty










