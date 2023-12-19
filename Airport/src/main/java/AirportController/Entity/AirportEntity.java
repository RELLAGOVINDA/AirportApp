package AirportController.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Airport")
@Entity
public class AirportEntity {
	
	@Id
	@Column(name="airId")
	int airId;
	
	@Column(name="name")
	String name;
	
	@Column(name="location")
	String location;
	
	
	@Column(name="noofplane")
	int noOfPlanes;
	
	
	@Column(name="runway")
	int noOfrunways;



	public AirportEntity() {
	}



	public AirportEntity(int airId, String name, String location, int noOfPlanes, int noOfrunways) {
		super();
		this.airId = airId;
		this.name = name;
		this.location = location;
		this.noOfPlanes = noOfPlanes;
		this.noOfrunways = noOfrunways;
	}



	public int getAirId() {
		return airId;
	}



	public void setAirId(int airId) {
		this.airId = airId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public int getNoOfPlanes() {
		return noOfPlanes;
	}



	public void setNoOfPlanes(int noOfPlanes) {
		this.noOfPlanes = noOfPlanes;
	}



	public int getNoOfrunways() {
		return noOfrunways;
	}



	public void setNoOfrunways(int noOfrunways) {
		this.noOfrunways = noOfrunways;
	}
	
	
	
	
}
