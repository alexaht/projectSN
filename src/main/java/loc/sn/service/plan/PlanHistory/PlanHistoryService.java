package loc.sn.service.plan.PlanHistory;

import loc.sn.model.plan.PlanHistory;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
public interface PlanHistoryService {

    List<PlanHistory> findAllPlanHistorys();

    PlanHistory findById(int id);
}
