package it.cspnet.beneficium.model;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

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

    @OneToMany(mappedBy = "automobile", fetch = FetchType.LAZY)
    private Collection<Contratto_Auto> contrattoAuto;

    public int getIdAuto() {
        return idAuto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idAuto;
        return hash;
    }

    public Collection<Contratto_Auto> getContrattoAuto() {
        return contrattoAuto;
    }

    public void setContrattoAuto(Collection<Contratto_Auto> contrattoAuto) {
        this.contrattoAuto = contrattoAuto;
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

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Collection<Contratto_Auto> getContratti() {
        return contrattoAuto;
    }

    public void setContratti(Collection<Contratto_Auto> contratti) {
        this.contrattoAuto = contratti;
    }

}
