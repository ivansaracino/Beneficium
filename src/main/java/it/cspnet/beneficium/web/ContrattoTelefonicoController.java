/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.ContrattoTelefonico;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
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
 * @author lora
 */
@Controller
public class ContrattoTelefonicoController {
      
    @Autowired
    private BenefitServices servizi;
      
    @ModelAttribute("contrattotelefonico")
    public ContrattoTelefonico getModelContrattoTelefonico() {
        return new ContrattoTelefonico();
    }
    
    @RequestMapping(value = "inseriscicontrattotelefonico", method = RequestMethod.GET)
    public String getInserisciContrattoTelefonico() {
        return "inseriscicontrattotelefonico";
    }
    
     @RequestMapping(value = "inseriscicontrattotelefonico", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult postInserisciContrattoTelefonico(@Valid @RequestBody ContrattoTelefonico contrattoTelefonico, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                JsonResult js = new JsonResult();
                js.setOggetto(servizi.inserisciContrattoTelefonico(contrattoTelefonico));

                if (js.getOggetto() != null) {
                    js.setMessaggio("cellulare inserito correttamente");
                    js.setStatus(true);
                   
                }
                else{
                    js.setMessaggio("errore nell'inserimento del cellulare");
                    js.setStatus(false);
                    
                }
                
                return js;
                
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;

        }

    }
    
}
