package loc.sn.service.plan.PlanCalculate;

import loc.sn.dao.plan.PlanCalculate.PlanCalcDao;
import loc.sn.model.plan.PlanCalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("planCalcService")
@Transactional
public class PlanCalcServiceImpl implements PlanCalcService {

    @Qualifier("planHistoryCalc")
    @Autowired
    private PlanCalcDao planCalcDao;

    public List<PlanCalc> findAllPlanCalc() {
        return planCalcDao.findAllPLanCalc();
    }

    public void savePlanCalc(PlanCalc planCalc) {
        planCalcDao.savePlanCalc(planCalc);
    }

    public void truncateTable() {
        planCalcDao.truncateTable();
    }
}
