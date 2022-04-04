/*
Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

function sumToK(ary, k) {
    let diffSet = new Set();
    for (let i = 0; i < ary.length; i++) {
        if (diffSet.has(ary[i])) {
            return true;
        }
        diffSet.add(k-ary[i]);
    }
    return false;
}

console.log(sumToK([10, 15, 3, 7], 17));
console.log(sumToK([1, 2, 3], 6));
console.log(sumToK([1, 2, 3], 7));
console.log(sumToK([10, 15, 3, 7], 14));
console.log(sumToK([1, 2, 3, 3], 6));