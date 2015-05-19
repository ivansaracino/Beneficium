/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.Contratto_Auto;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ivan
 */
@Controller
public class AutomobiliController {
    
    @Autowired
    private BenefitServices servizi;
    
    @RequestMapping(value = "inserisciautomobile", method = RequestMethod.GET)
    
    @ModelAttribute("automobile")
    public Automobile creaAutomobile() throws Exception {
        return new Automobile();
    }
   
     
    
    @ModelAttribute("contratto")
    public Contratto_Auto creaContratto() throws Exception {
        return new Contratto_Auto();
    }
    

    
//    @RequestMapping(value = "aggiungiAuto", method = RequestMethod.POST)
//    public String creaAutomobile(HttpServletRequest req, @Valid Automobile automobile, BindingResult result) throws Exception {
//        if (!result.hasErrors()) {
//            
//            servizi.aggiungiAutomobile(automobile);
//            req.setAttribute("messaggio", "automobile inserita!");
//            
//        }
//        
//        return "inserisciautomobile";
//    }
    
    @RequestMapping(value = "listaAutomobili", method = RequestMethod.GET)
    public @ResponseBody
    Collection<Automobile> listaAutomobiliJSON(HttpServletRequest req) {
        String codiceFiscale = req.getParameter("codiceFiscale");
        return servizi.listaAutomobileJSON(codiceFiscale);
    }
    
    @RequestMapping(value = "salvaautomobile", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult salvaautomobile(@RequestBody Automobile a) {
        JsonResult risultato = new JsonResult();
        Automobile auto = servizi.salvaautomobile(a);
        if (auto != null) {
            risultato.setOggetto(auto);
            risultato.setMessaggio("auto inserita con successo");
            risultato.setStatus(true);
        } else {
            risultato.setMessaggio("errore nell'inserimento auto");
            risultato.setStatus(false);
        }
        
        return risultato;
    }
}
