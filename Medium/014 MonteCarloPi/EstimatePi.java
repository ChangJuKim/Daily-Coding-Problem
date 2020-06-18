import java.util.Random;

public class EstimatePi {
    /*
      Estimates pi by taking random points in a square of size 2*radius
      Sees if the points are in the enclosed circle
      The ratio of points in the circle to points not is pi/4
     */
    

    // Returns x^2 + y^2 <= radius^2
    public static boolean inCircle(double x, double y, int radius) {
	return Math.pow(radius, 2) >= (Math.pow(x, 2) + Math.pow(y, 2));
    }

    // numTrials = number of runs for monte carlo
    // radius = radius of circle.
    public static double monteCarlo(int numTrials, int radius) {
        double insideCircle = 0.0;
	Random rand = new Random();
	for (int i = 0; i < numTrials; i++) {
	    // subtract by .5 to center square around circle
	    double x = (rand.nextDouble() - .5) * 2 * radius;
	    double y = (rand.nextDouble() - .5) * 2 * radius;
	    if (inCircle(x, y, radius)) {
		insideCircle += 1;
	    }
	}
	if (numTrials <= 0) {
	    return 0;
	} else {
	    return insideCircle / numTrials * 4;
	}
    }

    public static void main(String[] args) {
	int numTrials = 1000000;
	int radius = 1;
	System.out.println("monteCarlo(" + numTrials + ", " + radius + "): " + monteCarlo(numTrials, radius));
    }
}
