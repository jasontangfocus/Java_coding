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

3. BST binary search
BST也可以做Binary Search, 一次去掉一半即可。

285_InOrder Successor in BST(TreeNode root, TreeNode p)
    + successor是右子树的左极或右父亲
    + while loop搜索到该元素，维护"右父亲"节点。若没有右子树就返回右父亲。

````java
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        //二分查找标记更新successor(右父亲)
        TreeNode successor = null;

        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (p.right == null) {
            return successor;
        }

        //p的右子树的左极
        p = p.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
````

270_Closest Binary Search Tree Value
找最近的元素而不是exact match, 在切割的时候保留root并比较哪个更近即可。

## Sorting
##O(N^2)Algorithm
###Bubble Sort
- 原理：
    + 两套循环：内循环对比每一个元素及其右边元素，将相对较大的元素swap到右边。一个循环结束后，未排序元素中最大的元素就被顶到右边了。外循环则控制内循环的次数，也就是最多length - 1次。内循环检查的元素数量，到拍过的顶层元素为止。所以每一层一次内循环，右侧需要检查的元素都向左推进一位。当一次内循环结束后，若没有发现逆序现象，说明已经排完了，左边的元素自动进入排好状态，即使外循环还有次数剩下，也可以提前结束。
    + 两个分类：将要排序的对象分作两部分，一个是已排序的，一个是未排序的。排序时若是从小到大，最大元素会如同气泡一样移至右端，其利用比较相邻元素的方式，将较大元素交换至右端，所以较大的元素会不断往右移动，直到适当的位置为止。
- 时间复杂度：N^2 / 2 cmoparisons, N^2 / 4 swaps. When is the case that we need to swap in every comparison on every pass?我认为是全部逆序的时候才会出现swap.

````java
    public void BubbleSort(int[] arr) {
        //Boundry Check
        if (arr == null || arr.lenght == 0) {
            return;
        }

        //normal 
        for (int i = 0; i < arr.length; i++) {
            //record if any two neighbours are in wrong order and needs swaping
            boolean swapped = false;
            //scan the subarray that is not yet bubbled
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //scan very pair of neighbours, if they need swapping
                if (arr[j] > arr[j + 1]) {
                    //note there is swap in this big round of i
                    swapped = true;
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(!swapped) {
                //if this round of scan shows absoulutely correct order
                break;
            }
        }
    }

````

### Selection Sort
- 原理：将要排序的对象分作两部分，一个是已排序的，一个是未排序的。如果排序是由小而大，从后段末排序部分选择一个最小值，并放入前端已排序部分的最后一个
- 时间复杂度也是O(N^2)，但小于Bubble Sort，因为Swap只发生于outer loop. 

````java
    public static void selectionSort(int[] data) {
        //set min variable for tmp min value
        int min;
        //move forward to right
        for (int out = 0; out < data.length - 1; out++) {
            //set initial min index to be out
            min = out;
            //move forward to right from out+1 to the end
            for (int in = out + 1; in < data.length; in++) {
                //if data is smaller than current min value
                if(data[in] < data[min]) {
                    //set a new min index
                    min = in;
                }
            }
            //swap min value with the first one as we move to the right
            //swap is happening within the outer loop
            swap(data, out, min);
        }
    }
````

### Insert Sort


















