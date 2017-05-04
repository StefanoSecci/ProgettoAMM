/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Stefano
 */
public class Utente {
    
    //attributi
    
    private int id;
    private String nome;
    private String cognome;
    private Date dataNascita;
    private String frasePresentazione;
    private String password;
    private String urlFotoProfilo;
    private ArrayList<Utente> listaAmici;
    
    //costruttori

    public Utente() {
        id = 0;
        nome = "";
        cognome = "";
        dataNascita = new Date();
        frasePresentazione = "";
        password = "";
        urlFotoProfilo = "";
        listaAmici = new ArrayList<Utente>();
    }

    //set e get

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the dataNascita
     */
    public Date getDataNascita() {
        return dataNascita;
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    /**
     * @return the frasePresentazione
     */
    public String getFrasePresentazione() {
        return frasePresentazione;
    }

    /**
     * @param frasePresentazione the frasePresentazione to set
     */
    public void setFrasePresentazione(String frasePresentazione) {
        this.frasePresentazione = frasePresentazione;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the urlFotoProfilo
     */
    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    /**
     * @param urlFotoProfilo the urlFotoProfilo to set
     */
    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }
    
    //metodi
    
    public String getUsername() 
    {
        return nome + " " + cognome;
    }
    
    /*@Override
    public boolean equals(Object o){
        if(this == o)
        {
            return true;
        } 
        if (o == null)
        {
            return false;
        }
        
        Utente other = (Utente) o;
        
        return this.getId() == other.getId();
    }*/

    /**
     * @return the listaAmici
     */
    public ArrayList<Utente> getListaAmici() {
        return listaAmici;
    }

    /**
     * @param listaAmici the listaAmici to set
     */
    public void setListaAmici(ArrayList<Utente> listaAmici) {
        this.listaAmici = listaAmici;
    }
}
