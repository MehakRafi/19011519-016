package edu.uog.student;

import java.util.List;
import java.util.Scanner;

import edu.uog.Option;


public class studentOptions {
	
	static studentData studentData = new studentData();

	public static void  StudentsDataOptions() {
		Scanner scan = new Scanner(System.in);
		char op;
		System.out.println("\n\n\n\n\n");
		System.out.println("------------------------------------------- ");
		System.out.println("       ------Accessed Students Data------   ");
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
		List<Student> Students = studentData.findAll();
		for (int i=0; i<Students.size(); i++) {
			System.out.println(Students.get(i).toString());
		}
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsDataOptions();
	}
	public static void  findoneOption() {
		System.out.println("---------------------------------");
		System.out.println("Enter Id number of record to be Found");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt(); 
		Student Student = studentData.findOne(op);
		System.out.println(Student.toString());
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		StudentsDataOptions();
		scan.close();
	}
	public static void  searchOption() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Enter Student Roll number to search its data");
		String stdCode = scan.nextLine();
		List<Student> Students = studentData.search(stdCode);
		for (int i=0; i<Students.size(); i++) {
			System.out.println(Students.get(i).toString());
		}
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsDataOptions();
		scan.close();
	}
	public static void  saveOption() {
		System.out.println("---------------------------------");
		Scanner scan = new Scanner(System.in);
		Student student = new Student();
		
		student.setSTUDENT_ID(1);
		System.out.println("Enter Student Roll Number: ");
			String studentRollNo = scan.nextLine();
			student.setSTUDENT_ROLLNO(studentRollNo);
		System.out.println("Enter Student Study Program: ");
			String studyProgram = scan.nextLine();
			student.setSTUDY_PROGRAM(studyProgram);
		System.out.println("Enter Student Study Year: ");
			String studyYear = scan.nextLine();
			student.setSTUDY_YEAR(studyYear);
			
		student = studentData.Save(student);
		System.out.println(student.toString());
		
		System.out.println("\n\n\n\n\n");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		StudentsDataOptions();
		scan.close();
	}
}
