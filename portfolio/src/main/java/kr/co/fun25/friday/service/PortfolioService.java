package kr.co.fun25.friday.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.fun25.friday.DAO.PortfolioDAO;
import kr.co.fun25.friday.VO.ResultVO;
import kr.co.fun25.friday.domain.Portfolio;
import kr.co.fun25.friday.util.SlackUtil;

@Service("PortfolioService")
public class PortfolioService {

	@Resource(name="PortfolioDAO")
	private PortfolioDAO portfolioDAO;
	
	public List<Portfolio> getAllList(){		
		return portfolioDAO.findAll();
	}
	
	public ResultVO sendSlackInvite(String email){		
		
		SlackUtil slack = new SlackUtil();
		return slack.sendInvite(email);		
	}
	
}
