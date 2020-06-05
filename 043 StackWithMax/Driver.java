public class Driver {

    public static void printPush(Stack<Integer> stack, int num) {
	System.out.println("Calling push(" + num + ")");
	stack.push(num);
    }

    
    public static void printMax(Stack<Integer> stack) {
	System.out.println("Calling max: " + stack.max());
    }

    public static void printPop(Stack<Integer> stack) {
	System.out.println("Calling pop: " + stack.pop());
    }
    
    public static void main(String[] args) {
	Stack<Integer> stack = new Stack<Integer>();
	printPush(stack, 5);
	printPush(stack, 3);
	printMax(stack);
	printPop(stack);
	printPush(stack, 7);
	printMax(stack);
	printPop(stack);
	printMax(stack);
	printPop(stack);
	printMax(stack);
	printPop(stack);
    }
}
