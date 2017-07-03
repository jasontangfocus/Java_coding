/*
ArrayList常见方法：

1.	add(object):	adds a new element to the end
2.	add(index, object):	inserts a new element at the specified index
3.	set(index, object):	replaces an existing element at the specified index with the new element
4.	get(index):	returns the element at the specified index
5.	size(): returns the number of elements
6.	iterator

每个ArrayList实例都有一个容量，当需要插入大量元素时，在插入前可以调用ensureCapacity方法来增加容量以提高插入效率

*/

public boolean add(E e) {
	ensureCapacity(size + 1);
	elementData[size++] = e;
	return true;
}

public void ensureCapacity(int minCapacity) {
	modCount++;	//维护线程安全用
	int oldCapacity = elementData.length;
	if (minCapacity > oldCapacity) {
		Object oldData[] = elementData;
		int newCapacity = (oldCapacity * 3) / 2 + 1;
		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}
}

//目前java所用的增长函数是 (oldCapacity * 3) / 2 + 1;