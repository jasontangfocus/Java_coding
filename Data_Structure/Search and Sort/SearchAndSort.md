#Search and Sort
##Searching
1. Linear Search
清点一遍全部，找到返回，没找到返回sentinel.  O(N)

````java
    public static int linerSearch(int[] arr, int key) {
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
````

2. Binary Search

- JAVA方法
````java
    java.util.Arrays.binarySearch(int[], int key)
    public static int binarySearch(int[] a, int key)
````

- 实现
依照顺序而一次去掉一半的搜索方式，只有有顺序的线形可定位结构能够使用(LinkedList不能用，因为无法直接access mid). O(Log(N))

````java
    int[] data;
    public int binarySearch(int key) {
        int low = 0;
        int high = data.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2; //Mind: this does not conver overflow
            if (data[middle] == key) {
                return middle;
            }
            if (data[middle] > key) {
                high = middle - 1;
            }
        }
        return -1;//sentinel
    }
````


























