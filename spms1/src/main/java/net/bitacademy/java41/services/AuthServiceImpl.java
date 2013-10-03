package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.LoginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired
	MemberDao memberDao;
	
	public LoginInfo getLoginInfo(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);
		LoginInfo loginInfo = memberDao.getLoginInfo(paramMap);
		loginInfo.setPhotoPath(memberDao.getPhoto(email));
		
		return loginInfo;
	}
}
