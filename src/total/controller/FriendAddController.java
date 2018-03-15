package total.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import total.service.FriendAddService;

@Controller
public class FriendAddController {

	@Autowired
	FriendAddService friendAddService;
	
	@RequestMapping("friendAdd")
	public String addHandle(Model model) {
		List<Map> list = friendAddService.friendAdd();
		model.addAttribute("list",list);
		return "friend";
	}
	
	@RequestMapping("accept")
	public String acceptHandle(Model model) {
		boolean accept = friendAddService.friendAccept();
		model.addAttribute("accept", accept);
		return "friendList";
		
	}
	
	@RequestMapping("insert")
	public String insertHandle(Model model) {
		boolean accept = friendAddService.friendApply();
		model.addAttribute("accept", accept);
		return "friendList";
		
	}
	
	
}
