public class DeepClone {
    private ArrayList<LinkedList<Integer>> hashSet; // by the way should i even make this a global variable?

    // hashing function for hashset
    // sorta crappy but whatever
    public static int hash(Node n) {
	int hash = n.value + n.random.value/3;
	if (n.next != null) hash += n.next.value/2;
	while (hash > hashSet.size()) {
	    index /= 2; // ensures hash is within array
	}
	return hash;
    }

    private static void insert(Node n) {
	int index = hash(n);
	if (hashSet.get(index) == null) {
	    hashSet.add(new LinkedList<Integer>());
	}
	hashSet.get(index).add(n);
    }

    // returns node with same parameters as n. Returns null if not found
    private static Node find(Node n) {
	int index = hash(n);
	LinkedList<Integer> list = hashSet.get(index);
	if (list == null) {
	    return null;
	}
	Iterator<Node> itr = list.iterator();
	while (itr.hasNext()) {
	    Node current = itr.next();
	    // Something about if current.value = n.value and so on then return n
	}
	return null;
    }

    public static Node deepClone(Node n) {
        hashSet = new ArrayList<LinkedList<Integer>>(100);
	
    }
}
