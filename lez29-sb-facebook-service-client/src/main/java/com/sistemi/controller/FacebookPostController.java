package com.sistemi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.entity.FacebookPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.service.FacebookPostServiceI;

@CrossOrigin
@RestController
@RequestMapping("rest/api/facebook/posts")
public class FacebookPostController {
	
	@Autowired
	private FacebookPostServiceI serv;
	
	@GetMapping
	public List<FacebookPost> findAllPosts() throws ReadException {
		return serv.findAllPosts();
	}
	
	@PostMapping
	public List<FacebookPost> saveAllPosts(@RequestBody List<FacebookPost> posts) throws SaveUpdateException {
		return serv.saveAllPosts(posts);
	}
	
	@DeleteMapping("isTagged/{isTagged}")
	public Map<String, Boolean> removeByIsTagged(@PathVariable Boolean isTagged) {
		return serv.removeAllPostsByIsTagged(isTagged);
	}
}
