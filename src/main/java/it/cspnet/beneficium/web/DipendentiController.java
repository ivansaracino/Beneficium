/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author corsojava
 */
@Controller
public class DipendentiController {

    @Autowired
    private BenefitServices servizi;

    
    @RequestMapping(value = "inseriscidipendente", method = RequestMethod.GET)
    @ModelAttribute("dip")
    public Dipendente creaDipendente() throws Exception {
        return new Dipendente();
    }
    
     @ModelAttribute("utente")
    public Utente creaUtente() throws Exception {
        return new Utente();
    }
    
    @RequestMapping(value = "inserisciDipendente", method = RequestMethod.POST)
    public String nuovoDipendente(HttpServletRequest req, @Valid Dipendente dip, BindingResult result) {
        if (!result.hasErrors()) {

            String codiceFiscale = req.getParameter("codiceFiscale");
            String nome = req.getParameter("nome");
            String cognome = req.getParameter("cognome");
            String indirizzo = req.getParameter("indirizzo");
            float stipendioMensile = Float.parseFloat(req.getParameter("stipendioMensile"));
            
            Dipendente d = new Dipendente();
            d.setCodiceFiscale(codiceFiscale);
            d.setNome(nome);
            d.setCognome(cognome);
            d.setIndirizzo(indirizzo);
            d.setStipendioMensile(stipendioMensile);
            
            servizi.aggiungiDipendente(dip);
            req.setAttribute("messaggio", "dipendente salvato!");
             return "start"; //deve ritornare al menù
        }
        else 
             return "inseriscidipendente.do"; //deve ritornare al menù
    }
    
        @RequestMapping(value = "listadipendentijson", method = RequestMethod.GET)
        public @ResponseBody Collection<Dipendente> listaDipendentiJSON(){
            return servizi.listDipendentiJSON();
        }


}