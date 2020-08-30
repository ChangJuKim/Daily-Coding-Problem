import java.util.Stack;

public class LongestFilePath {

    // Determines "level" of file
    public static int countTabs(String file) {
	int tabs = 0;
	while(file.length() >= 2 && file.substring(0, 2).equals("\t")) {
	    tabs += 1;
	    file = file.substring(2);
	}
	return tabs;
    }

    // Removes leading "\t"
    // Probably is a better way to do this given the countTabs function
    public static String stripTabs(String file) {
	while (file.length() >= 2 && file.substring(0, 2).equals("\t")) {
	    file = file.substring(2);
	}
	return file;
    }

    // I realize that the directory/subdirectory won't contain periods so no need to check
    //   for a letter
    public static boolean isFile(String file) {
	int dotIndex = file.indexOf(".");
	// Checks that a . exists and that there's at least a letter after it
	if (dotIndex == -1 || dotIndex == file.length()-1) {
	    return false;
	}
	return true;
    }

    public static int longestFilePath(String fileSystem) {
	int maxLength = 0; // max length
	Stack<Integer> lengths = new Stack<>();
	lengths.push(0);
	int currentLevel = -1;
	int currentLength = 0;

	/* First convert to array by splitting by "\n" */
	String[] ary = fileSystem.split("\n");

	for (int i = 0; i < ary.length; i++) {
	    String file = ary[i];
	    int numTabs = countTabs(file);
	    file = stripTabs(file);

	    /* Go to correct directory */
	    // Case 1: it is in a previous directory
	    if (numTabs <= currentLevel) {
		// Get the right directory
		while (numTabs <= currentLevel) {
		    currentLevel -= 1;
		    currentLength = lengths.pop();
		}
	    }
	    // Case 2: already in correct directory. Do nothing.
	    // I just put this here so that readers don't get confused with this case
	    else if (numTabs == currentLevel + 1) {}
	    // Case 3: the number of tabs don't add up (should never happen)
	    else {
		System.out.println("Too many tabs here! File being ignored!");
		continue;
	    }

	    /* Determine length if it's a file. Otherwise (a directory), add to stack */
	    if (isFile(file)) {
		// filelength is actually a bit longer cause of the /
		int fileLength = file.length() + currentLevel;
		maxLength = Math.max(maxLength, currentLength + fileLength);
	    } else {
		currentLevel += 1;
		currentLength += file.length();
		lengths.push(currentLength);
	    }
	}
	return maxLength;
    }
}
