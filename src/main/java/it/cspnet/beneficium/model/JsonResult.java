/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cspnet.beneficium.model;

/**
 *
 * @author dave
 */
public class JsonResult {

    private Object oggetto;

    private String messaggio;

    private boolean status;

    public Object getOggetto() {
        return oggetto;
    }

    public void setOggetto(Object oggetto) {
        this.oggetto = oggetto;
    }


    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
