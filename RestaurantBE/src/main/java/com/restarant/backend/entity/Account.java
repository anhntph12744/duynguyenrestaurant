package com.restarant.backend.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Component
@Entity
public class Account {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "secret")
    private String cecret;

    @Column(name = "timereset")
    private LocalDate timereset;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "customer_id")
    private Customer customer;


}
