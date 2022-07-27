package com.adancau.trainings.collabera.converter;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.entity.EmployeeDO;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeConverter {

    private final ProjectConverter projectConverter = new ProjectConverter();

    public static EmployeeDO dtoToDO(EmployeeDTO employeeDTO) {
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employeeDTO.getId());
        employeeDO.setSalary(employeeDTO.getSalary());
        employeeDO.setProject(ProjectConverter.dtoToDO(employeeDTO.getProject()));
        return employeeDO;
    }

    public static EmployeeDTO doToDTO(EmployeeDO employeeDO) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeeDO.getId());
        employeeDTO.setSalary(employeeDO.getSalary());
        employeeDTO.setProject(ProjectConverter.doToDTO(employeeDO.getProject()));
        return employeeDTO;
    }

    public static List<EmployeeDO> dtoToDO(List<EmployeeDTO> employeeDTOS) {
        return employeeDTOS.stream().map(EmployeeConverter::dtoToDO).collect(Collectors.toList());
    }

    public static List<EmployeeDTO> doToDTO(List<EmployeeDO> employeeDOS) {
        return employeeDOS.stream().map(EmployeeConverter::doToDTO).collect(Collectors.toList());
    }
}
