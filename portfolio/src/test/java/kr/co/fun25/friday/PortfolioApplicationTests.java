package kr.co.fun25.friday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.fun25.friday.VO.EmailVO;
import kr.co.fun25.friday.util.EmailSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioApplicationTests {

	@Autowired
	EmailSender sender;
	
	@Test
	public void contextLoads() {
		EmailVO emailVO = new EmailVO();
		emailVO.setAddr("me3602@naver.com");
		emailVO.setTitle("제목");
		emailVO.setContents("내용");
		
		/*EmailSender e = new EmailSender();
		e.send(emailVO);*/
		
		sender.send(emailVO);
	}
	

}
