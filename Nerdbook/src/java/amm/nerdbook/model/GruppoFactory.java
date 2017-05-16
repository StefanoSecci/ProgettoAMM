/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class GruppoFactory {
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new  GruppoFactory();
        }
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {
        UtenteFactory userFactory = UtenteFactory.getInstance();
        ArrayList<Utente> temp = new ArrayList<Utente>();
        
        //Creazione utenti
        
        //applefag id 0
        //admin: steve
        //membri: aldo, giovanni, mark
        Gruppo group1 = new Gruppo();
        group1.setId(0);
        group1.setNomeGruppo("AppleFag");
        group1.setAdmin(userFactory.getUtenteById(4));
        temp.add(userFactory.getUtenteById(1));
        temp.add(userFactory.getUtenteById(2));
        temp.add(userFactory.getUtenteById(6));
        group1.setListaMembri(temp);
        
        temp.clear();
        
        //commodore zone id 1
        //admin: lester
        //membri: gicomo, giovanni
        Gruppo group2 = new Gruppo();
        group2.setId(1);
        group2.setNomeGruppo("Commodore Zone");
        group2.setAdmin(userFactory.getUtenteById(0));
        temp.add(userFactory.getUtenteById(3));
        temp.add(userFactory.getUtenteById(2));
        group2.setListaMembri(temp);
        
        temp.clear();
        
        listaGruppi.add(group1);
        listaGruppi.add(group2);
        
    }

    public Gruppo getGruppoById(int id) {
        for (Gruppo group : this.listaGruppi) {
            if (group.getId() == id) {
                return group;
            }
        }
        return null;
    }
    
    public List getGrouptByAdmin(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        for (Gruppo gruppo : this.listaGruppi) {
            if (gruppo.getAdmin().equals(usr)) {
                listaGruppo.add(gruppo);
            }
        }
        return listaGruppo;
    }
    
    public List getGrouptByMembro(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        for (Gruppo gruppo : this.listaGruppi) {
            for (Utente membro : gruppo.getListaMembri()) {
                if (membro.equals(usr)) {
                    listaGruppo.add(gruppo);
                }
            }
            
        }
        return listaGruppo;
    }
    
    public List getListaGruppi() {

        List<Gruppo> groupList = new ArrayList<Gruppo>();

        groupList = this.listaGruppi;
        
        return groupList;
    }
}
