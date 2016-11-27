package kr.co.fun25.friday.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fun25.friday.service.PortfolioService;
import kr.co.fun25.friday.util.CommonUtil;

@RestController
@RequestMapping(value="/apps/portfolio")
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
		
		mav.addObject("CAREER", CommonUtil.getCareer());
		
		mav.setViewName("portfolio/profile");
		return mav;
	}
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public Map<String,Object> sendMail(@RequestParam Map<String,Object> params){
		
		
		CommonUtil.sendMail(params);
		
		return params;
	}
	
	@RequestMapping(value="/lab", method=RequestMethod.GET)
	public ModelAndView getLab(ModelAndView mav){
		
		
		mav.setViewName("portfolio/Lab");
		return mav;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView getTest(ModelAndView mav){
		
		
		mav.setViewName("portfolio/test");
		return mav;
	}
	
	
}
