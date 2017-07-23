/*
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 /* capacity 

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

public class LFUCache460 {
	//store key - value
	HashMap<Integer, Integer> vals;
	//store frequency
	HashMap<Integer, Integer> freqs;
	//store freq - key
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	int capacity;
	int minFreq = 1;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.vals = new HashMap<>();
		this.freqs = new HashMap<>();
		this.lists = new HashMap<>();
		this.lists.put(1, new LinkedHashSet<>());
	}

	public int get(int key) {
		if (!vals.containsKey(key)) {
			return -1;
		}

		int freq = freqs.get(key);
		freqs.put(key, freq + 1);

		lists.get(freq).remove(key);

		if (freq == minFreq && lists.get(freq).size() == 0) {
            minFreq++;
        }

		if (!lists.containsKey(freq + 1)) {
			lists.put(freq + 1, new LinkedHashSet<>());
		}

		lists.get(freq + 1).add(key);

		return vals.get(key);
	}

	public void put(int key, int value) {
		if (this.capacity <= 0) {
			return;
		}

		if (vals.containsKey(key)) {
			vals.put(key, value);
			get(key);
			return;
		}

		if (vals.size() >= this.capacity) {
			int evit = lists.get(minFreq).iterator().next();
			lists.get(minFreq).remove(evit);
			vals.remove(evit);
		}

		vals.put(key, value);
		freqs.put(key, 1);
		minFreq = 1;
		lists.get(1).add(key);
	}
}












