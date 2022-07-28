package p1;

import java.io.Serializable;
import java.util.Objects;

public class Project
{

    private String projectName;

    public Project() {
        super();
        // TODO Auto-generated constructor stub
    }



    public Project(String projectName) {
        super();
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "p1.Project [projectName=" + projectName + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }
}