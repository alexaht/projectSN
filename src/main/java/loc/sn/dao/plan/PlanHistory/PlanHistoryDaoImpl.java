package loc.sn.dao.plan.PlanHistory;

import loc.sn.dao.AbstractDao;
import loc.sn.model.plan.PlanHistory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("playHistoryDao")
public class PlanHistoryDaoImpl extends AbstractDao<Integer, PlanHistory> implements PlanHistoryDao {

    public List<PlanHistory> findAllPlanHistorys() {
        Criteria criteria = createEntityCriteria();
        return (List<PlanHistory>) criteria.list();
    }

    public PlanHistory findById(int id) {
        return getByKey(id);
    }

    public void savePlanHistory(PlanHistory planHistory) {
        persist(planHistory);
    }

    public void updatePlanHistory(PlanHistory planHistory) {
        merge(planHistory);
    }

    public void deletePlanHistory(String id) {
        Query query = getSession().createQuery("delete from PlanHistory where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    public List<PlanHistory> findAllByYearAndGroup(int learningYear, int groupTbl) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("learningYear.id", learningYear));
        criteria.add(Restrictions.eq("groupTbl.id", groupTbl));
        return (List<PlanHistory>) criteria.list();
    }
}
