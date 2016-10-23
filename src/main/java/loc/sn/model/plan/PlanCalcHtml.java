package loc.sn.model.plan;

import javax.persistence.*;

@Entity
@Table(name = "PLAN_CALC_HTML")
public class PlanCalcHtml {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "html", columnDefinition = "TEXT")
    private String html;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
