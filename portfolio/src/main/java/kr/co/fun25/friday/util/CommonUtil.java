package kr.co.fun25.friday.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CommonUtil {

	public static String getCareer(){
		
		Date today = new Date ( );
		Calendar cal = Calendar.getInstance ( );
		cal.setTime ( today );// 오늘로 설정. 
		 
		 
		Calendar cal2 = Calendar.getInstance ( );
		cal2.set ( 2014, 10, 10 ); // 입사일 달은 month-1
		 
		 
		int count = 0;
		while ( !cal2.after ( cal ) ){
			count++;
			cal2.add ( Calendar.DATE, 1 ); // 다음날로 바뀜
		}
				
		String year = Integer.toString(count/365);
		int intMonth = (count%365)/30;
		
		String month = (intMonth <= 0)? "1" : Integer.toString(intMonth);		
		
		return String.format("%s년 %s개월", year,month);
	}
	
	
	public static void sendMail(Map<String,Object> params){
		String webmaster = "me3602@gmail.com";
		
		Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail은 무조건 true 고정
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp 서버 주소
        p.put("mail.smtp.auth","true");                 // gmail은 무조건 true 고정
        p.put("mail.smtp.port", "587");                 // gmail 포트
           
        Authenticator auth = new MyAuthentication();
         
        //session 생성 및  MimeMessage생성
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
         
      //편지보낸시간
        try {
			msg.setSentDate(new Date());
			
			 InternetAddress from = new InternetAddress() ;
	         
	         
		        from = new InternetAddress(params.get("email").toString());
		         
		        // 이메일 발신자
		        msg.setFrom(from);
		         
		         
		        // 이메일 수신자
		        InternetAddress to = new InternetAddress(webmaster);
		        msg.setRecipient(Message.RecipientType.TO, to);
		         
		        // 이메일 제목
		        msg.setSubject(params.get("title").toString(), "UTF-8");
		         
		        // 이메일 내용 
		        msg.setText(params.get("contents").toString(), "UTF-8");
		         
		        // 이메일 헤더 
		        //msg.setHeader("content-Type", "text/html");
		         
		        //메일보내기
		        javax.mail.Transport.send(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
       
    }
 
}
 
 
class MyAuthentication extends Authenticator {
      
    PasswordAuthentication pa;
    
 
    public MyAuthentication(){
         
        String id = "me3602@gmail.com";       // 구글 ID
        String pw = "dudwls4751";          // 구글 비밀번호
 
        // ID와 비밀번호를 입력한다.
        pa = new PasswordAuthentication(id, pw);
      
    }
 
    // 시스템에서 사용하는 인증정보
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
	
	
}
