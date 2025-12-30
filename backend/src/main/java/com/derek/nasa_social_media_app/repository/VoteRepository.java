package com.derek.nasa_social_media_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.derek.nasa_social_media_app.model.Vote;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer> {
}