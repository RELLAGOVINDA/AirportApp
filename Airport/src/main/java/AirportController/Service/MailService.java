package AirportController.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	
	JavaMailSenderImpl javaMailSender;
	
	@Autowired
	public MailService(JavaMailSenderImpl javaMailSender) {
		super();
		this.javaMailSender = javaMailSender;
	}

	public boolean mailValidate(String to,String subject,String body) {
		boolean flag = false;
		if(to!=null && !to.isEmpty()&& !to.isBlank())
			if(subject!=null && !subject.isEmpty()&& !subject.isBlank())
				if(body!=null && !body.isEmpty()&& !body.isBlank()) {
					flag = true;
					return flag;
				}
		return false;
	}
	
	public boolean mailSend(String to,String subject,String body) {
		boolean flag=false;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(body);
		
		try {
			javaMailSender.send(simpleMailMessage);
			flag = true;
			return flag;
		} catch (MailException e) {
			System.out.println(e.getMessage()); 
			System.out.println("something went wrong");
		}
		
		return flag;
	}
	
	
	
	
	
}
