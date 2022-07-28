package stream;

import p1.Employee;
import p1.Project;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Project project = new Project("p1");

        Stream<Employee> stream = initializeStream(project);

//        Employee minValue = stream.min(Comparator.comparingInt(Employee::getSalary)).get();
//        System.out.println(minValue);
//
//        stream = initializeStream(project);
//        Employee max = stream.min((obj1, obj2) -> obj2.getSalary() - obj1.getSalary()).get();
//        System.out.println(max);

        stream.forEach(System.out::println);

        System.out.println("\n============\n");
        stream = initializeStream(project);
        stream.filter(employee -> isTargetProject(project, employee))
                .forEach(Main::processEmployee);
    }

    private static boolean isTargetProject(Project project, Employee employee) {
        return employee.getProject().equals(project);
    }

    private static void processEmployee(Employee e) {
        e.setSalary(calculateNewSalary(e));
        System.out.println(e);
    }

    private static int calculateNewSalary(Employee e) {
        return e.getSalary() + e.getSalary() / 10;
    }

    private static Stream<Employee> initializeStream(Project project) {
        Employee e1 = new Employee(101, "mike", 2000, 1, "ADF-Java");
        e1.setProject(project);
        Employee e2 = new Employee(102, "jenny", 1000, 2, "Oracle");
        e2.setProject(project);
        Employee e3 = new Employee(101, "mike", 3000, 1, "Java");
        e3.setProject(project);


        Employee e4 = new Employee(103, "mi", 2500, 1, "Java");
        e4.setProject(new Project());
        Employee e5 = new Employee(104, "Yong", 4000, 1, "Salesforce");
        e5.setProject(new Project());
        Employee e6 = new Employee(106, "Yong", 300, 1, "ADF-Java");
        e6.setProject(new Project());
        return Stream.of(e1, e2, e3, e4, e5, e6);
    }
}
