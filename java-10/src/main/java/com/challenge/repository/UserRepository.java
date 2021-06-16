package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users AS users" +
            " INNER JOIN candidate AS candidate" +
            " ON users.id = candidate.user_id" +
            " INNER JOIN acceleration AS acceleration" +
            " ON candidate.acceleration_id = acceleration.id" +
            " WHERE acceleration.name LIKE %:name%",
            nativeQuery = true)
    List<User> findByAccelerationName(@Param("name") String name);

    @Query(value = "SELECT * FROM users AS users" +
            " INNER JOIN candidate AS candidate" +
            " ON users.id = candidate.user_id" +
            " INNER JOIN company AS company" +
            " ON company.id = candidate.company_id" +
            " WHERE company.id = :id",
            nativeQuery = true
    )
    List<User> findByCompanyId(@Param("id") Long companyId);
}
