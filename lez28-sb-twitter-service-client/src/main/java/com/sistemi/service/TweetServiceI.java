package com.sistemi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.entity.Tweet;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.RemoveException;
import com.sistemi.exception.SaveUpdateException;

public interface TweetServiceI {
	
	public List<Tweet> findAllTweets() throws ReadException;
	
	public List<Tweet> findAllTweetsByHashTag(String hashTag) throws ReadException;
	
	public Tweet saveOrUpdateTweet(Tweet tweet) throws SaveUpdateException;
	
	public Map<String, Boolean> removeTweet(Integer id) throws RemoveException;	
}
