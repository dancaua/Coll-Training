package com.adancau.trainings.collabera.repository;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.domain.entity.EmployeeDO;
import com.adancau.trainings.collabera.domain.entity.ProjectDO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final List<EmployeeDO> employees;

    public EmployeeDAOImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public EmployeeDO save(EmployeeDO employeeDO) {
        employees.add(employeeDO);
        employeeDO.setId((long) (employees.size() - 1));
        return employeeDO;
    }

    @Override
    public EmployeeDO update(EmployeeDO employeeDO) {
        if (employees.size() > employeeDO.getId()) {
            EmployeeDO employeeDO1 = employees.get(employeeDO.getId().intValue());
            employeeDO1.setSalary(employeeDO.getSalary());
            return employeeDO1;
        }
        return null;
    }

    @Override
    public Optional<EmployeeDO> findByIdAndProject(Long id, ProjectDO projectDO) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public List<EmployeeDO> findByProject(ProjectDO projectDO) {
        return employees.stream().filter(e -> e.getProject().contains(projectDO)).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDO> findBySalary(int lowerRange, int upperRange) {
        return employees.stream().filter(e -> e.getSalary() >= lowerRange
                && e.getSalary() <= upperRange).collect(Collectors.toList());
    }

    @Override
    public EmployeeDO allocateProject(EmployeeDO employeeDTO, ProjectDO projectDO) {
        if (employeeDTO.getId() <= employees.size()) {
            EmployeeDO found = employees.get(employeeDTO.getId().intValue());
            List<ProjectDO> projectDOS = found.getProject();
            projectDOS.add(projectDO);
            found.setProject(projectDOS);
            return found;
        } else {
            throw new NoSuchElementException("Employee not found.");
        }
    }
}
