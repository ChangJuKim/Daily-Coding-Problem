import java.util.ArrayList;

public class LastElementLog {

    private ArrayList<Integer> log;
    
    public LastElementLog() {
	log = new ArrayList<Integer>();
    }

    public LastElementLog(int N) {
	log = new ArrayList<Integer>(N);
    }

    // Adds the order_id to the log
    public void record(int order_id) {
	log.add(order_id);
    }

    // Returns the ith last order_id
    // i is guaranteed to be smaller or equal to N
    public int get_last(int i) {
	return log.get(log.size()-i);
    }
}
