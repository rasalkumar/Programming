package mergeIntervals;

import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

}

public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}
		Collections.sort(intervals, new IntervalComparator());
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) {
				Interval merged = new Interval(prev.start, Math.max(prev.end,
						curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
	}

	public static void main(String args[]) {
		Interval obj = new Interval(1, 3);
		Interval obj1 = new Interval(2, 6);
		Interval obj2 = new Interval(8, 10);
		Interval obj3 = new Interval(15, 18);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(obj);
		intervals.add(obj1);
		intervals.add(obj2);
		intervals.add(obj3);
		Solution obj4 = new Solution();
		ArrayList<Interval> result = obj4.merge(intervals);
		for (Interval i : result) {
			System.out.println("[" + i.start + " " + i.end + "]");
		}
	}

}

class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}

}