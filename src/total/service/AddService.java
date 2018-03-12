package total.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class AddService {
	
	@Autowired
	SqlSessionTemplate template;
	
	public boolean addMember(Map map)	{
		int add = template.insert("join.join",map);
		return add==1;
	}
	
	public boolean lvUpdate(String string)	{
		int add = template.update("join.lvUpdate",string);
		return add==1;
	}


	
	
}
