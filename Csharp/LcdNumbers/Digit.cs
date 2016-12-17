using System;
using System.Collections.Generic;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Value Object of an LCD digit.</summary>
	public class Digit
	{
		private readonly int digit;

		private readonly IList<Line> lines;

		public Digit(int digit, Patterns patterns)
			: this(digit, patterns.Of(digit))
		{
		}

		private Digit(int digit, IList<Line> lines)
		{
			Objects.RequireNonNull(lines);
			this.digit = digit;
			this.lines = lines;
		}

		internal virtual IList<Line> Lines()
		{
			return lines;
		}

		internal virtual Org.Codecop.Lcdnumbers.Digit Scale(IList<Line> scaledLines)
		{
			Objects.RequireNonNull(scaledLines);
			int linesCount = lines.Count;
			int scaledCount = scaledLines.Count;
			if (scaledCount < linesCount)
			{
				throw new ArgumentException("Scaled lines must be more than original ones: " + scaledCount + ">=" + linesCount);
			}
			return new Org.Codecop.Lcdnumbers.Digit(digit, scaledLines);
		}

		public override bool Equals(object other)
		{
			if (!(other is Org.Codecop.Lcdnumbers.Digit))
			{
				return false;
			}
			Org.Codecop.Lcdnumbers.Digit that = (Org.Codecop.Lcdnumbers.Digit)other;
			return this.digit == that.digit;
		}

		public override int GetHashCode()
		{
			return digit;
		}

		public override string ToString()
		{
			return Sharpen.Extensions.ToString(digit);
		}
	}
}
