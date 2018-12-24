package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;

        intervals.sort((i1, i2) -> i1.start - i2.start);
        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval interval : intervals) {
            // show this interval overlaps
            if(interval.start <= end) end = Math.max(end, interval.end);
            else {
                // the interval disjoints
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // The last interval hasn't been added
        res.add(new Interval(start, end));
        return res;
    }

    private class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }
}
