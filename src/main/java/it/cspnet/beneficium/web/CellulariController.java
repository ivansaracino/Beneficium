
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

    @RequestMapping(value = "listacellulari", method = RequestMethod.GET)
    public @ResponseBody Collection<Cellulare> listaCellulari(HttpServletRequest req) throws Exception {
        String codiceFiscale = req.getParameter("codiceFiscale");
        return servizi.listaCellulareJSON(codiceFiscale);
    }
}
