package employee;

import java.util.Map;

public class MainExecution {

    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        String[] codes = service.getEmployeeCodes();

        for (String empid : codes) {
            System.out.println(empid);
        }

        Map<String, String> employeeJobLocationMap = service.getEmployeeJobLocationMap();
        for(Map.Entry<String, String> entry : employeeJobLocationMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Following is the new requirement from Client
    // Print employee id with their respective job location
    // for example
    // 101 : Delhi
    // 102 : Mumbai
    // and so on
}
