package home.pdm.web;

import home.pdm.form.CalcForm;
import home.pdm.service.CalcService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalcController {
    @Autowired
    private CalcService calcService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String start(ModelMap model) {
        CalcForm calcForm = new CalcForm();
        model.put("calcForm", calcForm);
        return "calculator";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String doWork(@Valid CalcForm calcForm, BindingResult result) {
        ModelMap model = new ModelMap();

        System.out.println("a = " + calcForm.getA());
        System.out.println("b = " + calcForm.getB());
        System.out.println("operator = " + calcForm.getOperator());
        if (result.hasErrors()) {
            return "calculator";
        }
        if (calcForm.getA() != null && calcForm.getB() != null) {
            if ("+".equals(calcForm.getOperator())) {
                calcForm.setResult(calcService.sum(calcForm.getA(), calcForm.getB()));
                System.out.println("a + b = " + calcForm.getResult());
            } else if ("-".equals(calcForm.getOperator())) {
                calcForm.setResult(calcService.minus(calcForm.getA(), calcForm.getB()));
                System.out.println("a - b = " + calcForm.getResult());
            } else if ("*".equals(calcForm.getOperator())) {
                calcForm.setResult(calcService.mult(calcForm.getA(), calcForm.getB()));
                System.out.println("a * b = " + calcForm.getResult());
            } else if ("/".equals(calcForm.getOperator())) {
                try {
                    calcForm.setResult(calcService.div(calcForm.getA(), calcForm.getB()));
                    System.out.println("a / b = " + calcForm.getResult());
                } catch (Exception e1) {
                    model.addAttribute("result", calcForm.getResult());
                    System.err.println(e1.getMessage());
                }
            } else if ("sqrt".equals(calcForm.getOperator())) {
                calcForm.setB(0.0);
                calcForm.setResult(calcService.sqrtRot(calcForm.getA()));
                System.out.println("sqrt(a) = " + calcForm.getResult());
            }

            model.addAttribute("a", calcForm.getA());
            model.addAttribute("b", calcForm.getB());
            model.addAttribute("result", calcForm.getResult());
        } else {
            calcForm.setResult(0.0);
            System.out.println("result " + calcForm.getResult());
            model.addAttribute("result", calcForm.getResult());
        }
        return "calculator";
    }
}
