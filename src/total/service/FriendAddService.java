package total.service;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendAddService {

	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> friendAdd() {
		return template.selectList("logon.member");
	}
	
	public boolean friendAccept() {
		return template.update("logon.accept")==1;
	}
	
	public List<Map> friend() {
		return template.selectList("logon.frend");
	}
	
	public boolean friendApply() {
		return template.insert("logon.apply")==1;
	}
	
	public boolean friendRefuse() {
		return template.delete("logon.refuse")==1;
	}
	
}
