package loc.sn.controller.admin;

import loc.sn.model.admin.Discipline;
import loc.sn.model.admin.Facultet;
import loc.sn.model.admin.Kafedra;
import loc.sn.service.admin.Discipline.DisciplineService;
import loc.sn.service.admin.Facultet.FacultetService;
import loc.sn.service.admin.Kafedra.KafedraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @Autowired
    MessageSource messageSource;

    @Qualifier("kafedraService")
    @Autowired
    private KafedraService kafedraService;

    @Qualifier("facultetService")
    @Autowired
    private FacultetService facultetService;

    private List<Kafedra> kafedras;


    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listDisciplines(ModelMap modelMap, HttpServletRequest request) {
        String f_facultet = (String) request.getSession().getAttribute("f_facultet");
        String f_kafedra = (String) request.getSession().getAttribute("f_kafedra");
        if (f_facultet == null || f_kafedra == null) {
            return "redirect:/discipline/select";
        } else {
            List<Discipline> disciplines = disciplineService.findAllDisciplineByKafedraId(Integer.parseInt(f_kafedra));
            modelMap.addAttribute("discipline", disciplines);
        }
        modelMap.addAttribute("title", "Список дисциплін | Адміністрування");
        return "/admin/discipline/list";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String testDisciplines(ModelMap modelMap) {
        List<Facultet> facultets = facultetService.findAllFacultets();
        List<Kafedra> kafedras = new LinkedList<Kafedra>();
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("title", "Список дисциплін | Адміністрування");
        return "/admin/discipline/test";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String filterDiscipline(ModelMap modelMap) {
        List<Facultet> facultets = facultetService.findAllFacultets();
        List<Kafedra> kafedras = new LinkedList<Kafedra>();
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("title", "Фільтр факультет-кафедра дисциплін | Адміністрування");
        return "/admin/discipline/select";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String showfilterDiscipline(@RequestParam(value = "kafedra.id") String id,ModelMap modelMap, HttpServletRequest request) {
        List<Discipline> disciplines = disciplineService.findAllDisciplineByKafedraId(Integer.parseInt(id));
        request.getSession().setMaxInactiveInterval(3600 * 24);
        request.getSession().setAttribute("f_kafedra", id);
        modelMap.addAttribute("discipline", disciplines);
        modelMap.addAttribute("title", "Фільтр факультет-кафедра дисциплін | Адміністрування");
        return "/admin/discipline/list";
    }

    @RequestMapping(value = "/loadKafedra", method = RequestMethod.GET)
    public @ResponseBody
    List<Kafedra> selectAjaxKafedra(@RequestParam(value = "facultetId") String id, HttpServletRequest request) {
        request.getSession().setAttribute("f_facultet", id);
        kafedras = kafedraService.findAllKafedrasByFacultetId(Integer.parseInt(id));
        return kafedras;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addDiscipline(ModelMap modelMap, HttpServletRequest request) {
        String f_kafedra = (String) request.getSession().getAttribute("f_kafedra");
        Discipline discipline = new Discipline();
        modelMap.addAttribute("f_kafedra", f_kafedra);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("discipline", discipline);
        modelMap.addAttribute("title", "Додати нову дисципліну | Адміністрування");
        modelMap.addAttribute("edit", false);
        return "/admin/discipline/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveDiscipline(@Valid Discipline discipline, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            modelMap.addAttribute("kafedra", kafedras);
            return "/admin/discipline/new";
        }
        disciplineService.saveDiscipline(discipline);
        modelMap.addAttribute("title", "Дисципілна додана успішно | Адміністрування");
        modelMap.addAttribute("success", discipline.getName() + " додана успішно");
        return "/admin/discipline/success";
    }

    @RequestMapping(value = "/edit-{id}-discipline", method = RequestMethod.GET)
    public String editDiscipline(@PathVariable String id, ModelMap modelMap) {
        Discipline discipline = disciplineService.findById(Integer.parseInt(id));
        modelMap.addAttribute("discipline", discipline);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("title", "Редагування дисциплін | Адміністрування");
        modelMap.addAttribute("edit", true);
        return "/admin/discipline/new";
    }

    @RequestMapping(value = "/edit-{id}-discipline", method = RequestMethod.POST)
    public String updateDiscipline(@Valid Discipline discipline, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "/admin/disipline/new";
        }
        disciplineService.updateDiscipline(discipline);
        modelMap.addAttribute("success", discipline.getName() + " успішно оновлена");
        modelMap.addAttribute("title", "Дисципліна оновлена | Адміністрування");
        return "/admin/discipline/success";
    }

    @RequestMapping(value = "/delete-{id}-discipline")
    public String deleteDiscipline(@PathVariable String id) {
        disciplineService.deleteDiscipline(id);
        return "redirect:/discipline/list";
    }

}

