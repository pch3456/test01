package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.vo.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class MemberDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public MemberDao() {	}
	
	public Member getMember(String email, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			
			Member member = sqlSession.selectOne(
				"net.bitacademy.java41.dao.MemberMapper.getMember",
				paramMap);
			
			String photo = sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.getPhoto",email);
			if(photo!=null){
				String[] temp = new String[]{photo};
				member.setPhotos(temp);
			}
			return member;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}
	
//	private List<Photo> listPhoto(String email) throws Exception {
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		
//		try{
//			con = conPool.getConnection();
//			stmt = con.prepareStatement(
//				"select INO,IMGURL from SPMS_MEMIMG"
//				+ " where EMAIL=?"); 
//			stmt.setString(1, email);
//			rs = stmt.executeQuery();
//			
//			ArrayList<Photo> list = new ArrayList<Photo>();
//			while (rs.next()) {
//				list.add(new Photo()
//						.setNo(rs.getInt("INO"))
//						.setEmail(email)
//						.setFilename(rs.getString("IMGURL")));
//			}
//			
//			return list;
//		} catch(Exception e){
//			throw e;
//		} finally{
//			try {rs.close();} catch (Exception e) {}
//			try {stmt.close();} catch (Exception e) {}
//			if (con != null) {
//				conPool.returnConnection(con);
//			}
//		}
//	}
//
	public int add(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.add", member);
			sqlSession.commit();
			
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public List<Member> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.MemberMapper.list");
		} catch (Exception e) {
			
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}

	public Member get(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			Member member = sqlSession.selectOne(
						"net.bitacademy.java41.dao.MemberMapper.get",email);
			
			String photo = sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.getPhoto",email);
			if(photo!=null){
				String[] temp = new String[]{photo};
				member.setPhotos(temp);
			}
			
			return member;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
			
		}
	}
	
    public int changePassword(
            String email, String oldPassword, String newPassword) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            HashMap<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("email", email);
            paramMap.put("oldPassword", oldPassword);
            paramMap.put("newPassword", newPassword);
            int count = sqlSession.update(
                    "net.bitacademy.java41.dao.MemberMapper.changePassword", paramMap);
            sqlSession.commit();
            return count;
 
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
         
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
             
        }
    }
	
    public int change(Member member) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            int count = sqlSession.update(
                    "net.bitacademy.java41.dao.MemberMapper.change", member);
            sqlSession.commit();
            return count;
             
 
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
         
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
             
        }
    }
    public int photoChange(Member member, String photo) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            HashMap<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("member", member);
            paramMap.put("photo", photo);
             
            int count = sqlSession.update(
                    "net.bitacademy.java41.dao.MemberMapper.photoChange", paramMap);
            sqlSession.commit();
            return count;
 
        } catch (Exception e) {
            throw e;
         
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
             
        }
    }
     
    public int remove(String email) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            int count = sqlSession.delete(
                    "net.bitacademy.java41.dao.MemberMapper.remove", email);
                     
            sqlSession.commit();
            return count;
             
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
             
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
        }
    }
     
    public int remove2(String email) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            int count = sqlSession.delete(
                    "net.bitacademy.java41.dao.MemberMapper.remove2", email);
                     
            sqlSession.commit();
            return count;
             
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
             
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
             
        }
    }
     
    public int photoRemove(String email) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         
        try {
            int count = sqlSession.delete(
                    "net.bitacademy.java41.dao.MemberMapper.photoRemove", email);
                     
            sqlSession.commit();
            return count;
        } catch (Exception e) {
            sqlSession.rollback();
            throw e;
             
        } finally {
            try {sqlSession.close();} catch(Exception e) {}
             
        }
    }
 
	public void addPhoto(String email, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("path", path);
			
			sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.addPhoto", paramMap);
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
}

