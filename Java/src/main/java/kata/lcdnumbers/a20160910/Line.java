package kata.lcdnumbers.a20160910;

/**
 * Value Object of an LCD digit line.
 */
public class Line {
    private final String line;

    public Line(String line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Line)) return false;
        Line that = (Line) other;
        return this.line.equals(that.line);
    }

    @Override
    public int hashCode() {
        return line.hashCode();
    }

    @Override
    public String toString() {
        return line;
    }

    public Line scaleHorizontal(int size) {
        if (size == 1) {
            return this;
        }

        char[] chars = line.toCharArray();
        return new Line("" + chars[0] + repeat(chars[1], size) + chars[2]);
    }

    private String repeat(char aChar, int size) {
        StringBuilder acc = new StringBuilder();
        for (int i = 0; i < size; i++) {
            acc.append(aChar);
        }
        return acc.toString();
    }
}
