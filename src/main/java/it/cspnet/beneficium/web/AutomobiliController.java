/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Automobile;
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

    @RequestMapping(value = "aggiungiAuto", method = RequestMethod.POST)
    public String creaAutomobile(HttpServletRequest req, @Valid Automobile automobile, BindingResult result) throws Exception {
        if (!result.hasErrors()) {

            servizi.aggiungiAutomobile(automobile);
            req.setAttribute("messaggio", "automobile inserita!");

        }

        return "inserisciautomobile";
    }

    @RequestMapping(value = "listaAutomobiliJson", method = RequestMethod.GET)
    public @ResponseBody
    Collection<Automobile> listaAutomobiliJSON(HttpServletRequest req) {
        String codiceFiscale = req.getParameter("codiceFiscale");
        return servizi.listaAutomobileJSON(codiceFiscale);
    }

}
