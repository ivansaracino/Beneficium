/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.Cellulare;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author corsojava
 */
@Repository
public interface CellulariRepository extends JpaRepository<Cellulare, Integer>{
    List<Cellulare> findBydipendente_codiceFiscale(String codiceFiscale);
}
