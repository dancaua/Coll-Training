package com.adancau.trainings.collabera.filter;

import com.adancau.trainings.collabera.domain.dto.ProjectDTO;

public class FilterCriteria {
    private boolean filterBySalary;
    private boolean filterByProject;
    private int lowerRange;
    private int upperRange;
    private ProjectDTO projectDTO;

    public boolean isFilterBySalary() {
        return filterBySalary;
    }

    public void setFilterBySalary(boolean filterBySalary) {
        this.filterBySalary = filterBySalary;
    }

    public boolean isFilterByProject() {
        return filterByProject;
    }

    public void setFilterByProject(boolean filterByProject) {
        this.filterByProject = filterByProject;
    }

    public int getLowerRange() {
        return lowerRange;
    }

    public void setLowerRange(int lowerRange) {
        this.lowerRange = lowerRange;
    }

    public int getUpperRange() {
        return upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }
}
