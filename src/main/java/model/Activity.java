package model;

import java.util.ArrayList;
import java.util.List;

public class Activity {

	private static int idCounter = 0;
	private int id;
	private String name;
	private String category;
	private String department;
	private List<String> tags;
	private String description;
	
	public Activity(String name,
			String category,
			String department,  
			String description, List<String> tags) {
		this.id = idCounter++;
		this.name = name;
		this.category = category;
		this.department = department;
		this.tags = new ArrayList<String>();
		this.description = description;
		
		for(String s : tags) {
			this.tags.add(s);
		}
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void addTag(String tag) {
		tags.add(tag);
	}
	
	public void removeTag(String tag) {
		for(int i = 0; i < tags.size(); i++) {
			if(tags.get(i).equals(tag)) {
				tags.remove(i);
			}
		}
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void clearTags() {
		tags.clear();
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
