using System.Collections.Generic;
using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Zip joins elements of collections element wise, i.e.</summary>
	/// <remarks>Zip joins elements of collections element wise, i.e. all first elements are joined and so on.</remarks>
	public class Zipper
	{
		public interface Combiner<T, R>
		{
			R Apply(T arg);
		}

		public virtual IList<R> Zip<T, R, _T2>(ICollection<_T2> collections, Zipper.Combiner<IList<T>, R> combine)
			where _T2 : ICollection<T>
		{
			Objects.RequireNonNull(collections);
			Objects.RequireNonNull(combine);
			IList<R> zipped = new AList<R>();
			// List<Iterator<T>> iterators = collections.map(Iterable::iterator);
			IList<Iterator<T>> iterators = new AList<Iterator<T>>();
			foreach (ICollection<T> c in collections)
			{
				iterators.Add(c.Iterator());
			}
			Iterator<T> first = iterators[0];
			while (first.HasNext())
			{
				IList<T> nthElements = NextOfEach(iterators);
				R joined = combine.Apply(nthElements);
				zipped.Add(joined);
			}
			return zipped;
		}

		private IList<T> NextOfEach<T>(IList<Iterator<T>> iterators)
		{
			IList<T> nthElements = new AList<T>();
			foreach (Iterator<T> i in iterators)
			{
				nthElements.Add(i.Next());
			}
			return nthElements;
		}
	}
}
