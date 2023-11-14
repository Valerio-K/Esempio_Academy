package com.sistemi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Tweet;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.RemoveException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.repository.TweetRepository;

@Service
public class TweetService implements TweetServiceI {
	
	@Autowired
	private TweetRepository repo;
	@Override
	public List<Tweet> findAllTweets() throws ReadException {
		List<Tweet> tweets = new ArrayList<>();
		tweets= repo.findAll();
		if(tweets.isEmpty()) throw new ReadException("Lista Tweet vuota");
		return tweets;
	}

	@Override
	public List<Tweet> findAllTweetsByHashTag(String hashTag) throws ReadException {
		List<Tweet> tweets = new ArrayList<>();
		tweets= repo.findByHashTag(hashTag);
		if(tweets.isEmpty()) throw new ReadException("Lista Tweet vuota");
		return tweets;
	}

	@Override
	public Tweet saveOrUpdateTweet(Tweet tweet) throws SaveUpdateException {
		Tweet savedOrUpdatedTweet = repo.save(tweet);
		// TO REVIEW
		if(savedOrUpdatedTweet.getId() == 0) throw new SaveUpdateException("Operazione Insert/Update Fallita");
		return savedOrUpdatedTweet;
	}

	@Override
	public Map<String, Boolean> removeTweet(Integer id) throws RemoveException {
		Map<String, Boolean> deletionMap = new HashMap<>();
		repo.deleteById(id);
		if (repo.existsById(id)) throw new RemoveException("Operazione Delete Fallita");
		deletionMap.put("deletion", true);
		return deletionMap;
	}

}
