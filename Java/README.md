## LCD Numbers Kata for Mocking Collaborators ##

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html)
in Java using outside-in development. There are no tests. In order to unit test its
classes you need to stub and mock the collaborators.

This is a [Apache Maven](https://maven.apache.org/) project. Run `mvnw test` to
run your tests. [JUnit](http://junit.org/) and [Mockito](http://site.mockito.org/)
are provided as dependencies.

## Requirements ##

The `LcdDisplay` creates an LCD string representation of an integer value using a
4x7 grid of space, using minus and pipe characters for each digit.

Each digit is shown below:

     --      --  --      --  --  --  --  -- 
    |  |   |   |   ||  ||   |      ||  ||  |
    |  |   |   |   ||  ||   |      ||  ||  |
             --  --  --  --  --      --  -- 
    |  |   ||      |   |   ||  |   ||  |   |
    |  |   ||      |   |   ||  |   ||  |   |
     --      --  --      --  --      --  -- 

The bar size should be adjustable. The default value is 2 - as shown above.

## Description of Classes ##

To make things easier for you, here is the description of the solution used in the code:
The `LcdDisplay` is the entry point. The given number is split into digits according to the
used `NumeralSystem` (which is the Decimal System). Then the initial `Digit`s are
created by copying the template `Line`s from `Patterns`. Then the (LCD) digits scaled
according to the `Scaling` value (by `DigitScaler`). The actual scaling is done by
the `ScalingRepeater` by repeating certain rows and columns of the template. Finally
the list of digits is combined to a single String by the `DigitPrinter`.

## Assignment ##

Create unit tests for all classes. Make sure all units are tested in isolation.
There are sample LCD outputs in the `src/test/resources` folder.

### Check your Coverage ###

To measure your progress you can use code coverage tools

* EclEmma inside of Eclipse.

* [Cobertura](http://cobertura.github.io/cobertura/) - type `mvnw cobertura:cobertura`.

* [PIT](http://pitest.org/) - type `mvnw test-compile org pitest:pitest-maven:mutationCoverage`.
  Note that PIT does not work if there are any blanks in the path names leading to the current location.

### License ###
This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.
