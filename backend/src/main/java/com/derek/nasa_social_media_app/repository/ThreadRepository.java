package com.derek.nasa_social_media_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.Thread;

@Repository
public interface ThreadRepository extends CrudRepository<Thread, Integer> {
    List<Thread> findByTitleContainingIgnoreCase(String title);
    List<Thread> findByContentContainingIgnoreCase(String content);
}