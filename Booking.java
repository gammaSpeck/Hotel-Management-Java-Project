
class Booking {
	protected int roomNo;
	protected String guestName;
	protected String guestEmail;
	protected int noOfDays;
	protected double guestBill;						// Not really required, but Meh
	
	
	public double bookRoom(int roomNo, String guestName, String guestEmail, int noOfDays) {
		this.roomNo = roomNo;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.noOfDays = noOfDays;
		
		
		return this.guestBill;
	}
}
