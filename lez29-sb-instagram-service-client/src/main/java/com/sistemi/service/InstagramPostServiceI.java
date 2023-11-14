package com.sistemi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.entity.InstagramPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;

public interface InstagramPostServiceI {
	
	public List<InstagramPost> findAllPosts() throws ReadException;
	
	public List<InstagramPost> saveAllPosts(List<InstagramPost> posts) throws SaveUpdateException;
	
	public Map<String, Boolean> removeAllPosts();
}
