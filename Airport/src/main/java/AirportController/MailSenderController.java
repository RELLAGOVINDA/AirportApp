package AirportController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AirportController.Service.MailService;

@Controller
public class MailSenderController {
	
	
	
	private MailService mailService;
	
	@Autowired
	public MailSenderController(MailService mailService) {
		super();
		this.mailService = mailService;
	}

	@RequestMapping("/sendmail")
	public String mailSender(@RequestParam String to,
			@RequestParam String subject,
			@RequestParam String body,Model model) {
		
		System.out.println("invoked mailSender()");
		
		boolean isValidate = mailService.mailValidate(to, subject, body);
		
		if(isValidate) {
			boolean mailSend = mailService.mailSend(to, subject, body);
			if(mailSend) {
				model.addAttribute("send","mail sent");
			}else {
				model.addAttribute("send","mail not send");
			}
		}else {
			model.addAttribute("send","invalid mail details");
		}
		return "mail.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
