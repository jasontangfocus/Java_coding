/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/
public class FindMedianFromDataStream295 {
	public class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer l1, Integer l2) {
			//return l2 - l1
			if (l2 > l1) {
				return 1;
			} else if (l2 < l1) {
				return -1;	
			} else {
				return 0;
			}
			//return l2.compareTo(l1);
		}
	}

	public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MyComparator());

    /** initialize your data structure here. */
    public MedianFinder() {
    	    
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
        	minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
        	return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
        	return (double)minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */