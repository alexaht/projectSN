package loc.sn.controller.admin;

import loc.sn.model.admin.Facultet;
import loc.sn.model.admin.Kafedra;
import loc.sn.service.admin.Facultet.FacultetService;
import loc.sn.service.admin.Kafedra.KafedraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/kafedra")
public class KafedraController {

    @Autowired
    private MessageSource messageSource;

    @Qualifier("kafedraService")
    @Autowired
    private KafedraService kafedraService;
    @Qualifier("facultetService")
    @Autowired
    private FacultetService facultetService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectKafedra(ModelMap modelMap) {
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("title", "Редагування кафедр | Адміністрування");
        return "/admin/kafedra/select";
    }

    @RequestMapping(value = "/select", method = RequestMethod.POST)
    public String showFacultetKafedra(@RequestParam(value = "facultet.id") String s, ModelMap modelMap, HttpServletRequest request) {
        List<Kafedra> kafedras = kafedraService.findAllKafedrasByFacultetId(Integer.parseInt(s));
        request.getSession().setAttribute("f_kaf_facultet", s);
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("title", "Редагування кафедр | Адміністрування");
        System.out.println(kafedras);
        return "/admin/kafedra/list";
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listKafedra(ModelMap modelMap, HttpServletRequest request) {
        String f_kaf_facultet = (String) request.getSession().getAttribute("f_kaf_facultet");
        if (f_kaf_facultet == null) {
            return "redirect:/kafedra/select";
        }
        List<Kafedra> kafedras = kafedraService.findAllKafedrasByFacultetId(Integer.parseInt(f_kaf_facultet));
        modelMap.addAttribute("kafedra", kafedras);
        modelMap.addAttribute("title", "Редагування кафедр | Адміністрування");
        return "/admin/kafedra/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newKafedra(ModelMap modelMap, HttpServletRequest request) {
        String f_kaf_facultet = (String) request.getSession().getAttribute("f_kaf_facultet");
        Kafedra kafedra = new Kafedra();
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("f_kaf_facultet", f_kaf_facultet);
        modelMap.addAttribute("kafedra", kafedra);
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("title", "Додати нову кафедру | Адміністрування");
        return "/admin/kafedra/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveKafedra(@Valid Kafedra kafedra, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            List<Facultet> facultets = facultetService.findAllFacultets();
            modelMap.addAttribute("facultet", facultets);
            return "/admin/kafedra/new";
        }
        kafedraService.saveKafedra(kafedra);
        modelMap.addAttribute("success", kafedra.getName() + " додана успішно");
        modelMap.addAttribute("title", "Кафедра успішно додана | Адміністрування");
        return "/admin/kafedra/success";
    }

    @RequestMapping(value = {"edit-{id}-kafedra"}, method = RequestMethod.GET)
    public String editKafedra(@PathVariable String id, ModelMap modelMap) {
        Kafedra kafedra = kafedraService.findById(Integer.parseInt(id));
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("kafedra", kafedra);
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагування " + kafedra.getName() + " | Адміністрування");
        return "/admin/kafedra/new";
    }

    @RequestMapping(value = {"edit-{id}-kafedra"}, method = RequestMethod.POST)
    public String updateKafedra(@Valid Kafedra kafedra, BindingResult result, ModelMap modelMap, @PathVariable String id) {
        if (result.hasErrors()) {
            List<Facultet> facultets = facultetService.findAllFacultets();
            modelMap.addAttribute("facultet", facultets);
            return "/admin/kafedra/new";
        }
        kafedraService.updateKafedra(kafedra);
        modelMap.addAttribute("success", kafedra.getName() + " оновлено успішно");
        modelMap.addAttribute("title", "Кафедру оновлено | Адміністрування");
        return "/admin/kafedra/success";
    }

    @RequestMapping(value = {"delete-{id}-kafedra"}, method = RequestMethod.GET)
    public String deleteKafedra(@PathVariable String id) {
        kafedraService.deleteKafedra(id);
        return "redirect:/kafedra/list";
    }
}
