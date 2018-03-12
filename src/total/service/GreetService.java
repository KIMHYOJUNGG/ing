package total.service;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetService {
	@Autowired
	SqlSessionTemplate template;
	
	public String make() {
		String[] ments = "어서오세요,WELCOME".split(",");
		
		return ments[(int)(Math.random()*ments.length)];
	}
	
	public Map login(Map map) {
		
		return template.selectOne("join.getByIdmailAndPassword",map); 
	}
	
	
}
