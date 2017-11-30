package dataBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Activity;
import model.DataBase;


public class DatabaseTest {

	List<String> t1;
	List<String> t2;
	List<String> t3;
	DataBase data;
	@Before
	public void setUp() throws Exception {
		t1 = new ArrayList<String>();
		t2 = new ArrayList<String>();
		t2.add("LIFE");
		t3 = new ArrayList<String>();		
		t3.add("Hard");
		t3.add("Unknown");
	}
	
	
	@Test
	public void TestIfDataBaseHasSameContent() throws Exception {
		Activity x = new Activity("LifeHacks", "dailies", "non", "Has nothing to do with you", t1);
		DataBase.addActivity(x);
		assertEquals(x, DataBase.getActivity(0));
	}
	
	@Test
	public void TestIfActivityIsSame() throws Exception {
		Activity x = new Activity("LifeHacks", "dailies", "non", "Has nothing to do with you", t1);
		DataBase.addActivity(x);
		assertEquals(x, DataBase.getActivity(1));
	}
	
	@Test
	public void TestDeleteActivity() throws Exception {
		DataBase.deleteActivity(0);
		Activity one = new Activity("LifeHacks", "dailies", "non", "Has nothing to do with you", t1);
		Activity two = new Activity("LifeIsHard", "Ded", "non", "Has nothing", t2);
		Activity three = new Activity("LifeHacks", "dailies", "non", "Has nothing to do with you", t3);
		DataBase.addActivity(one);
		DataBase.addActivity(two);
		DataBase.addActivity(three);
		DataBase.deleteActivity(3);
		DataBase.deleteActivity(2);
		assertEquals(2, DataBase.getLength());
	}
	
}
