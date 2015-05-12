/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.services.Servizi;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author corsojava
 */
@Controller
public class CellulariController {
    @Autowired
    private Servizi servizi;
    
    @ModelAttribute("cellulare")
    public Cellulare getModelCellulare() {
        return new Cellulare();
    }
    
    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.GET)
    public String getInserisciCellulare() {
        return "inseriscicellulare";
    }
    
    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.POST)
    public String postInserisciCellulare(HttpServletRequest req, @Valid Cellulare cellulare, BindingResult result){
        if(!result.hasErrors()){
        try {
            servizi.inserisciCellulare(cellulare);
            req.setAttribute("messaggio", "Cellulare inserito correttamente!!");
                return "inseriscicellulare";
        } catch (Exception ex) {
            req.setAttribute("messaggio", "Cellulare non inserito correttamente!!");
                return "inseriscicellulare";
        }
        }
        else
             return "inseriscicellulare";
        
    }
}
