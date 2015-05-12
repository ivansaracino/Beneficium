/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.AutomobiliRepository;
import it.cspnet.beneficium.data.CellulariRepository;
import it.cspnet.beneficium.data.UtenteRepository;
import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author luca
 */
@Service
public class BenefitServicesImpl implements BenefitServices {
    
    @Autowired
    private AutomobiliRepository repAutomobile;
    
    @Autowired
    private UtenteRepository utenteRepository;
    
     @Autowired
    private CellulariRepository cellulariRepository;


    @Transactional
    public Utente findUtente(Utente u) throws Exception {
        
       return utenteRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
       
    }
    
    public void aggiungiAutomobile(Automobile automobile) {
        repAutomobile.save(automobile);
     
    }
   
    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception {
       return cellulariRepository.save(cellulare);
    }
}
