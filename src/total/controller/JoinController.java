package total.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.MethodMapTransactionAttributeSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import total.service.AddService;
import total.service.GreetService;

@Controller
public class JoinController {


	@Autowired
	GreetService greetService;
	@Autowired
	AddService addService;
	
	
	@RequestMapping(path="/login" )
	public String loginHandle(Model model) {
		
	model.addAttribute("ment",greetService.make());
		
		return "login";
	}
	
	@RequestMapping(path="/join",method=RequestMethod.GET)
	public String joinGetHandle(Model model) {
	model.addAttribute("ment",greetService.make());
	
	return "join";
	
	}
	
	@RequestMapping(path="/join",method=RequestMethod.POST)
	public String joinPostHandle(Model model, HttpSession session, @RequestParam Map<String,String> param) {
	
	boolean rst = addService.addMember(param);
	
	if(rst) {
		System.out.println("id" + param.get("id"));
		session.setAttribute("logon", param.get("id"));
		return "redirect:/login";
	}else {
		model.addAttribute("err","문제발생함");
		System.out.println("문제");
		return "join";
	}
	
	
	
	}
	
	
}
