/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook;

import amm.nerdbook.model.Gruppo;
import amm.nerdbook.model.GruppoFactory;
import amm.nerdbook.model.Post;
import amm.nerdbook.model.PostFactory;
import amm.nerdbook.model.Utente;
import amm.nerdbook.model.UtenteFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stefano
 */
@WebServlet(name = "Profilo_1", urlPatterns = {"/Profilo_1"})
public class Profilo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String group = request.getParameter("group");

        int userID;
        int groupID;
        int utenteLoggato;
        Utente loggato = null;
        Utente proprietarioBacheca = null;
        Gruppo gruppoBacheca = null;

        utenteLoggato = 0; //Da sostituire con utente loggato

        if(user != null){

            userID = Integer.parseInt(user);
            proprietarioBacheca = UtenteFactory.getInstance().getUtenteById(userID);

        } else if(group != null)
        {
            groupID = Integer.parseInt(group);
            gruppoBacheca = GruppoFactory.getInstance().getGruppoById(groupID);
            
            
        }else
        {
            proprietarioBacheca = UtenteFactory.getInstance().getUtenteById(utenteLoggato);
        }

        
        // variabili per navbar e sidebar
        loggato = UtenteFactory.getInstance().getUtenteById(utenteLoggato);

        if(loggato != null){

            List<Utente> utenti = UtenteFactory.getInstance().getListaUtenti();
            List<Gruppo> gruppi = GruppoFactory.getInstance().getListaGruppi();
            
            request.setAttribute("utenteLoggato", loggato);
            request.setAttribute("utenti", utenti);
            request.setAttribute("gruppi", gruppi);

            //request.getRequestDispatcher("bacheca.jsp").forward(request, response);

        } else {

            //response.setStatus(HttpServletResponse.SC_NOT_FOUND, "non puoi accedere a questa pagina perchè non sei loggato");

        }
        
        request.getRequestDispatcher("profilo.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
