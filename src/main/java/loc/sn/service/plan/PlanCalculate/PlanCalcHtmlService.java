package loc.sn.service.plan.PlanCalculate;

import loc.sn.model.plan.PlanCalcHtml;

import java.util.List;

public interface PlanCalcHtmlService {

    List<PlanCalcHtml> findAllPlanCalc();

    void savePlanCalc(PlanCalcHtml planCalcHtml);

    void truncateTable();
}
