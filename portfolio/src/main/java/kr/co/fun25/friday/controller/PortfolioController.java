package kr.co.fun25.friday.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fun25.friday.VO.EmailVO;
import kr.co.fun25.friday.VO.ResultVO;
import kr.co.fun25.friday.service.PortfolioService;
import kr.co.fun25.friday.util.CommonUtil;
import kr.co.fun25.friday.util.EmailSender;

@RestController
@RequestMapping(value="/apps/portfolio")
public class PortfolioController {

	@Resource(name = "PortfolioService")
	private PortfolioService portfolioService;
	
	@Resource(name = "EmailSender")
	private EmailSender emailSender;
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public ModelAndView getIntro(ModelAndView mav){
		
		mav.setViewName("portfolio/intro");
		return mav;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView getList(ModelAndView mav){
		
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
	
	@RequestMapping(value="/lab", method=RequestMethod.GET)
	public ModelAndView getLab(ModelAndView mav){
		
		
		mav.setViewName("portfolio/lab");
		return mav;
	}
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
	public ModelAndView getSlack(ModelAndView mav){		
		
		mav.setViewName("portfolio/chat");
		return mav;
	}
	
	@RequestMapping(value="/sock", method=RequestMethod.GET)
	public ModelAndView getSockPage(ModelAndView mav){
		
		mav.setViewName("portfolio/sock");
		return mav;
	}
	
	@RequestMapping(value="/test/{id}", method=RequestMethod.GET)
	public ModelAndView getTest(ModelAndView mav, @PathVariable String id){
		
		
		mav.setViewName("portfolio/test/"+id);
		return mav;
	}
	
	
	/* ajax 처리 컨트롤러 */
	
	@RequestMapping(value="/sendMail", method=RequestMethod.POST)
	public ResultVO sendMail(EmailVO emailVO){		
		
		return CommonUtil.makeResultVO(emailSender.send(emailVO));
	}
	
	@RequestMapping(value="/invite", method=RequestMethod.POST)
	public ResultVO sendInvite(@RequestParam(value="email") String email){
		
		return portfolioService.sendSlackInvite(email);		
	}
	
	
}
