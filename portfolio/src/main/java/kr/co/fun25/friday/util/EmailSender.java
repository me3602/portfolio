package kr.co.fun25.friday.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import kr.co.fun25.friday.VO.EmailVO;

@Component("EmailSender")
public class EmailSender {
	
	@Autowired
    protected JavaMailSender mailSender;
	
	public boolean send(EmailVO emailVO){
		
		final EmailVO email = emailVO;
		MimeMessagePreparator preparator = new MimeMessagePreparator(){
			
			@Override
			public void prepare(MimeMessage msg) throws Exception {
				msg.setSubject(String.format("[%s] %s", email.getName(),email.getTitle()));
				msg.setText(String.format("%s\n[회신받을 주소 : %s]", email.getContents(),email.getAddr()));
				msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("me3602@gmail.com"));
				//msg.setFrom(new InternetAddress(email.getAddr()));
			}
			
		};
		
		try{
			mailSender.send(preparator);
			return true;
		}catch(Exception e){			
			e.printStackTrace();
			return false;
		}		
	}

}
