/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author dave
 */
@Entity
@Table(name = "CONTRATTI")
public class Contratto {
    
    @Id
    @GeneratedValue
    private int id_contratto;
    
    private String tipo_contratto;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_contratto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contratto other = (Contratto) obj;
        if (this.id_contratto != other.id_contratto) {
            return false;
        }
        return true;
    }
    
    


    public int getId_contratto() {
        return id_contratto;
    }

    public void setId_contratto(int id_contratto) {
        this.id_contratto = id_contratto;
    }

    public String getTipo_contratto() {
        return tipo_contratto;
    }

    public void setTipo_contratto(String tipo_contratto) {
        this.tipo_contratto = tipo_contratto;
    }
    
}