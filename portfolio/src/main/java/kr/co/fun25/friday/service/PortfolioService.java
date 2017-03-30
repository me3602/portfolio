package kr.co.fun25.friday.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.common.BitMatrix;

import kr.co.fun25.friday.DAO.PortfolioDAO;
import kr.co.fun25.friday.VO.QRCodeVO;
import kr.co.fun25.friday.VO.ResultVO;
import kr.co.fun25.friday.domain.Portfolio;
import kr.co.fun25.friday.util.QrCodeUtil;
import kr.co.fun25.friday.util.SlackUtil;

@Service("PortfolioService")
public class PortfolioService {

	@Resource(name="PortfolioDAO")
	private PortfolioDAO portfolioDAO;
	
	@Resource(name="QrCodeUtil")
	private QrCodeUtil qrCodeUtil;
	
	public List<Portfolio> getAllList(){		
		return portfolioDAO.findAll();
	}
	
	public ResultVO sendSlackInvite(String email){		
		
		SlackUtil slack = new SlackUtil();
		return slack.sendInvite(email);		
	}
	
	public BitMatrix getQRMatrix(QRCodeVO params){			
		return qrCodeUtil.makeQRMatrix(params.getUrl(), params.getWidth(), params.getHeight());		
	}
	
	public MatrixToImageConfig getQRColor(QRCodeVO params){			
		return qrCodeUtil.makeColorConfig(params.getQrColor(), params.getBackColor());
	}
	
}
