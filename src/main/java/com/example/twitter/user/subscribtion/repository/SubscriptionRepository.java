package com.example.twitter.user.subscribtion.repository;

import com.example.twitter.user.profile.model.UserProfile;
import com.example.twitter.user.subscribtion.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    boolean existsByFollowerAndFollowed(UserProfile follower,UserProfile followed);

    Optional<Subscription> findByFollowerAndFollowed(UserProfile follower, UserProfile followed);


    Page<Subscription> findAllByFollowed(UserProfile author, Pageable pageable);
}
