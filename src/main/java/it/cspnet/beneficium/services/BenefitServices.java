
package it.cspnet.beneficium.services;

import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.model.Automobile;


import it.cspnet.beneficium.model.Contratto_Auto;


import it.cspnet.beneficium.model.ContrattoTelefonico;
import java.util.Collection;
import java.util.List;


public interface BenefitServices {

    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception;

    public Utente findUtente(Utente u) throws Exception;

    public Dipendente aggiungiDipendente(Dipendente dipendente);

    public void aggiungiAutomobile(Automobile automobile);

    public List<Cellulare> listaCellulareJSON(String codiceFiscale) throws Exception;

    public Collection<Dipendente> listDipendentiJSON();

    public List<Utente> listaUtenti();

    public List<Automobile> listaAutomobileJSON(String codiceFiscale);

    public Automobile salvaautomobile(Automobile a);


    public ContrattoTelefonico aggiungiContrattoTelefonico(ContrattoTelefonico contrattoTelefonico);

    public Contratto_Auto salvaContratto(Contratto_Auto contratto);

    public Collection<Automobile> listAutomobiliJSON(String codiceFiscale);

}
