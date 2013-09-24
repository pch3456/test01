package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class ProjectDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
		
	public ProjectDao(){}

/*	
	public List<Member> getMember(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"select a.EMAIL,a.MNAME,b.LEVEL,a.TEL,a.BLOG from SPMS_MEMBS a, SPMS_PRJMEMB b "
				+ " where a.EMAIL=b.EMAIL and PNO=?"); // ? -> in-parameter
			stmt.setInt(1, no);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Member()
				          .setEmail(rs.getString("EMAIL"))
				          .setName(rs.getString("MNAME"))
				          .setLevel(Integer.parseInt(rs.getString("LEVEL")))
				          .setTel(rs.getString("TEL"))
				          .setBlog(rs.getString("Blog")));
			}				
				
				return list;
			
		} catch (Exception e) {
			throw e;
			
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		} 
			
	}
	
	
	*/
	
	public List<Project> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			try {
				return sqlSession.selectList(
						"net.bitacademy.java41.dao.ProjectMapper.list");
			} catch (Exception e) {
				throw e;
				
			} finally {
				try {sqlSession.close();} catch (Exception e) {}
			}
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public Project get(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("net.bitacademy.java41.dao.ProjectMapper.get", no);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	
	public List<MemberProject> listByMember(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.ProjectMapper.listByMember",
					email);
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	
	public int add(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.add", project);
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", project.getLeader());
			paramMap.put("projectNo", project.getNo());
			paramMap.put("memberLevel", 0);
			
			sqlSession.insert(
				"net.bitacademy.java41.dao.ProjectMapper.addProjectMember", 
				paramMap);
			
			sqlSession.commit();
			return project.getNo();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	

	public void change(Project project) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.update(
				"net.bitacademy.java41.dao.ProjectMapper.update", project);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
		
	}

	
	public void delete(int no) throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMapper.deleteProjectMember", no);
			sqlSession.delete(
					"net.bitacademy.java41.dao.ProjectMapper.delete", no);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
	
}
