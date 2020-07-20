import java.util.ArrayList;

public class GraphColoring {

    // Marks all reachable nodes from node as visited
    public static boolean[] DFS(int[][] graph, boolean[] visited, int node) {
	visited[node] = true;
	for (int i = 0; i < graph[node].length; i++) {
	    if (graph[node][i] == 1) {
		visited = DFS(graph, visited, i);
	    }
	}
	return visited;
    }

    // Returns one vertex of each independent subgraph
    public static ArrayList<Integer> getSubgraphs(int[][] graph) {
	if (graph.length == 0) {
	    return null;
	}
	
	ArrayList<Integer> subgraphs = new ArrayList<Integer>();
	boolean[] visited = new boolean[graph.length];
	for (int i = 0; i < graph.length; i++) {
	    if (!visited[i]) {
		subgraphs.add(i);
		visited = DFS(graph, visited, i);
	    }
	}
	return subgraphs;
    }

    // Didn't finish this
    // Gives available colors
    public static boolean[] availableColors(int[][] graph, int[] colors, int k, int node) {
	boolean[] available = new boolean[k]; //
	for (int i = 0; i < graph[node].length; i++) {
	    
	}
	return available
    }

    // Checks if... it's possible to color neighbors
    // Not if it's able to color itself
    // Why do I do it this way??

    // Cause of complexity of code, not acutally sure if this works or there's
    // Some part I'm missing
    public static boolean isColorable(int[][] graph, int[] colors, int k, int node) {
	// Try every color for every uncolored neighbor
	for (int i = 0; i < graph[node].length; i++) {
	    if (colors[i] == 0 && i != node) {
		boolean availableColors = availableColors(graph, colors, k, i);
		boolean noneAvailable = true;
		for (int j = 0; j < k; j++) {
		    if (availableColors[j]) {
			noneAvailable = false;
			colors[i] == j+1;
			if (isColorable(graph, colors, k, node)) {
			    return true;
			}
			colors[i] = 0;
		    }
		}
		// No colors available
		if (noneAvailable) {
		    return false;
		}
	    }
	}
	return true;
    }

    // Determines if graph is K-Colorable
    // Didn't check if k = 0, k = 1, k >= 2
    public static int isColorbale(int[][] graph, int k) {
	ArrayList<Integer> subgraphs = getSubgraphs(graph);

	// For each subgraph, color an arbitrary node and a neighbor.
	// Do brute force for the rest
	for (int i = 0; i < subgraphs.size(); i++) {
	    int node = subgraphs.get(i);

	    // Marks colors of each vertex. Marks from 1-k
	    int[] colors = new int[graph.length];
	    colors[node] = 1; // pick a color WLoG

	    for (int i = 1; i < graph[node].length; i++) {
		if (graph[node][i] == 1) { // Find a neighbor
		    if (colors[i] == 0) { // That hasn't been colored
			colors[i] == 2; // And color it the next arbitrary one.
			if (!isColorable(graph, colors, k, node)) {
			    return false;
			}
		    }
		}
	    }
	}
	return true;
    }
}
