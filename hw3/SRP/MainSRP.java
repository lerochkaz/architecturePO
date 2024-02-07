package hw3.SRP;

public class MainSRP {
    public static void main(String[] args) {
        Employee employee = new Employee("Ben");
        ClalucateSalary clalucateSalary = new ClalucateSalary(350, 192);
        System.out.println(employee);
        System.out.println(clalucateSalary.calculateSalary());
    }
}
