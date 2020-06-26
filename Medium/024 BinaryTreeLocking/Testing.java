public class Testing {

    public static void printIsLocked(LockingBinaryNode node) {
	System.out.println("" + node.name + " is locked: " + node.is_locked());
    }
    
    public static void printLock(LockingBinaryNode node) {
	System.out.println("" + node.name + " locked: " + node.lock());
    }

    public static void printUnlock(LockingBinaryNode node) {
	System.out.println("" + node.name + " unlocked: " + node.unlock());
    }
    
    public static void main(String[] args) {
	LockingBinaryNode root = new LockingBinaryNode("root");
        LockingBinaryNode left = new LockingBinaryNode("left");
        LockingBinaryNode leftLeft = new LockingBinaryNode("leftleft");
        LockingBinaryNode right = new LockingBinaryNode("right");
        LockingBinaryNode rightRight = new LockingBinaryNode("rightright");
        root.addLeft(left);
	left.addLeft(leftLeft);
	root.addRight(right);
	right.addRight(rightRight);
	
	printIsLocked(root);
	printLock(root);
	printLock(left);
	printUnlock(root);
	printLock(left);
	printLock(right);
	printUnlock(right);
	printUnlock(left);
	printUnlock(right);
    }
}
