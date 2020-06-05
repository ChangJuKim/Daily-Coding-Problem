public class TreeAndString {


    // Temporarily uses ; to separate Nodes
    // Temporarily uses , to separate positional index
    // 1 is the head, 2/3 left and right, 4/5/6/7 the next row and so on
    // Relies on ';' and ',' not being used as values
    // If this is not allowed, create a String wrapper object.
    //    This is the same as a String class except:
    //    It holds a local variable that marks if it is a special character or not.
    //    If it is, treat it differently (like ';' or ',' in this example)
    public static String serialize(Node root) {
	return serialize(root, 1);
    }

    public static String serialize(Node head, int position) {
        if (head == null) {
	    return "";
	}
	String serialized = "" + position + "," + head.value + ";";
	return serialized +
	    serialize(head.left, position * 2) +
	    serialize(head.right, position * 2 + 1);
    }

    public static Node deserialize(String code) {
	return deserialize(code, 1);
    }

    public static Node deserialize(String code, int requiredPosition) {
	int positionIndex = code.indexOf("" + requiredPosition);
	if (positionIndex == -1) {
	    return null;
	}
	System.out.println("code: " + code);
	int nextSemicolon = code.indexOf(";", positionIndex);
	// Gets full serialized code of a node
	String relevantCode = code.substring(positionIndex, nextSemicolon);
	int comma = relevantCode.indexOf(",");
	// Gets value of node
	String value = relevantCode.substring(comma + 1);
	// Gets position of node
	String position = relevantCode.substring(0, comma);
	
	Node n = new Node(value, null, null);
	// Shortens code string the function looks through
	// Unsure if this just makes runtime longer
	String newCode = code.substring(0, positionIndex) + code.substring(nextSemicolon + 1) ;
	n.left = deserialize(newCode, requiredPosition * 2);
	n.right = deserialize(newCode, requiredPosition * 2 + 1);
	return n;
    }

    public static void main(String[] args) {
	Node n = new Node("Root",
			  new Node("Left",
				   new Node("LeftLeft",
					    new Node("LeftLeftLeft", null, null),
					    new Node("LeftLeftRight", null, null)),
				   new Node("LeftRight",
					    new Node("LeftRightLeft", null, null),
					    new Node("LeftLeftRight", null, null))),
			  new Node("Right",
				   new Node("RightLeft",
					    new Node("RightLeftLeft", null, null),
					    new Node("RightLeftRight", null, null)),
				   new Node("RightRight",
					    new Node("RightRightLeft", null, null),
					    new Node("RightLeftRight", null, null))));

	System.out.println(n.value);
	System.out.println(serialize(n));
	Node a_node = deserialize(serialize(n));
	System.out.println(a_node.value);
	System.out.println(a_node.left.value);
	System.out.println(a_node.right.value);
	System.out.println(a_node.left.left.value);
	System.out.println(a_node.left.right.value);
    	System.out.println(a_node.right.left.value);
	System.out.println(a_node.right.right.value);
    }
}
