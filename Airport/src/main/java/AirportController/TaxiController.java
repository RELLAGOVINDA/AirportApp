package AirportController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AirportController.Entity.Taxi;
import AirportController.Service.TaxiService;

@Controller
public class TaxiController {
	
	TaxiService taxiService;
	
	@Autowired
	public TaxiController(TaxiService taxiService) {
		super();
		this.taxiService = taxiService;
	}

	@RequestMapping("/saveTaxi")
	public String savetaxi(@RequestParam int id,@RequestParam String dName,
			@RequestParam int mNumber,@RequestParam int tNumber,@RequestParam String ac,Model model) {
		System.out.println("savetaxi() is invoked in controller Class");
		
		boolean valid = taxiService.taxivalidation(id, dName, mNumber, tNumber, ac);
		if(valid) {
			taxiService.saveTaxi(id, dName, mNumber, tNumber, ac);
			model.addAttribute("save","taxi details Stored in database");
		}else {
			model.addAttribute("save","invalid taxi details");
		}
		
		return "taxi.jsp";
	}
	
	
	@RequestMapping("/searchTaxibyId")
	public String searchTaxiById(@RequestParam int id,Model model) {
		boolean isValidation = taxiService.idValidation(id);
		if(isValidation) {
			List<Taxi> taxi = taxiService.searchTaxiById(id);
			if(!taxi.isEmpty()) {
				model.addAttribute("list", taxi);
			}
				
			else {
				model.addAttribute("save", "No Such Taxies");
			}
		}else {
			model.addAttribute("save", "invalid id...");
		}
		
		
		return "taxi.jsp";
	}
	
	@RequestMapping("/editTaxi/{name}")
	public String editTaxi(@PathVariable String name,Model model) {
		System.out.println("editTaxi() invoked ..."+name );
		Taxi taxi = taxiService.getTaxiByName(name);
		if(taxi != null) {
			model.addAttribute("id",taxi.getAirId());
			model.addAttribute("name",taxi.getdName());
			model.addAttribute("mobile",taxi.getMobile());
			model.addAttribute("taxiNum",taxi.gettNumber());
			model.addAttribute("type",taxi.gettType());
		}else {
			model.addAttribute("save", "no such Taxi...");
		}
		return "/WEB-INF/editTaxi.jsp";
	}
	
	
	@RequestMapping("/upadteTAxiDetails")
	public String updateTaxiByName(@RequestParam int id,@RequestParam String dName,
			@RequestParam int mNumber,@RequestParam int tNumber,@RequestParam String ac,Model model) {
		System.out.println("updateTaxiByName() invoked");
		boolean isvalid = taxiService.updateTaxi(id, dName, mNumber, tNumber, ac);
		if(isvalid) {
			model.addAttribute("save", "update taxi details successfully");
		}else {
			model.addAttribute("save", "something went wrong");
		}
		
		return "taxi.jsp";
	}
	
	
	
	
	
	
}
