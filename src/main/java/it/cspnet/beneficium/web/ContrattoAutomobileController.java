
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Automobile;
import it.cspnet.beneficium.model.AutomobileView;
import it.cspnet.beneficium.model.ContrattoAuto;
import it.cspnet.beneficium.model.Dipendente;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
import java.util.ArrayList;
import java.util.Collection;
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


@Controller
public class ContrattoAutomobileController {
    
    @Autowired
    private BenefitServices servizi;
    
    @RequestMapping(value = "salvacontratto", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult salvaContratto(@RequestBody ContrattoAuto contratto) {
        JsonResult risultato = new JsonResult();
        ContrattoAuto contratto2 = servizi.salvaContratto(contratto);
        if (contratto2 != null) {
            risultato.setOggetto(contratto);
            risultato.setMessaggio("contratto inserito con successo");
            risultato.setStatus(true);
        } else {
            risultato.setMessaggio("errore nell'inserimento contratto");
            risultato.setStatus(false);
        }
        
        return risultato;
    }
    
      @RequestMapping(value = "listaauto", method = RequestMethod.GET)
      
        public @ResponseBody Collection<AutomobileView> listaAuto(HttpServletRequest req) throws Exception{
            String codiceFiscale= req.getParameter("codiceFiscale");
             Collection<ContrattoAuto> lista =servizi.listaContrattiAuto(codiceFiscale);
             List<AutomobileView> listaAuto = new ArrayList<>();
             for (ContrattoAuto c : lista) {
                 AutomobileView aW = new AutomobileView();
                 aW.setCodiceFiscale(c.getAutomobile().getDipendente().getCodiceFiscale());
                 aW.setModello(c.getAutomobile().getModello());
                 aW.setTarga(c.getAutomobile().getTarga());
//                 aW.setDataAttivazione(c.getDataAttivazione());
//                 aW.setDataScadenza(c.getDataScadenza());
                 aW.setCostoNoleggio(c.getCostoNoleggio());
                 aW.setCostoServizi(c.getCostoServizi());
                 aW.setKilometriContratto(c.getKilometriContratto());
                 aW.setSocietaLeasing(c.getSocietaLeasing());
                 listaAuto.add(aW);
             }
             return listaAuto;
        }
}
 