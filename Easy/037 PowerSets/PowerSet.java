import java.util.ArrayList;

public class PowerSet {
    // Idea: Start with empty set
    // Add each number to all your previous sets (wherever possible)

    public static ArrayList<ArrayList<Integer>> addNumber(ArrayList<ArrayList<Integer>> ary, int num) {
	int size = ary.size();
	for (int i = 0; i < size; i++) {
	    ArrayList<Integer> new_ary = (ArrayList<Integer>)ary.get(i).clone();
	    new_ary.add(num);
	    ary.add(new_ary);
	}
	return ary;
    }

    public static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> nums) {
	ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
	powerSet.add(new ArrayList<Integer>());
	for (int i = 0; i < nums.size(); i++) {
	    addNumber(powerSet, nums.get(i));
	}
	return powerSet;
    }
    
    public static void main(String[] args) {
	ArrayList<Integer> ary = new ArrayList<Integer>();
	System.out.println(getPowerSet(ary));
	ary.add(1); ary.add(2); ary.add(3);
	System.out.println(getPowerSet(ary));
    }
}
