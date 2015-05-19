/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;


import it.cspnet.beneficium.model.ContrattoTelefonico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lora
 */
@Repository
public interface ContrattiTelefoniciRepository extends JpaRepository<ContrattoTelefonico, Integer>{
    List<ContrattoTelefonico> findByIdContrattoTelefonico(int idContrattoTelefonico);
}
