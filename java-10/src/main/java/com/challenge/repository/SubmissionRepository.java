package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(value = "SELECT MAX(submission.score) FROM submission AS submission" +
            " INNER JOIN challenge AS challenge" +
            " ON challenge.id = submission.challenge_id" +
            " WHERE challenge.id = :id",
            nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("id") Long challengeId);

    @Query(value = "SELECT * FROM submission AS submission" +
            " INNER JOIN challenge AS challenge ON submission.challenge_id = challenge.id" +
            " INNER JOIN acceleration AS acceleration ON acceleration.challenge_id = challenge.id" +
            " WHERE challenge.id = :challengeId AND acceleration.id = :accelerationId ",
            nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(
            @Param("challengeId") Long challengeId,
            @Param("accelerationId") Long accelerationId
    );
}
