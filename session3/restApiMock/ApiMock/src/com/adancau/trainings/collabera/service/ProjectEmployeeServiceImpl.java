package com.adancau.trainings.collabera.service;

import com.adancau.trainings.collabera.converter.ProjectEmployeeConverter;
import com.adancau.trainings.collabera.domain.dto.EmployeeDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.domain.dto.ProjectEmployeeMapDTO;
import com.adancau.trainings.collabera.domain.entity.ProjectEmployeeMapDO;
import com.adancau.trainings.collabera.repository.ProjectEmployeeMapDAO;
import com.adancau.trainings.collabera.repository.ProjectEmployeeMapDAOImpl;

public class ProjectEmployeeServiceImpl implements ProjectEmployeeService {

    private final ProjectEmployeeMapDAO projectEmployeeMapDAO;

    public ProjectEmployeeServiceImpl() {
        projectEmployeeMapDAO = new ProjectEmployeeMapDAOImpl();
    }

    public ProjectEmployeeMapDTO allocateEmployeeToProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO){
        ProjectEmployeeMapDO projectEmployeeMapDO = new ProjectEmployeeMapDO();
        projectEmployeeMapDO.setUserId(employeeDTO.getId());
        projectEmployeeMapDO.setProjectId(projectDTO.getId());
        projectEmployeeMapDO = projectEmployeeMapDAO.save(projectEmployeeMapDO);
        return ProjectEmployeeConverter.doToDTO(projectEmployeeMapDO);
    }
}
