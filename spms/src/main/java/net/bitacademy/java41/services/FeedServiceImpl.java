package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.FeedDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.vo.Feed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedServiceImpl implements FeedService{
	@Autowired PlatformTransactionManager txManager; 
	@Autowired FeedDao feedDao;
	@Autowired ProjectMemberDao projectMemberDao;
	
	public List<Feed> getFeedList(int projectNo) throws Exception{
		return feedDao.list(projectNo);
	}
	
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor=Throwable.class)
	public void addFeed(Feed feed) throws Exception {	
		try {
			
			feedDao.add(feed);
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public void deleteFeed(int fno) throws Exception{
		try{
			feedDao.delete(fno);
		} catch(Exception e){
			throw e;
		}
	}
}
