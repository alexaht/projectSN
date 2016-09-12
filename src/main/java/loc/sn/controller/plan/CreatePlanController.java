package loc.sn.controller.plan;

import loc.sn.model.admin.Discipline;
import loc.sn.model.admin.GroupTbl;
import loc.sn.model.admin.Kafedra;
import loc.sn.model.admin.LearningYear;
import loc.sn.model.plan.PlanHistory;
import loc.sn.service.admin.Discipline.DisciplineService;
import loc.sn.service.admin.Group.GroupTblService;
import loc.sn.service.admin.Kafedra.KafedraService;
import loc.sn.service.admin.LearningYear.LearningYearService;
import loc.sn.service.plan.PlanHistory.PlanHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/createPlan")
public class CreatePlanController {

    @Autowired
    private MessageSource source;

    @Qualifier("learningYearService")
    @Autowired
    private LearningYearService learningYearService;

    @Qualifier("groupTblService")
    @Autowired
    private GroupTblService groupTblService;

    @Qualifier("kafedraService")
    @Autowired
    private KafedraService kafedraService;

    @Qualifier("disciplineService")
    @Autowired
    private DisciplineService disciplineService;

    @Qualifier("planHistoryService")
    @Autowired
    private PlanHistoryService planHistoryService;


    @RequestMapping(value = {"/select"}, method = RequestMethod.GET)
    public String showFilter(ModelMap modelMap, HttpServletRequest request) {
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();

        List<PlanHistory> planHistories = null;
        if (null != request.getSession().getAttribute("s_ly")) {
            planHistories = planHistoryService.findAllByYearAndGroup(Integer.parseInt((String)request.getSession().getAttribute("s_ly")), Integer.parseInt((String)request.getSession().getAttribute("s_gr")));
        }
        modelMap.addAttribute("planHistory", planHistories);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("title", "Ввести дані плану | План");
        return "/plan/createplan/select";
    }

    @RequestMapping(value = {"/select"}, method = RequestMethod.POST)
    public String showFilteredResult(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "learningYear") String learningYear, @RequestParam(value = "groupTbl") String groupTbl) {
        request.getSession().setAttribute("s_ly", learningYear);
        request.getSession().setAttribute("s_gr", groupTbl);
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();

        List<PlanHistory> planHistories = null;
        if (null != request.getSession().getAttribute("s_ly")) {
            planHistories = planHistoryService.findAllByYearAndGroup(Integer.parseInt((String)request.getSession().getAttribute("s_ly")), Integer.parseInt((String)request.getSession().getAttribute("s_gr")));
        }
        modelMap.addAttribute("planHistory", planHistories);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("title", "Ввести дані плану | План");
        return "/plan/createplan/select";
    }

    @RequestMapping(value = "/loadDiscipline", method = RequestMethod.GET)
    public @ResponseBody
    List<Discipline> selectAjaxDiscipline(@RequestParam(value = "kafedraId") String id) {
        if (Integer.parseInt(id) == -1) {
            return null;
        }
        List<Discipline> disciplines = disciplineService.findAllDisciplineByKafedraId(Integer.parseInt(id));
        return disciplines;
    }

    @RequestMapping(value = {"/new/{learningYear}/{groupTbl}"}, method = RequestMethod.GET)
    public String addNewPlanValue(@PathVariable("learningYear") String learningYear, @PathVariable("groupTbl") String groupTbl, ModelMap modelMap, HttpServletRequest request) {
        if ((request.getSession().getAttribute("s_ly") == null) || (request.getSession().getAttribute("s_gr") == null)) {
            return "redirect:/createPlan/select";
        }
        List<Kafedra> kafedras = kafedraService.findAllKafedras();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        PlanHistory planHistory = new PlanHistory();
        modelMap.addAttribute("planHistory", planHistory);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("title", "Додати новий план | План");
        modelMap.addAttribute("edit", false);
        return "/plan/createplan/add";
    }

    @RequestMapping(value = {"/new/{learningYear}/{groupTbl}"}, method = RequestMethod.POST)
    public String saveNewPlanValue(@Valid PlanHistory planHistory, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            modelMap.addAttribute("title", "Помилка | План");

            // Output to console errors @Valid PlanHistory
            /*List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }*/
            return "/plan/createplan/add";
        }
        planHistoryService.savePlanHistory(planHistory);
        modelMap.addAttribute("success", planHistory.getDiscipline().getName() + "на" + planHistory.getKafedra().getName() + "успішно оновлена");
        modelMap.addAttribute("title", "План доданий успішно | План");
        modelMap.addAttribute("title", "Додати новий план | План");
        return "/plan/createplan/success";
    }

    @RequestMapping(value = {"/edit-{id}-planHistory"}, method = RequestMethod.GET)
    public String editPlanValue(@PathVariable String id, ModelMap modelMap) {
        PlanHistory planHistory = planHistoryService.findById(Integer.parseInt(id));
        List<Kafedra> kafedras = kafedraService.findAllKafedras();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        List<Discipline> disciplines = disciplineService.findAllDisciplineByKafedraId(planHistory.getKafedra().getId());
        // TODO: 10.09.16 add kafedra and discipline selected value when edit true
        modelMap.addAttribute("planHistory", planHistory);
        modelMap.addAttribute("discipline", disciplines);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагувати план | План");
        return "/plan/createplan/add";
    }

    @RequestMapping(value = {"/edit-{id}-planHistory"}, method = RequestMethod.POST)
    public String updatePlanValue(@Valid PlanHistory planHistory, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "/plan/createplan/add";
        }
        planHistoryService.updatePlanHistory(planHistory);
        modelMap.addAttribute("success", planHistory.getDiscipline().getName() + "на" + planHistory.getKafedra().getName() + "успішно оновлена");
        modelMap.addAttribute("title", "План оновлений | Адміністрування");
        return "/plan/createplan/success";
    }

    @RequestMapping(value = {"/delete-{id}-planHistory"}, method = RequestMethod.GET)
    public String deletePlanValue(@PathVariable String id) {
        planHistoryService.deletePlanHistory(id);
        return "redirect:/createPlan/select";
    }




}
