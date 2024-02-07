package hw3.LSP;

public class MainLSP {
    public static void main(String[] args) {
        QuadRangle shape = new Rectangle(6, 10);
        printArea(shape);
        shape = new Square(4);
        printArea(shape);
    }

    public static void printArea(QuadRangle quadRangle) {
        System.out.println(quadRangle.area());
    }
}
