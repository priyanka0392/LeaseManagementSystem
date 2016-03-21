package LeaseManagementSystem;

import java.util.ArrayList;
import java.util.Date;

import LeaseManagementSystem.Add;
import LeaseManagementSystem.UserDetails;

public class appointment {
	private int appointId;
	private UserDetails user;
	private Add apartment;
	private Date appointDate;
	private String status;
	private ArrayList<Date> ruledDate=new ArrayList<Date>();
	public appointment(int appointId, UserDetails user, Add apartment, Date appointDate, String status,
			ArrayList<Date> ruledDate) {
		super();
		this.appointId = appointId;
		this.user = user;
		this.apartment = apartment;
		this.appointDate = appointDate;
		this.status = status;
		this.ruledDate = ruledDate;
	}
	public int getAppointId() {
		return appointId;
	}
	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Add getApartment() {
		return apartment;
	}
	public void setApartment(Add apartment) {
		this.apartment = apartment;
	}
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Date> getRuledDate() {
		return ruledDate;
	}
	public void setRuledDate(ArrayList<Date> ruledDate) {
		this.ruledDate = ruledDate;
	}
}
