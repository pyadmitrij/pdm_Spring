package home.pdm.controllers;

import home.pdm.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger("RoleController");

    @Autowired
    private IRoleService roleService;

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/all_role", method = RequestMethod.GET)
    public String listRole(Model model)
    {
        model.addAttribute("roles", roleService.getAll());
        return "/all_role";
    }

}
