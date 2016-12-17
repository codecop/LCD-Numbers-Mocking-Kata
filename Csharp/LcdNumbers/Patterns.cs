using System;
using System.Collections.Generic;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Knows the initial pattern of each LCD digit.</summary>
	public class Patterns
	{
		private readonly IDictionary<int, IList<Line>> lcdByDigit = new Dictionary<int, IList<Line>>();

		public Patterns()
		{
			Put(0, new Line(" - "), new Line("| |"), new Line("   "), new Line("| |"), new Line(" - "));
			//
			//
			//
			//
			Put(1, new Line("   "), new Line("  |"), new Line("   "), new Line("  |"), new Line("   "));
			//
			//
			//
			//
			Put(2, new Line(" - "), new Line("  |"), new Line(" - "), new Line("|  "), new Line(" - "));
			//
			//
			//
			//
			Put(3, new Line(" - "), new Line("  |"), new Line(" - "), new Line("  |"), new Line(" - "));
			//
			//
			//
			//
			Put(4, new Line("   "), new Line("| |"), new Line(" - "), new Line("  |"), new Line("   "));
			//
			//
			//
			//
			Put(5, new Line(" - "), new Line("|  "), new Line(" - "), new Line("  |"), new Line(" - "));
			//
			//
			//
			//
			Put(6, new Line(" - "), new Line("|  "), new Line(" - "), new Line("| |"), new Line(" - "));
			//
			//
			//
			//
			Put(7, new Line(" - "), new Line("  |"), new Line("   "), new Line("  |"), new Line("   "));
			//
			//
			//
			//
			Put(8, new Line(" - "), new Line("| |"), new Line(" - "), new Line("| |"), new Line(" - "));
			//
			//
			//
			//
			Put(9, new Line(" - "), new Line("| |"), new Line(" - "), new Line("  |"), new Line(" - "));
		}

		//
		//
		//
		//
		private void Put(int digit, params Line[] lines)
		{
			if (lcdByDigit.ContainsKey(digit))
			{
				throw new ArgumentException("duplicate pattern definition for digit " + digit);
			}
			IList<Line> listOfLines = Sharpen.Collections.UnmodifiableList(Arrays.AsList(lines));
			lcdByDigit.Put(digit, listOfLines);
		}

		public virtual IList<Line> Of(int digit)
		{
			if (!lcdByDigit.ContainsKey(digit))
			{
				throw new ArgumentException("no pattern defined for digit " + digit);
			}
			return lcdByDigit.Get(digit);
		}
	}
}
