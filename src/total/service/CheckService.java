package total.service;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {
	
	@Autowired
	SqlSessionTemplate template;
	
	public Map  idcheck(String id) {
		
		return template.selectOne("join.lvcheck",id);
	}
	
}
