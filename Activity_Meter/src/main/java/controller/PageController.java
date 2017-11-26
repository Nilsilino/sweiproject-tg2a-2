package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.*;

@Controller
public class PageController {

    @RequestMapping("/view")
    public String view(Model model) {
		return "view";
    }

}
