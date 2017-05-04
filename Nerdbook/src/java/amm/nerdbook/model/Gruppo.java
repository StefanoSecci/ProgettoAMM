/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;

import java.util.ArrayList;

/**
 *
 * @author Stefano
 */
public class Gruppo {
    // attributi
    private int id;
    private String nomeGruppo;
    private Utente admin;
    private ArrayList<Utente> listaMembri;
    
    //costruttori
    
    public Gruppo()
    {
        id = 0;
        nomeGruppo = "";
        listaMembri = new ArrayList<Utente>();
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
     * @return the nomeGruppo
     */
    public String getNomeGruppo() {
        return nomeGruppo;
    }

    /**
     * @param nomeGruppo the nomeGruppo to set
     */
    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    /**
     * @return the listaMembri
     */
    public ArrayList<Utente> getListaMembri() {
        return listaMembri;
    }

    /**
     * @param listaMembri the listaMembri to set
     */
    public void setListaMembri(ArrayList<Utente> listaMembri) {
        this.listaMembri = listaMembri;
    }
    
    
    /**
     * @return the admin
     */
    public Utente getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Utente admin) {
        this.admin = admin;
    }
    
}
