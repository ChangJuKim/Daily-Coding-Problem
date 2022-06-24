/*
Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number 
could represent. You can assume each valid number in the mapping is a single digit.

For example if {"2": ["a", "b", "c"], "3": ["d", "e", "f"], …} then 
"23" should return ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

----------------------------------------

0. Create an empty linked list. If length of number > 0, put empty string inside.
        We want a linked list because we're pushing a lot of values in, changing current values, and iterating through incrementally.
        We don't need to get a specific element -- just need to start from the beginning and end up at the end of list
        So therefore, because there's a lot of pushes I think linked list will be faster to implement.
1. For each number in the numberString:
    2. For each element in the list (keep track of the length in a const variable. Otherwise this will be an infinite loop)
        3. For each element in the mapping of that number (start at index 1):
            4. list.push(currentInList + mapping[indexThatStartsAt1])
        list.current = list.current + mapping[0]
5. Return list

I can't see how it gets more efficient than that.
Basically, if we have "1234" and mapping = {"1": [stuff], "2": [otherStuff] ... "4"=...}
    Then loop through 1, loop through [stuff for 1], and loop through the current length of list.

------------------------------------

Turns out this was indeed the optimal solution. Though there's a cooler (python) solution on 
https://www.geeksforgeeks.org/iterative-letter-combinations-of-a-phone-number/ so go check that out!
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class DigitsToLetters {
    
    public static LinkedList<String> possibleLetters(String numberString, HashMap<String, String[]> totalMaps) {
        LinkedList<String> list = new LinkedList<String>();
        if (numberString.length() > 0) {
            list.add("");
        }

        for (int numIndex = 0; numIndex < numberString.length(); numIndex++) {
            String number = numberString.substring(numIndex, numIndex + 1);
            if (totalMaps.containsKey(number)) {
                String[] map = totalMaps.get(number);
                ListIterator<String> listItr = list.listIterator();
                while (listItr.hasNext()) {
                    String current = listItr.next();
                    if (map.length > 0) {
                        listItr.set(current + map[0]);
                    }
                    for (int mapIndex = 1; mapIndex < map.length; mapIndex++) {
                        listItr.add(current + map[mapIndex]);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String nums = "123456";
        HashMap<String, String[]> map = new HashMap<>();
        map.put("1", new String[]{"a", "b", "c"});
        map.put("2", new String[]{"D", "E", "F"});
        map.put("3", new String[]{"x"});
        map.put("4", new String[]{"Q", "R", "S"});
        map.put("6", new String[]{});

        System.out.println(possibleLetters(nums, map));

        System.out.println(possibleLetters("", new HashMap<String, String[]>()));
    }
}
