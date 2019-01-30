
class Room {
	// Each time a new Room is created by Hotel, roomNo is 100, but a roomCounter in the Hotel class increments it each time
	protected int roomNo = 100; 					// This is only set for a Room object when the Room object is first is created
	protected String type;
	protected double dailyRent;
	protected boolean hasSeaView;
	protected boolean occupancyStatus;
	
	
	public int setRoom(String type, double dailyRent, boolean hasSeaView) {
		this.type = type;
		this.dailyRent = dailyRent;
		this.hasSeaView = hasSeaView;
		this.occupancyStatus = false;				// By default, whenever a Room is added it is empty
		
		return this.roomNo;
	}
	
	
}
