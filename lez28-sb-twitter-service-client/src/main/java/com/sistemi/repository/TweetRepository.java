package com.sistemi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
	
	public List<Tweet> findByHashTag(String hashTag);
}
