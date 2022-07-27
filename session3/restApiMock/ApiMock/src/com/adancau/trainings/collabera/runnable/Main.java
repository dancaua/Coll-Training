package com.adancau.trainings.collabera.runnable;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.filter.FilterCriteria;
import com.adancau.trainings.collabera.resource.EmployeeResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeDTO e1 = new EmployeeDTO();
        e1.setSalary(1010);

        EmployeeDTO e2 = new EmployeeDTO();
        e2.setSalary(10001);

        EmployeeDTO e3 = new EmployeeDTO();
        e3.setSalary(999);

        EmployeeDTO e4 = new EmployeeDTO();
        e4.setSalary(2000);

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setEmployees(new ArrayList<>());
        projectDTO.setName("p1");

        ProjectDTO otherProject = new ProjectDTO();
        otherProject.setEmployees(new ArrayList<>());
        otherProject.setName("p2");

        ProjectDTO thirdProject = new ProjectDTO();
        thirdProject.setEmployees(new ArrayList<>());
        thirdProject.setName("p3");

        e1.setProject(new ArrayList<>(Arrays.asList(projectDTO)));
        e2.setProject(new ArrayList<>(Arrays.asList(projectDTO)));
        e3.setProject(new ArrayList<>(Arrays.asList(projectDTO)));
        e4.setProject(new ArrayList<>(Arrays.asList(otherProject)));

        EmployeeResource employeeResource = new EmployeeResource();

        EmployeeDTO e1Saved = employeeResource.addEmployee(e1);
        System.out.println(e1Saved);

        EmployeeDTO e2Saved = employeeResource.addEmployee(e2);
        System.out.println(e2Saved);

        EmployeeDTO e4Saved = employeeResource.addEmployee(e4);
        System.out.println(e4Saved);

        FilterCriteria projectFilter = new FilterCriteria();
        projectFilter.setFilterByProject(true);
        projectFilter.setProjectDTO(projectDTO);

        List<EmployeeDTO> employeesFilteredByProject = employeeResource.getFilteredEmployees(projectFilter);
        System.out.println("\nEmployees by project");
        System.out.println(employeesFilteredByProject);

        FilterCriteria salaryFilter = new FilterCriteria();
        salaryFilter.setFilterBySalary(true);
        salaryFilter.setLowerRange(1020);
        salaryFilter.setUpperRange(11000);

        List<EmployeeDTO> employeesFilteredBySalary = employeeResource.getFilteredEmployees(salaryFilter);
        System.out.println("\nEmployees by salary");
        System.out.println(employeesFilteredBySalary);


        System.out.println("\nUpdated employee salary");
        EmployeeDTO updatedEmployee = employeeResource.updateSalary(e4Saved, otherProject, 123456);
        System.out.println(updatedEmployee);

        System.out.println("\nBefore employee addition to project eg 1");
        System.out.println(e1Saved);
        EmployeeDTO updatedProjectEmployee1 = employeeResource.allocateEmployeeToProject(e1Saved, otherProject);
        System.out.println("\nAdded employee to project eg 1");
        System.out.println(updatedProjectEmployee1);

        System.out.println("\nBefore employee addition to project eg 2");
        System.out.println(e2Saved);
        EmployeeDTO updatedProjectEmployee2 = employeeResource.allocateEmployeeToProject(e2Saved, thirdProject);
        System.out.println("\nAdded employee to project eg 2");
        System.out.println(updatedProjectEmployee2);
    }
}
