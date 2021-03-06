package shakhrai.pavel.taskmanager.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sex")
public class Sex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "sex", unique = true)
    public String sex;
    @OneToMany(mappedBy = "sex")
    private Set<User> users = new HashSet<>();

    public Sex() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        Sex sex1 = (Sex) o;
        return id == sex1.id &&
                Objects.equals(sex, sex1.sex) &&
                Objects.equals(users, sex1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sex, users);
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", users=" + users +
                '}';
    }
}
