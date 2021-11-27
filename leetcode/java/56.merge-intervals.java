/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals==null||intervals.size()==0) return res;
        intervals.sort((in1,in2)->Integer.compare(in1.start,in2.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for(Interval in : intervals){
			if(in.start <= end ){
				end = Math.max(end,in.end);
			}else{
				res.add(new Interval(start,end));
				start = in.start;
				end = in.end;
			}
		}
		res.add(new Interval(start,end));
		return res;	
    }
}