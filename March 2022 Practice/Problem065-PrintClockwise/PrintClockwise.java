/*
Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12

-----------------------------------

Ending thoughts: I think I made this much more complicated than I should've. I'm not sure how 
anyone can be expected to modify or debug my code.
Maybe simple (but verbose) code is better than condensed but complicated code.
*/

public class PrintClockwise {
    private static final int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static void printInClockwise(int[][] ary) {
        if (ary.length == 0 || ary[0].length == 0) {
            return;
        }
        // borders is {top, right, bottom, left}
        int[] borders = new int[] {0, ary[0].length-1, ary.length-1, 0};
        int x = 0;
        int y = 0;
        int i = 0;
        while (borders[0] <= borders[2] && borders[3] <= borders[1]) {
            System.out.println(ary[x][y]);
            if (isValid(borders[0], borders[1], borders[2], borders[3], x + directions[i][0], y + directions[i][1])) {
                x += directions[i][0];
                y += directions[i][1];
            } else {
                // Change direction
                // For top/left, add one and for right/bottom, subtract 1
                borders[i] = i == 0 || i == 3 ? borders[i] + 1 : borders[i] - 1;
                i = (i + 1) % 4;
                x += directions[i][0];
                y += directions[i][1];
            }
        }
    }

    public static boolean isValid(int top, int right, int bot, int left, int x, int y) {
        return x >= top && x <= bot && y >= left && y <= right;
    }

    public static void main(String[] args) {
        int[][] ary = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        printInClockwise(ary);
    }
}
