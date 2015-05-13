/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author corsojava
 */
@Entity
@Table(name = "CELLULARI")
public class Cellulare implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String numero;
    @OneToMany(mappedBy = "cellulare")
    private List<Contratto> contratti;
    @ManyToOne
    @JsonIgnore
    private Dipendente dipendente;

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public List<Contratto> getContratti() {
        return contratti;
    }

    public void setContratti(List<Contratto> contratti) {
        this.contratti = contratti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final Cellulare other = (Cellulare) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
