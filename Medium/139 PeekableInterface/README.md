Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given an iterator with methods next() and hasNext(), create a wrapper iterator, PeekableInterface, which also implements peek(). peek shows the next element that would be returned on next().

Here is the interface:

class PeekableInterface(object):
    def __init__(self, iterator):
        pass

    def peek(self):
        pass

    def next(self):
        pass

    def hasNext(self):
        pass

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Well this is given in python...

Idea 1:
  For peek, create a cloned iterator, and make iterator go to next and return that value


Idea 2:
  Create a value private variable. If value is null, next and hasnext are the same.
  Peek:
    1. Call hasNext and ensure it's true. Error otherwise.
    2. if value is null: Call super.next and value = result from next.
    3. return value.
  Next:
    1. if value is null: call super.next or someting
       else: return value. value = null
  hasNext:
    1. if value is null: super.hasNext
       else: return true

Well we didn't code it. I guess cause we're lazy :<