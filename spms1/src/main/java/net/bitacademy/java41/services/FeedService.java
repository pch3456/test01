package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedService {
	void addFeed(Feed feed) throws Exception;
	List<Feed> getFeedList(int projectNo) throws Exception;
	void deleteFeed(int fno) throws Exception;
}
