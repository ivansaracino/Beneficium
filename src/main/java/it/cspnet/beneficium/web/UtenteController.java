/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.JsonResult;
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
<<<<<<< HEAD
    public @ResponseBody
    JsonResult login(HttpServletRequest req, @RequestBody Utente utente) throws Exception {
        JsonResult jR = new JsonResult();
        try {

            Utente u = benefitServices.findUtente(utente);
            if (u != null) {
                jR.setOggetto(u);
                jR.setMessaggio("bEnvenuto");
                jR.setStatus(true);
            }
            else 
            {
                jR.setMessaggio("utente non abilititato");
                jR.setStatus(false);
            }

        } catch (Exception ex) {
            jR.setMessaggio("utente non abilititato");
            jR.setStatus(false);
        } finally {
            return jR;
        }
    }

    @RequestMapping(value = "listautenti", method = RequestMethod.GET)
    public @ResponseBody
    List<Utente> getListaUtenti() {
=======
     public @ResponseBody JsonResult login(HttpServletRequest req, @RequestBody  Utente utente) throws Exception {
           JsonResult jR = new JsonResult();
           
           
           Utente u = benefitServices.findUtente(utente);
           jR.setOggetto(u);
           
           if(u != null){
           jR.setMessaggio("bEnvenuto");
           jR.setStatus(true);
           }
           else{
               jR.setMessaggio("utente non abilititato");
               jR.setStatus(false);
           } 
               return jR;
           
    } 
    
    @RequestMapping(value="listautenti", method=RequestMethod.GET)
    public @ResponseBody List<Utente> getListaUtenti(){
>>>>>>> c76c93b6cb563e457bcd9c24622bd877cdde7461
        return benefitServices.listaUtenti();
    }
    
   
}
    

