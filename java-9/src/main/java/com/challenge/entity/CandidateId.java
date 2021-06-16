package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateId implements Serializable {

    @ManyToOne
    public User user_id;

    @ManyToOne
    public Acceleration acceleration_id;

    @ManyToOne
    public Company company_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateId)) return false;
        CandidateId that = (CandidateId) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(acceleration_id, that.acceleration_id) && Objects.equals(company_id, that.company_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, acceleration_id, company_id);
    }
}
