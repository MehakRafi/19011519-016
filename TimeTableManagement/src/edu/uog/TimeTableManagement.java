package edu.uog;

public class TimeTableManagement {

	public static void main(String[] args) {
		Option option = new Option();
		try {
			option.optionSelect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
