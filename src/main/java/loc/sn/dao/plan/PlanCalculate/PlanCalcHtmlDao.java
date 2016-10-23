package loc.sn.dao.plan.PlanCalculate;

import loc.sn.model.plan.PlanCalcHtml;

import java.util.List;

public interface PlanCalcHtmlDao {

    List<PlanCalcHtml> findAllPLanCalc();

    void savePlanCalc(PlanCalcHtml planCalcHtml);

    void truncateTable();

}
