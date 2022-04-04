/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/

/* CJ's Notes:
    No time intervals: 0 classrooms

    1. Sort the array (by start time)
    2. For all intervals in ary:
        If ary[i][0] (which is start time) is greater than endTime[j]:
            endTime[j] = ary[i][1]
        else:
            endTime.push(ary[i][1])
    3. Return endTime.length;

    We want endTimes to be a min-heap.
*/

function compareByStartTime(timeOne: number[], timeTwo: number[]) {
    return timeOne[0] - timeTwo[0];
}

function numClassrooms(timeIntervals) {
    timeIntervals = timeIntervals.sort(compareByStartTime); // check if sort automatically changes base array
    let endTimes = [];
    for (let i = 0; i < timeIntervals.length; i++) {
        let endTimesIndex = notSmallest(timeIntervals[i], endTimes);
        if (endTimesIndex === -1) {
            endTimes.push(timeIntervals[i][1]);
        } else {
            endTimes.splice(endTimesIndex, 1, timeIntervals[i][1]);
        }
    }
    return endTimes.length;
}

// If num > any value in endTimes, returns index of that value. Else, returns -1
function notSmallest(num, endTimes) {
    for (let i = 0; i < endTimes.length; i++) {
        if (num > endTimes[i]) {
            return i;
        }
    }
    return -1;
}

const timesOne = [[30, 75], [0, 50], [60, 150]];
//const timesTwo = [[30, 75], [0, 50], [60, 150]];

console.log(`The number of classrooms needed is ${numClassrooms(timesOne)}`);