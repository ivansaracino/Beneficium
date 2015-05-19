
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.ContrattoTelefonico;
import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
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

@Controller
public class ContrattoTelefonicoController {
    
    @Autowired
    private BenefitServices servizi;
    
    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.GET)
    @ModelAttribute("contratto")
    public ContrattoTelefonico getModelContrattoTelefonico() {
        return new ContrattoTelefonico();
    }
    
     @ModelAttribute("cellulare")
    public Cellulare getModelCellulare() {
        return new Cellulare();
    }

    
  
    
    
    
    @RequestMapping(value = "inseriscicontrattojson", method = RequestMethod.POST)
    public @ResponseBody JsonResult nuovoContrattoTelefonico(HttpServletRequest req,@Valid @RequestBody ContrattoTelefonico contrattoTelefonico, BindingResult result) {
      
            
            ContrattoTelefonico cT = servizi.aggiungiContrattoTelefonico(contrattoTelefonico);
            JsonResult j = new JsonResult();
            
            if(cT != null){
           
            j.setOggetto(cT);
            j.setMessaggio("inserimento corretto");
            j.setStatus(true);
            }
            else{
            j.setMessaggio("inserimento sbagliato");  
            j.setStatus(false);
            }
            
            return j;

    }
    
}
