package controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Mail.EMail;
import model.*;

@RestController
public class ApiController {
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
    @RequestMapping("/list")
    public List<Activity> list() {	
        return DataBase.getList();
    }
    
    @RequestMapping("/details")
    public Activity details(@RequestParam(value="id", required=true) int requested_id, Model model) {  
        return DataBase.getActivity(requested_id);
    }
    
    @RequestMapping("/MailTo")
    public String sendMail(@RequestParam(value="mail", required=true) String mail, Model model) {
    	System.out.println("sending Email to "+ mail);
    	new EMail(mail);
    	return "{ \"status\" : \"ok\"}";
    }
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }

}
