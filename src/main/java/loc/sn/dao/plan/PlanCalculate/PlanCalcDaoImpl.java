package loc.sn.dao.plan.PlanCalculate;

import loc.sn.dao.AbstractDao;
import loc.sn.model.plan.PlanCalc;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("planHistoryCalc")

public class PlanCalcDaoImpl extends AbstractDao<Integer, PlanCalc> implements PlanCalcDao {
    public List<PlanCalc> findAllPLanCalc() {
        Criteria criteria = createEntityCriteria();
        return (List<PlanCalc>) criteria.list();
    }

    public void savePlanCalc(PlanCalc planCalc) {
        persist(planCalc);
    }
}
