/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.CellulariRepository;
import it.cspnet.beneficium.model.Cellulare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author corsojava
 */
@Service
public class ServiziImpl implements Servizi{
     @Autowired
    private CellulariRepository cellulariRepository;

    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception {
       return cellulariRepository.save(cellulare);
    }
    
}
