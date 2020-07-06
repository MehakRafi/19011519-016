package edu.uog.campus;

import java.util.List;
import java.util.Scanner;

import edu.uog.Option;

public class roomOptions {
	static roomData roomdata = new roomData();
	static Scanner scan = new Scanner(System.in);
	public static char op;

	public static void roomsDataOptions() throws Exception {
		System.out.println("\n\n\n\n\n");
		System.out.println("-------------------------------------------");
		System.out.println("       ------Accessed Rooms Data------     ");
		System.out.println("===========================================");
		System.out.println("       ------Enter Your Choice------       ");
		System.out.println("===========================================");
		System.out.println("1. For Viewing All The Records .");
		System.out.println("2. For Finding a Record.");
		System.out.println("3. For Searching A Record.");
		System.out.println("4. For Adding a New Record.");
		System.out.println("5. For Deleting a Record.");
		System.out.println("6. For Updating a Record.");
		System.out.println("7. For Returning to Main Menu.");
		System.out.println("===========================================");
		do {
			System.out.println("Choice: ");
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
				update();
				break;
			case '7':
				Option option = new Option();
				System.out.println("....");
				option.optionSelect();
				break;
			default:
				System.out.println("Invalid Input!!!!\nEnter Again!!!");
				break;
			}
			
		}while(!(op=='1'||op=='2'||op=='3'||op=='4'||op=='5'||op=='6'||op=='7'));
	}
	public static void findallOption() throws Exception {
		System.out.println("---------------------------------");
		System.out.println("FindAll");
		List<Room> rooms = roomdata.findAll();
		for (int i=0; i<rooms.size(); i++) {
			System.out.println(rooms.get(i).toString());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		roomsDataOptions();
	}
	public static void findoneOption() throws Exception {
		System.out.println("---------------------------------");
		System.out.println("Enter Id number of record to be Found");
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt(); 
		Room room = roomdata.findOne(op);
		System.out.println(room.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		roomsDataOptions();
		scan.close();
	}
	public static void searchOption() throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------------");
		System.out.println("Enter Room name to be Searched");
		//String roomName = scan.nextLine();
		List<Room> rooms = roomdata.search("B-112");
		for (int i=0; i<rooms.size(); i++) {
			System.out.println(rooms.get(i).toString());
		}
		scan.close();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		roomsDataOptions();
	}
	public static void saveOption() throws Exception {
		System.out.println("---------------------------------");
		Scanner scan = new Scanner(System.in);
		Room room = new Room();
		room.setROOM_ID(1);
		System.out.println("Enter Room Name:");
			String rOOM_NAME = scan.nextLine();
			room.setROOM_NAME(rOOM_NAME);
		System.out.println("Enter Room Floor:");
			int rOOM_FLOOR = scan.nextInt();
			room.setROOM_FLOOR(rOOM_FLOOR);
		System.out.println("Enter Room Capacity:");
			int rOOM_CAPACITY = scan.nextInt();
			room.setROOM_CAPACITY(rOOM_CAPACITY);
		System.out.println("Enter Room Type:");
			scan.nextLine();
			String rOOM_TYPE = scan.nextLine(); 
			room.setROOM_TYPE(rOOM_TYPE);
		room = roomdata.Save(room);
		System.out.println(room.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//roomsDataOptions();
		scan.close();
	}

	public static void deleteRecord() throws Exception {
		Scanner scan = new Scanner(System.in);
		roomData roomdata = new roomData();
		System.out.println("Enter ID Number to Be deleted!");
		int ID = scan.nextInt();
		roomdata.deleteRecord(ID);
		System.out.println("Records after deletion!!!");
		findallOption();
		scan.close();
	}
	public static void update() throws Exception {
		Scanner scan = new Scanner(System.in);
		roomData roomdata = new roomData();
		System.out.println("Enter ID Number to Be Updated!!!");
		int ID = scan.nextInt();
		roomdata.updateRecord(ID);
		System.out.println("Record Updated!!!");
		findallOption();
		scan.close();
	}

}
