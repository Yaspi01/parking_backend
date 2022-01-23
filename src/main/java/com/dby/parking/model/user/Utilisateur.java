package com.dby.parking.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50)
    private String nom;

    @NotNull
    @Column(length = 50)
    private String prenom;

    @NotNull
    @Size(min = 8, max = 15)
    @Column(length = 15)
    private int telephone;

    @NotNull
    @Column(length = 50)
    private String adresse;

    @NotNull
    @Email
    @Column(length = 50)
    private String email;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(length = 50)
    private String login;

    @NotNull
    @Column(length = 50)
    private String password;
}
