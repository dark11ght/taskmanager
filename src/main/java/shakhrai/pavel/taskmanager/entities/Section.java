package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "section_title")
    private String sectionTitle;

    @OneToMany(mappedBy = "section")
    private Set<Specialization> specializations = new HashSet<>();

    @OneToMany(mappedBy = "section")
    private Set<TaskTemplate> taskTemplates = new HashSet<>();

    public Section() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
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
        Section section = (Section) o;
        return Objects.equals(id, section.id) &&
                Objects.equals(sectionTitle, section.sectionTitle) &&
                Objects.equals(specializations, section.specializations) &&
                Objects.equals(taskTemplates, section.taskTemplates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sectionTitle, specializations, taskTemplates);
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", specializations=" + specializations +
                ", taskTemplates=" + taskTemplates +
                '}';
    }
}
