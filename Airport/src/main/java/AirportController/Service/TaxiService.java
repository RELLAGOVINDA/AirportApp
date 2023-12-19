package AirportController.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import AirportController.DAO.TaxiDAO;
import AirportController.Entity.Taxi;
import java.util.List;
@Component
public class TaxiService {
	TaxiDAO taxidao;
	
	@Autowired
	public TaxiService(TaxiDAO taxidao) {
		super();
		this.taxidao = taxidao;
	}
	
	public boolean taxivalidation(int id,String dName,int mNumber,int tNumber,String ac) {
		if(id>0) {
			if(dName!=null && !dName.isEmpty() && !dName.isBlank()) {
				if(mNumber>0) {
					if(tNumber>0) {
						if(ac!=null && !ac.isBlank() && !ac.isEmpty()) {
							return true;
						}else {
							return false;
						}
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean saveTaxi(int id,String dName,int mNumber,int tNumber,String ac) {
		Taxi taxi = new Taxi(id, dName, mNumber, tNumber, ac);
		return taxidao.saveTaxi(taxi);
	}
	
	
	
	public boolean idValidation(int id) {
		return id>0;
	}

	public List<Taxi> searchTaxiById(int id){
		return taxidao.searchTaxiById(id);
	}
	
	
	
	public Taxi getTaxiByName(String name) {
		return taxidao.getTaxiByName(name);
	}
	
	public boolean updateTaxi(int id,String dName,int mNumber,int tNumber,
							String ac) {
		Taxi taxi = new Taxi(id, dName, mNumber, tNumber, ac);
		return taxidao.updateTaxi(taxi);
	}
	
	
	
	
	
	
	
	
	
	
	
}
