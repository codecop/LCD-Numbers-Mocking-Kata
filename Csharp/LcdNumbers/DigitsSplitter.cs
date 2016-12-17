using System.Collections.Generic;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Splits into digits and converts digits to LCD digits.</summary>
	public class DigitsSplitter
	{
		private readonly NumeralSystem numeralSystem;

		private readonly DigitFactory digitFactory;

		public DigitsSplitter(NumeralSystem numeralSystem, DigitFactory digitFactory)
		{
			Objects.RequireNonNull(numeralSystem);
			Objects.RequireNonNull(digitFactory);
			this.numeralSystem = numeralSystem;
			this.digitFactory = digitFactory;
		}

		public virtual IList<Digit> Convert(int number)
		{
			IList<int> numeralDigits = numeralSystem.DigitsOf(number);
			// return numeralDigits.map(digitFactory::create);
			IList<Digit> digits = new AList<Digit>();
			foreach (int i in numeralDigits)
			{
				digits.Add(digitFactory.Create(i));
			}
			return digits;
		}
	}
}
