package total.controller;

import java.util.LinkedHashSet;
import java.util.*;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
/*
 * ws 통신을 제어할 용도의 컨트롤러
 *  1. WebSocketHandler (I) 를 Implements걸어서 목적에 개조해서 사용
 *  2. 목적에 맞는 WebSocketHandler를 extends 걸어서 사용
 *  	- TextWebSocketHandler / BinaryWebSocketHandler
 *  
 *  WebsSocket Handler 의 매핑은, spring 설정파일에.
 *  
 */
@Controller("wsController")  //자동등록(scan : 클래스명으로 바뀌어서 등록됨)되는 이름을 변경할시에 괄호안에 적음.
public class WSController extends TextWebSocketHandler {
		
		Set<WebSocketSession> wsSessions;
		
		@PostConstruct	// init-method (자동등록될때)
		public void init() {
			wsSessions = new LinkedHashSet<>();
			
		}
	
		
		@Override   // 클라이언트측에서 웹소켓 연결이 되었을때 
		public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			System.out.println("afterConnectionEstablished"+session);
			System.out.println(session.getRemoteAddress().getAddress().getHostAddress());	// ip
			wsSessions.add(session);
			Gson gson = new Gson();
			Map map = new HashMap();
			map.put("cnt", wsSessions.size());
			map.put("info",session.getRemoteAddress().getAddress().getHostAddress()+"가 들어왔습니다.");
			String str = gson.toJson(map);
			for(WebSocketSession ws : wsSessions) {
			ws.sendMessage(new TextMessage(str));     // httpsesssion과 다른 객체임
			}
			System.out.println("current size : " + wsSessions.size());

		}
		
		@Override	// 클라이언트측에서 메세지가 들어올때 
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			System.out.println("handleTextMessage"+session+"/"+message);
		}
		
		@Override	// 클라이언트측과 연결이 해제될때 
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			System.out.println("afterConnectionClosed"+session);
			wsSessions.remove(session);
			Gson gson = new Gson();
			Map map = new HashMap();
			map.put("data", "close");
			map.put("cnt", wsSessions.size());
			map.put("info",session.getRemoteAddress().getAddress().getHostAddress()+"가 나갔습니다.");
			String str = gson.toJson(map);
			for(WebSocketSession ws : wsSessions) {
				ws.sendMessage(new TextMessage(str));     // httpsesssion과 다른 객체임
				}
		}
	
	
}
