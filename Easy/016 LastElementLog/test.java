public class test {
    public static void main(String[] args) {
	LastElementLog l = new LastElementLog(5);
	l.record(0);
	l.record(1);
	l.record(2);
	l.record(3);
	l.record(4);
	System.out.println(l.get_last(1));

	LastElementLog l = new LastElementLog();
    }
}
