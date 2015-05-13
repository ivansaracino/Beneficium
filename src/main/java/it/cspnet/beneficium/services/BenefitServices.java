/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.services;


import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Contratto;
import java.util.List;
/**
 *
 * @author ivan
 */
    


public interface BenefitServices {
    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception;

    public Utente findUtente(Utente u) throws Exception;

    
    public Dipendente aggiungiDipendente(Dipendente dipendente);
    
    public void aggiungiAutomobile(Automobile automobile);

   // public List<Contratto> listaContratti(String tipo);
    
}
