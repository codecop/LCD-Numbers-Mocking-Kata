using Sharpen;

namespace Org.Codecop.Lcdnumbers
{
	/// <summary>Fake client code.</summary>
	public class Main
	{
		public static void Main(string[] args)
		{
			LcdDisplay lcdDisplay = new LcdDisplay(new DigitsSplitter(new NumeralSystem(), new DigitFactory(new Patterns())), new DigitScaler(new ScalingRepeater()), new DigitPrinter(new Zipper()));
			//
			//
			//
			int number = System.Convert.ToInt32(args[0]);
			Scaling scaling = Scaling.Of(System.Convert.ToInt32(args[1]));
			System.Console.Out.Println(lcdDisplay.ToLcd(number, scaling));
		}
	}
}
