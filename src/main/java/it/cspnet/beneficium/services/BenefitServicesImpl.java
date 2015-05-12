/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.AutomobiliRepository;
import it.cspnet.beneficium.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luca
 */
@Service
public class BenefitServicesImpl implements BenefitServices {
    
    @Autowired
    private AutomobiliRepository repAutomobile;
    
    public void aggiungiAutomobile(Automobile automobile) {
        repAutomobile.save(automobile);
     
    }
    
}
