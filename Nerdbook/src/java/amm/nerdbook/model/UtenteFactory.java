/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    //Gestione DB
    private String connectionString;
    private Object java;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    //private ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    private UtenteFactory() {} 

    public Utente getUtenteById(int id) {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select * from utente "
                    + "where id_utente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Utente current = new Utente();
                current = this.compilaUtente(res);

                stmt.close();
                conn.close();
                return current;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String username, String password){
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                  "select id_utente from utente "
                + "where username = ? and password = ?";

            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);

            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);

            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            

            // ciclo sulle righe restituite
            if (res.next()) {
                int id = res.getInt("id_utente");

                stmt.close();
                conn.close();
                return id;
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1;
    }
    
    public List getListaUtenti() {

        List<Utente> userList = new ArrayList<Utente>();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select * from utente order by cognome, nome";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                
                Utente current = new Utente();
                current = this.compilaUtente(res);

                userList.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //userList = this.listaUtenti;
        
        return userList;
    }
    
    /*public void deleteUser(Utente usr)
    {
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            int idUser = usr.getId();
            
            String cancellaPost = 
                      "delete from post "
                    + "where utenteDestinatario = ? or autore = ?";
            
            String cancellaAmicizie =
                    "delete from amicizia "
                    + "where utente = ? or amico = ?";
            
            String cancellaAppartenenzaGruppi = 
                    "delete from appartenenzaGruppo "
                    + "where utente = ?";
            
            String cancellaGruppi = 
                    "delete from gruppo "
                    + "where admin = ?";
            
            String cancellaUtente = 
                    "delete from Utente "
                    + "where id_utente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
    // prende un result set e crea un utente in java
    private Utente compilaUtente(ResultSet res) throws SQLException{
        java.sql.Date dbDate;
        Utente current = new Utente();
        
        current.setId(res.getInt("id_utente"));
        current.setNome(res.getString("nome"));
        current.setCognome(res.getString("cognome"));
        dbDate=res.getDate("dataNascita");
        current.setDataNascita(new java.util.Date(dbDate.getTime()));
        current.setFrasePresentazione(res.getString("frasePresentazione"));
        current.setPassword(res.getString("password"));
        current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
        current.setSuperUtente(res.getBoolean("superUtente"));
        current.setUsername(res.getString("username"));
        
        return current;
    }
}
    

