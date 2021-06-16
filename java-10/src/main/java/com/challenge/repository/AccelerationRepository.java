package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    @Query(value = "SELECT * FROM acceleration AS acceleration" +
            " INNER JOIN candidate AS candidate" +
            " ON candidate.acceleration_id = acceleration.id" +
            " INNER JOIN company AS company" +
            " ON company.id = candidate.company_id" +
            " WHERE company.id = :id",
            nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("id") Long companyId);
}
