package loc.sn.controller.admin;

import loc.sn.model.admin.LearningYear;
import loc.sn.service.admin.LearningYear.LearningYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ly")
public class LearningYearController {

    @Autowired
    LearningYearService learningYearService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/","list"},method = RequestMethod.GET)
    public String listLearningyears(ModelMap modelMap) {
        List<LearningYear> learningYears = learningYearService.findAllLearningYears();
        System.out.println(learningYears);
        modelMap.addAttribute("learningYear", learningYears);
        modelMap.addAttribute("title", "Список навчальних років | Адміністрування");
        return "/admin/learningYear/list";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String addLearningYear(ModelMap modelMap) {
        LearningYear learningYear = new LearningYear();
        modelMap.addAttribute("learningYear", learningYear);
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("title", "Список навчальних років | Адміністрування");
        return "/admin/learningYear/new";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveLearningYear(@Valid LearningYear learningYear, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "/admin/learningYear/new";
        }
        learningYearService.saveLearningYear(learningYear);
        modelMap.addAttribute("learningYear", learningYear);
        modelMap.addAttribute("success", "Навчальний рік " + learningYear.getName() + " успішно додано");
        modelMap.addAttribute("title", "Список навчальних років | Адміністрування");
        return "/admin/learningYear/success";
    }

    @RequestMapping(value = {"/edit-{id}-ly"},method = RequestMethod.GET)
    public String editLearningYear(@PathVariable String id, ModelMap modelMap) {
        LearningYear learningYear = learningYearService.findById(Integer.parseInt(id));
        modelMap.addAttribute("learningYear", learningYear);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагування навчального року | Адміністрування");
        return "/admin/learningYear/new";
    }

    @RequestMapping(value = {"/edit-{id}-ly"},method = RequestMethod.POST)
    public String updateLearningYear(@Valid LearningYear learningYear, BindingResult result, ModelMap modelMap, @PathVariable String id) {
        if (result.hasErrors()) {
            return "/admin/learningYear/new";
        }
        learningYearService.updateLearningYear(learningYear);
        modelMap.addAttribute("learningYear", learningYear);
        modelMap.addAttribute("success", "Навчальний рік " + learningYear.getName() + " оновлений успішно");
        modelMap.addAttribute("title", "Редагування навчального року | Адміністрування");
        return "/admin/learningYear/success";
    }

    @RequestMapping(value = {"/delete-{id}-ly"}, method = RequestMethod.GET)
    public String deleteLearningYear(@PathVariable String id) {
        learningYearService.deleteLearningYear(id);
        return "redirect:/ly/list";
    }
}
