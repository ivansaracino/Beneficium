package it.cspnet.beneficium.services;

import it.cspnet.beneficium.data.AutomobiliRepository;
import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.data.CellulariRepository;
import it.cspnet.beneficium.data.ContrattoTelefonicoRepository;
import it.cspnet.beneficium.data.ContrattoAutoRepository;
import it.cspnet.beneficium.data.DipendentiRepository;
import it.cspnet.beneficium.data.UtenteRepository;
import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Contratto_Auto;
import it.cspnet.beneficium.model.ContrattoTelefonico;
import it.cspnet.beneficium.model.Utente;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BenefitServicesImpl implements BenefitServices {

    @Autowired
    private AutomobiliRepository repositoryAutomobile;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private DipendentiRepository dipendenteRepository;

    @Autowired
    private CellulariRepository cellulariRepository;

    @Autowired
    private ContrattoAutoRepository contrattoAutoRepository;

    @Autowired
    private ContrattoTelefonicoRepository contrattiTelefoniciRepository;

    public Cellulare inserisciCellulare(Cellulare cellulare) throws Exception {
        return cellulariRepository.save(cellulare);
    }

    @Transactional
    public Utente findUtente(Utente u) throws Exception {
        return utenteRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
    }

    public void aggiungiAutomobile(Automobile automobile) {
        repositoryAutomobile.save(automobile);
    }

    public Dipendente aggiungiDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public List<Automobile> listaAutomobileJSON(String codiceFiscale) {
        return repositoryAutomobile.findByDipendente_codiceFiscale(codiceFiscale);
    }

    public List<Cellulare> listaCellulareJSON(String codiceFiscale) throws Exception {
        return cellulariRepository.findBydipendente_codiceFiscale(codiceFiscale);
    }

    public Collection<Dipendente> listDipendentiJSON() {

        return dipendenteRepository.findAll();
    }

    public List<Utente> listaUtenti() {
        return utenteRepository.findAll();

    }

    public Automobile salvaautomobile(Automobile a) {
        return repositoryAutomobile.save(a);
    }

    @Override
    public Contratto_Auto salvaContratto(Contratto_Auto contratto) {

        return contrattoAutoRepository.save(contratto);
    }

    @Transactional
    public ContrattoTelefonico aggiungiContrattoTelefonico(ContrattoTelefonico contrattoTelefonico) {
        return contrattiTelefoniciRepository.save(contrattoTelefonico);
    }

    @Override
    public Collection<Automobile> listAutomobiliJSON(String codiceFiscale) {

        return repositoryAutomobile.findByDipendente_codiceFiscale(codiceFiscale);
    }
}
