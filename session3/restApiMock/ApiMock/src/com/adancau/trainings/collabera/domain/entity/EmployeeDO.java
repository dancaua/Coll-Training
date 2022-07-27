package com.adancau.trainings.collabera.domain.entity;


import java.util.List;

public class EmployeeDO {
    private Long id;
    private int salary;

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

    public List<ProjectDO> getProject() {
        return project;
    }

    public void setProject(List<ProjectDO> project) {
        this.project = project;
    }

    private List<ProjectDO> project;

    @Override
    public String toString() {
        return "EmployeeDO{" +
                "id=" + id +
                ", salary=" + salary +
                ", project=" + project +
                '}';
    }
}
