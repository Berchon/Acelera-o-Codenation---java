package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class Acceleration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column(length = 100) // Determina o tamanho do campo no banco de dados, mas não faz a validaćão
    @Size(max = 100) // Faz a validaćão da propriedade full_name
    private String name;

    @NotNull
    @Column(length = 50)
    @Size(max = 50)
    private String slug;

    @CreatedDate
    private Timestamp createdat;

    @OneToMany
    public List<Candidate> candidates;

    @ManyToOne
    public Challenge challenge_id;
}
