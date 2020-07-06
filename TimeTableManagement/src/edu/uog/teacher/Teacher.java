package edu.uog.teacher;

import edu.uog.person.Person;

public class Teacher extends Person {
	
	public static String csvFile = "Teacher.csv";
	
	private int TEACHER_ID;
	private String TEACHER_NAME;
	private String TEACHER_TITLE;
	
	
	public int getTEACHER_ID() {
		return TEACHER_ID;
	}
	public void setTEACHER_ID(int tEACHER_ID) {
		TEACHER_ID = tEACHER_ID;
	}
	public String getTEACHER_NAME() {
		return TEACHER_NAME;
	}
	public void setTEACHER_NAME(String tEACHER_NAME) {
		TEACHER_NAME = tEACHER_NAME;
	}
	public String getTEACHER_TITLE() {
		return TEACHER_TITLE;
	}
	public void setTEACHER_TITLE(String tEACHER_TITLE) {
		TEACHER_TITLE = tEACHER_TITLE;
	}
	
	
	public String toString() {
		
		String str = "null";
		str = this.TEACHER_ID 
				+ "," + this.TEACHER_NAME
				+ "," + this.TEACHER_TITLE;
		return str;
	}
}
