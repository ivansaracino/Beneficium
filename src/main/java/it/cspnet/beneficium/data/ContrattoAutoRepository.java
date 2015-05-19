/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.Cellulare;
import it.cspnet.beneficium.model.Contratto_Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dave
 */
@Repository
public interface ContrattoAutoRepository extends JpaRepository<Contratto_Auto, Integer>{
}
