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
    
    private String costo;
    
    private String compagniaTelefonica;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date scadenza;
    
    private boolean scaduto;
    
   


    public int getId_contratto() {
        return id_contratto;
    }

    public void setId_contratto(int id_contratto) {
        this.id_contratto = id_contratto;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_contratto;
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

    public String getCompagniaTelefonica() {
        return compagniaTelefonica;
    }

    public void setCompagniaTelefonica(String compagniaTelefonica) {
        this.compagniaTelefonica = compagniaTelefonica;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public boolean isScaduto() {
        return scaduto;
    }

    public void setScaduto(boolean scaduto) {
        this.scaduto = scaduto;
    }

    
    
}
