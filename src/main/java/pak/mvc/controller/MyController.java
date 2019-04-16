package pak.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        String model = "data";
        return new ModelAndView("welcome", "model", model);
    }

}
