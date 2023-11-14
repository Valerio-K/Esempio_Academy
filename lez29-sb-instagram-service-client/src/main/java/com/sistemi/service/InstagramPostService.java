package com.sistemi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.entity.InstagramPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.repository.InstagramPostRepository;

@Service
public class InstagramPostService implements InstagramPostServiceI {
	
	@Autowired
	private InstagramPostRepository repo;

	@Override
	public List<InstagramPost> findAllPosts() throws ReadException {
		List<InstagramPost> posts = new ArrayList<>();
		posts= repo.findAll();
		if(posts.isEmpty()) throw new ReadException("Lista post vuota");
		return posts;
	}

	@Override
	public List<InstagramPost> saveAllPosts(List<InstagramPost> posts) throws SaveUpdateException {
		List<InstagramPost> addedPosts = repo.saveAll(posts);
		if(addedPosts.isEmpty()) throw new SaveUpdateException("Niente da Inserire");
		return addedPosts;
	}

	@Override
	public Map<String, Boolean> removeAllPosts() {
		Map<String, Boolean> deletionMap = new HashMap<String, Boolean>();
		repo.deleteAll();
		deletionMap.put("deletion", repo.findAll().isEmpty());
		return deletionMap;
	}

}
