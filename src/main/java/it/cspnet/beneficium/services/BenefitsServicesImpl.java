/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.UtenteRepository;
import it.cspnet.beneficium.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dave
 */
@Service
public class BenefitsServicesImpl implements BenefitServices{
    
    @Autowired
    private UtenteRepository utenteRepository;

    @Transactional
    public Utente findUtente(Utente u) throws Exception {
        
       return utenteRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
       
    }
    
}
