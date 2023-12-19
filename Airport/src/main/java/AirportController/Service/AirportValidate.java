package AirportController.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import AirportController.DAO.AirportDAO;
import AirportController.Entity.AirportEntity;

@Component
public class AirportValidate {
	
	AirportDAO airportDAO;
	
	
	@Autowired
	public AirportValidate(AirportDAO airportDAO) {
		super();
		this.airportDAO = airportDAO;
	}

	public AirportValidate() {
	}

	public boolean validate(int airId,String name,String location,int planes,int runway) {
		if(!(airId>0)) {
			return false;
		}if(!(name!=null && !name.isEmpty())) {
			return false;
		}
		if(!(location!=null && !location.isEmpty())) {
			return false;
		}
		if(!(planes>0)) {
			return false;
		}if(!(runway>0)) {
			return false;
		}
		
		AirportEntity airport = new AirportEntity(airId,name,location,planes,runway);
		airportDAO.saveAirportEntity(airport);
		return true;
	}
	public AirportEntity  getAirportEntityById(int id) {
		return airportDAO.getAirportEntityById(id);
	}
	
	public boolean airportIdValidation(int id) {
		return id>0;
	}
	public boolean airportNameValidation(String name) {
		if(!(name!=null && !name.isEmpty())) {
			return false;
		}
		return true;
	}
	
	public AirportEntity  getAirportEntityByName(String name) {
		return airportDAO.getAirportEntityByName(name);
	}
	public int deleteAirportEntityById(int id) {
		return airportDAO.deleteAirportEntityById(id);
	}
	public int deleteAirportEntityByName(String name) {
		return airportDAO.deleteAirportEntityByName(name);
	}
	
	
	public List<AirportEntity> getAll() {
		return airportDAO.getAll();
	}
	
	public boolean updateAirport(int airId,String name,String location,int planes,int runway) {
		AirportEntity entity = new AirportEntity(airId, name, location, planes, runway);
		boolean airport = airportDAO.updateAirport(entity);
		return airport;
	}
	
	
	
}
