import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> ary;

    public Stack() {
	ary = new ArrayList<T>();
    }

    public void push(T value) {
	ary.add(value);
    }

    public T pop() {
	if (ary.size() == 0) {
	    throw new IndexOutOfBoundsException("Stack size is 0");
	}
	T value = ary.remove(ary.size() - 1);
	return value;
    }

    public boolean isEmpty() {
	return ary.size() == 0;
    }

    // Not actually needed but I wanted it
    public T get(int i) {
	if (ary.size() < i) {
	    throw new IndexOutOfBoundsException("Index out of bounds in get function");
	}
	T value = ary.get(i);
	return value;
    }
}
