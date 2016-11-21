package kr.co.fun25.friday.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/portfolio")
public class PortfolioController {

	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public ModelAndView getIntro(ModelAndView mav){
		
		System.out.println("tttt");
		
		mav.setViewName("portfolio/intro");
		return mav;
	}
}
