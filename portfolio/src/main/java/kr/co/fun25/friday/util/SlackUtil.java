package kr.co.fun25.friday.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

/**
 * 슬랙 유틸 클래스 
 * 채널 변수 기본 값은 알람 채널
 * 
 * @author 천영진
 *
 */
public class SlackUtil {

	private String url = "https://hooks.slack.com/services/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";
	private String botName = "Friday Bot";
	private String botImg = "http://friday.fun25.co.kr/image/portfolio/robot.png";
	private String token = "xoxp-111206116549-111195793460-111212981701-f5040e775203eea31e89e98f9b3efbd4";
	
	private String channel = Channel.ALARM.getChannel();
	
	//채널 enum
	public static enum Channel{		
		ALARM("#alarm"),
		GENERAL("#general");
		
		private String channelName;
		
		Channel(String channelName){
			this.channelName = channelName;
		};
		
		public String getChannel(){
			return this.channelName;
		}
		
	}
	
	
	public SlackUtil(){};	
	public SlackUtil(String channel){
		this.channel = channel;		
	};
	
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
	
	/**
	 * 슬랙 웹 API 전송 메서드
	 * @param data
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
}
