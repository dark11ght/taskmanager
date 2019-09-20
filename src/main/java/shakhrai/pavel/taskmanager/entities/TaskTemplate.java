package shakhrai.pavel.taskmanager.entities;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "task_template")
public class TaskTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "task_title", nullable = false, length = 255)
    private String taskTitle;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "section_id", insertable = false)
    private Section section;

    @ManyToOne
    @JoinColumn(name = "creator_id", insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_status_id", insertable = false)
    private TaskStatus taskStatus;

    @Column(name = "task_info", length = 500)
    private String taskInfo;
    @Column(name = "task_notes", length = 500)
    private String taskNotes;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
    @Column(name = "changed_date")
    private LocalDate changedDate;
    @Column(name = "close_date")
    private Timestamp closeDate;

    @OneToMany(mappedBy = "taskTemplate")
    private Set<Task> tasks = new HashSet<>();

    public TaskTemplate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(String taskNotes) {
        this.taskNotes = taskNotes;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(LocalDate changedDate) {
        this.changedDate = changedDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskTemplate that = (TaskTemplate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(taskTitle, that.taskTitle) &&
                Objects.equals(project, that.project) &&
                Objects.equals(section, that.section) &&
                Objects.equals(user, that.user) &&
                Objects.equals(taskStatus, that.taskStatus) &&
                Objects.equals(taskInfo, that.taskInfo) &&
                Objects.equals(taskNotes, that.taskNotes) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(finishDate, that.finishDate) &&
                Objects.equals(changedDate, that.changedDate) &&
                Objects.equals(closeDate, that.closeDate) &&
                Objects.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskTitle, project, section, user, taskStatus, taskInfo, taskNotes, createDate, startDate, finishDate, changedDate, closeDate, tasks);
    }

    @Override
    public String toString() {
        return "TaskTemplate{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", project=" + project +
                ", section=" + section +
                ", user=" + user +
                ", taskStatus=" + taskStatus +
                ", taskInfo='" + taskInfo + '\'' +
                ", taskNotes='" + taskNotes + '\'' +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", changedDate=" + changedDate +
                ", closeDate=" + closeDate +
                ", tasks=" + tasks +
                '}';
    }
}
