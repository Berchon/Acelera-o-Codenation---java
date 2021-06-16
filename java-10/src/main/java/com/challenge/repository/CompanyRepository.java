package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    @Query(value = "SELECT * FROM company AS company" +
            " INNER JOIN candidate AS candidate" +
            " ON candidate.company_id = company.id" +
            " INNER JOIN acceleration AS acceleration" +
            " ON candidate.acceleration_id = acceleration.id" +
            " WHERE acceleration.id = :id" +
            " LIMIT 1",
            nativeQuery = true
    )
    public List<Company> findByAccelerationId(@Param("id") Long accelerationId);

    @Query(value = "SELECT * FROM company AS company" +
            " INNER JOIN candidate AS candidate" +
            " ON candidate.company_id = company.id" +
            " INNER JOIN users AS users" +
            " ON candidate.user_id = users.id" +
            " WHERE users.id = :id",
            nativeQuery = true
    )
    public List<Company> findByUserId(@Param("id") Long userId);
}
