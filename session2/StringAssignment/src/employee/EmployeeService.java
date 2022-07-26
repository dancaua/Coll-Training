package employee;

import p2.Main;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    private final String[] employees = {"101001011", "102001022", "103002011", "104003080", "105002020", "106002080"};
    private static final int EMPLOYEE_ID_START_INDEX = 0;
    private static final int EMPLOYEE_ID_END_INDEX = 3;
    private static final int EMPLOYEE_JOB_START_INDEX = 6;
    private static final int EMPLOYEE_JOB_END_INDEX = 9;
    private static Map<String, String> locationMap;

    static {
        locationMap = new HashMap<>();
        locationMap.put("011", "Delhi");
        locationMap.put("022", "Mumbai");
        locationMap.put("080", "Banglore");
        locationMap.put("020", "Pune");
    }

    /*
     * Note : employee codes are designed in following way:
     * a) first 3 digits are employee code
     * b) next 3 digits are related to their department id.
     * c) and last 3 digits are the city code of their work location
     *     for example
     *       011 : Delhi
     *       022 : Mumbai
     *       080 : Banglore
     *       020 : Pune
     * */

    public String[] getEmployeeCodes() {
        String[] codes = new String[employees.length];
        int count = -1;
        for (String empid : employees) {
            codes[++count] = getEmployeeCode(empid);
        }

        return codes;
    }

    private String getEmployeeCode(String employee) {
        return employee.substring(EMPLOYEE_ID_START_INDEX, EMPLOYEE_ID_END_INDEX);
    }

    private String getJobLocationCodeByEmployee(String employee) {
        return employee.substring(EMPLOYEE_JOB_START_INDEX, EMPLOYEE_JOB_END_INDEX);
    }

    public Map<String, String> getEmployeeJobLocationMap() {
        Map<String, String> employeeJobLocationMap = new HashMap<>();
        for (String employee : employees) {
            String jobLocation = getJobLocationCodeByEmployee(employee);
            if (locationMap.containsKey(jobLocation)) {
                employeeJobLocationMap.put(getEmployeeCode(employee), locationMap.get(jobLocation));
            }
        }
        return employeeJobLocationMap;
    }
}
