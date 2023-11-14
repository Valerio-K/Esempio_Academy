package com.sistemi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.InstagramPost;

public interface InstagramPostRepository extends JpaRepository<InstagramPost, Integer>{

}