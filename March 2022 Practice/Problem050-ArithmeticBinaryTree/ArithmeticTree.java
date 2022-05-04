/*
Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).

-----------------------------------------------------------------------
Idea 1:
    Evaluate function: 
        If not leaf: Call evaluate on left child, then right child, then operation the two together.
        If leaf: return number 
*/


public class ArithmeticTree {
    private static final String[] operationsList = {"+", "-", "*", "/"};
    
    private static boolean isOperation(String value) {
        for (int i = 0; i < operationsList.length; i++) {
            if (operationsList[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int performOperation(String operation, int left, int right) {
        int i = 0;
        for (; i < operationsList.length; i++) {
            if (operationsList[i] == operation) {
                break;
            }
        }
        switch (i) {
            case 0:
                return left + right;
            case 1:
                return left - right;
            case 2:
                return left * right;
            case 3:
                return left / right;
        }
        // Need to throw an error here instead of just returning -1
        return -1;
    }

    public static int evaluate(TreeNode root) {
        if (isOperation(root.value)) {
            return performOperation(root.value, evaluate(root.left), evaluate(root.right));
        } else {
            try {
                return Integer.parseInt(root.value);
            }
            catch (Exception e) {
                System.out.println("Tree value is not a number or a valid operator");
                throw e;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode("*");
        t.left = new TreeNode("+");
        t.right =  new TreeNode("+");
        t.left.left = new TreeNode("3");
        t.left.right = new TreeNode("2");
        t.right.left = new TreeNode("4");
        t.right.right = new TreeNode("5");
        System.out.println("Evaluated: " + evaluate(t));
    }
}
