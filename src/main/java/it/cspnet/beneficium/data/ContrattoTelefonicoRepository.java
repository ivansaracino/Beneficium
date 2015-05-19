/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.ContrattoTelefonico;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrattoTelefonicoRepository extends JpaRepository<ContrattoTelefonico, Integer>{
    
}
