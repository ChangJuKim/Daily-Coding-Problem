/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
*/
class Coordinate {
    x: number;
    y: number;

    constructor(_x: number, _y: number) {
        this.x = _x;
        this.y = _y;
    }

    getTop() { return new Coordinate(this.x, this.y-1); }
    getLeft() { return new Coordinate(this.x-1, this.y-1); }
    getBot() { return new Coordinate(this.x, this.y+1); }
    getRight() { return new Coordinate(this.x+1, this.y); }

    // Returns true if x and y are within board dimensions
    isValid(boardWidth: number, boardHeight: number) {
        console.log(`Validation: ${!(this.x < 0 || this.y < 0 || this.x >= boardWidth, this.y >= boardHeight)}`);
        return !(this.x < 0 || this.y < 0 || this.x >= boardWidth || this.y >= boardHeight);
    }
}

// Normal BFS
function shortestPath(ary: boolean[][], start: Coordinate, end: Coordinate) {
    if (ary.length == 0 || ary[0].length == 0 || !start.isValid(ary.length, ary[0].length) || !end.isValid(ary.length, ary[0].length)) {
        return 0;
    }

    let queue = [];
    return shortestPathImpl(ary, start, end, queue, 0);
}

// 1. Scan for possible points
// 2. Add to queue if it's not there
// 3. Pick a point to move forward to
function shortestPathImpl(ary: boolean[][], start: Coordinate, end: Coordinate, queue: Coordinate[], numSteps: number) {
    if (start.x === end.x && start.y === end.y) {
        //console.log(`Returning ${numSteps}`);
        return numSteps;
    }
    
    if (ary[start.x][start.y] === false) {

        console.log(`(${start.x}, ${start.y})`);
        ary[start.x][start.y] = true;
        let up = start.getTop();
        let left = start.getLeft();
        let down = start.getBot();
        let right = start.getRight();

        if (up.isValid(ary.length, ary[0].length) && ary[up.x][up.y] === false) {
            queue.push(up);
        }
        if (left.isValid(ary.length, ary[0].length) && ary[left.x][left.y] === false) {
            queue.push(left);
        }
        if (down.isValid(ary.length, ary[0].length) && ary[down.x][down.y] === false) {
            queue.push(down);
        }
        if (right.isValid(ary.length, ary[0].length) && ary[right.x][right.y] === false) {
            queue.push(right);
        }
    }

    start = queue[0];
    queue = queue.slice(1)
    // Breaks because not keeping track of depth of BFS -- necessary to get the number of steps
    return Math.min(shortestPathImpl(ary, start, end, queue, numSteps + 1), numSteps);
}

let ary = [[false, false, false, false],
[true, true, false, true],
[false, false, false, false],
[false, false, false, false]]

let start = new Coordinate(3, 0);
let end = new Coordinate(0, 0);

console.log(shortestPath(ary, start, end));