package com.adancau.trainings.collabera.resource;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.filter.FilterCriteria;
import com.adancau.trainings.collabera.service.EmployeeService;
import com.adancau.trainings.collabera.service.EmployeeServiceImpl;

import java.util.List;

public class EmployeeResource {

    private final EmployeeService employeeService;
    public EmployeeResource() {
        employeeService = new EmployeeServiceImpl();
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    public List<EmployeeDTO> getFilteredEmployees(FilterCriteria filterCriteria) {
        return employeeService.filterByCriteria(filterCriteria);
    }

    public EmployeeDTO updateSalary(EmployeeDTO employeeDTO, ProjectDTO projectDTO, int newSalary) {
        return employeeService.updateByIdAndProject(employeeDTO.getId(), projectDTO, newSalary);
    }

    public EmployeeDTO allocateEmployeeToProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO){
        return employeeService.allocateEmployeeToProject(employeeDTO, projectDTO);
    }
}
