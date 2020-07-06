package edu.uog;

import java.util.Scanner;

import edu.uog.campus.roomOptions;
import edu.uog.course.courseOptions;
import edu.uog.person.personOptions;
import edu.uog.student.studentCourseOptions;
import edu.uog.student.studentOptions;
import edu.uog.teacher.teacherOptions;

public class Option 
{
	Scanner scan = new Scanner(System.in);
	public char op;

	public void optionSelect() throws Exception {
		System.out.println("===========================================");
		System.out.println("           Enter Your Choice               ");
		System.out.println("===========================================");
		System.out.println("1. For Accessing Courses Data.");
		System.out.println("2. For Accessing Rooms Data.");
		System.out.println("3. For Accessing Students Data.");
		System.out.println("4. For Accessing Students Courses Data.");
		System.out.println("5. For Accessing Teachers Data.");
		System.out.println("6. For Accessing TimeTable.");
		System.out.println("7. For Accessing Persons Data.");
		System.out.println("8. For Exiting the system.");
		System.out.println("===========================================");
		do {
			System.out.println("Choice: ");
			op = scan.next().charAt(0);
			switch(op) {
			case '1':
				courseOptions.coursesDataOptions();
				break;
			case '2':
				roomOptions.roomsDataOptions();
				break;
			case '3':
				studentOptions.StudentsDataOptions();
				break;
			case '4':
				studentCourseOptions.StudentsCourseDataOptions();
				break;
			case '5':
				teachersData();
				teacherOptions.TeachersDataOptions();
				break;
			case '6':
				timeTableData();
				break;
			case '7':
				personOptions.personsDataOptions();
				break;
			
			case '8':
				System.out.println("System Exiting....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'||op=='7'));
	}
		public void coursesData() {
			System.out.println("accesed course data");
		}
		
		public void studentsData() {
			System.out.println("accesed students data");
		}
		public void teachersData() {
			System.out.println("accesed teachers data");
		}
		public void timeTableData() {
			System.out.println("accesed timetable data");
		}
}

