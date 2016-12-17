using System.Collections.Generic;
using System.Text;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Appends lines next to each other and adds line breaks.</summary>
	public class DigitPrinter
	{
		private const string Newline = "\n";

		private readonly Zipper zipper;

		public DigitPrinter(Zipper zipper)
		{
			Objects.RequireNonNull(zipper);
			this.zipper = zipper;
		}

		public virtual string Render(IList<Digit> digits)
		{
			Objects.RequireNonNull(digits);
			IList<IList<Line>> linesOfAllDigits = LinesOfAllDigits(digits);
			IList<string> linesSideBySide = Zip(linesOfAllDigits);
			return Join(linesSideBySide);
		}

		private IList<IList<Line>> LinesOfAllDigits(IList<Digit> digits)
		{
			// return digits.map(Digit::lines);
			IList<IList<Line>> digitLines = new AList<IList<Line>>();
			foreach (Digit d in digits)
			{
				digitLines.Add(d.Lines());
			}
			return digitLines;
		}

		private IList<string> Zip(IList<IList<Line>> linesOfAllDigits)
		{
			return zipper.Zip(linesOfAllDigits, new _Combiner_41(this));
		}

		private sealed class _Combiner_41 : Zipper.Combiner<IList<Line>, string>
		{
			public _Combiner_41(DigitPrinter _enclosing)
			{
				this._enclosing = _enclosing;
			}

			/*lambda*/
			public string Apply(IList<Line> arg)
			{
				return this._enclosing.Concat(arg);
			}

			private readonly DigitPrinter _enclosing;
		}

		private string Concat(IList<Line> lines)
		{
			// return lines.map(Line::toString).joining());
			StringBuilder joiner = new StringBuilder();
			foreach (Line line in lines)
			{
				joiner.Append(line.ToString());
			}
			return joiner.ToString();
		}

		private string Join(IList<string> lines)
		{
			// return lines.joining(NEWLINE, "", NEWLINE));
			StringBuilder joiner = new StringBuilder();
			foreach (string line in lines)
			{
				joiner.Append(line);
				joiner.Append(Newline);
			}
			return joiner.ToString();
		}
	}
}
