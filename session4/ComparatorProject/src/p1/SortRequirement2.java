package p1;

import java.util.*;


public class SortRequirement2 {

    public static void main(String[] args) {

        Set<Employee> employeeSet = new HashSet<>();

        Employee e1 = new Employee(101, "mike", 2000, 1, "ADF-Java");
        Employee e2 = new Employee(102, "jenny", 2000, 2, "Oracle");
        Employee e3 = new Employee(101, "mike", 2000, 1, "Java");
        Employee e4 = new Employee(103, "mi", 3000, 1, "Java");
        Employee e5 = new Employee(104, "Yong", 3000, 1, "Salesforce");
        Employee e6 = new Employee(106, "Yong", 3000, 1, "ADF-Java");


        employeeSet.add(e1);
        employeeSet.add(e2);
        employeeSet.add(e3);
        employeeSet.add(e4);
        employeeSet.add(e5);
        employeeSet.add(e6);


        List<Employee> list = new ArrayList<>(employeeSet);

        System.out.println(list);

        System.out.println("\n------------------------\n");

        Collections.sort(list, Comparator.comparingInt(Employee::getId));
        for(Employee e : list){
            System.out.println(e);
        }

        System.out.println("\n------------------------\n");

        Collections.sort(list, Comparator.comparingInt(Employee::getSalary));
        for(Employee e : list){
            System.out.println(e);
        }

        System.out.println("\n------------------------\n");

        Collections.sort(list, new EmployeeComparator());
        for(Employee e : list){
            System.out.println(e);
        }

    }

}