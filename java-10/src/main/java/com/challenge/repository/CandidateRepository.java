package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    @Query(value="SELECT * FROM candidate AS candidate" +
            " WHERE" +
            " candidate.id.user.id = :userId AND" +
            " candidate.id.company.id = :companyId AND" +
            " candidate.id.acceleration.id = :accelerationId",
            nativeQuery = true
    )
    Optional<Candidate> findById(
            @Param("userId") Long userId,
            @Param("companyId") Long companyId,
            @Param("accelerationId") Long accelerationId
    );

    @Query(value = "SELECT * FROM candidate AS candidate" +
            " INNER JOIN company AS company" +
            " ON candidate.company_id = company.id" +
            " WHERE company.id = :id",
            nativeQuery = true
    )
    List<Candidate> findByCompanyId(@Param("id") Long companyId);

    @Query(value = "SELECT * FROM candidate AS candidate" +
            " INNER JOIN acceleration AS acceleration" +
            " ON candidate.acceleration_id = acceleration.id" +
            " WHERE acceleration.id = :id",
            nativeQuery = true
    )
    List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);
}
