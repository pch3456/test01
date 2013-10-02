package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedDao {
	void add(Feed feed) throws Exception;
	
	List<Feed> list(int projectNo) throws Exception;
	
	void delete(int fno) throws Exception;
}
