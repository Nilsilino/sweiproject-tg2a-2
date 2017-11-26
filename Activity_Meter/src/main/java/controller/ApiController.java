package controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.*;

@RestController
public class ApiController {
	
    @RequestMapping("/list")
    public List<Activity> list() {	
        return DataBase.getList();
    }
    
    @RequestMapping("/details")
    public Activity details(@RequestParam(value="id", required=true) int requested_id, Model model) {  	
        return DataBase.getActivity(requested_id);
    }
    
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
