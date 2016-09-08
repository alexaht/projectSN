package loc.sn.model.admin;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by oleksiy on 23.08.16.
 */
@Entity
@Table(name = "GROUPTBL")
public class GroupTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле має бути заповненим")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_facultet")
    private Facultet facultet;

    @NotNull
    @Min(value = 1, message = "Мінімальне значення поля 1")
    @Column(name = "st_amount")
    private int stAmount;

    @NotNull
    @Min(value = 1, message = "Мінімальне значення поля 1")
    @Max(value = 6, message = "Максимальне значення поля 6")
    @Column(name = "kurs")
    private int kurs;

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

    public int getStAmount() {
        return stAmount;
    }

    public void setStAmount(int stAmount) {
        this.stAmount = stAmount;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public Facultet getFacultet() {
        return facultet;
    }

    public void setFacultet(Facultet facultet) {
        this.facultet = facultet;
    }
}
