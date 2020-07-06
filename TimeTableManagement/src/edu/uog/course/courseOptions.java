package edu.uog.course;

import java.util.List;

import edu.uog.Option;
import edu.uog.course.Course;
import java.util.Scanner;


public class courseOptions 
{
	static courseData coursedata = new courseData();
	

	public static void  coursesDataOptions() throws Exception {
		Scanner scan = new Scanner(System.in);
		char op;
		System.out.println("\n\n\n\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("       ------Accessed Courses Data------   ");
		System.out.println("===========================================");
		System.out.println("       ------Enter Your Choice------       ");
		System.out.println("===========================================");
		System.out.println("1. For Viewing All The Records .");
		System.out.println("2. For Finding a Record.");
		System.out.println("3. For Searching A Record.");
		System.out.println("4. For Adding a New Record.");
		System.out.println("5. For Deleting a Record.");
		System.out.println("6. For Returning to Main Menu.");
		System.out.println("===========================================");
		do {
			System.out.println("Choice: ");
			scan.hasNext();
			op = scan.next().charAt(0);
			switch(op) {
			case '1':
				System.out.println("---------------------------------");
				findallOption();
				break;
			case '2':
				System.out.println("---------------------------------");
				findoneOption();
				break;
			case '3':
				System.out.println("---------------------------------");
				searchOption();
				break;
			case '4':
				System.out.println("---------------------------------");
				saveOption();
				break;
			case '5':
				deleteRecord();
				break;
			case '6':
				Option option = new Option();
				System.out.println("....");
				option.optionSelect();
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'));
		scan.close();
	}
	public static void  findallOption() throws Exception {
		System.out.println("---------------------------------");
		System.out.println("FindAll");
		List<Course> courses = coursedata.findAll();
		for (int i=0; i<courses.size(); i++) {
			System.out.println(courses.get(i).toString());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coursesDataOptions();
	}
	public static void  findoneOption() throws Exception {
		System.out.println("---------------------------------");
		System.out.println("Enter Id number of record to be Found");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt(); 
		Course course = coursedata.findOne(op);
		System.out.println(course.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coursesDataOptions();
		scan.close();
	}
	public static void  searchOption() throws Exception {
		System.out.println("---------------------------------");
		System.out.println("Enter Course code to Search for subject");
		List<Course> courses = coursedata.search("CS-104");
		for (int i=0; i<courses.size(); i++) {
			System.out.println(courses.get(i).toString());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coursesDataOptions();
	}
	public static void  saveOption() throws Exception {
		System.out.println("---------------------------------");
		Scanner scan = new Scanner(System.in);
		Course course = new Course();
		course.setCOURSE_ID(4);
		course.setCOURSE_CODE("CS-104");
		course.setCOURSE_TITLE("Java");
		course.setCOURSE_DESC("course covers core java");
		course.setCOURSE_CREDITHOUR(4);
		course = coursedata.Save(course);
		System.out.println(course.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		coursesDataOptions();
		scan.close();
	}
	
	public static void deleteRecord() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter ID Number to Be deleted!");
		int ID = scan.nextInt();
		coursedata.deleteRecord(ID);
		System.out.println("Records after deletion!!!");
		scan.close();
	}

}
