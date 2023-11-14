package com.sistemi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.entity.Tweet;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.RemoveException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.service.TweetServiceI;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/rest/api/tweets")
public class TweetController {
	
	@Autowired
	private TweetServiceI serv;
	
	@GetMapping
	public List<Tweet> findAllTweets() throws ReadException {
		return serv.findAllTweets();
	}
	
	@GetMapping("/hashTag/{hashTag}") //il simbolo # va codificato da %23 nell'url
	public List<Tweet> findAllTweetsByHashTag(@PathVariable String hashTag) throws ReadException {
		return serv.findAllTweetsByHashTag(hashTag);
	}
	
	@PostMapping
	public Tweet saveTweet(@Valid @RequestBody Tweet tweet) throws SaveUpdateException {
		return serv.saveOrUpdateTweet(tweet);
	}
	
	@PutMapping
	public Tweet updateTweet(@RequestBody Tweet tweet) throws SaveUpdateException {
		return serv.saveOrUpdateTweet(tweet);
	}
	
	@DeleteMapping("/id/{id}")
	public Map<String, Boolean> removeTweet(@PathVariable Integer id) throws RemoveException {
		return serv.removeTweet(id);
	}
	
}
