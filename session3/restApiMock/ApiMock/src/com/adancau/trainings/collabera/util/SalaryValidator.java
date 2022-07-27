package com.adancau.trainings.collabera.util;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;

public class SalaryValidator {

    private static final int MINIMUM_ACCEPTED_SALARY = 1000;

    public static boolean validateSalary(EmployeeDTO employeeDTO) {
        return employeeDTO.getSalary() >= MINIMUM_ACCEPTED_SALARY;
    }
}
