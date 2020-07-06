package edu.uog.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class studentCourseData {
	@SuppressWarnings("resource")
	public List<Student> findAll()  {
		List<Student> students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			// reading data from file and storing it in a List to be displayed
			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();
				
				String[] studentRow = line.split(",");
				
				student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
				student.setSTUDENT_ROLLNO(studentRow[1]);
				student.setSTUDY_PROGRAM(studentRow[2]);
				student.setSTUDY_YEAR(studentRow[3]);
				
				students.add(student);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@SuppressWarnings("resource")
	public Student findOne(int Student_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();
				String[] studentRow = line.split(",");
				
				if (Integer.parseInt(studentRow[0]) == Student_ID) {
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setSTUDENT_ROLLNO(studentRow[1]);
					student.setSTUDY_PROGRAM(studentRow[2]);
					student.setSTUDY_YEAR(studentRow[3]);
					
										
					return student;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public List<Student> search(String search)  {
		List<Student> students = new ArrayList<Student>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Student.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Student student = new Student();
				
				String[] studentRow = line.split(",");
				
				if (studentRow[1].contains(search) == true) {
					student.setSTUDENT_ID(Integer.parseInt(studentRow[0]));
					student.setSTUDENT_ROLLNO(studentRow[1]);
					student.setSTUDY_PROGRAM(studentRow[2]);
					student.setSTUDY_YEAR(studentRow[3]);
					
					students.add(student);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return students;
	}

	@SuppressWarnings("static-access")
	public Student Save(Student Student) {
		FileWriter filewriter;

		List<Student> students = findAll();

		try {
			filewriter = new FileWriter(Student.csvFile);

			for (int i=0; i<students.size(); i++) {
				filewriter.append(students.get(i).toString());
				filewriter.append("\n");
			}
			if (students.size()>0)
				Student.setSTUDENT_ID(students.get(students.size()-1).getSTUDENT_ID()+1);
			else
				Student.setSTUDENT_ID(1);
			filewriter.append(Student.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return Student;
	}
}
