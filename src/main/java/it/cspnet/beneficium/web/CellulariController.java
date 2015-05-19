
package it.cspnet.beneficium.web;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.JsonResult;
import it.cspnet.beneficium.services.BenefitServices;
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
public class CellulariController {

    @Autowired
    private BenefitServices servizi;

    @ModelAttribute("cellulare")
    public Cellulare getModelCellulare() {
        return new Cellulare();
    }

    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.GET)
    public String getInserisciCellulare() {
        return "inseriscicellulare";
    }
//
//    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.POST)
//    public String postInserisciCellulare(HttpServletRequest req, @Valid Cellulare cellulare, BindingResult result) {
//        if (!result.hasErrors()) {
//            try {
//                servizi.inserisciCellulare(cellulare);
//                req.setAttribute("messaggio", "Cellulare inserito correttamente!!");
//                return "inseriscicellulare";
//            } catch (Exception ex) {
//                req.setAttribute("messaggio", "Cellulare non inserito correttamente!!");
//                return "inseriscicellulare";
//            }
//        } else {
//            return "inseriscicellulare";
//        }
//
//    }

    @RequestMapping(value = "inseriscicellulare", method = RequestMethod.POST)
    public @ResponseBody
    JsonResult postInserisciCellulare(@Valid @RequestBody Cellulare cellulare, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                JsonResult js = new JsonResult();
                js.setOggetto(servizi.inserisciCellulare(cellulare));

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


    @RequestMapping(value = "listaCellulareJson", method = RequestMethod.GET)
    public @ResponseBody List<Cellulare> listaCellulariJSON(HttpServletRequest req) throws Exception {
        String codiceFiscale = req.getParameter("codiceFiscale");
        return servizi.listaCellulareJSON(codiceFiscale);
    }
}
