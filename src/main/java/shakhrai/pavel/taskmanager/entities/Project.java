package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "project_code")
    private String projectCode;
    @Column(name = "project_title")
    private String projectTitle;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "creater_id", insertable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_project_id", insertable = false)
    private ProjectStatus projectStatus;

    @Column(name = "project_info", length = 255)
    private String projectInfo;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
    @Column(name = "changed_date")
    private Timestamp changedDate;
    @Column(name = "close_date")
    private Timestamp closeDate;

    @OneToMany(mappedBy = "project")
    private Set<TaskTemplate> taskTemplates = new HashSet<>();

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
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

    public Timestamp getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Timestamp changedDate) {
        this.changedDate = changedDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
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
        Project project = (Project) o;
        return Objects.equals(id, project.id) &&
                Objects.equals(projectCode, project.projectCode) &&
                Objects.equals(projectTitle, project.projectTitle) &&
                Objects.equals(company, project.company) &&
                Objects.equals(user, project.user) &&
                Objects.equals(projectStatus, project.projectStatus) &&
                Objects.equals(projectInfo, project.projectInfo) &&
                Objects.equals(createDate, project.createDate) &&
                Objects.equals(startDate, project.startDate) &&
                Objects.equals(finishDate, project.finishDate) &&
                Objects.equals(changedDate, project.changedDate) &&
                Objects.equals(closeDate, project.closeDate) &&
                Objects.equals(taskTemplates, project.taskTemplates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectCode, projectTitle, company, user, projectStatus, projectInfo, createDate, startDate, finishDate, changedDate, closeDate, taskTemplates);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectCode='" + projectCode + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", company=" + company +
                ", user=" + user +
                ", projectStatus=" + projectStatus +
                ", projectInfo='" + projectInfo + '\'' +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", changedDate=" + changedDate +
                ", closeDate=" + closeDate +
                ", taskTemplates=" + taskTemplates +
                '}';
    }
}

