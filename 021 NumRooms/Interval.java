public class Interval implements Comparable<Interval> {
    public int start;
    public int end;

    public Interval(int startTime, int endTime) {
	start = startTime;
	end = endTime;
    }

    public Interval() {
	start = end = -1;
    }

    @Override
    public int compareTo(Interval i) {
	// Should be able to do something like this instead for cleaner code
	// return start * 10000 + end - (i.start * 10000 + end)
	// Problem is, you never know if end >>>>>> start
	if (start != i.start) {
	    return start - i.start;
	} else {
	    return end - i.end;
	}
    }
}
