package loc.sn.dao.plan.PlanCalculate;

import loc.sn.model.plan.PlanCalc;

import java.util.List;


public interface PlanCalcDao {

    List<PlanCalc> findAllPLanCalc();

    void savePlanCalc(PlanCalc planCalc);

}
