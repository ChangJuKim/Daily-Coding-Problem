Good morning! Here's your coding interview problem for today.

This problem was asked by Dropbox.

Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Notes:
  Given a point (x, y):
    Neighbors are (x+1, y), (x+1, y+1), (x, y+1), (x-1, y+1),
    	          (x-1, y), (x-1, y-1), (x, y-1), (x+1, y-1)
       You can use certain properties:
           1. Odd/Even of adding <x> and <y>
	   2. Perhaps something like mod 9
	      A. Take x coordinate, mod 3
	      B. Take y coordinate, mod 3
	      This becomes similar to a hashing but with 9 spots
	      Basically any point in Array #x (1 <= x <= 9) will not be neighbors with other
	      points in that array




Thoughts:
  Given 9 sorted int arrays, you want to print the integers in ascending order
  Which one's faster? (Total n integers)
    1. Have 9 indicies and each time you print the next integer,
       do 8 comparisons and print smallest one. Increment that index
          Storage (shouldn't matter in this problem): O(1)
	  Runtime: 8 * n
    2. Take array 1. Insert array 2 to array 1 using a binary sort. Keep going.
          Storage (shouldn't matter): O(n) (which doesn't really add to anything)
	  Runtime: n log n
    Huh, method 1 is shorter.
    This was for printCells(liveCellsHashed)


/*
Thoughts about neighbors:
  A. Adding neighbors:
     Runtime: O(log(n)) whenever a cell comes alive (check for neighbors)
     	      Dead -> Alive is the same because we don't keep track of dead cells
	        O(8n * log(n))
     Storage: O(8n)
  B. Not adding neighbors:
     Runtime: Finding neighbors: O(8log(n))
  C. Adding neighbors (and keeping track of neighboring dead cells in an array):
     Runtime: Checking Dead -> Alive: O(n)
     	      New Alive cell: O(8log(n))
     Storage: O(~8n)   
*/

Actually I need to be more organized in how I think about runtime. These numbers are off
For now I won't implement due to coding time constraints


Stopping for now because we're now timing our coding sessions.