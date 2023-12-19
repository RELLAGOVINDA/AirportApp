package AirportController.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;




@Table(name="Taxi")
@Entity
public class Taxi {
	
	@JoinColumn(name="airId")
	int airId ;
	
	@Column(name="driverName")
	String dName;
	
	@Column(name="mobile")
	int mobile;
	
	@Id
	@Column(name="TaxiNumber")
	int tNumber;
	
	@Column(name="type")
	String tType;

	public Taxi() {
	}

	public Taxi(int airId, String dName, int mobile, int tNumber, String tType) {
		super();
		this.airId = airId;
		this.dName = dName;
		this.mobile = mobile;
		this.tNumber = tNumber;
		this.tType = tType;
	}

	public int getAirId() {
		return airId;
	}

	public void setAirId(int airId) {
		this.airId = airId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int gettNumber() {
		return tNumber;
	}

	public void settNumber(int tNumber) {
		this.tNumber = tNumber;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	
	
	
	
}
