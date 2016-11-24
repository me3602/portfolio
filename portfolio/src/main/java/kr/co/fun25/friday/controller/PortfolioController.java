package kr.co.fun25.friday.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fun25.friday.service.PortfolioService;

@RestController
@RequestMapping(value="/portfolio")
public class PortfolioController {

	@Resource(name = "PortfolioService")
	private PortfolioService portfolioService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView getIntro(ModelAndView mav){
		
		mav.addObject("LIST", portfolioService.getAllList());
		
		mav.setViewName("portfolio/list");
		return mav;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public ModelAndView getProfile(ModelAndView mav){
		
		mav.setViewName("portfolio/profile");
		return mav;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView getTest(ModelAndView mav){
		
		
		mav.setViewName("portfolio/test");
		return mav;
	}
}
