/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
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
    
    @ManyToOne
    @JsonIgnore
    private Dipendente dipendente;
    
//    @OneToMany(mappedBy = "automobile")
//    private Collection<Contratto> contratti;        

    
    public Dipendente getDipendente() {
        return dipendente;
    }

    
    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

//    public Collection<Contratto> getContratti() {
//        return contratti;
//    }
//
//    public void setContratti(Collection<Contratto> contratti) {
//        this.contratti = contratti;
//    }
    
    
    
    
    
   
  

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
