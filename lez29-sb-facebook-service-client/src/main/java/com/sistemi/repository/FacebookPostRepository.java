package com.sistemi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.entity.FacebookPost;

public interface FacebookPostRepository extends JpaRepository<FacebookPost, Integer>{
	
	public List<FacebookPost> findByIsTagged(Boolean isTagged);
	
	//JPQL
    @Transactional
	@Modifying
	@Query("DELETE FROM FacebookPost p WHERE p.isTagged=:isTagged")
	public void deleteByIsTagged(@Param("isTagged") Boolean isTagged);	
}