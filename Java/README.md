## LCD Numbers Mocking Collaborators ##

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html) 
in Java using outside-in development. There are no tests. In order to unit test its 
classes you need to stub and mock the collaborators.

This is a [Apache Maven](https://maven.apache.org/) project.  Run `mvnw test` to 
run your tests [JUnit](http://junit.org/) and [Mockito](http://site.mockito.org/) 
are provided as dependencies.

## Description of Requirements ##

The `LcdDisplay` createy an LCD string representation of an integer value using a
4x7 grid of space, using minus and pipe characters for each digit.

● Each digit is shown below:

   --      --  --      --  --  --  --  -- 
  |  |   |   |   ||  ||   |      ||  ||  |
  |  |   |   |   ||  ||   |      ||  ||  |
           --  --  --  --  --      --  -- 
  |  |   ||      |   |   ||  |   ||  |   |
  |  |   ||      |   |   ||  |   ||  |   |
   --      --  --      --  --      --  -- 
  
● The bar size should be adjustable. The default value is 2 - as shown above.

## Description of Classes ##

TODO describe code or paste API doc

+ LcdDisplay
| first test only uses DigitConverter and Digit's toString
| but String composition is not line wise
| write first test again
|- + DigitsConverter
   |- + DigitFactory
      |- + Patterns

|- + DigitsPrinter
   | the direct print ended in getting lines of the digit, which is mocked 
   | again logic pushed out   
   |- + Digit/Patterns/Line

## Assignment ##

Create unit tests for all classes.  Make sure all units are tested in isolation.
There are sample LCD outputs in the `src/test/resources` folder. 

### Check your Coverage ###

To measure your progress you can use code coverage tools 

* EclEmma inside of Eclipse. 

* [Cobertura](http://cobertura github io/cobertura/) `mvnw cobertura:cobertura`.

* [PIT](http://pitest org/) `mvnw test-compile org pitest:pitest-maven:mutationCoverage`.
  PIT does not work if there are blanks in any path names leading to the current location.

### License ###
This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.