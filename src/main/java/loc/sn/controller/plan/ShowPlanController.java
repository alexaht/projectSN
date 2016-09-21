package loc.sn.controller.plan;

import loc.sn.model.admin.Facultet;
import loc.sn.model.admin.Kafedra;
import loc.sn.model.admin.LearningYear;
import loc.sn.model.plan.PlanHistory;
import loc.sn.service.admin.Facultet.FacultetService;
import loc.sn.service.admin.Kafedra.KafedraService;
import loc.sn.service.admin.LearningYear.LearningYearService;
import loc.sn.service.plan.PlanCalculate.PlanCalcService;
import loc.sn.service.plan.PlanHistory.PlanHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/showPlan")
public class ShowPlanController {

    @Qualifier("learningYearService")
    @Autowired
    private LearningYearService learningYearService;

    @Qualifier("facultetService")
    @Autowired
    private FacultetService facultetService;

    @Qualifier("kafedraService")
    @Autowired
    private KafedraService kafedraService;

    @Qualifier("planHistoryService")
    @Autowired
    private PlanHistoryService planHistoryService;

    @Qualifier("planCalcService")
    @Autowired
    private PlanCalcService planCalcService;

    List<LearningYear> learningYears;
    List<Facultet> facultets;
    List<Kafedra> kafedras;

    @RequestMapping(value = {"/select"}, method = RequestMethod.GET)
    public String showFilter(ModelMap modelMap, HttpServletRequest request) {

        learningYears = learningYearService.findAllLearningYears();
        facultets = facultetService.findAllFacultets();

        if ((null != request.getSession().getAttribute("s_ly")) && (null != request.getSession().getAttribute("s_facultet")) && (null != request.getSession().getAttribute("s_kafedra"))) {
            List<Kafedra> kafedras = kafedraService.findAllKafedrasByFacultetId(Integer.parseInt(request.getSession().getAttribute("s_facultet").toString()));
            modelMap.addAttribute("kafedra", kafedras);
        }

        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("title", "Показати план | План");

        return "/plan/showplan/select";
    }

    @RequestMapping(value = {"/select"}, method = RequestMethod.POST)
    public String showResult(ModelMap modelMap, HttpServletRequest request) {
        request.getSession().setAttribute("s_ly", request.getParameter("learningYear"));
        request.getSession().setAttribute("s_facultet", request.getParameter("facultet"));
        request.getSession().setAttribute("s_kafedra", request.getParameter("kafedra"));

        List<PlanHistory> planHistories = planHistoryService.findAllByYearAndFacultetAndKafedra(Integer.parseInt(request.getParameter("learningYear")), Integer.parseInt(request.getParameter("kafedra")));
        System.out.println(planHistories);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("title", "Показати план | План");

        return "/plan/showplan/select";
    }

    @RequestMapping(value = "/loadKafedra", method = RequestMethod.GET)
    public @ResponseBody
    List<Kafedra> selectAjaxDiscipline(@RequestParam(value = "facultetId") String id) {
        if (Integer.parseInt(id) == -1) {
            return null;
        }
        kafedras = kafedraService.findAllKafedrasByFacultetId(Integer.parseInt(id));
        System.out.println(kafedras);
        return kafedras;
    }
}
