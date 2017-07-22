/*
Given a collection of intervals, merge all overlapping intervals.
For examples,

given [1,3], [2,6], [8, 10], [15,18],

return [1,6],[8,10],[15,18]
*/

public class MergeIntervals56 {
	public class MyComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval l1, Interval l2) {
			return l1.start - l2.start;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, new MyComparator());

		int beg = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (int i = 0; i < intervals.size(); i++) {
			
			Interval cur = intervals.get(i);

			if (end >= cur.start) {
				end = Math.max(end, cur.end);
			} else {
				res.add(new Interval(beg, end));
				beg = cur.start;
				end = cur.end;
			}
		}

		res.add(new Interval(beg, end));
		return res;
	}
}