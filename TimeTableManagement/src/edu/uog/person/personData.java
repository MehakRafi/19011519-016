package edu.uog.person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.uog.person.Person;

public class personData {

	@SuppressWarnings("resource")
	public static List<Person> findAll() throws Exception  {
		List<Person> persons = new ArrayList<Person>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader("Persons.CSV"));
			
			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();
				
				String[] personRow = line.split(",");
				
				person.setPERSON_ID(Integer.parseInt(personRow[0]));
				person.setTITLE(personRow[1]);
				person.setFORE_NAME(personRow[2]);
				person.setSUR_NAME(personRow[3]);
				person.setAGE(Integer.parseInt(personRow[4]));
				person.setGENDER(personRow[5]);
				person.setADDRESS(personRow[6]);
				
				persons.add(person);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return persons;
	}

	@SuppressWarnings("resource")
	public static Person findOne(int person_ID) throws Exception  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();
				
				String[] personRow = line.split(",");
				
				if (Integer.parseInt(personRow[0]) == person_ID) {
					
					person.setPERSON_ID(Integer.parseInt(personRow[0]));
					person.setTITLE(personRow[1]);
					person.setFORE_NAME(personRow[2]);
					person.setSUR_NAME(personRow[3]);
					person.setAGE(Integer.parseInt(personRow[4]));
					person.setGENDER(personRow[5]);
					person.setADDRESS(personRow[6]);
					
					return person;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public static List<Person> search(String search) throws Exception  {
		List<Person> persons = new ArrayList<Person>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Person.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Person person = new Person();
				
				String[] personRow = line.split(",");
				
				if (personRow[2].contains(search) == true) {
					
					person.setPERSON_ID(Integer.parseInt(personRow[0]));
					person.setTITLE(personRow[1]);
					person.setFORE_NAME(personRow[2]);
					person.setSUR_NAME(personRow[3]);
					person.setAGE(Integer.parseInt(personRow[4]));
					person.setGENDER(personRow[5]);
					person.setADDRESS(personRow[6]);
					
					persons.add(person);
				}
				return persons;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return persons;
	}

	public static Person Save(Person person) throws Exception {
		FileWriter filewriter;

		List<Person> persons = findAll();

		try {
			filewriter = new FileWriter(Person.csvFile);

			for (int i=0; i<persons.size(); i++) {
				filewriter.append(persons.get(i).toString());
				filewriter.append("\n");
			}
			if (persons.size()>0)
				person.setPERSON_ID(persons.get(persons.size()-1).getPERSON_ID()+1);
			else
				person.setPERSON_ID(1);
			filewriter.append(person.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return person;
	}
	public Person deleteRecord(int ID) throws Exception{
		String temp = "temp.txt";
		File fileMain = new File(Person.csvFile);
		File fileTemp = new File(temp);
		BufferedReader breader = new BufferedReader(new FileReader (fileMain));
		BufferedWriter bwriter = new BufferedWriter(new FileWriter (fileTemp,true));
		String line;
		
		while((line = breader.readLine()) != null) {
			String[] personRow = line.split(",");
			if(!(Integer.parseInt(personRow[0]) == ID)) {
				bwriter.write(line);
				bwriter.write("\n");
			}
		}
		System.out.println("data deleted");
		breader.close();
		bwriter.flush();
		bwriter.close();
		fileMain.delete();
		fileTemp.renameTo(fileMain);
		return null;
	}
	
	public Person updateRecord(int person_ID) throws Exception {
		String temp = "temp.txt";
		File fileMain = new File(Person.csvFile);
		File fileTemp = new File(temp);
		Scanner scan = new Scanner(System.in);
		BufferedReader breader = new BufferedReader(new FileReader (fileMain));
		BufferedWriter bwriter = new BufferedWriter(new FileWriter (fileTemp,true));
		String line;
		
		while((line = breader.readLine()) != null) {
			String[] personRow = line.split(",");
			if(!(Integer.parseInt(personRow[0]) == person_ID)) {
				bwriter.write(line);
				bwriter.write("\n");
			}
			
		}
		System.out.println("Data Updated");
		breader.close();
		bwriter.flush();
		bwriter.close();
		fileMain.delete();
		fileTemp.renameTo(fileMain);
		scan.close();
		return null;
	}

}
