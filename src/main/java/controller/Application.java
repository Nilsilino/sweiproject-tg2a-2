package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	
    	List<String> t1 = new ArrayList<String>();
    	List<String> t2 = new ArrayList<String>();
    	List<String> t3 = new ArrayList<String>();
    	
    	t1.add("geil");
    	t1.add("Hammer");
    	t2.add("unnötig");
    	t3.add("NoLife");
    	
    	DataBase.addActivity(new Activity("Activity 1","Cat1", "Informatik", "Diese Activity muss man gemacht haben", t1));
    	DataBase.addActivity(new Activity("Activity 2","Cat2", "BWL", "Diese Activity hat keinen Wert", t2));
    	DataBase.addActivity(new Activity("Activity 3","Cat3", "Maschinenbau", "Diese Activity ist für komische Menschen", t3));
    	
        SpringApplication.run(Application.class, args);
    }
}
