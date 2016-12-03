package kr.co.fun25.friday.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kr.co.fun25.friday.VO.ResultVO;

/**
 * 슬랙 유틸 클래스 
 * 채널 변수 기본 값은 알람 채널
 * 
 * @author 천영진
 *
 */
public class SlackUtil {

	private final String client_id = "111206116549.111812259639";
	private final String client_secret = "c2e294b5cd0f44df9a979aa9f4782205";
	private final String code = "111206116549.112885559174.b0e9fe76e9";
	private String url = "https://hooks.slack.com/services/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";
	private String botName = "Friday Bot";
	private String botImg = "http://friday.fun25.co.kr/image/portfolio/robot.png";
	private String token = "xoxp-111206116549-111195793460-112287327988-454c4f7bffb7b7416634242227698aa2";
	
	private String channel = Channel.ALARM.getChannel();
	
	//채널 enum
	public static enum Channel{		
		ALARM("#alarm","G393SETEE"),
		GENERAL("#general","C395RPECU");
		
		private String channelName;
		private String id;
		
		Channel(String channelName, String id){
			this.channelName = channelName;
			this.id = id;
		};
		
		public String getChannel(){
			return this.channelName;
		}
		
		public String getID(){
			return this.id;
		}
		
	}
	
	
	public SlackUtil(){};	
	public SlackUtil(String channel){
		this.channel = channel;		
	};
		
	public ResultVO sendInvite(String email){
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("email", email);
		data.put("channels", Channel.GENERAL.getID());
		data.put("token", this.token);
		
		JSONObject result = sendDatatoAPI("https://fridayit.slack.com/api/users.admin.invite",data);
		
		
		ResultVO resultVO = new ResultVO();
		boolean stat = Boolean.parseBoolean(result.get("ok").toString());
		
		if(stat){
			resultVO.setResult(ConstResult.SUCCESS);
		}else{
			resultVO.setResult(ConstResult.FAIL);
			
			if(result.containsKey("error")){
				resultVO.setReason(result.get("error").toString());
			}else{
				resultVO.setReason(result.get("reason").toString());
			}
			
		}
		
		return resultVO;
	}
	
	
	/**
	 * 슬랙 봇 메시지 전송 메서드
	 * @param text 
	 * @return boolean
	 */
	public boolean sendBotMessage(String text){
		JSONObject data = new JSONObject();
		data.put("channel", this.channel);
		data.put("text", text);
		data.put("username", botName);
		data.put("icon_url", botImg);
		
		return this.sendJSONDatatoAPI(this.url,data);		
	}
	
	/*
	public void setToken(){
		String url = "https://slack.com/api/oauth.access";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("client_id", client_id);
		params.put("client_secret", client_secret);
		params.put("code", code);
		
		System.out.println(this.sendDatatoAPI(url, params).toString());
	}*/
	
	/**
	 * 슬랙 웹 API 전송 메서드 (JSON 이용)
	 * @param url, data
	 * @return boolean
	 */
	private boolean sendJSONDatatoAPI(String url, JSONObject data){
		String result = "";
		
		OutputStreamWriter wr = null;
		BufferedReader buf = null;
		try {
			URL sendURL = new URL(url);
			
			URLConnection conn = sendURL.openConnection();
			
			conn.setDoOutput(true);
			conn.setUseCaches(false);			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			
			
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data.toString());
			wr.flush();
			
			buf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			while((line = buf.readLine()) != null){
				result += line;
			}
			
			System.out.println(result);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			result = "fail";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "fail";
		} finally{
			try {
				wr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = "fail";
			}
		}
		
		if(result.equals("ok")){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 슬랙 웹 API 전송 메서드
	 * @param url, data
	 * @return JSONObject
	 */
	private JSONObject sendDatatoAPI(String url, Map<String, Object> params){
		JSONObject result = new JSONObject();
		
		String data = "";
		Iterator<String> keys = params.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			try {
				
				data += key + "=" + URLEncoder.encode(params.get(key).toString(),"UTF-8") + "&";
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		data = data.replaceAll("&$", "");
		
		OutputStreamWriter wr = null;
		BufferedReader buf = null;
		try {
			URL sendURL = new URL(url);
			
			URLConnection conn = sendURL.openConnection();
			
			conn.setDoOutput(true);
			conn.setUseCaches(false);			
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data.toString());
			wr.flush();
			
			buf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = "";
			String returnStr = "";
			while((line = buf.readLine()) != null){
				returnStr += line;
			}			
			
			result = (JSONObject)new JSONParser().parse(returnStr);			
			
			
		} catch (MalformedURLException e) {
			result.put("ok", false);
			result.put("reason", e.getMessage());
		} catch (IOException e) {
			result.put("ok", false);
			result.put("reason", e.getMessage());
		} catch (ParseException e) {
			result.put("ok", false);
			result.put("reason", e.getMessage());
		} finally{
			try {
				wr.close();
			} catch (IOException e) {
				result.put("ok", false);
				result.put("reason", e.getMessage());
			}
		}
		
		return result;
		
	}
}
