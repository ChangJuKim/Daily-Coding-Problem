public class Edge {
    public String start;
    public String end;

    public Edge(String _start, String _end) {
	start = _start;
	end = _end;
    }

    // Overwrites arrays.sort()'s function to compare
    public int compareTo(Edge e) {
	if (start != e.start) {
	    return start - e.start;
	} else {
	    return end - e.end;
	}
    }
}
