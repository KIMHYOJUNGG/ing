package total.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.MethodMapTransactionAttributeSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;

import total.model.LogonMembers;
import total.model.WebSocketMap;
import total.service.AddService;
import total.service.CheckService;
import total.service.GreetService;

@Controller
public class JoinController {

	@Autowired
	GreetService greetService;
	@Autowired
	AddService addService;
	@Autowired
	CheckService checkService;
	@Autowired
	WebSocketMap sessions;
	@Autowired
	LogonMembers logonMembers;
	

	@RequestMapping(path = "/login")
	public String greetHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "login";
	}

	@RequestMapping(path = "/join", method = RequestMethod.GET)
	public String joinGetHandle(Model model) {
		model.addAttribute("ment", greetService.make());
		return "join";

	}

	@RequestMapping(path = "/logincheck")
	public String loginHandle(@RequestParam Map map, HttpSession session) {
		if (greetService.login(map) == null) {
			return "login";
		} else {
			session.setAttribute("logon", map.get("id"));
			return "t_index";
		}

	}
	
	@RequestMapping(path = "/logout")
	public String logoutHandle(@RequestParam Map map, HttpSession session) {
			session.removeAttribute((String) session.getAttribute("logon"));
			return "t_index";
		
	}

	@RequestMapping(path = "/join", method = RequestMethod.POST)
	public String joinPostHandle(Model model, HttpSession session, @RequestParam Map<String, String> param) {

		boolean rst = addService.addMember(param);

		if (rst) {
			session.setAttribute("email", param.get("email"));
			session.setAttribute("pass", param.get("pass"));
			session.setAttribute("logon", param.get("id"));
			List<WebSocketSession> s = sessions.get(session.getId());
			if (s!=null) {
				for (WebSocketSession ws : s) {
					try {
						Gson gson = new Gson();
						Map map = new HashMap<>();
						map.put("warn", "변경");
						String str = gson.toJson(map);
						ws.sendMessage(new TextMessage(str));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			return "redirect:/login";
		} else {
			model.addAttribute("err", "문제발생함");
			System.out.println("문제");
			return "join";
		}
	}

	@RequestMapping("/chat")
	public String chatHandle(Model model, HttpSession session) {

		if ((String) session.getAttribute("logon") != null) {
			Map id = checkService.idcheck((String) session.getAttribute("logon"));
			if (id.get("LV").toString().equals("1")) {
				return "chat";
			} else {
				return "certify";
			}
		} else {
			return "login";
		}

	}

	@RequestMapping("/auth")
	public String authHandle(Model model, HttpSession session) {

		boolean id = addService.lvUpdate((String) session.getAttribute("logon"));
		if (id == true) {
			return "chat";
		} else {
			return "certify";
		}

	}
}
