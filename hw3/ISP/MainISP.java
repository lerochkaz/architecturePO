package hw3.ISP;

public class MainISP {
    public static void main(String[] args) {
        Shape shape = new Circle(10);
        printPerimetr(shape);
        Shape3d shape3d = new Cube(4);
        printPerimetr(shape3d);
        printValue(shape3d);
    }

    public static void printPerimetr(Shape shape) {
        System.out.println(shape.perimetr());
    }

    public static void printValue(Shape3d shape3d) {
        System.out.println(shape3d.value());
    }
}
