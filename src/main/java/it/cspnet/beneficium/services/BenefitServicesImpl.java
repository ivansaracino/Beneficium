/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.DipendentiRepository;
import it.cspnet.beneficium.model.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author corsojava
 */
@Service
public class BenefitServicesImpl implements BenefitServices {
    
    @Autowired
    private DipendentiRepository dipendenteRepository;
    
    @Transactional
    public Dipendente aggiungiDipendente(Dipendente d) {
    dipendenteRepository.save(d);
    return d;
    }
    
}
