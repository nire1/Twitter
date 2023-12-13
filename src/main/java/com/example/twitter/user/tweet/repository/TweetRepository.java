package com.example.twitter.user.tweet.repository;

import com.example.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {
}
