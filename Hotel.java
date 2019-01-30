/**@author Madhusoodhanan KM
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

	protected String name;
	protected String city;
	protected int maxRooms;									// To hold max possible rooms in a hotel
	protected ArrayList<Room> rooms;

	public static int roomCounter = 1;						// To simply increment each time a room is added


	protected ArrayList<Integer> searchedRooms;				// A list to just hold the searched Rooms list. It will be cleared after each search.


	protected ArrayList<Booking> bookings;

	// Setter for Hotel : Method to set up a Hotel
	public void setHotel(String name, String city, int maxRooms) {			// 
		this.name = name;
		this.city = city;
		this.maxRooms = maxRooms;							//Sets maxRooms to inputed value
		this.rooms= new ArrayList<Room>(maxRooms);	
		this.bookings= new ArrayList<Booking>(maxRooms);	// Declares Array List which can max have 5 rooms
		System.out.println("Congratulations on setting up your new Hotel ");
	}


	// Getter for Hotel : Method to display Details of Hotel
	public void getHotel() {			
		System.out.println("*****************************************************************");
		System.out.println("Hotel name: "+this.name);
		System.out.println("Hotel city: "+this.city);
		System.out.println("Max Rooms in hotel: "+(this.maxRooms));
		System.out.println("*****************************************************************");
		System.out.println("\n\n");
	}


	// Function to add new Room into Hotel (ArrayList of rooms)
	public void addRoom(Room roomObj) {
		this.rooms.add(roomObj);
	}


	// Function to get all details of all rooms in the Hotel
	public void displayAllRooms() {											
		System.out.println("Max Rooms in Hotel "+this.name+" are "+rooms.size());
		System.out.println("----------------------------------------------------------------");
		System.out.println("Room num type\t dailyRent\t hasSeaView\t occupancyStatus ");
		System.out.println("----------------------------------------------------------------");

		// Iterates for max rooms number of times, and displays needed details of all rooms line by line
		for(int i=0; i<rooms.size(); i++) {
			System.out.print(rooms.get(i).roomNo+"\t  ");
			System.out.print(rooms.get(i).type+"\t  ");
			System.out.print(rooms.get(i).dailyRent+"\t\t  ");
			System.out.print(rooms.get(i).hasSeaView+"\t\t  ");
			System.out.println(rooms.get(i).occupancyStatus);
			System.out.println("----------------------------------------------------------------");
		}

		System.out.println("*****************************************************************");
		System.out.println("               All room details are shown above                  ");
		System.out.println("*****************************************************************");
	}


	// Function to add a new Booking with the Booking Object
	public void addBooking(Booking bookingObj) {
		this.bookings.add(bookingObj);
	}


	// Function to display the room numbers of all the booked rooms
	public void displayAllBookedRooms() {
		System.out.println("The Rooms(room numbers) that have been booked are ");
		System.out.println("---------------------------------------------------------");
		for(int i=0; i<bookings.size(); i++) {												// Iterates through the Array List: bookings
			System.out.print(bookings.get(i).roomNo+"  ");
		}
		System.out.println("\n---------------------------------------------------------");
		System.out.println();
	}


	// Function to search for a room based on Case Study Criteria of asking for Room type and whether it has a sea View or not
	public int searchRoom(String roomType,boolean hasSeaView){
		int c=0;																// Counter for rooms that are matching the criteria
		this.searchedRooms = new ArrayList<Integer>(this.maxRooms);				

		for(int i=0; i<rooms.size(); i++) {										// Iterating through the ArrayList: rooms
			Room roomObj = rooms.get(i);										// Retrieving Room Object from the ArrayList: rooms, one at a time

			// If criteria matches, increment Counter
			if((roomObj.type.equals(roomType)) && (roomObj.hasSeaView==hasSeaView) && (roomObj.occupancyStatus==false)) {
				searchedRooms.add(roomObj.roomNo);								// The room number gets appended onto the List
				c++;															
			}
		}
		return c;																// Returns the number of rooms that matched the criteria
	}


	// Function to search for room based on a maxBudget per night constraint as specified by the user
	public int  searchRoom(double maxBudget) {
		int c=0;																//counter for rooms matching criteria
		this.searchedRooms = new ArrayList<Integer>(this.maxRooms);
		for(int i=0; i<rooms.size(); i++) {										// Iterating through the ArrayList: rooms
			Room roomObj = rooms.get(i);										// Retrieving Room Object from the ArrayList: rooms, one at a time

			// If the daily rent of a room is less than maxBudget, and room is not occupied
			if((roomObj.dailyRent <= maxBudget) && (roomObj.occupancyStatus==false)) {
				searchedRooms.add(roomObj.roomNo);								// The room number gets appended onto the List
				c++;
			}
		}
		return c;																// Returns the number of rooms that matched the criteria
	}


	// Function to show all the Guests who have already Booked a room
	public void displayGuestDetails() {
		System.out.println("*****************************************************************");
		System.out.println("Room num Guest Name\t email\t\t noOfDays\t Bill ");
		System.out.println("----------------------------------------------------------------");
		System.out.println();

		for(int i=0; i<bookings.size(); i++) {									// Iterates through the ArrayList: bookings
			System.out.print(bookings.get(i).roomNo+"\t  ");
			System.out.print(bookings.get(i).guestName+"\t    ");
			System.out.print(bookings.get(i).guestEmail+"\t   ");
			System.out.print(bookings.get(i).noOfDays+"\t  ");
			System.out.println(bookings.get(i).guestBill+"\t  ");
			System.out.println("_____________________________________________________________\n");
		}
	}


	// Main Method
	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);

		// I've used a simple Exception Handling mechanism where the Error message will be apt. Errors during runtime usually might be due to "bad inputs". Always follow the instructions provided
		try {

			System.out.println("Note: Please follow each instruction carefully, and you wont run into issues. Thank you."
					+ "The way inputs are to be given are specified in brackets []\n\n\n");

			System.out.println("Welcome to my Simple Hotel Management System. Before we begin with our"
					+ "functionalities, let us set up your Hotel");

			System.out.println("Enter Hotel_name, City, Capacity(max number of rooms that your hotel can hold) [3 words seperated by spaces]");	// Reading Hotel attributes from user
			String name = sc.next();
			String city = sc.next();
			int maxRooms = sc.nextInt();

			Hotel hotelObj = new Hotel();										// Hotel Object is created here
			hotelObj.setHotel(name, city, maxRooms); 							// Hotel is SET here
			hotelObj.getHotel();												// To check if all details have been set correctly 

			//-------------------------------------------------------------------


			System.out.println("Now you'll have to enter EACH Room Details "
					+ "(Yes, For all the "+hotelObj.maxRooms+" rooms that YOU mentioned your Hotel can accomodate. "
					+ "\nYour room numbers will be auto generated as per the given Case study\n");

			System.out.println("Room Types are to be entered in a certain fashion for better readability"
					+ "\nS: Standard \t D: Deluxe \t L: Luxury \n");

			System.out.println("--------------------------------------------------------------------");

			for(int i=1; i<=hotelObj.maxRooms; i++) {							// Iterating up to the Max rooms

				System.out.println("Room "+i);
				System.out.println("Enter Room_Type, Daily_Rent, and mention if it has a sea view or not [boolean] ");
				String type = sc.next();
				double dailyRent = sc.nextDouble();
				boolean hasSeaView = sc.nextBoolean();

				Room roomObj = new Room();										// New Room Object is created here
				int roomNo = roomObj.setRoom(type, dailyRent, hasSeaView);		// Room Properties are set here and 100 is always returned 
				roomObj.roomNo = roomNo+roomCounter;							// Custom roomNo property is set here
				roomCounter++;													// Increments whenever a new Room is created
				hotelObj.addRoom(roomObj);										//Adds the Room into the ArrayList: rooms in Hotel

				System.out.println("____________________________________________________");
			}
			System.out.println("Congratulations, all your rooms have been set ");

			//-------------------------------------------------------------------


			System.out.println("All your room details are ");
			hotelObj.displayAllRooms();											//Displays all rooms


			// ---------------------------------------------------------------------------------------


			System.out.println("Your Hotel is set, and all your Rooms are defined. Good ! "
					+ "\nFrom here onwards comes the functionalities of what can be done. "
					+ "\nNeither your Hotel details nor your Room details can be redefined. "
					+ "\nHowever if you REALLY REALLY want to redefine it, run this program again :p");
			System.out.println("\n\nFunctionalities provided(or coded for are limited)"
					+ " You can make bookings, View total Bookings, or Search for rooms based on criteria\n\n");

			int c=-1;								//


			do {

				System.out.println("\nWhat do you wanna do? \n"
						+ "1:Make a booking \n2:View All bookings \n3:Search Rooms  \n4:Display Guest Details\n"
						+ "  Default/Any other option: Exit  [Positive numeric Input only] ");
				c = sc.nextInt();

				switch(c) {
				// Case: Make a new Booking
				case 1:
					System.out.println("Enter the Room_Number, Guest_Name, Guest_Email_Id and Number_of_days they're staying for");
					int roomNo = sc.nextInt();
					String guestName = sc.next();				// This accepts only One name(no spaces allowed) Use sc.nextLine() for reading full names			
					String guestEmail = sc.next();
					int noOfDays = sc.nextInt();

					Booking bookingObj = new Booking();			// New Booking Object is created

					int desiredRoomLocInList = -1;				// To hold the position of Object: Room in ArrayList: rooms, if found

					for(int i=0; i<hotelObj.rooms.size(); i++) {					// Iterates through the ArrayList rooms till desired Room object is found
						if(roomNo == hotelObj.rooms.get(i).roomNo) {
							desiredRoomLocInList = i;								// To find position of desired room in ArrayList: rooms
							break;
						}
					}

					if(desiredRoomLocInList == -1) {			
						System.out.println("No such Room Number exists. What did I tell you about following the damn Instructions? ");   		// Means user has input a wrong room Number
					}

					// When the Room exists
					else {

						if(noOfDays<=0) {
							System.out.println("Number of Days of stay can't be 0 or lower. What are you thinking? ");
						}

						else if(hotelObj.rooms.get(desiredRoomLocInList).occupancyStatus) {							// If Room is occupied
							System.out.println("Sorry! That Room has already been booked ");
						}


						else {																										// When Room is NOT occupied

							double guestBill = bookingObj.bookRoom(roomNo, guestName, guestEmail, noOfDays);						// Always returns a 0 as guestBill is calculated here, not in the Booking class

							bookingObj.guestBill = hotelObj.rooms.get(desiredRoomLocInList).dailyRent * bookingObj.noOfDays;		// Bill is calculated HERE and set 

							hotelObj.rooms.get(desiredRoomLocInList).occupancyStatus = true;										// Set Occupancy status to true
							System.out.println("Room "+bookingObj.roomNo+" has been booked by "+bookingObj.guestName);
							System.out.println("Staying for "+bookingObj.noOfDays+" days with Bill amounting to "+bookingObj.guestBill);

							hotelObj.addBooking(bookingObj);					// Since the new booking is successful, add it to the list of bookings
						}
					}

					break;																											// Break for case 1

					// ---------------------------------------------------------------------------------------


				case 2:
					if(hotelObj.bookings.size()==0)
						System.out.println("No Bookings Yet\n\n");
					else 
						hotelObj.displayAllBookedRooms();																									// Adding a booking


					break;

					// ---------------------------------------------------------------------------------------


				case 3:
					double maxBudget = -1;
					int numOfRooms=0;

					System.out.println("Search based on criteria[1] or MaxBudget[2] [Don't enter any other choice]");
					int ch1 = sc.nextInt();

					if(ch1==1) {
						System.out.println("Enter the Room Type[S/D/L], Want seaView(true/false) [Yes, type 'true' or 'false']");
						String roomType = sc.next();
						boolean hasSeaView = sc.nextBoolean();
						numOfRooms = hotelObj.searchRoom(roomType,hasSeaView);
					}

					else if(ch1==2){
						System.out.println("Enter Max Budget you'll pay for daily rent ");
						maxBudget = sc.nextDouble();
						numOfRooms = hotelObj.searchRoom(maxBudget);
					}

					if(ch1==1 || ch1==2) {
					
						System.out.println("Num of rooms that meet your needs are "+numOfRooms);
						System.out.println("Rooms are : ");
						// Gets all Room Numbers available
						for(int i=0; i<hotelObj.searchedRooms.size(); i++) {				// Iterating through ArrayList: searchedRooms
							System.out.println(hotelObj.searchedRooms.get(i)+" ");
						}
						
						hotelObj.searchedRooms.clear(); 									// We need to empty the ArrayList for the next Search 
					}
					else
						System.out.println("What's whith you and not following Instructions? No such option exists!!");



					break;

					// ---------------------------------------------------------------------------------------


				case 4:
					if(hotelObj.bookings.size()==0)
						System.out.println("No Guests Yet\n\n");
					else 
						hotelObj.displayGuestDetails();

					break;
				}

			}while(c>0 && c<=4);


		}
		catch(Exception e) {
			System.out.println("The Program has been terminated as YOU probably(100%) didn't stick to the Basic Instructions provided at each line");
			System.out.println("You probably didn't provide the correct datatype Inputs in the correct Order");
			System.out.println("Error: "+e);
		}


		System.out.println("Thank You, Come Again !!!");


	}

}
