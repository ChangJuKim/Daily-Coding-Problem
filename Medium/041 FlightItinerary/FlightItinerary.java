import java.util.ArrayList;
import java.util.Arrays;

public class FlightItinerary {
    // locations in alphabetical order
    private static String[] locations;

    // Turns flights into a directed matrix
    public static ArrayList<ArrayList<int>> preprocessFlights(String[][] flights) {
	Arrays.sort(flights);
	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	for (int i = 0; i < flights.length; i++) {
	    
	}
	return result;
    }

    // flights[x][y] = a flight from x -> y
    public static ArrayList<String> getPath(ArrayList<ArrayList<int>> flights, int start, ArrayList<String> path) {
	// if flight is empty or something return path here
	ArrayList<Integer> destinations = flight.get(i);
	for (int y = 0; y < destinations.size(); y++) {
	    if (destinations.get(i) > 0) {
		// call getPath here
	    }
	}
	// return null here
    }
}
