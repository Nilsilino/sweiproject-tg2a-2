package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Activity;

public class DataBase {
	
	/*
	 * Only One DataBase in ths Application allowed
	 * -> Everything is static.
	 */

	private static List<Activity> activities = new ArrayList<Activity>();
	
	public static Activity getActivity(int id) {
		for(Activity a : activities) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	/*
	 * this method will have a filter.
	 */
	public static List<Activity> getList() {
		return activities;
	}
	
	public static void addActivity(Activity a) {
		activities.add(a);
	}
	
	public static void deleteActivity(int id) {
		for(int i = 0; i < activities.size(); i++)  {
			if(activities.get(i).getId() == id) {
				activities.remove(i);
			}
		}
	}
	
}
