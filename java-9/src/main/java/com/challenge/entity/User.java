package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(EntityListeners.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100) // Faz a validaćão da propriedade full_name
    @Column(length = 100) // Determina o tamanho do campo no banco de dados, mas não faz a validaćão
    private String fullname;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private  String password;

    @CreatedDate
    private Timestamp createdat;

    @OneToMany
    public List<Candidate> candidates;

    @OneToMany
    public List<Submission> submissions;
}
