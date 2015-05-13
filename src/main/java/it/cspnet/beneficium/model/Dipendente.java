/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cspnet.beneficium.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author corsojava
 */

@Entity
@Table(name = "DIPENDENTI")
public class Dipendente implements Serializable{
    
    @Id
    @NotEmpty
    private String codiceFiscale;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String cognome;
    @NotEmpty
    private String indirizzo;
    private float stipendioMensile;

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public float getStipendioMensile() {
        return stipendioMensile;
    }

    public void setStipendioMensile(float stipendioMensile) {
        this.stipendioMensile = stipendioMensile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.codiceFiscale != null ? this.codiceFiscale.hashCode() : 0);
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
        final Dipendente other = (Dipendente) obj;
        if ((this.codiceFiscale == null) ? (other.codiceFiscale != null) : !this.codiceFiscale.equals(other.codiceFiscale)) {
            return false;
        }
        return true;
    }

}
