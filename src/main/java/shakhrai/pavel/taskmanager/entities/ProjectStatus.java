package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "project_status")
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id")
    private Long id;
    @Column(name = "project_status", unique = true, nullable = false)
    private String projectStatus;

    @OneToMany(mappedBy = "projectStatus")
    private Set<Project> projects = new HashSet<>();

    public ProjectStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectStatus that = (ProjectStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(projectStatus, that.projectStatus) &&
                Objects.equals(projects, that.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectStatus, projects);
    }

    @Override
    public String toString() {
        return "ProjectStatus{" +
                "id=" + id +
                ", projectStatus='" + projectStatus + '\'' +
                ", projects=" + projects +
                '}';
    }
}
