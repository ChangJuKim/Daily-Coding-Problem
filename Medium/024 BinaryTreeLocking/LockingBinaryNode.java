public class LockingBinaryNode {
    public LockingBinaryNode parent;
    public LockingBinaryNode left;
    public LockingBinaryNode right;
    private boolean locked;
    public String name; // just for testing purposes


    public LockingBinaryNode(String _name) {
	parent = null;
	left = null;
	right = null;
	locked = false;
	name = _name;
    }

    public boolean addLeft(LockingBinaryNode node) {
	if (left == null) {
	    left = node;
	    node.parent = this;
	    return true;
	}
	return false;
    }
    
    public boolean addRight(LockingBinaryNode node) {
	if (right == null) {
	    right = node;
	    node.parent = this;
	    return true;
	}
	return false;
    }
    
    private boolean canBeLocked() {
	return !locked && ancestorsUnlocked() && descendentsUnlocked();
    }
    
    private boolean canBeUnlocked() {
	return locked && ancestorsUnlocked() && descendentsUnlocked();
    }
    

    // Returns true if all ancestors are unlocked
    private boolean ancestorsUnlocked() {
	if (parent == null) {
	    return true;
	}
	if (parent.locked == true) {
	    return false;
	}
	return parent.ancestorsUnlocked();
    }

    // Returns true if all descendents are unlocked
    private boolean descendentsUnlocked() {
	boolean leftUnlocked;
	boolean rightUnlocked;

	if (left == null) {
	    leftUnlocked = true;
	} else if (left.locked == true) {
	    leftUnlocked = false;
	} else {
	    leftUnlocked = left.descendentsUnlocked();
	}
	
	if (right == null) {
	    rightUnlocked = true;
	} else if (right.locked == true) {
	    rightUnlocked = false;
	} else {
	    rightUnlocked = right.descendentsUnlocked();
	}
	return leftUnlocked && rightUnlocked;
    }   


    
    public boolean is_locked() {
	return locked;
    }

    public boolean lock() {
	if (canBeLocked()) {
	    locked = true;
	    return true;
	}
	return false;
    }

    public boolean unlock() {
	if (canBeUnlocked()) {
	    locked = false;
	    return true;
	}
	return false;
    }
}
