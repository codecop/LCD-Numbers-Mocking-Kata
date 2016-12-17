using System;
using System.Collections.Generic;
using System.Linq;

namespace Org.Codecop.Lcdnumbers
{
    /// <summary>Splits a number into its digits according to its numeral system, e.g.</summary>
    /// <remarks>Splits a number into its digits according to its numeral system, e.g. Decimal System.</remarks>
    public class NumeralSystem
    {
        private readonly int @base;

        public NumeralSystem()
            : this(10)
        {
        }

        public NumeralSystem(int @base)
        {
            if (@base < 2)
            {
                throw new ArgumentException("Smallest base is binary; base=" + @base);
            }

            this.@base = @base;
        }

        public virtual IList<int> DigitsOf(int value)
        {
            if (value < 0)
            {
                throw new ArgumentException("negative number " + value);
            }

            IList<int> digits = new List<int>();
            int remainder = value;

            while (remainder > 0)
            {
                digits.Add(remainder % @base);
                remainder /= @base;
            }

            return digits.Reverse().ToList();
        }
    }
}
