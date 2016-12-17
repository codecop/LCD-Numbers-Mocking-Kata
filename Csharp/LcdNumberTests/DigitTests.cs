using Org.Codecop.Lcdnumbers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Xunit;
using Moq;

namespace Org.Codecop.Lcdnumbers.Tests
{
    public class DigitTests
    {
        [Fact]
        public void ShouldThrowExceptionWhenScalingWithFewerDigit()
        {
            var someLine = new Line("Actual content is irrelevant");
            var mockedPatterns = new Mock<IPatterns>();
            mockedPatterns.Setup(pattern => pattern.Of(It.IsAny<int>())).Returns(new List<Line>() { someLine, someLine });
            
            var digit = new Digit(1, mockedPatterns.Object);
            IList<Line> fewerLines = new List<Line>() { someLine };

            Assert.Throws<ArgumentException>(() => digit.Scale(fewerLines));
        }

        [Fact]
        public void ShouldReturnScaledLinesWithSameContent()
        {
            var mockedLine = new Mock<Line>("Dummy");

            var mockedPatterns = new Mock<IPatterns>();
            mockedPatterns.Setup(pattern => pattern.Of(It.IsAny<int>())).Returns(new List<Line>() { mockedLine.Object });

            var digit = new Digit(1, mockedPatterns.Object);
            IList<Line> scaledLines = new List<Line>() { new Line("ABC") };

            Digit scaledDigit = digit.Scale(scaledLines);

            Assert.Equal(scaledLines, scaledDigit.Lines());
        }

        [Fact]
        public void ShouldReturnLcdStringRepresentationOfDigit()
        {
            var mockedPatterns = new Mock<IPatterns>();
            mockedPatterns.Setup(p => p.Of(It.IsAny<int>())).Returns(new List<Line>() { new Line("A") });

            Digit digit = new Digit(0, mockedPatterns.Object);
        }
    }
}
