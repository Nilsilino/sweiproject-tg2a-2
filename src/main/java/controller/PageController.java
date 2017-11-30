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
    
    @RequestMapping("/activity")
    public String seeActivity(@RequestParam(value="id", required=true) int id, Model model) {
		return "details";
    }
    
    @RequestMapping("/createActivity")
    public String create(@RequestParam(defaultValue="", required=false)String text, Model model) {
		return "createActivity";
    	
    }
}
