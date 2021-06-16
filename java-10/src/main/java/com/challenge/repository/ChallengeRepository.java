package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(value = "SELECT * FROM challenge AS challenge" +
            " INNER JOIN acceleration AS acceleration" +
            " ON challenge.id = acceleration.challenge_id" +
            " INNER JOIN candidate AS candidate" +
            " ON candidate.acceleration_id = acceleration.id" +
            " INNER JOIN users AS users" +
            " ON candidate.user_id = users.id" +
            " WHERE acceleration.id = :accelerationId AND users.id = :userId",
            nativeQuery = true
    )
    List<Challenge> findByAccelerationIdAndUserId(
            @Param("accelerationId") Long accelerationId, @Param("userId") Long userId
    );
}
