package com.sistemi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.entity.FacebookPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.repository.FacebookPostRepository;

@Service
public class FacebookPostService implements FacebookPostServiceI {
	
	@Autowired
	private FacebookPostRepository repo;
	
	public List<FacebookPost> findAllPosts() throws ReadException {
		List<FacebookPost> posts = new ArrayList<>();
		posts = repo.findAll();
		if(posts.isEmpty()) throw new ReadException("Lista post vuota");
		return posts;
	}

    public List<FacebookPost> saveAllPosts(List<FacebookPost> posts) throws SaveUpdateException {
    	List<FacebookPost> addedPosts = repo.saveAll(posts);
		if(addedPosts.isEmpty()) throw new SaveUpdateException("Niente da Inserire");
		return addedPosts;
    }

    public Map<String,Boolean> removeAllPostsByIsTagged(Boolean isTagged) {
    	Map<String,Boolean> deletionMap = new HashMap<>();
    	repo.deleteByIsTagged(isTagged);
    	deletionMap.put("deletion", repo.findByIsTagged(isTagged).isEmpty());
    	return deletionMap;
    }
}
