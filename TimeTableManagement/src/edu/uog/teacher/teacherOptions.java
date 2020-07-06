package edu.uog.teacher;

import java.util.List;
import java.util.Scanner;

import edu.uog.Option;
import edu.uog.teacher.Teacher;
import edu.uog.teacher.teacherData;

public class teacherOptions {
	static Scanner scan = new Scanner(System.in);

	public static void TeachersDataOptions() {
		char op;
		System.out.println("\n\n\n\n\n");
		System.out.println("------------------------------------------- ");
		System.out.println("       ------Accessed Teachers Data------   ");
		System.out.println("============================================");
		System.out.println("       ------Enter Your Choice------        ");
		System.out.println("============================================");
		System.out.println("1. For Viewing All The Records .");
		System.out.println("2. For Finding a Record.");
		System.out.println("3. For Searching A Record.");
		System.out.println("4. For Adding a New Record.");
		System.out.println("5. For Deleting a Record.");
		System.out.println("6. For Returning to Main Menu.");
		System.out.println("============================================");
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'));
	}
	public static void findallOption() {
		System.out.println("---------------------------------");
		System.out.println("FindAll");
		List<Teacher> teachers = teacherData.findAll();
		for (int i=0; i<teachers.size(); i++) {
			System.out.println(teachers.get(i).toString());
		}
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TeachersDataOptions();
	}
	public static void findoneOption() {
		System.out.println("---------------------------------");
		System.out.println("Enter Id number of record to be Found");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt(); 
		Teacher teacher = teacherData.findOne(op);
		System.out.println(teacher.toString());
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TeachersDataOptions();
		scan.close();
	}
	public static void searchOption() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Enter Teacher Name to search its data");
		String name = scan.nextLine();
		List<Teacher> teachers = teacherData.search(name.toUpperCase());
		for (int i=0; i<teachers.size(); i++) {
			System.out.println(teachers.get(i).toString());
		}
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TeachersDataOptions();
		scan.close();
	}
	public static void saveOption() {
		System.out.println("---------------------------------");
		Scanner scan = new Scanner(System.in);
		Teacher teacher = new Teacher();
		
		teacher.setTEACHER_ID(1);
		teacher.setTEACHER_NAME("Nouman Riaz".toUpperCase());
		teacher.setTEACHER_TITLE("Dr assistant professor");
		
		teacher = teacherData.Save(teacher);
		System.out.println(teacher.toString());
		
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TeachersDataOptions();
		scan.close();
	}

}
