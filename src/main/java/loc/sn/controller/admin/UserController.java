package loc.sn.controller.admin;

import loc.sn.model.admin.User;
import loc.sn.service.admin.User.UserService;
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

/**
 * Created by oleksiy on 22.08.16.
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap) {
        List<User> users = userService.findAllUsers();
        modelMap.addAttribute("users", users);
        modelMap.addAttribute("title", "Список користувачів | Адміністрування");
        return "/admin/users/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("edit", false);
        modelMap.addAttribute("title", "Додати нового користувача | Адміністрування");
        return "/admin/users/new";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()) {
            return "/admin/users/new";
        }
        userService.saveUser(user);
        modelMap.addAttribute("success", "Користувача " + user.getFirstName() + " " + user.getLastName() + " успішно додано");
        modelMap.addAttribute("title", "Додати нового користувача | Адміністрування");
        return "/admin/users/success";
    }

    @RequestMapping(value = "/edit-{id}-users", method = RequestMethod.GET)
    public String editUser(@PathVariable String id, ModelMap modelMap) {
        User user = userService.findById(Integer.parseInt(id));
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("edit", true);
        modelMap.addAttribute("title", "Редагування користувача | Адміністрування");
        return "/admin/users/new";
    }

    @RequestMapping(value = {"/edit-{id}-users"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, ModelMap modelMap, @PathVariable String id) {
        if (result.hasErrors()) {
            return "/admin/users/new";
        }
        userService.updateUser(user);
        modelMap.addAttribute("success", user.getFirstName() + " " + user.getLastName() + " оновлений успішно");
        modelMap.addAttribute("title", "Редагування користувача | Адміністрування");
        return "/admin/users/success";
    }

    @RequestMapping(value = {"/delete-{id}-users"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }
}
