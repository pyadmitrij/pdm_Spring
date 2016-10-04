package home.pdm.web;

import home.pdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Map<String, Object> model) {
        model.put("users", userService.getUsers());
        return "users";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
