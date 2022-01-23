package com.dby.parking.services;

import com.dby.parking.model.user.Utilisateur;
import com.dby.parking.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    UtilisateurRepository utilisateurRepository;

     PasswordEncoder passwordEncoder;

    UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        String encodedPassword = this.passwordEncoder.encode(utilisateur.getPassword());
        utilisateur.setPassword(encodedPassword);
        return utilisateurRepository.save(utilisateur);
    }
}
