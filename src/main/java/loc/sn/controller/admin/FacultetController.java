package loc.sn.controller.admin;

import loc.sn.model.admin.Facultet;
import loc.sn.service.admin.Facultet.FacultetService;
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
@RequestMapping("/facultet")
public class FacultetController {

    @Autowired
    FacultetService facultetService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "list"},method = RequestMethod.GET)
    public String listFacultets(ModelMap modelMap) {
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("facultets", facultets);
        modelMap.addAttribute("title", new String("Редагування факультетів | Адміністрування"));
        return "/admin/facultet/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newFacultet(ModelMap modelMap) {
        Facultet facultet = new Facultet();
        modelMap.addAttribute("facultet", facultet);
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("title","Додати новий факультет | Адміністрування");
        return "/admin/facultet/new";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveFacultet(@Valid Facultet facultet, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {

            return "/admin/facultet/new";
        }
        facultetService.saveFacultet(facultet);
        modelMap.addAttribute("success", "Факультет: " + facultet.getName() + " доданий успішно!");
        modelMap.addAttribute("title", "Факультет додано успішно | Адміністрування");
        return "/admin/facultet/success";
    }

    @RequestMapping(value = {"/edit-{id}-facultet"}, method = RequestMethod.GET)
    public String editFacultet(@PathVariable String id, ModelMap modelMap) {
        Facultet facultet = facultetService.findById(Integer.parseInt(id));
        modelMap.addAttribute("facultet", facultet);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагування факульетут | Адміністрування");
        return "/admin/facultet/new";
    }

    @RequestMapping(value = {"/edit-{id}-facultet"}, method = RequestMethod.POST)
    public String updateFacultet(@Valid Facultet facultet, BindingResult result, ModelMap modelMap, @PathVariable String id) {
        if (result.hasErrors()) {
            return "/admin/facultet/new";
        }
        facultetService.updateFacultet(facultet);
        modelMap.addAttribute("success", facultet.getName() + " оновлено успішно");
        modelMap.addAttribute("title", "Факультет оновлено | Адміністрування");
        return "/admin/facultet/success";
    }

    @RequestMapping(value = {"/delete-{id}-facultet"}, method = RequestMethod.GET)
    public String deleteFacultet(@PathVariable String id) {
        facultetService.deleteFacultet(id);
        return "redirect:/facultet/list";
    }
}
