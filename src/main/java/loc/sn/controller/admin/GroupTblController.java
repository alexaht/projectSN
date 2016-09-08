package loc.sn.controller.admin;

import loc.sn.model.admin.Facultet;
import loc.sn.model.admin.GroupTbl;
import loc.sn.service.admin.Facultet.FacultetService;
import loc.sn.service.admin.Group.GroupTblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by oleksiy on 29.08.16.
 */
@Controller
@RequestMapping("/group")
public class GroupTblController {

    @Autowired
    private MessageSource source;

    @Qualifier("groupTblService")
    @Autowired
    private GroupTblService groupTblService;


    @Qualifier("facultetService")
    @Autowired
    private FacultetService facultetService;

    @RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
    public String listGroup(ModelMap modelMap) {
        List<GroupTbl> groupTbls = groupTblService.findAllGroupTbl();
        modelMap.addAttribute("groupTbl", groupTbls);
        modelMap.addAttribute("title", "Список груп | АДміністрування");
        return "/admin/group/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addGroup(ModelMap modelMap) {
        GroupTbl groupTbl = new GroupTbl();
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("groupTbl", groupTbl);
        modelMap.addAttribute("title", "Додати нову групу | АДміністрування");
        modelMap.addAttribute("edit", false);
        return "/admin/group/new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveGroup(@Valid GroupTbl groupTbl, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "/group/new";
        }
        groupTblService.saveGroupTbl(groupTbl);
        modelMap.addAttribute("success", "Групу " +  groupTbl.getName() + " додано");
        modelMap.addAttribute("title", "Додати нову групу | АДміністрування");
        return "/admin/group/success";
    }

    @RequestMapping(value = "/edit-{id}-group", method = RequestMethod.GET)
    public String editGroup(@PathVariable String id, ModelMap modelMap) {
        GroupTbl groupTbl = groupTblService.findById(Integer.parseInt(id));
        List<Facultet> facultets = facultetService.findAllFacultets();
        modelMap.addAttribute("groupTbl", groupTbl);
        modelMap.addAttribute("facultet", facultets);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагування групи | АДміністрування");
        return "/admin/group/new";
    }

    @RequestMapping(value = "/edit-{id}-group", method = RequestMethod.POST)
    public String updateGroup(@Valid GroupTbl groupTbl, BindingResult result, ModelMap modelMap, @PathVariable String id) {
        if (result.hasErrors()) {
            List<Facultet> facultets = facultetService.findAllFacultets();
            modelMap.addAttribute("facultet", facultets);
            return "/admin/group/new";
        }
        groupTblService.updateGroupTbl(groupTbl);
        modelMap.addAttribute("success", groupTbl.getName() + " оновлено успішно");
        modelMap.addAttribute("title", "Групу оновлено | АДміністрування");
        return "/admin/group/success";
    }

    @RequestMapping(value = "/delete-{id}-group", method = RequestMethod.GET)
    public String deleteGroup(@PathVariable String id) {
        groupTblService.deleteGroupTbl(id);
        return "redirect:/group/list";
    }
}
