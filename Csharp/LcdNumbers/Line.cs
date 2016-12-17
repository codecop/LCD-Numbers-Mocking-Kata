using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Value Object of an LCD digit line.</summary>
	public class Line
	{
		private readonly string line;

		public Line(string line)
		{
			Objects.RequireNonNull(line);
			this.line = line;
		}

		public virtual Org.Codecop.Lcdnumbers.Line ScaleHorizontal(ScalingRepeater repeater, Scaling scaling)
		{
			Objects.RequireNonNull(repeater);
			Objects.RequireNonNull(scaling);
			char[] chars = line.ToCharArray();
			return new Org.Codecop.Lcdnumbers.Line(chars[0] + repeater.Repeat(chars[1], scaling) + chars[2]);
		}

		public override bool Equals(object other)
		{
			if (!(other is Org.Codecop.Lcdnumbers.Line))
			{
				return false;
			}
			Org.Codecop.Lcdnumbers.Line that = (Org.Codecop.Lcdnumbers.Line)other;
			return this.line.Equals(that.line);
		}

		public override int GetHashCode()
		{
			return line.GetHashCode();
		}

		public override string ToString()
		{
			return line;
		}
	}
}
