package loc.sn.service.plan.PlanHistory;

import loc.sn.dao.plan.PlanHistory.PlanHistoryDao;
import loc.sn.model.plan.PlanHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by oleksiy on 23.08.16.
 */
@Service("planHistoryService")
@Transactional
public class PlanHistoryServiceImpl implements PlanHistoryService {

    @Autowired
    PlanHistoryDao planHistoryDao;

    public List<PlanHistory> findAllPlanHistorys() {
        return planHistoryDao.findAllPlanHistorys();
    }

    public PlanHistory findById(int id) {
        return planHistoryDao.findById(id);
    }

    public void savePlanHistory(PlanHistory planHistory) {
        planHistoryDao.savePlanHistory(planHistory);
    }

    public void updatePlanHistory(PlanHistory planHistory) {
        planHistoryDao.updatePlanHistory(planHistory);
    }

    public void deletePlanHistory(String id) {
        planHistoryDao.deletePlanHistory(id);
    }

}
