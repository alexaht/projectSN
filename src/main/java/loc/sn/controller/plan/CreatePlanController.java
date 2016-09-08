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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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


    @RequestMapping(value = {"/select"}, method = RequestMethod.GET)
    public String showFilter(ModelMap modelMap) {
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("title", "Ввести дані плану | План");
        return "/plan/createplan/select";
    }

    @RequestMapping(value = {"/select"}, method = RequestMethod.POST)
    public String showFilteredResult(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "learningYear") String learningYear, @RequestParam(value = "groupTbl") String groupTbl) {
        request.getSession().setAttribute("learningYear", learningYear);
        request.getSession().setAttribute("groupTbl", groupTbl);
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("title", "Ввести дані плану | План");
        return "/plan/createplan/select";
    }

    @RequestMapping(value = {"/new/{learningYear}/{groupTbl}"}, method = RequestMethod.GET)
    public String addNewPlanValue(@PathVariable("learningYear") String learningYear, @PathVariable("groupTbl") String groupTbl, ModelMap modelMap) {
        List<Kafedra> kafedras = kafedraService.findAllKafedras();
        PlanHistory planHistory = new PlanHistory();
        modelMap.addAttribute("planHistory", planHistory);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("filter_learningYear", learningYear);
        modelMap.addAttribute("filter_groupTbl", groupTbl);
        modelMap.addAttribute("title", "Додати новий план | План");
        return "/plan/createplan/add";
    }

    @RequestMapping(value = "/loadDiscipline", method = RequestMethod.GET)
    public @ResponseBody
    List<Discipline> selectAjaxDiscipline(@RequestParam(value = "kafedraId") String id, HttpServletRequest request) {
        if (Integer.parseInt(id) == -1) {
            return null;
        }
//        request.getSession().setAttribute("f_kafedra", id);
        List<Discipline> disciplines = disciplineService.findAllDisciplineByKafedraId(Integer.parseInt(id));
        return disciplines;
    }

}
