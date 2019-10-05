# Creating Tests for LCD Numbers Kata by Mocking Collaborators

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html)
using outside-in development. There are no tests. In order to unit test its
classes you need to create [test doubles](http://martinfowler.com/bliki/TestDouble.html)
for the collaborators.

The starting point is available in different programming languages.

## Requirements (copied from Ruby Quiz)

The `LcdDisplay` creates an LCD string representation of an integer value using a
4x7 grid of space each, using minus and pipe characters for each digit.
Each digit is shown below:

     --      --  --      --  --  --  --  --
    |  |   |   |   ||  ||   |      ||  ||  |
    |  |   |   |   ||  ||   |      ||  ||  |
             --  --  --  --  --      --  --
    |  |   ||      |   |   ||  |   ||  |   |
    |  |   ||      |   |   ||  |   ||  |   |
     --      --  --      --  --      --  --

The bar size should be adjustable. The default value is 2 - as shown above.
Read more about it at [RubyQuiz](http://rubyquiz.com/quiz14.html).

## Description of Existing Solution

To make things easier for you, the solutions are described in their Readme together
with an UML diagram.

## Creating Unit Tests

Create unit tests for all functions and classes. Make sure all units are tested in isolation.
The point of this exercise is to go extreme to practise using test doubles.
**Create test doubles for everything!** Create dummy objects for all used values
and stub all collaborators, even the most simple ones.

### Check your Coverage

To measure your progress you should use code coverage tools.

### Warning

Enforcing all calls to other functions and classes in a test is not recommended in real unit tests
because this leads to bad tests which are bound to the implementation. These
over specified tests make it impossible to change the code under test without breaking.
We want to be able to change the code without breaking the test as long as the
required functionality is not changed. This exercise is for practising test doubles.

### License

This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.
