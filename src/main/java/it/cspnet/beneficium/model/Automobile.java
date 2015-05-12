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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author luca
 */

@Entity
public class Automobile {
    
    @Id
    @GeneratedValue
    private int idAuto;
    
    @NotEmpty
    private String targa;
    @NotEmpty
    private String modello;
    @NotNull
    private Float tariffaMensile;
    private boolean scaduto;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date scadenza;
    @NotEmpty
    private String compagniaLeasing;

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Float getTariffaMensile() {
        return tariffaMensile;
    }

    public void setTariffaMensile(Float tariffaMensile) {
        this.tariffaMensile = tariffaMensile;
    }

    public boolean isScaduto() {
        return scaduto;
    }

    public void setScaduto(boolean scaduto) {
        this.scaduto = scaduto;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public String getCompagniaLeasing() {
        return compagniaLeasing;
    }

    public void setCompagniaLeasing(String compagniaLeasing) {
        this.compagniaLeasing = compagniaLeasing;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idAuto;
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
        final Automobile other = (Automobile) obj;
        if (this.idAuto != other.idAuto) {
            return false;
        }
        return true;
    }
   
    
    
}
