package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Activity;

public class DataBase {
	
	/*
	 * Only One DataBase in ths Application allowed
	 * -> Everything is static.
	 */

	private static List<Activity> activities = new ArrayList<Activity>();
	private static Map<Integer, Integer> m = new HashMap<Integer,Integer>();
	
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
	
	public static int createVerfication(int id){
		int i = (int)(Math.random()*1000000);
		while(m.containsKey(i)) {
			i = (int)(Math.random()*1000000);
		}
		m.put(i, id);
		return i;	
	}
	
	public static boolean checkKey(int key, int id) {
		if (m.containsKey(key)){
			if(m.get(key)==id){
				return true;
			}
		}
		return false;
	}
	
	public static void removeKey(int key) {
		m.remove(key);
	}
	
	public static int getLength() {
		int i = 0;
		for (Activity a : activities) {
			i++;
		}
		return i;
	}
	
}
