package shakhrai.pavel.taskmanager.entities;

import javax.persistence.*;
import java.util.HashSet;
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


}
