package com.adancau.trainings.collabera.converter;

import com.adancau.trainings.collabera.domain.dto.ProjectEmployeeMapDTO;
import com.adancau.trainings.collabera.domain.entity.ProjectEmployeeMapDO;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectEmployeeConverter {

    public static ProjectEmployeeMapDO dtoToDO(ProjectEmployeeMapDTO ProjectEmployeeMapDTO) {
        ProjectEmployeeMapDO ProjectEmployeeMapDO = new ProjectEmployeeMapDO();
        ProjectEmployeeMapDO.setUserId(ProjectEmployeeMapDTO.getUserId());
        ProjectEmployeeMapDO.setProjectId(ProjectEmployeeMapDTO.getProjectId());
        return ProjectEmployeeMapDO;
    }

    public static ProjectEmployeeMapDTO doToDTO(ProjectEmployeeMapDO projectEmployeeMapDO) {
        ProjectEmployeeMapDTO projectEmployeeMapDTO = new ProjectEmployeeMapDTO();
        projectEmployeeMapDTO.setUserId(projectEmployeeMapDO.getUserId());
        projectEmployeeMapDTO.setProjectId(projectEmployeeMapDO.getProjectId());
        return projectEmployeeMapDTO;
    }

    public static List<ProjectEmployeeMapDO> dtoToDO(List<ProjectEmployeeMapDTO> projectEmployeeMapDTOS) {
        return projectEmployeeMapDTOS.stream().map(ProjectEmployeeConverter::dtoToDO).collect(Collectors.toList());
    }

    public static List<ProjectEmployeeMapDTO> doToDTO(List<ProjectEmployeeMapDO> projectEmployeeMapDOS) {
        return projectEmployeeMapDOS.stream().map(ProjectEmployeeConverter::doToDTO).collect(Collectors.toList());
    }
}
