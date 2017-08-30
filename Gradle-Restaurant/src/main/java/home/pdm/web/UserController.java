package home.pdm.web;

import home.pdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Map<String, Object> model) {
        model.put("users", userService.getUsers());
        return "users";
    }

    @RequestMapping(value = "/user/{userName}", method = RequestMethod.GET)
    public ModelAndView user(@PathVariable String userName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getUserByName(userName));
        modelAndView.setViewName("user");
        return modelAndView;
    }

}
