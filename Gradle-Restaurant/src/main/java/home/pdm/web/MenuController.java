package home.pdm.web;

import home.pdm.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
public class MenuController {

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "menu";
    }

}
