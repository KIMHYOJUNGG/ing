package total.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import total.service.GreetService;

@Controller
@RequestMapping("alpha")
public class AlphaController {
	
	@Autowired
	GreetService greetService;
	
	@RequestMapping({"/index","/"})
	public String alphaHendle(Model model) {
		model.addAttribute("ment",greetService.make());
		
		return "index";
	}
	
	
}
