package AirportController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AirportController.Entity.AirportEntity;
import AirportController.Service.AirportValidate;

@Controller
public class AirportControl {
	
	AirportValidate airportValidate;
	@Autowired
	public AirportControl(AirportValidate airportValidate) {
		this.airportValidate=airportValidate;
	}
	
	
	
	public AirportControl() {
	}



	@RequestMapping("/insertAirportDetails")
	public String requestHandler(@RequestParam int id ,@RequestParam String name,@RequestParam String location,
							   @RequestParam int planes,@RequestParam int runway,Model model) {
		boolean validate = airportValidate.validate(id, name, location, planes, runway);
		
		if(validate) {
			model.addAttribute("saveEntity","Airport Details are valid & Saved in Database SuccessFully");
			return "/index.jsp";
		}else {
			model.addAttribute("Error","Airport Details are not valid");
			return "/index.jsp";
		}
	}
	
	
	@RequestMapping("/getAirportDetailsById")
	public String getAirportDetailsById(@RequestParam int id,Model model) {
		boolean validate = airportValidate.airportIdValidation(id);
		if(validate) {
			AirportEntity entity = airportValidate.getAirportEntityById(id);
			if(entity!=null) {
				model.addAttribute("Airport_id","Id");
				model.addAttribute("Airport_Name","AirportName");
				model.addAttribute("Location","Location");
				model.addAttribute("No_of_Planes","NoOfPlanes");
				model.addAttribute("no_of_Runways","Runways");
				model.addAttribute("id",entity.getAirId());
				model.addAttribute("name",entity.getName());
				model.addAttribute("location",entity.getLocation());
				model.addAttribute("planes",entity.getNoOfPlanes());
				model.addAttribute("runways",entity.getNoOfrunways());
				return "index.jsp";
			}else {
				model.addAttribute("resource","Not found Airpport Details.....");
				return "index.jsp";
			}
		}else {
			model.addAttribute("resource","invalid Airport id........");
			return "index.jsp";
		}
	}
	@RequestMapping("/getAirportDetailsByName")
	public String getAirportDetailsByName(@RequestParam String name,Model model) {
		boolean validate = airportValidate.airportNameValidation(name);
		if(validate) {
			AirportEntity entity = airportValidate.getAirportEntityByName(name);
			if(entity!=null) {
				model.addAttribute("Airport_id","Id");
				model.addAttribute("Airport_Name","AirportName");
				model.addAttribute("Location","Location");
				model.addAttribute("No_of_Planes","NoOfPlanes");
				model.addAttribute("no_of_Runways","Runways");
				model.addAttribute("id",entity.getAirId());
				model.addAttribute("name",entity.getName());
				model.addAttribute("location",entity.getLocation());
				model.addAttribute("planes",entity.getNoOfPlanes());
				model.addAttribute("runways",entity.getNoOfrunways());
				return "index.jsp";
			}else {
				model.addAttribute("resource","Not found Airpport Details.....");
				return "index.jsp";
			}
		}else {
			model.addAttribute("resource","invalid Airport Name........");
			return "index.jsp";
		}
	}
	@RequestMapping("/deleteAirportDetailsById")
	public String deleteAirportById(@RequestParam int id,Model model) {
		boolean validate = airportValidate.airportIdValidation(id);
		if(validate) {
			int i = airportValidate.deleteAirportEntityById(id);
			if(i==1) model.addAttribute("resource","Airport Details successfully delete from database");
			else model.addAttribute("resource","No such Airport....");
		}else {
			model.addAttribute("resource","invalid Airport Id........");
		}
		return "index.jsp";
	}
	
	@RequestMapping("/deleteAirportDetailsByName")
	public String deleteAirportByName(@RequestParam String name,Model model) {
		boolean validate = airportValidate.airportNameValidation(name);
		if(validate) {
			int i = airportValidate.deleteAirportEntityByName(name);
			if(i==1) model.addAttribute("resource","Airport Details successfully delete from database");
			else model.addAttribute("resource","No such Airport....");
		}else {
			model.addAttribute("resource","invalid Airport Id........");
		}
		return "index.jsp";
	}
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		
		List<AirportEntity> airports = airportValidate.getAll();
		
		
		model.addAttribute("airports",airports);
		
		return	"index.jsp";
				
	}
	
	@RequestMapping("/editAirport/{id}")
	public String editAirport(@PathVariable int id,Model model) {
		AirportEntity entity = airportValidate.getAirportEntityById(id);
		
		model.addAttribute("id",entity.getAirId());
		model.addAttribute("name",entity.getName());
		model.addAttribute("location",entity.getLocation());
		model.addAttribute("planes",entity.getNoOfPlanes());
		model.addAttribute("runways",entity.getNoOfrunways());
		return "/WEB-INF/edit.jsp";
		
		
	}
	
	@RequestMapping("/updateAirport")
	public String updateAirportById(@RequestParam int id,@RequestParam String name,
								@RequestParam String location,@RequestParam int planes,
								@RequestParam int runways,Model model) {
		System.out.println("updateAirportById() invoked");
		boolean airport = airportValidate.updateAirport(id, name, location, planes, runways);
		if(airport) {
			model.addAttribute("saveEntity","Airport Details are saved");
		}
		return "index.jsp";
	}
	
	@RequestMapping("/deleteAirport/{id}")
	public String delete(@PathVariable int id,Model model) {
		airportValidate.deleteAirportEntityById(id);
		model.addAttribute("resource","Airport Details removed From database");
		return "redirect:/getAll";
	}
	
	
	
	
	
	
	
	
}
