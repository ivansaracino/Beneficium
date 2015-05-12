/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.data;

import it.cspnet.beneficium.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ivan
 */
public interface AutomobiliRepository extends JpaRepository<Automobile, Integer> {
    
    
}
