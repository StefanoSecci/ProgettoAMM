/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class UtenteFactory {
    //Pattern Design Singleton
    private static UtenteFactory singleton;

    public static UtenteFactory getInstance() {
        if (singleton == null) {
            singleton = new  UtenteFactory();
        }
        return singleton;
    }

    private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

    private UtenteFactory() {
        
        ArrayList<Utente> temp = new ArrayList<Utente>();
        
        //Creazione utenti
        
        //lester id 0
        Utente user1 = new Utente();
        user1.setId(0);
        user1.setNome("Lester");
        user1.setCognome("Crest");
        user1.setDataNascita("1960-09-17");
        user1.setFrasePresentazione("Welcome to paradise.");
        user1.setPassword("password");
        user1.setUrlFotoProfilo("http://media.gtanet.com/gta-5/images/characters/lester-crest_t.jpg");
        
        //aldo id 1
        Utente user2 = new Utente();
        user2.setId(1);
        user2.setNome("Aldo");
        user2.setCognome("Baglio");
        user2.setDataNascita("1958-09-28");
        user2.setFrasePresentazione("ora non posso ne scendere ne salire, ne scendere ne salire!");
        user2.setPassword("qwerty2");
        user2.setUrlFotoProfilo("http://scontent.cdninstagram.com/t51.2885-19/s150x150/14033682_1638964053080704_540705153_a.jpg");
        
        //giovanni id 2
        Utente user3 = new Utente();
        user3.setId(2);
        user3.setNome("Giovanni");
        user3.setCognome("Storti");
        user3.setDataNascita("1957-02-20");
        user3.setFrasePresentazione("l'arte è un lavoro sporco, qualcuno deve pur farlo");
        user3.setPassword("qwerty3");
        user3.setUrlFotoProfilo("http://www.milanodavedere.it/wp-content/uploads/giovanni-storti-150x150.jpg");
        
        //giacomo id 3
        Utente user4 = new Utente();
        user4.setId(3);
        user4.setNome("Giacomo");
        user4.setCognome("Poretti");
        user4.setDataNascita("1956-04-26");
        user4.setFrasePresentazione("chiedimi se sono felice!");
        user4.setPassword("qwerty4");
        user4.setUrlFotoProfilo("http://www.farodiroma.it/wp-content/uploads/2017/03/Giacomo-Poretti-1%C2%BA-piano1-150x150.jpg");
        
        //steve id 4
        Utente user5 = new Utente();
        user5.setId(4);
        user5.setNome("Steve");
        user5.setCognome("Jobs");
        user5.setDataNascita("1955-02-24");
        user5.setFrasePresentazione("think different, Finkbrau");
        user5.setPassword("qwerty5");
        user5.setUrlFotoProfilo("img/steve.jpg");
        
        
        //bill id 5
        Utente user6 = new Utente();
        user6.setId(5);
        user6.setNome("Bill");
        user6.setCognome("Gates");
        user6.setDataNascita("1955-10-28");
        user6.setFrasePresentazione("il successo porta cattivi consigli");
        user6.setPassword("qwerty6");
        user6.setUrlFotoProfilo("img/bill.jpg");
        
        //mark id 6
        Utente user7 = new Utente();
        user7.setId(6);
        user7.setNome("Mark");
        user7.setCognome("Zuckerberg");
        user7.setDataNascita("1984-05-14");
        user7.setFrasePresentazione("quanto costa questo sito?");
        user7.setPassword("qwerty7");
        user7.setUrlFotoProfilo("img/mark.jpg");
        
        // user7 id 7, utente incompleto
        Utente user8 = new Utente();
        user8.setId(7);
        user8.setNome(null);
        user8.setCognome("Incompleto");
        user8.setDataNascita("1000-10-10");
        user8.setFrasePresentazione(null);
        user8.setPassword("qwerty8");
        user8.setUrlFotoProfilo("http://www.gssi.infn.it/images/studenti-ritratti/no-utente.jpg");
        
        //creazione amicizie
        
        //lester -> steve, bill, mark
        temp.add(user5);
        temp.add(user6);
        temp.add(user7);
        user1.setListaAmici(temp);
        temp.clear();
        
        //aldo -> giovanni, giacomo
        temp.add(user3);
        temp.add(user4);
        user2.setListaAmici(temp);
        temp.clear();
        
        //giovanni -> aldo, giacomo
        temp.add(user2);
        temp.add(user4);
        user3.setListaAmici(temp);
        temp.clear();
        
        //giacomo -> giovanni, aldo
        temp.add(user3);
        temp.add(user2);
        user4.setListaAmici(temp);
        temp.clear();
        
        //steve -> lester
        temp.add(user1);
        user5.setListaAmici(temp);
        temp.clear();
        
        //bill -> lester
        temp.add(user1);
        user6.setListaAmici(temp);
        temp.clear();
        
        //mark -> lester
        temp.add(user1);
        user7.setListaAmici(temp);
        temp.clear();
        
        listaUtenti.add(user1);
        listaUtenti.add(user2);
        listaUtenti.add(user3);
        listaUtenti.add(user4);
        listaUtenti.add(user5);
        listaUtenti.add(user6);
        listaUtenti.add(user7);
        listaUtenti.add(user8);
        
    }

    public Utente getUtenteById(int id) {
        for (Utente user : this.listaUtenti) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String username, String password){
        for(Utente user : this.listaUtenti){
            if(user.getUsername().equals(username))
            {
                if(user.getPassword().equals(password))
                {
                    return user.getId();
                }
                else
                {
                    return -2;
                }
            }
        }
        return -1;
    }
    
    public List getListaUtenti() {

        List<Utente> userList = new ArrayList<Utente>();

        userList = this.listaUtenti;
        
        return userList;
    }
    
    
}
