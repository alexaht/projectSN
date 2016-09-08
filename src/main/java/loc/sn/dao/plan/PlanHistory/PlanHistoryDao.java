package loc.sn.dao.plan.PlanHistory;

import loc.sn.model.plan.PlanHistory;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface PlanHistoryDao {

    List<PlanHistory> findAllPlanHistorys();

    PlanHistory findById(int id);

    void savePlanHistory(PlanHistory planHistory);

    void updatePlanHistory(PlanHistory planHistory);

    void deletePlanHistory(String id);


}
