## LCD Numbers Kata for Mocking Collaborators ##

This is an implementation of the [LCD Numbers Kata](http://rubyquiz.com/quiz14.html)
in C#'s .NET Core using outside-in development. There are no tests. In order to unit
test its classes you need to stub and mock the collaborators.

This is a [.NET Core](https://www.microsoft.com/net/core) project. Build and run it with
`dotnet restore` and `dotnet run`. It is set up to work with Visual Studio and 
[VSCode](https://code.visualstudio.com/).
There are no dependencies provided.
You will need [NUnit](https://www.nunit.org/) or [xUnit.net](https://xunit.github.io/)
and [MOQ](http://www.moqthis.com/) as dependencies.

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
There are sample LCD outputs in the `test-resources` folder.

### License ###
This work is licensed under a [New BSD License](http://opensource.org/licenses/bsd-license.php), see `license txt` in repository.
