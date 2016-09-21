package loc.sn.service.plan.PlanCalculate;

import loc.sn.model.plan.PlanCalc;

import java.util.List;

public interface PlanCalcService {

    List<PlanCalc> findAllPlanCalc();

    void savePlanCalc(PlanCalc planCalc);
}
