package p1;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    // compares salaries in descending order

    @Override
    public int compare(Employee o1, Employee o2) {
        return Comparator.comparing(Employee::getSalary).compare(o2, o1);
    }
}
