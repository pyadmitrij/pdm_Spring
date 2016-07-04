package home.pdm.controllers;


import home.pdm.model.Role;
import home.pdm.model.User;
import home.pdm.service.IRoleService;
import home.pdm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Handles requests for the application add_user, user page.
 */

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserController");

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.GET)
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAll());
        return "/add_user";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public String addUserSubmit(Model model, @Valid User user, HttpServletRequest request,
                                BindingResult result) {
        model.addAttribute("user", new User());
        model.addAttribute("role", roleService.getAll());
        Role role = roleService.getRole(Integer.parseInt(request.getParameter("roleId")));
        if (result.hasErrors()) return "add_user";
        user.getRoles().add(role);
        userService.addUser(user);
        model.addAttribute("addeduser", user);
        return "/add_user";
    }

    @RequestMapping(value = "/all_user", method = RequestMethod.GET)
    public String listUser(Model model)
    {
        model.addAttribute("users", userService.getAll());
        return "/all_user";
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.GET)
    public String updateUser(@ModelAttribute("update_user") User user, Model model)
    {
        user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "/update_user";
    }

}
