/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required
 to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for
  “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

compute
mput

*/

// Checking all cases
let usedWords = new Set<string>();

function editDistance(s1: string, s2: string) {
    return editDistanceHelper(s1, s2, 0, 0, 0);
}

function editDistanceHelper(s1: string, s2: string, index1: number, index2: number, numSteps: number) {
    if (s1 === s2) {
        return numSteps;
    }
    if (usedWords.has(s1)) {
        return;
    }

    usedWords.add(s1);

    // insert s2's element at index2, into index1 at s1
    let result1 = editDistanceHelper(s1.slice(0,index1) + s2.charAt(index2) + s1.slice(index1), s2, index1, index2+1, numSteps+1);
    // delete element at index1
    let result2 = editDistanceHelper(s1.slice(0, index1) + s1.slice(index1 + 1), s2, index1+1, index2, numSteps+1);
    // replace element at index1 with element at index2
    let result3 = editDistanceHelper(s1.slice(0, index1) + s2.charAt(index2) + s1.slice(index1 + 1), s2, index1+1, index2+1, numSteps+1);

    // get the min value of result1, result2 and result3 (if not undefined) and return it
}