package loc.sn.service.plan.PlanCalculate;

import loc.sn.dao.plan.PlanCalculate.PlanCalcHtmlDao;
import loc.sn.model.plan.PlanCalcHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("planCalcHtmlService")
@Transactional
public class PlanCalsHtmlServiceImpl implements PlanCalcHtmlService {


    @Qualifier("planCalcHtml")
    @Autowired
    private PlanCalcHtmlDao planCalcHtmlDao;

    public List<PlanCalcHtml> findAllPlanCalc() {
        return planCalcHtmlDao.findAllPLanCalc();
    }

    public void savePlanCalc(PlanCalcHtml planCalcHtml) {
        planCalcHtmlDao.savePlanCalc(planCalcHtml);
    }

    public void truncateTable() {
        planCalcHtmlDao.truncateTable();
    }
}
