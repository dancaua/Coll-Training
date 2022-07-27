package com.adancau.trainings.collabera.service;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.filter.FilterCriteria;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateByIdAndProject(Long id, ProjectDTO projectDTO, int newSalary);
    List<EmployeeDTO> filterByCriteria(FilterCriteria filterCriteria);

    EmployeeDTO allocateEmployeeToProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO);
}
