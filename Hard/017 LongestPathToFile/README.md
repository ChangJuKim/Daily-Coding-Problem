Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

[dir, subdir2, subsubdir2]

The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts:


Idea 1: Create a tree. Each tree can store the length to get to that directory. Finding
the longest file path should then be easy. The problem is that it takes quite a bit of
memory.

Idea 2: Have some kinda stack and determine longest length directly
The number of tabs represents nested files. So a file path will have something like
(no /t), (1 /t), (2 /t), ... file.ext

You can then pop off the stack each time you have a different/lower number of /t

I will go with idea 2.
Things to make it easier:
  1. You can split the string by "\n" to get an array of each dir/subdir/file.
  2. Have a "count tabs" function
  3. Store in the stack the length of the current filepath. Keep a #/t variable.
       A. If # of /t is one greater, then you want to add that next value to the stack
       B. If # of /t is equal, you want to pop once
       C. If # of /t is (n) less, you want to pop n+1 times

Time to think: 9 min
Time to code: 26 min


~~~~~~~~~~~

I guess it's good