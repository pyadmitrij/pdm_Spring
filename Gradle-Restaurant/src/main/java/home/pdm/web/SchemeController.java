package home.pdm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchemeController {

    @RequestMapping(value = "/schema", method = RequestMethod.GET)
    public String getScheme(){
        return "schema";
    }
}
