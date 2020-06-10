import java.util.Timer;
import java.util.TimerTask;

public class JobScheduler {


    public static void addTask(TimerTask task, int delay, Timer timer) {
	timer.schedule(task, delay);
    }

    // Function for testing purposes
    public static void wait(int ms) {
	try {
	    Thread.sleep(ms);
	}
	catch (InterruptedException ex) {
	    System.out.println("Interrupted my waittime!");
	    Thread.currentThread().interrupt();
	}
    }
    
    public static void main(String[] args) {
	Timer t = new Timer();
	for (int i = 0; i < 1000; i+= 100) {
	    TimerTask task = new TimerTask() {
		    String message = "This is a task!";
		    @Override
		    public void run() {
			System.out.println(message);
		    }
		};
	    addTask(task, i, t);
	    
	}
	wait(500);
	addTask(new TimerTask() {
		@Override
		public void run() {
		    System.out.println("Manually added this task~");
		}
	    }, 5, t);
	
    }
}
