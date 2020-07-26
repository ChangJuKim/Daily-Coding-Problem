Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Thoughts/etc

(this is consolidated below)
1. divide by 2
   A. Maybe get an array.
   B. Basically start at exp = 1, value = x
   C. Keep squaring value until exp * 2 > y.
   D. Integer multiplication from there. Alterntely,
   E. Make y binary.
   F. Till you reach the highest digit, square value and add to an array
   G. Multiply the values corresponding to each "1"

Thoughts consolidated:
   1. Get binary representation of the exponent
   2. Make an array of size [log2(exponent)] (# digits of binary)
      A. Let array[0] = base
      B. Array[i] = array[i-1]^2.
      	 So array[1] = base^2
	 array[2] = base^4
	 array[3] = base^8
 	 ...
	 array[n] = base[2^n]
   3. Loop through each digit of binary. Total = 1
      A. If binary[i] = 1, multiply total by array[i].
         {One of them (looping through array or binary) will have to go backwards}

   E.g. 3^10 = 59049     => 3^10 = 3^8 * 3^2
   1) 10 => 1010.
   2) 3 => [3^1, 3^2, 3^4, 3^8]
        => [3, 9, 81, 6561]
   3) 3^10 => 9 * 6561 = 59049
   

   Runtime:
     Getting binary representation is... log(exp)? Yeah probably
     Filling in array (squaring value) is... log(exp) again.
     Multiplying the respective values is log(exp) again.

     So O(log(exp) + log(exp) + log(exp)) = O(log(exp)).
     Storage: O(log(exp)) for the array

11 min to think
14 min to finish coding



Final thoughts:
   Storage can be shrunk to O(1) by changing base and exp at the same time
   So you get binary of exp
   And if exp == 1, multiply total by x
   x = x^2, exp = exp / 2


~~~~~~~~~~~~~~~~~~~~~~~~~~~~


5^9
Divide 9 => 2^0 + 2^3 => 1001
5, 25, 625, 625^2, 625^4

5^8 * 5^1