package shakhrai.pavel.taskmanager.entities;


import javax.persistence.*;


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

    public Company() {
    }


}
