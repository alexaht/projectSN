package loc.sn.model.admin;

import loc.sn.model.plan.PlanHistory;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by oleksiy on 23.08.16.
 */
@Entity
@Table(name = "KAFEDRA")
public class Kafedra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Поле має бути заповненим")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_facultet")
    private Facultet facultet;

    @Email(message = "Поле пошта заповнене не вірно (приклад - admin@knutd.com.ua)")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Поле має бути заповненим")
    @Column(name = "short_kaf_name")
    private String shortKafName;

    @Column(name = "pn")
    private int pn;

    @JsonIgnore
    @OneToMany(mappedBy = "kafedra")
    private Set<Discipline> disciplines;

    @JsonIgnore
    @OneToMany(mappedBy = "kafedra",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<PlanHistory> planHistories;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShortKafName() {
        return shortKafName;
    }

    public void setShortKafName(String shortKafName) {
        this.shortKafName = shortKafName;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public Facultet getFacultet() {
        return facultet;
    }

    public void setFacultet(Facultet facultet) {
        this.facultet = facultet;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Set<PlanHistory> getPlanHistories() {
        return planHistories;
    }

    public void setPlanHistories(Set<PlanHistory> planHistories) {
        this.planHistories = planHistories;
    }

    @Override
    public String toString() {
        return "Kafedra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", facultet=" + facultet +
                ", email='" + email + '\'' +
                ", shortKafName='" + shortKafName + '\'' +
                ", pn=" + pn +
                '}';
    }

}
