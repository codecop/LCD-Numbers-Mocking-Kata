using System.Collections.Generic;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Scales x and y of digit lines.</summary>
	public class DigitScaler
	{
		private readonly ScalingRepeater repeater;

		public DigitScaler(ScalingRepeater repeater)
		{
			Objects.RequireNonNull(repeater);
			this.repeater = repeater;
		}

		public virtual IList<Digit> Scale(IList<Digit> digits, Scaling scaling)
		{
			Objects.RequireNonNull(digits);
			Objects.RequireNonNull(scaling);
			// return digits.map(d -> scale(d, scaling));
			IList<Digit> scaled = new AList<Digit>();
			foreach (Digit d in digits)
			{
				scaled.Add(Scale(d, scaling));
			}
			return scaled;
		}

		private Digit Scale(Digit digit, Scaling scaling)
		{
			Objects.RequireNonNull(digit);
			Objects.RequireNonNull(scaling);
			if (scaling.None())
			{
				return digit;
			}
			IList<Line> scaled = new AList<Line>();
			bool oddLine = true;
			foreach (Line line in digit.Lines())
			{
				Line scaledLine = line.ScaleHorizontal(repeater, scaling);
				if (oddLine)
				{
					scaled.Add(scaledLine);
				}
				else
				{
					Sharpen.Collections.AddAll(scaled, repeater.Repeat(scaledLine, scaling));
				}
				oddLine = !oddLine;
			}
			return digit.Scale(scaled);
		}
	}
}
