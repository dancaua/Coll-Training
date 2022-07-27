package com.adancau.trainings.collabera.domain.entity;

import java.util.List;
import java.util.Objects;

public class ProjectDO {

    private Long id;
    private List<EmployeeDO> employees;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EmployeeDO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDO> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "ProjectDO{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDO projectDO = (ProjectDO) o;
        return Objects.equals(employees, projectDO.employees) && Objects.equals(name, projectDO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, name);
    }
}
