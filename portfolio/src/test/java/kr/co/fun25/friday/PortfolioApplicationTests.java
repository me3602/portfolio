package kr.co.fun25.friday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.fun25.friday.VO.EmailVO;
import kr.co.fun25.friday.util.EmailSender;
import kr.co.fun25.friday.util.SlackUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioApplicationTests {

	
	
	@Test
	public void contextLoads() {
		//SlackUtil slack = new SlackUtil(SlackUtil.Channel.ALARM.getChannel());
		//slack.sendBotMessage("봇 테스트");
		//slack.sendInvite("stark9838@gmail.com");
		
	}
	

}
