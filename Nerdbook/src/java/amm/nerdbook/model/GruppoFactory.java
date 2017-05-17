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

    //private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {}

    public Gruppo getGruppoById(int id) {
        
        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select * from gruppo "
                    + "where id_gruppo = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, id);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            if (res.next()) {
                Gruppo current = new Gruppo();
                current = this.compilaGruppo(res);

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
    
    public List getGrouptByAdmin(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select * from gruppo "
                    + "where admin = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Gruppo current = new Gruppo();
                current = this.compilaGruppo(res);

                listaGruppo.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGruppo;
    }
    
    public List getGrouptByMembro(Utente usr) {

        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select gruppo.id_gruppo, gruppo.nome, gruppo.admin "
                    + "from gruppo join appartenenzaGruppo "
                    + "on gruppo.id_gruppo = appartenenzaGruppo.gruppo "
                    + "where utente = ?";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Si associano i valori
            stmt.setInt(1, usr.getId());
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Gruppo current = new Gruppo();
                current = this.compilaGruppo(res);

                listaGruppo.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGruppo;
    }
    
    public List getListaGruppi() {
        List<Gruppo> listaGruppo = new ArrayList<Gruppo>();

        try {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "ammdb", "123");
            
            String query = 
                      "select * from gruppo order by nome";
            
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Esecuzione query
            ResultSet res = stmt.executeQuery();

            // ciclo sulle righe restituite
            while (res.next()) {
                Gruppo current = new Gruppo();
                current = this.compilaGruppo(res);

                listaGruppo.add(current);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaGruppo;
        
    }
    
    // prende un result set e crea un gruppo in java
    private Gruppo compilaGruppo(ResultSet res) throws SQLException{
        UtenteFactory utenteFactory = UtenteFactory.getInstance();
        Gruppo current = new Gruppo();
        
        current.setId(res.getInt("id_gruppo"));
        current.setNomeGruppo(res.getString("nome"));
        Utente admin = utenteFactory.getUtenteById(res.getInt("admin"));
        current.setAdmin(admin);
        
        return current;
    }
}
