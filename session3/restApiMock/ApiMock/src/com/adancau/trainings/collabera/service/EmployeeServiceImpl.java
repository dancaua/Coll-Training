package com.adancau.trainings.collabera.service;

import com.adancau.trainings.collabera.converter.EmployeeConverter;
import com.adancau.trainings.collabera.converter.ProjectConverter;
import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.domain.entity.EmployeeDO;
import com.adancau.trainings.collabera.exception.InvalidSalaryException;
import com.adancau.trainings.collabera.filter.FilterCriteria;
import com.adancau.trainings.collabera.exception.InvalidFilterCriteriaException;
import com.adancau.trainings.collabera.repository.EmployeeDAO;
import com.adancau.trainings.collabera.repository.EmployeeDAOImpl;
import com.adancau.trainings.collabera.util.SalaryValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDO employeeDO = employeeDAO.save(EmployeeConverter.dtoToDO(employeeDTO));
        boolean isValid = SalaryValidator.validateSalary(employeeDTO);
        if (!isValid) {
            throw new InvalidSalaryException("Invalid salary");
        }
        return EmployeeConverter.doToDTO(employeeDO);
    }

    @Override
    public EmployeeDTO updateByIdAndProject(Long id, ProjectDTO projectDTO, int newSalary) {
        Optional<EmployeeDO> employeeDO = employeeDAO.findByIdAndProject(id,
                ProjectConverter.dtoToDO(projectDTO));
        if (employeeDO.isPresent()) {
            EmployeeDO actualEmployee = employeeDO.get();
            actualEmployee.setSalary(newSalary);
            EmployeeDO updatedEmployee = employeeDAO.update(actualEmployee);
            return EmployeeConverter.doToDTO(updatedEmployee);
        }
        return null;
    }

    @Override
    public List<EmployeeDTO> filterByCriteria(FilterCriteria filterCriteria) {
        if (filterCriteria.isFilterByProject()) {
            return filterByProject(filterCriteria);
        } else if (filterCriteria.isFilterBySalary()) {
            return filterBySalaryRange(filterCriteria);
        } else {
            throw new InvalidFilterCriteriaException("Invalid filter criteria.");
        }
    }

    private List<EmployeeDTO> filterBySalaryRange(FilterCriteria filterCriteria) {
        int lowerRange = filterCriteria.getLowerRange();
        int upperRange = filterCriteria.getUpperRange();
        List<EmployeeDO> employeeDOS = employeeDAO.findBySalary(lowerRange, upperRange);
        employeeDOS.sort(Comparator.comparingInt(EmployeeDO::getSalary));
        return EmployeeConverter.doToDTO(employeeDOS);
    }

    private List<EmployeeDTO> filterByProject(FilterCriteria filterCriteria) {
        List<EmployeeDO> employeeDOS = employeeDAO
                .findByProject(ProjectConverter.dtoToDO(filterCriteria.getProjectDTO()));
        return EmployeeConverter.doToDTO(employeeDOS);
    }

    @Override
    public EmployeeDTO allocateEmployeeToProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO) {
        EmployeeDO employeeDO = employeeDAO.allocateProject(EmployeeConverter.dtoToDO(employeeDTO),
                ProjectConverter.dtoToDO(projectDTO));
        return EmployeeConverter.doToDTO(employeeDO);
    }
}
