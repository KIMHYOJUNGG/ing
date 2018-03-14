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
	
	public List<Map> friendAccept() {
		return template.selectList("logon.accept");
	}
	
	public List<Map> friend() {
		return template.selectList("logon.accept");
	}
	
	
}
