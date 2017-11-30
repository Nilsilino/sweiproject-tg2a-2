package controller;

import java.util.ArrayList;
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
    public String sendMail(@RequestParam(value="mail", required=true) String mail, @RequestParam(value="id", required=false, defaultValue="-1") int id, Model model) {
    	System.out.println("sending Email to "+ mail);
    	new EMail(mail,DataBase.createVerfication(id));
    	return "{ \"status\" : \"ok\"}";
    }
    
    @RequestMapping("/checkKey")
    public String check(@RequestParam(value="key", required=true) int key, @RequestParam(value="id", required=false, defaultValue="-1") int id, Model model) {
    	return "{ \"status\" : \""+Boolean.toString(DataBase.checkKey(key, id))+"\"}";
    }
    
    @RequestMapping("/create")
    public String create(
    		@RequestParam(value="key", required=true) int key,
    		@RequestParam(value="id", required=false, defaultValue="-1") int id,
    		@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="cat", required=false, defaultValue="category") String category,
    		@RequestParam(value="dep", required=false, defaultValue="department") String department,
    		@RequestParam(value="tag", required=false, defaultValue="tag") String tags,
    		@RequestParam(value="des", required=false, defaultValue="description") String description,
    		Model model) {
    	
    	if(!name.equals("")) {
    		tags = tags.trim();
    		String[] s = tags.split(",");
    		List<String> t = new ArrayList<String>();
    		for(String minitag : s) {
    			t.add(minitag);
    		}
    		DataBase.addActivity(new Activity(name, category, department, description, t));
    		DataBase.removeKey(key);
    		return "{ \"status\" : \"true\"}";
    		}
    	return "{ \"status\" : \"false\"}";
    }
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }

}
