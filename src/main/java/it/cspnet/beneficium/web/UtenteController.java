/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Utente;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.List;
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
 * @author dave
 */
@Controller
public class UtenteController {

    @Autowired
    private BenefitServices benefitServices;

    @ModelAttribute("utente")
    public Utente getUtente() {
        return new Utente();
    }
    
    

//    @RequestMapping(value = "start")
//    public String nuovoUtente() {
//        return "login";
//
//    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
//   
     public @ResponseBody Utente login(HttpServletRequest req, @RequestBody  Utente utente, BindingResult result) throws Exception {
            
           return benefitServices.findUtente(utente);
    }
    
    @RequestMapping(value="listautenti", method=RequestMethod.GET)
    public @ResponseBody List<Utente> getListaUtenti(){
        return benefitServices.listaUtenti();
    }
}
