package home.pdm.controllers;

import home.pdm.model.User;
import home.pdm.service.IRoleService;
import home.pdm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger("HomeController");

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        LOGGER.debug("Start home page.");

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance();

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }
}
