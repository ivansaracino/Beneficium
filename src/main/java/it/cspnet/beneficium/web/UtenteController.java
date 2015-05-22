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
    
    

    @RequestMapping(value = "start")
    public String nuovoUtente() {
        return "start";

    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, @Valid Utente utente, BindingResult result) throws Exception {

        if (!result.hasErrors()) {

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Utente u = new Utente();
            u.setPassword(password);
            u.setUsername(username);

            Utente x = benefitServices.findUtente(u);
            if (x != null) {
                req.getSession().setAttribute("utente", x);
                return "home";
            } else {
                req.setAttribute("messaggio", "credenziali errate");
                return "start";
            }

        } else {
            return "index";
        }

    }
    
    @RequestMapping(value="listautenti", method=RequestMethod.GET)
    public @ResponseBody List<Utente> getListaUtenti(){
        return benefitServices.listaUtenti();
    }
}
