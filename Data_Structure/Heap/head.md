# Heap
一道题：给一串未排序的数，如何实现操作popMax(),每次弹出其中的最大值？26，32，45，10，29，8，11，9，73，15直觉的想法：先把这串数的顺序排一遍，每次提取出最大的即可。
O(Nlog(N))。
但是，每次插入一个新数，就要把它放进该放的位置，插入的复杂度是O(N)。

Heap是一个二叉树，满足以下性质:
1. It's complete(Almost). Every level of the tree has the maximum number of nodes except possibly the last level. It's filled in reading from left to right across each row.
2. The largest data is in the root
3. For every node in the max#heap, its children contain smaller key
4. value

## 功能，方法和复杂度
Heap的基本功能： Add: O(logN) PopTop(Max or Min): O(log(N))

## 实现
1. 表示方法和基本操作 操作-用linked Node的结构对比表，把index写在树的旁边。我们可以用Array来实现堆。 奇怪，树不就是linkedlist吗？为什么可以用Array?正式利用了堆几乎是完全树的性质：除了最后一层，每一层的树木都是恒定的，所以我们可以算出每一个节点对应到array里面的index

### 实现
Array实现堆可以省掉指针的空间，而且不影响节点之间的联通
<br>
<img src="headpicfolder/Snip20170711_40.png">
<br>

+ its left child is located at 2*k index
+ its right child is located at 2*k + 1. index
+ its parent is located at k/2 index

0的位置空出来，是为了配出上面的关系，可以用二进制左右移动来定位，进一步提高了效率。

+ 建堆，建堆的两种方法，第二种需要证明正确性(叶子树已经是valid的了)， 但不需要证明复杂度(O(N)).给我们一串数，不断加数进去就是建堆了。那么，建一个堆堆时间复杂度是多少呢？是O(Nlog(N))吗？我们还有更快的方法建立堆么？逐层扫描法这样做建堆时间只有O(N)!.






















