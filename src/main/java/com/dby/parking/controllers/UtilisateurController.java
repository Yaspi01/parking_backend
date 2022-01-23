package com.dby.parking.controllers;

import com.dby.parking.model.user.Utilisateur;
import com.dby.parking.services.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking/utilisateur")
public class UtilisateurController {

    @Autowired
    UtilisateurServiceImpl utilisateurService;

    @PostMapping("/ajout_utilisateur")
    Utilisateur ajout_utilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouterUtilisateur(utilisateur);
    }
}
