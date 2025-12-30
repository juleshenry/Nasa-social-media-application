package com.derek.nasa_social_media_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.KnowledgeBase;

@Repository
public interface KnowledgeBaseRepository extends CrudRepository<KnowledgeBase, Integer> {
}