package LeaseManagementSystem;

public class Add {
	private int apartmentID;
	private String apartmentNo;
	private int maxPeople;
	private int rent;
	private int deposit;
	private String type;
	private String facility;
	boolean vacant;
	public int getApartmetnID() {
		return apartmentID;
	}
	public void setApartmetnID(int apartmetnID) {
		this.apartmentID = apartmetnID;
	}
		
	public Add(String apartmentNo, int maxPeople, int rent, int deposit, String type, String facility, boolean vacant) {
		super();
		this.apartmentNo = apartmentNo;
		this.maxPeople = maxPeople;
		this.rent = rent;
		this.deposit = deposit;
		this.type = type;
		this.facility = facility;
		this.vacant = vacant;
	}
	public String getApartmentNo() {
		return apartmentNo;
	}
	public void setApartmentNo(String apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public boolean isVacant() {
		return vacant;
	}
	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}
}
