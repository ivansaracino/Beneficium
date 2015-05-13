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
    
    private String costo;
    
    private String compagniaTelefonica;
    
    private String tipo_contratto;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_attivazione;
    
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date scadenza;
    
    private boolean scaduto;
    
    @ManyToOne
    private Automobile automobile;
    
    @ManyToOne
    private Cellulare cellulare;
    
   


    public int getId_contratto() {
        return id_contratto;
    }

    public void setId_contratto(int id_contratto) {
        this.id_contratto = id_contratto;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public Cellulare getCellulare() {
        return cellulare;
    }

    public void setCellulare(Cellulare cellulare) {
        this.cellulare = cellulare;
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

    public String getTipo_contratto() {
        return tipo_contratto;
    }

    public void setTipo_contratto(String tipo_contratto) {
        this.tipo_contratto = tipo_contratto;
    }

    public Date getData_attivazione() {
        return data_attivazione;
    }

    public void setData_attivazione(Date data_attivazione) {
        this.data_attivazione = data_attivazione;
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
