package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubmissionId implements Serializable {

    @ManyToOne
    public User user_id;

    @ManyToOne
    public Challenge challenge_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubmissionId)) return false;
        SubmissionId that = (SubmissionId) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(challenge_id, that.challenge_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, challenge_id);
    }
}
