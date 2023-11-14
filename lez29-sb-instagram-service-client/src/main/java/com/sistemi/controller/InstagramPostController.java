package com.sistemi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.entity.InstagramPost;
import com.sistemi.exception.ReadException;
import com.sistemi.exception.SaveUpdateException;
import com.sistemi.service.InstagramPostServiceI;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("rest/api/instagram/posts")
public class InstagramPostController {
	

	@Autowired
	private InstagramPostServiceI serv;
	
	@GetMapping
	public List<InstagramPost> findAllPost() throws ReadException {
		return serv.findAllPosts();
	}
	
	@PostMapping
	public List<InstagramPost> saveAllPost(@Valid @RequestBody List<InstagramPost> posts) throws SaveUpdateException {
		return serv.saveAllPosts(posts);
	}
	
	@DeleteMapping
	public Map<String, Boolean> removeAllPosts() {
		return serv.removeAllPosts();
	}
}
