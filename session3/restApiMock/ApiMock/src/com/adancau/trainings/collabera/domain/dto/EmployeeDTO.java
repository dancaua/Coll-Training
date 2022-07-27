package com.adancau.trainings.collabera.domain.dto;

import java.util.List;

public class EmployeeDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<ProjectDTO> getProject() {
        return project;
    }

    public void setProject(List<ProjectDTO> project) {
        this.project = project;
    }

    private int salary;
    private List<ProjectDTO> project;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", salary=" + salary +
                ", project=" + project +
                '}';
    }
}
