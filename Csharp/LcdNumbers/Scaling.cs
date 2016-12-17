using System;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>The scale factor value.</summary>
	public class Scaling
	{
		public static readonly Org.Codecop.Lcdnumbers.Scaling None = new Org.Codecop.Lcdnumbers.Scaling(1);

		public static readonly Org.Codecop.Lcdnumbers.Scaling Two = new Org.Codecop.Lcdnumbers.Scaling(2);

		private readonly int times;

		public static Org.Codecop.Lcdnumbers.Scaling Of(int t)
		{
			return new Org.Codecop.Lcdnumbers.Scaling(t);
		}

		private Scaling(int times)
		{
			if (times <= 0)
			{
				throw new ArgumentException("scaling factor must be >= 1");
			}
			this.times = times;
		}

		public virtual bool None()
		{
			return times == 1;
		}

		public virtual void Times(Runnable block)
		{
			Objects.RequireNonNull(block);
			for (int i = 0; i < times; i++)
			{
				block.Run();
			}
		}

		public override bool Equals(object other)
		{
			if (!(other is Org.Codecop.Lcdnumbers.Scaling))
			{
				return false;
			}
			Org.Codecop.Lcdnumbers.Scaling that = (Org.Codecop.Lcdnumbers.Scaling)other;
			return this.times == that.times;
		}

		public override int GetHashCode()
		{
			return times;
		}

		public override string ToString()
		{
			return Sharpen.Extensions.ToString(times);
		}
	}
}
