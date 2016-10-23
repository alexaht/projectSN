package loc.sn.dao.plan.PlanCalculate;

import loc.sn.dao.AbstractDao;
import loc.sn.model.plan.PlanCalcHtml;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("planCalcHtml")
public class PlanCalcHtmlDaoImpl extends AbstractDao<Integer, PlanCalcHtml> implements PlanCalcHtmlDao {

    public List<PlanCalcHtml> findAllPLanCalc() {
        Criteria criteria = createEntityCriteria();
        return (List<PlanCalcHtml>) criteria.list();
    }

    public void savePlanCalc(PlanCalcHtml planCalcHtml) {
        persist(planCalcHtml);
    }

    public void truncateTable() {
        Query query = getSession().createQuery("DELETE from PlanCalcHtml");
        query.executeUpdate();
    }
}
