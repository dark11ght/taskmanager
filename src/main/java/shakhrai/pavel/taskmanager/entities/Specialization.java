package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "specialization")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "specialization_title", unique = true, nullable = false, length = 255)
    private String specializationTitle;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToMany(mappedBy = "specialization")
    private Set<User> users = new HashSet<>();

    public Specialization() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecializationTitle() {
        return specializationTitle;
    }

    public void setSpecializationTitle(String specializationTitle) {
        this.specializationTitle = specializationTitle;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(specializationTitle, that.specializationTitle) &&
                Objects.equals(section, that.section) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specializationTitle, section, users);
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", specializationTitle='" + specializationTitle + '\'' +
                ", section=" + section +
                ", users=" + users +
                '}';
    }
}
