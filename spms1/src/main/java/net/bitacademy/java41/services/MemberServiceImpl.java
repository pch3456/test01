package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired 
	MemberDao memberDao;
	@Autowired    
	DBConnectionPool dbConnectionPool;

	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void signUp(Member member) throws Exception {
		try {
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				HashMap<String,String> paramMap = new HashMap<String,String>();
				String email = member.getEmail(); 
				paramMap.put("email", email);
				for (String path : photos) {
					paramMap.put("path", path);
					memberDao.addPhoto(paramMap);
				}
			}

		} catch (Exception e) {
			throw e;

		} finally {

		}
	}

	public List<Member> getMemberList() throws Exception {
		return memberDao.list();

	}

	public Member getMember(String email) throws Exception {
		Member member = memberDao.get(email);
		String[] photo = {memberDao.getPhoto(email)};
		if(photo[0] !=null){
		member.setPhotos(photo);
		}
		return member; 

	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
        paramMap.put("email", email);
        paramMap.put("oldPassword", oldPassword);
        paramMap.put("newPassword", newPassword);
		
		if (memberDao.changePassword(paramMap) > 0) {
			return true;
		} else {
			return false;
		}   

	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public int deleteMember(String email) throws Exception{
		try{
			memberDao.photoRemove(email);
			memberDao.remove2(email);
			return memberDao.remove(email);

		} catch(Exception e){

			throw e;
		} finally{

		}


	}

	public Member get(String email) throws Exception {
		Member member = memberDao.get(email);
		return member;

	}

	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void change(Member member) throws Exception {

		try{
			
//			memberDao.add(member);
//			String[] photos = member.getPhotos();
//			if (photos != null) {
//				HashMap<String,String> paramMap = new HashMap<String,String>();
//				String email = member.getEmail(); 
//				paramMap.put("email", email);
//				for (String path : photos) {
//					paramMap.put("path", path);
//					memberDao.addPhoto(paramMap);
//				}
//			}
			memberDao.change(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				HashMap<String,String> paramMap = new HashMap<String,String>();
				String email = member.getEmail();
				for (String path : photos) {
					paramMap.put("email", email);
		            paramMap.put("path", path);
		            memberDao.photoRemove(paramMap);
					memberDao.addPhoto(paramMap);
				}
			}
			

		} catch(Exception e){

			throw e;
		} finally{

		}
	}

}