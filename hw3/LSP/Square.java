package hw3.LSP;

public class Square extends QuadRangle {
    private int lengths;

    public Square(int length) {
        this.lengths = length;
    }

    public int getLength() {
        return lengths;
    }

    public void setLength(int length) {
        this.lengths = length;
    }

    @Override
    public int area() {
        return lengths * lengths;
    }
}
