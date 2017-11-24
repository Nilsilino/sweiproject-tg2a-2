package hello;

import java.util.List;

public class CreateActivity {

	static int idCounter;
	int id;
	String name;
	String department;
	List<String> tags;
	String description;
	List<String> pictureLinks;
	
	
	CreateActivity(int idCounter, 
			int id, 
			String name, 
			String department, 
			List<String> tags, 
			String description,
			List<String> pictureLinks) {
		this.idCounter = idCounter;
		this.id = id;
		this.name = name;
		this.department = department;
		this.tags = tags;
		this.description = description;
		this.pictureLinks = pictureLinks;
	}
	
	public int getId() {
		return id;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	void setDepartment(String department) {
		this.department = department;
	}
	
	String getDepartment() {
		return department;
	}
	
	void addTag(String tag) {
		tags.add(tag);
	}
	
	void removeTag(String tag) {
		for(int i = 0; i < tags.size(); i++) {
			if(tags.get(i) == tag) {
				tags.remove(i);
			}
		}
	}
	
	void clearTags() {
		tags.removeAll(tags);
	}
	
	void setDescription(String description) {
		this.description = description;
	}
	
	String getDescription() {
		return description;
	}
	
		void addPictureLink(String link) {
		pictureLinks.add(link);
	}
	
	void removePictureLinks(String link) {
		for(int i = 0; i < pictureLinks.size(); i++) {
			if(pictureLinks.get(i) == link) {
				pictureLinks.remove(i);
			}
		}
	}
	
}
