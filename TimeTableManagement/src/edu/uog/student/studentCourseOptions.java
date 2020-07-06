package edu.uog.student;

import java.util.List;
import java.util.Scanner;

import edu.uog.Option;

public class studentCourseOptions {
	
	static studentCourseData studentcoursedata = new studentCourseData();

	public static void  StudentsCourseDataOptions() {
		Scanner scan = new Scanner(System.in);
		char op;
		System.out.println("\n\n\n\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("       ------Accessed Students Data------   ");
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
				//deleting();
				break;
			case '6':
				Option option = new Option();
				System.out.println("....");
				try {
					option.optionSelect();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'));
		scan.close();
	}
	public static void  findallOption() {
		System.out.println("---------------------------------");
		System.out.println("FindAll");
		List<Student> Students = studentcoursedata.findAll();
		for (int i=0; i<Students.size(); i++) {
			System.out.println(Students.get(i).toString());
		}System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsCourseDataOptions();
	}
	public static void  findoneOption() {
		System.out.println("---------------------------------");
		System.out.println("Enter Id number of record to be Found");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt(); 
		Student Student = studentcoursedata.findOne(op);
		System.out.println(Student.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsCourseDataOptions();
		scan.close();
	}
	public static void  searchOption() {
		System.out.println("---------------------------------");
		System.out.println("Enter Student code to Search for subject");
		List<Student> Students = studentcoursedata.search("19011519-");
		for (int i=0; i<Students.size(); i++) {
			System.out.println(Students.get(i).toString());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsCourseDataOptions();
	}
	public static void  saveOption() {
		System.out.println("---------------------------------");
		Scanner scan = new Scanner(System.in);
		Student student = new Student();
		student.setSTUDENT_ID(1);
		student.setSTUDENT_ROLLNO("19011519-027");
		student.setSTUDY_PROGRAM("Computer Science");
		student.setSTUDY_YEAR("2019");
		student = studentcoursedata.Save(student);
		System.out.println(student.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsCourseDataOptions();
		scan.close();
	}
}
