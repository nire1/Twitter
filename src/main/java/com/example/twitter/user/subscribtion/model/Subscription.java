package com.example.twitter.user.subscribtion.model;

import com.example.twitter.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
@Entity
@Getter
@Setter
@Table(schema = "twitter",name = "subscriptions")
@EntityListeners(AuditingEntityListener.class)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private UserProfile follower;
    @OneToOne
    private UserProfile followed;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;


}