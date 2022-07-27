package com.adancau.trainings.collabera.converter;

import com.adancau.trainings.collabera.domain.dto.ProjectDTO;
import com.adancau.trainings.collabera.domain.entity.ProjectDO;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectConverter {

    public static ProjectDO dtoToDO(ProjectDTO projectDTO) {
        ProjectDO projectDO = new ProjectDO();
        projectDO.setName(projectDTO.getName());
        projectDO.setEmployees(EmployeeConverter.dtoToDO(projectDTO.getEmployees()));
        return projectDO;
    }

    public static ProjectDTO doToDTO(ProjectDO projectDO) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(projectDO.getId());
        projectDTO.setName(projectDO.getName());
        projectDTO.setEmployees(EmployeeConverter.doToDTO(projectDO.getEmployees()));
        return projectDTO;
    }

    public static List<ProjectDTO> doToDTO(List<ProjectDO> projectDOS) {
        return projectDOS.stream().map(ProjectConverter::doToDTO).collect(Collectors.toList());
    }

    public static List<ProjectDO> dtoToDO(List<ProjectDTO> projectDTOS) {
        return projectDTOS.stream().map(ProjectConverter::dtoToDO).collect(Collectors.toList());
    }
}
