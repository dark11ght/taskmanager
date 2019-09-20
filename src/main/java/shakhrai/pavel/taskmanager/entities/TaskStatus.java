package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "task_status")
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "task_status")
    private String taskStatus;

    @OneToMany(mappedBy = "taskStatus")
    private Set<TaskTemplate> taskTemplates = new HashSet<>();

    public TaskStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Set<TaskTemplate> getTaskTemplates() {
        return taskTemplates;
    }

    public void setTaskTemplates(Set<TaskTemplate> taskTemplates) {
        this.taskTemplates = taskTemplates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskStatus that = (TaskStatus) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(taskStatus, that.taskStatus) &&
                Objects.equals(taskTemplates, that.taskTemplates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskStatus, taskTemplates);
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "id=" + id +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskTemplates=" + taskTemplates +
                '}';
    }
}
