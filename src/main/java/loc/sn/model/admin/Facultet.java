package loc.sn.model.admin;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by oleksiy on 23.08.16.
 */
@Entity
@Table(name = "FACULTET")
public class Facultet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не може бути порожнім")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Поле не може бути порожнім")
    @Column(name = "short_fac_name", nullable = false)
    private String shortFacName;

    @JsonIgnore
    @OneToMany(mappedBy = "facultet")
    private Set<Kafedra> kafedra;

    @JsonIgnore
    @OneToMany(mappedBy = "facultet")
    private Set<GroupTbl> groupTbls;

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

    public String getShortFacName() {
        return shortFacName;
    }

    public void setShortFacName(String shortFacName) {
        this.shortFacName = shortFacName;
    }

    public Set<Kafedra> getKafedra() {
        return kafedra;
    }

    public void setKafedra(Set<Kafedra> kafedra) {
        this.kafedra = kafedra;
    }

    public Set<GroupTbl> getGroupTbls() {
        return groupTbls;
    }

    public void setGroupTbls(Set<GroupTbl> groupTbls) {
        this.groupTbls = groupTbls;
    }

    @Override
    public String toString() {
        return "Facultet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortFacName='" + shortFacName + '\'' +
                '}';
    }
}
