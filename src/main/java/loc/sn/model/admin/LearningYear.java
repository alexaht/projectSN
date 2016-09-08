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
@Table(name = "LEARNING_YEAR")
public class LearningYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Ім\'я не може бути пустим")
    @Column(name = "name")
    private String name;


    @NotNull
    @Min(value = 2000)
    @Max(value = 3000)
    @Column(name = "begin")
    private int beginYear;

    @NotNull
    @Min(value = 2000)
    @Max(value = 3000)
    @Column(name = "end")
    private int endYear;

    @NotNull
    @Column(name = "current")
    private int current;

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

    public int getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(int beginYear) {
        this.beginYear = beginYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "LearningYear{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beginYear=" + beginYear +
                ", endYear=" + endYear +
                ", current=" + current +
                '}';
    }
}
