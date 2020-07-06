package edu.uog.campus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class roomData {
	
	@SuppressWarnings("resource")
	public List<Room> findAll() throws Exception  {
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader("Rooms.CSV"));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				room.setROOM_ID(Integer.parseInt(roomRow[0]));
				room.setROOM_NAME(roomRow[1]);
				room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
				room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
				room.setROOM_TYPE(roomRow[4]);
				
				rooms.add(room);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return rooms;
	}

	@SuppressWarnings("resource")
	public Room findOne(int room_ID) throws Exception  {
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				if (Integer.parseInt(roomRow[0]) == room_ID) {
					
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					
					return room;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("resource")
	public List<Room> search(String search) throws Exception  {
		List<Room> rooms = new ArrayList<Room>();
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Room.csvFile));
			
			while ((line = bufferreader.readLine()) != null) {
				Room room = new Room();
				
				String[] roomRow = line.split(",");
				
				if (roomRow[1].contains(search) == true) {
					room.setROOM_ID(Integer.parseInt(roomRow[0]));
					room.setROOM_NAME(roomRow[1]);
					room.setROOM_FLOOR(Integer.parseInt(roomRow[2]));
					room.setROOM_CAPACITY(Integer.parseInt(roomRow[3]));
					room.setROOM_TYPE(roomRow[4]);
					rooms.add(room);
				}
				return rooms;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rooms;
	}

	public Room Save(Room room) throws Exception {
		FileWriter filewriter;

		List<Room> rooms = findAll();

		try {
			filewriter = new FileWriter(Room.csvFile);

			for (int i=0; i<rooms.size(); i++) {
				filewriter.append(rooms.get(i).toString());
				filewriter.append("\n");
			}
			if (rooms.size()>0)
				room.setROOM_ID(rooms.get(rooms.size()-1).getROOM_ID()+1);
			else
				room.setROOM_ID(1);
			filewriter.append(room.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return room;
	}
	public Room deleteRecord(int ID) throws Exception{
		String temp = "temp.txt";
		File fileMain = new File(Room.csvFile);
		File fileTemp = new File(temp);
		BufferedReader breader = new BufferedReader(new FileReader (fileMain));
		BufferedWriter bwriter = new BufferedWriter(new FileWriter (fileTemp,true));
		String line;
		
		while((line = breader.readLine()) != null) {
			String[] roomRow = line.split(",");
			if(!(Integer.parseInt(roomRow[0]) == ID)) {
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
	
	public Room updateRecord(int room_ID) throws Exception {
		String temp = "temp.txt";
		File fileMain = new File(Room.csvFile);
		File fileTemp = new File(temp);
		Scanner scan = new Scanner(System.in);
		BufferedReader breader = new BufferedReader(new FileReader (fileMain));
		BufferedWriter bwriter = new BufferedWriter(new FileWriter (fileTemp,true));
		String line;
		
		while((line = breader.readLine()) != null) {
			String[] roomRow = line.split(",");
			if(!(Integer.parseInt(roomRow[0]) == room_ID)) {
				bwriter.write(line);
				bwriter.write("\n");
			}
			else {
				Room room = new Room();
				room.setROOM_ID(room_ID);
				System.out.println("Enter Room Name:");
				String rOOM_NAME = scan.nextLine();
				room.setROOM_NAME(rOOM_NAME);
				System.out.println("Enter Room floor");
				int rOOM_FLOOR = scan.nextInt();
				room.setROOM_FLOOR(rOOM_FLOOR);
				System.out.println("ENter Room Capacity");
				int rOOM_CAPACITY = scan.nextInt();
				room.setROOM_CAPACITY(rOOM_CAPACITY);
				System.out.println("Enter Room Type");
				scan.nextLine();
				String rOOM_TYPE = scan.nextLine();
				room.setROOM_TYPE(rOOM_TYPE);
				Save(room);
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
