package com.adancau.trainings.collabera.repository;

import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.domain.entity.EmployeeDO;
import com.adancau.trainings.collabera.domain.entity.ProjectDO;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    EmployeeDO save(EmployeeDO employeeDO);

    EmployeeDO update(EmployeeDO employeeDO);
    Optional<EmployeeDO> findByIdAndProject(Long id, ProjectDO projectDO);

    List<EmployeeDO> findByProject(ProjectDO projectDO);

    List<EmployeeDO> findBySalary(int lowerRange, int upperRange);

    EmployeeDO allocateProject(EmployeeDO employeeDTO, ProjectDO projectDO);

}
