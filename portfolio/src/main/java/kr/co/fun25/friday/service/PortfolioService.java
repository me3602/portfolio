package kr.co.fun25.friday.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.fun25.friday.DAO.PortfolioDAO;

@Service("PortfolioService")
public class PortfolioService {

	@Resource(name="PortfolioDAO")
	private PortfolioDAO portfolioDAO;
	
	public void test(){		
		System.out.println(portfolioDAO.findAll().toString());
	}
	
}
