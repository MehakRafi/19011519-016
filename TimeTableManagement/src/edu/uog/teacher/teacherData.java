package edu.uog.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.teacher.Teacher;;

public class teacherData {
	@SuppressWarnings("resource")
	public static List<Teacher> findAll()  {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			// reading data from file and storing it in a List to be displayed
			while ((line = bufferreader.readLine()) != null) {
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
				teacher.setTEACHER_NAME(teacherRow[1]);
				teacher.setTEACHER_TITLE(teacherRow[2]);
				
				teachers.add(teacher);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return teachers;
	}

	@SuppressWarnings("resource")
	public static Teacher findOne(int Teacher_ID)  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher teacher = new Teacher();
				String[] teacherRow = line.split(",");
				
				if (Integer.parseInt(teacherRow[0]) == Teacher_ID) {
					
					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					teacher.setTEACHER_NAME(teacherRow[1]);
					teacher.setTEACHER_TITLE(teacherRow[2]);
										
					return teacher;
				}
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Teacher> search(String search)  {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				if (teacherRow[1].contains(search) == true) {
					
					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					teacher.setTEACHER_NAME(teacherRow[1]);
					teacher.setTEACHER_TITLE(teacherRow[2]);
					
					teachers.add(teacher);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return teachers;
	}

	@SuppressWarnings("static-access")
	public static Teacher Save(Teacher Teacher) {
		FileWriter filewriter;

		List<Teacher> teachers = findAll();

		try {
			filewriter = new FileWriter(Teacher.csvFile);

			for (int i=0; i<teachers.size(); i++) {
				filewriter.append(teachers.get(i).toString());
				filewriter.append("\n");
			}
			if (teachers.size()>0)
				Teacher.setTEACHER_ID(teachers.get(teachers.size()-1).getTEACHER_ID()+1);
			else
				Teacher.setTEACHER_ID(1);
			
			filewriter.append(Teacher.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return Teacher;
	}
}
