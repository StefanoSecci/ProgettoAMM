/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Date dataNascita; // formato yyyy-mm-dd
    private String frasePresentazione;
    private String password;
    private String urlFotoProfilo;
    private boolean superUtente;
    private String username;
    
    //costruttori

    public Utente() {
        id = 0;
        nome = null;
        cognome = null;
        dataNascita = null;
        frasePresentazione = null;
        password = null;
        urlFotoProfilo = null;
        superUtente = false;
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
    
    

    /**
     * @return the dataNascita
     */
    public Date getDataNascita() {
        return dataNascita;
    }
    
    public String getDataNascitaString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        return df.format(this.dataNascita);
    }

    /**
     * @param dataNascita the dataNascita to set
     */
    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    
    public void setDataNascita(String dataNascita) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        this.dataNascita = df.parse(dataNascita);
    }

    /**
     * @return the superUtente
     */
    public boolean isSuperUtente() {
        return superUtente;
    }

    /**
     * @param superUtente the superUtente to set
     */
    public void setSuperUtente(boolean superUtente) {
        this.superUtente = superUtente;
    }

    void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() 
    {
        return this.username;
    }
}
