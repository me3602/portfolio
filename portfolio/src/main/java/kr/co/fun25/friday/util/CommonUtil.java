package kr.co.fun25.friday.util;

import java.util.Calendar;
import java.util.Date;

import kr.co.fun25.friday.VO.ResultVO;

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
	
	
	public static ResultVO makeResultVO(boolean result){
		ResultVO resultVO = new ResultVO();		
		
		if(result){
			resultVO.setResult(ConstResult.SUCCESS);
		}else{
			resultVO.setResult(ConstResult.FAIL	);
		}
		
		return resultVO;
    }
}
 
 