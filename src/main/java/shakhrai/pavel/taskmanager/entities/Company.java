package shakhrai.pavel.taskmanager.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "companys")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "company_title", nullable = false, unique = true, length = 255)
    private String companyTitle;
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @Column(name = "company_info", length = 255)
    private String companyInfo;

    @OneToMany(mappedBy = "company")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "company")
    private Set<Project> projects = new HashSet<>();

    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(companyTitle, company.companyTitle) &&
                Objects.equals(address, company.address) &&
                Objects.equals(companyInfo, company.companyInfo) &&
                Objects.equals(users, company.users) &&
                Objects.equals(projects, company.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyTitle, address, companyInfo, users, projects);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyTitle='" + companyTitle + '\'' +
                ", address='" + address + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", users=" + users +
                ", projects=" + projects +
                '}';
    }
}
