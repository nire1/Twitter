package com.example.twitter.user.tweet.repository;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {
    List<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
