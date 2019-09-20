package shakhrai.pavel.taskmanager.entities;

import org.springframework.web.method.support.HandlerMethodReturnValueHandler;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;
    @Column(name = "second_name", nullable = false, length = 255)
    private String secondName;
    @Column(name = "last_name", length = 255)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "sex_id", insertable = false)
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "specialization_id", insertable = false)
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "notes", length = 255)
    private String notes;

    @OneToMany(mappedBy = "user")
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<TaskTemplate> taskTemplates = new HashSet<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(role, user.role) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(company, user.company) &&
                Objects.equals(specialization, user.specialization) &&
                Objects.equals(position, user.position) &&
                Objects.equals(notes, user.notes) &&
                Objects.equals(projects, user.projects) &&
                Objects.equals(tasks, user.tasks) &&
                Objects.equals(taskTemplates, user.taskTemplates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, secondName, lastName, role, sex, company, specialization, position, notes, projects, tasks, taskTemplates);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", sex=" + sex +
                ", company=" + company +
                ", specialization=" + specialization +
                ", position=" + position +
                ", notes='" + notes + '\'' +
                ", projects=" + projects +
                ", tasks=" + tasks +
                ", taskTemplates=" + taskTemplates +
                '}';
    }
}
