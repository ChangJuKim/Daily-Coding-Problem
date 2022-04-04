/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

Given the root to a binary tree, count the number of unival subtrees.

For example, the following tree has 5 unival subtrees:

   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
*/

// Let tree be an array representation of a binary tree. 
// tree[0] = the root. tree[n]'s children are tree[2n+1] and tree[2n+2].
// if tree[x] is undefined, that child does not exist.
function countUnival(tree) {
    return countUnival(tree, 0);
}

function countUnival(tree, index) {
    // infinite loop -- have to stop when index is >= tree.length   
    if (isUnival(tree, index)) {
        return 1 + countUnival(tree, 2*index+1) + countUnival(tree, 2*index + 2);
    } else {
        return countUnival(tree, 2*index+1) + countUnival(tree, 2*index+2);
    }
}

function isUnival(tree, index) {
    if (index >= tree.length || !tree[index]) {
        return false;
    }
    leftIndex = 2*index + 1;
    rightIndex = 2*index + 2;
    if (leftIndex < tree.length) { // have to check for undefined here
        if (tree[index] != tree[leftIndex] || !isUnival(tree, leftIndex)) {
            return false;
        }
    }
    if (rightIndex < tree.length) { // have to check for undefined here
        if (tree[index] != tree[rightIndex] || !isUnival(tree, rightIndex)) {
            return false;
        }
    }

    return true;
}


tree1 = [0, 1, 0, undefined, undefined, 1, 0, undefined, undefined, undefined, undefined, 1, 1, undefined];
console.log(countUnival(tree1));






function createUnivalArray(tree) {
    univalArray = new Array[tree.length];
    index = 0;
    
}

function createUnivalArray(tree, univalArray, index) {

}
