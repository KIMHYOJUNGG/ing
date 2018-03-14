package total.controller;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import total.model.WebSocketMap;

@Controller("alertController")
public class AlertController  extends TextWebSocketHandler{

	// 웹소켓 커넥션이 열릴때, 세션을 키로 해서 묶어서 관리를 하려고 함
	@Autowired
	WebSocketMap sessions;
	
	/*
	@PostConstruct
	public void init()	{
		sessions = new HashMap<>();
	}
	*/
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// HttpSession 을 접근해서 정보를 얻어와야함..그냥은 안되고.
		// HttpSessionHandshakeInterceptor를 설정해두면, 
		// spring이 이 메서드를 호출할때, 이 클라이언트가 사용중이던 HttpSession의 setAttributes
		// 되어있는 값들을 WebSocketSession에서 뽑아다 쓸수 있게 넣어줌.
		// 그러면서 추가로, "HTTP.SESSION.ID"라는 키로 사용중인 session id도 넣어주고,
		Map<String,Object> map = session.getAttributes();
		System.out.println(map);
		System.out.println("AlertController.ConnectionEstablished"+session);
		String key = (String)session.getAttributes().get("HTTP.SESSION.ID");		
		if(!sessions.containsKey(key))
			sessions.put(key, new ArrayList<>());
		sessions.get(key).add(session);
				
		for(String k : sessions.keySet() ) {
			int size = sessions.get(k).size();
			System.out.println("??" + k+" ("+size+")" );
		}

		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String key = (String)session.getAttributes().get("HTTP.SESSION.ID");
		sessions.get(key).remove(session);
		if(	sessions.get(key).isEmpty()) {
			sessions.remove(key);
		}
		
		
	}
	
	
	
	
}
