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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        
        int userID;
        
        int utenteLoggato;
        
        Utente loggato = null;
        Utente proprietarioBacheca = null;
        Gruppo gruppoBacheca = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        HttpSession session = request.getSession(false);
        
        if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
            
            
            
            utenteLoggato = (Integer)session.getAttribute("loggedUserID");
            
            // variabili per navbar e sidebar
            loggato = UtenteFactory.getInstance().getUtenteById(utenteLoggato);

            List<Utente> utenti = UtenteFactory.getInstance().getListaUtenti();
            List<Gruppo> gruppi = GruppoFactory.getInstance().getListaGruppi();

            request.setAttribute("utenteLoggato", loggato);
            request.setAttribute("utenti", utenti);
            request.setAttribute("gruppi", gruppi);

            if(request.getParameter("modificaProfilo")!=null){
                //logica profilo
                request.setAttribute("click", 0);
                String s = request.getParameter("name"); //prendo la stringa ...
                String newNome = new String (s.getBytes("ISO-8859-1"), "UTF-8"); // ... e la converto
                s = request.getParameter("surname");
                String newCognome = new String (s.getBytes("ISO-8859-1"), "UTF-8");
                String newDataNascita = request.getParameter("data");
                String newPropic = request.getParameter("propic");
                s = request.getParameter("frase");
                String newFrase = new String (s.getBytes("ISO-8859-1"), "UTF-8");
                s = request.getParameter("username");
                String newUsername = new String (s.getBytes("ISO-8859-1"), "UTF-8");
                String newPassword = request.getParameter("pswd");
                String confPsw = request.getParameter("confpswd");
                String userp = request.getParameter("userp");
                String modificaProfilo = request.getParameter("modificaProfilo");

                if(userp != null)
                {
                    userID = Integer.parseInt(userp);
                }
                else
                {
                    userID = utenteLoggato;
                }

                if(userID == utenteLoggato)
                {
                    if (modificaProfilo.equals("needConfirm"))
                    {
                        if(newPassword != null && confPsw != null && newPassword.equals(confPsw) )
                        {
                            request.setAttribute("newNome", newNome);
                            request.setAttribute("newCognome", newCognome);
                            try {
                                Date date = df.parse(newDataNascita);
                                String dn = date.getDate() + "/" + date.getMonth() + "/" + date.getYear();
                                request.setAttribute("newDataNascita", dn);
                            } catch (ParseException ex) {
                                Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            request.setAttribute("newPropic", newPropic);
                            request.setAttribute("newFrase", newFrase);
                            request.setAttribute("newUsername", newUsername);
                            request.setAttribute("newPassword", newPassword);
                            //request.setAttribute("ggg", userp);


                            request.setAttribute("click", 1);
                        }
                        else
                        {
                            request.setAttribute("click", 2);

                        }


                    } 

                    //request.getRequestDispatcher("profilo.jsp").forward(request, response);
                }

                else{
                    response.sendError(400, "stai tentando di modifiare i dati di un profilo che non ti appartiene!");

                }
            
            }else if(request.getParameter("cancellaProfilo")!= null)
            {
                String userp = request.getParameter("userp");
                String cancellaProfilo = request.getParameter("cancellaProfilo");
                request.setAttribute("click", 0);
                
                if(userp != null)
                {
                    userID = Integer.parseInt(userp);
                }
                else
                {
                    userID = utenteLoggato;
                }

                if(userID == utenteLoggato)
                {
                    if (cancellaProfilo.equals("deleteProfile"))
                    {
                        request.setAttribute("userp2", userp);
                        request.setAttribute("click", 3);
                        
                    }
                    else
                    {
                        request.setAttribute("click", 0);
                        UtenteFactory.getInstance().deleteUser(loggato);
                        request.getRequestDispatcher("Login?logout=1").forward(request, response);
                    }
                }else{
                    
                    response.sendError(400, "stai tentando di cancellare un profilo che non ti appartiene!");
                }
                //request.getRequestDispatcher("Login?logout=1").forward(request, response);
            }
            
            
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }
        else{
            
            response.sendError(400, "accesso non consentito agli utenti non autenticati");
        }
        
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
