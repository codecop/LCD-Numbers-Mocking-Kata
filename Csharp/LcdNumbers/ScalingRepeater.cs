using System.Collections.Generic;
using System.Text;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Repeat objects and characters according to scaling.</summary>
	public class ScalingRepeater
	{
		public virtual IList<T> Repeat<T>(T element, Scaling scaling)
		{
			Objects.RequireNonNull(element);
			Objects.RequireNonNull(scaling);
			IList<T> elements = new AList<T>();
			scaling.Times(new _Runnable_17(elements, element));
			/*lambda*/
			return elements;
		}

		private sealed class _Runnable_17 : Runnable
		{
			public _Runnable_17(IList<T> elements, T element)
			{
				this.elements = elements;
				this.element = element;
			}

			public void Run()
			{
				elements.Add(element);
			}

			private readonly IList<T> elements;

			private readonly T element;
		}

		public virtual string Repeat(char aChar, Scaling scaling)
		{
			Objects.RequireNonNull(scaling);
			StringBuilder acc = new StringBuilder();
			scaling.Times(new _Runnable_30(acc, aChar));
			/*lambda*/
			return acc.ToString();
		}

		private sealed class _Runnable_30 : Runnable
		{
			public _Runnable_30(StringBuilder acc, char aChar)
			{
				this.acc = acc;
				this.aChar = aChar;
			}

			public void Run()
			{
				acc.Append(aChar);
			}

			private readonly StringBuilder acc;

			private readonly char aChar;
		}
	}
}
