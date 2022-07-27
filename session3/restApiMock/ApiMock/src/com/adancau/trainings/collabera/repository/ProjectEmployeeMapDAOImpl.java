package com.adancau.trainings.collabera.repository;

import com.adancau.trainings.collabera.domain.entity.ProjectEmployeeMapDO;

import java.util.ArrayList;
import java.util.List;

public class ProjectEmployeeMapDAOImpl implements ProjectEmployeeMapDAO {
    private List<ProjectEmployeeMapDO> projectEmployeeMapDOS;

    public ProjectEmployeeMapDAOImpl() {
        projectEmployeeMapDOS = new ArrayList<>();
    }

    @Override
    public ProjectEmployeeMapDO save(ProjectEmployeeMapDO projectEmployeeMapDO) {
        projectEmployeeMapDOS.add(projectEmployeeMapDO);
        projectEmployeeMapDO.setMapId((long) projectEmployeeMapDOS.size() - 1);
        return projectEmployeeMapDO;
    }
}
