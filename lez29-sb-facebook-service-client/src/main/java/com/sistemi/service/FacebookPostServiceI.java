package com.sistemi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.entity.FacebookPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;

public interface FacebookPostServiceI {
	
	public List<FacebookPost> findAllPosts() throws ReadException;

    public List<FacebookPost> saveAllPosts(List<FacebookPost> posts) throws SaveUpdateException;

    public Map<String,Boolean> removeAllPostsByIsTagged(Boolean isTagged);
}
