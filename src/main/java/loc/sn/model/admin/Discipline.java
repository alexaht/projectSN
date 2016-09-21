package loc.sn.model.admin;

import loc.sn.model.plan.PlanHistory;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by oleksiy on 23.08.16.
 */
@Entity
@Table(name = "DISCIPLINE")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не може бути порожнім")
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_kaf")
    private Kafedra kafedra;

    @JsonIgnore
    @OneToMany(mappedBy = "discipline",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
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

    public Kafedra getKafedra() {
        return kafedra;
    }

    public void setKafedra(Kafedra kafedra) {
        this.kafedra = kafedra;
    }

    public Set<PlanHistory> getPlanHistories() {
        return planHistories;
    }

    public void setPlanHistories(Set<PlanHistory> planHistories) {
        this.planHistories = planHistories;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kafedra=" + kafedra +
                '}';
    }
}
