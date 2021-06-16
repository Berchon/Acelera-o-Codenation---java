package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@EntityListeners(EntityListeners.class)
public class Submission {

    @EmbeddedId
    private SubmissionId id;

    @NotNull
    @Max(100)
    @Min(0)
    private  float score;

    @CreatedDate
    private Timestamp createdat;

}
