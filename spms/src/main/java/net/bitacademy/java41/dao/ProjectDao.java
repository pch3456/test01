package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectDao {

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
	
	public List<Project> list() throws Exception;
	
	public Project get(int no) throws Exception;
	
	public List<MemberProject> listByMember(String email) throws Exception;	
	
	public int add(Project project) throws Exception;	

	public void update(Project project);
	
	public void delete(int no) throws Exception;	
}
