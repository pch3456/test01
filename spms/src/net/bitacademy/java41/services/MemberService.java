package net.bitacademy.java41.services;

import java.sql.Connection;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;

@Component
public class MemberService {
	MemberDao memberDao;
	DBConnectionPool dbConnectionPool;
	
	public void setDbConnectionPool(DBConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public MemberService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	public void signUp(Member member) throws Exception {
		Connection con = dbConnectionPool.getConnection();
		con.setAutoCommit(false);
		try {
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			con.commit();
			
		} catch (Exception e) {
			con.rollback();
			throw e;
			
		} finally {
			con.setAutoCommit(true);
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}
	
	public Member getMember(String email) throws Exception {
		return memberDao.get(email);
	}
	
	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
			return true;
		} else {
			return false;
		}	
	}
	
	public int deleteMember(String email) throws Exception{
		Connection con = dbConnectionPool.getConnection();
		con.setAutoCommit(false);
		try{
			memberDao.photoRemove(email, con);
			memberDao.remove2(email, con);
		    return memberDao.remove(email, con);
		} catch(Exception e){
			con.rollback();
			throw e;
		} finally{
			con.setAutoCommit(true);
			dbConnectionPool.returnConnection(con);
		}
		
		
	}

	public Member get(String email) throws Exception {
	   Member member = memberDao.get(email);
	   return member;
	}

	public void change(Member member) throws Exception {
		Connection con = dbConnectionPool.getConnection();
		con.setAutoCommit(false);
		try{
			String[] photos = member.getPhotos();
			if (photos != null) {
				for (String path : photos) {
					memberDao.photoChange(member,con, path);
				}
			}
			memberDao.change(member, con);
			con.commit();
		} catch(Exception e){
			con.rollback();
			throw e;
		} finally{
			con.setAutoCommit(true);
			dbConnectionPool.returnConnection(con);
		}
	}
}
