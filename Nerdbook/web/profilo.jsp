<%-- 
    Document   : profilo
    Created on : 4-mag-2017, 10.59.41
    Author     : Stefano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="keywords" content="profilo, utente, nerdbook, nome">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="profilo personale di nerdbook">
        <meta name="author" content="Stefano Secci">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <link href='//fonts.googleapis.com/css?family=Tauri' rel='stylesheet'>
    </head>
    <body>
        
        <!-- include navbar -->
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="navbar.jsp"/>
       
        
        <div id="divBody">
            
            
            
            <jsp:include page="sidebar.jsp"/>
            
            
        
            
            <c:choose>
                <c:when test="${click == 1}">
                    <div id="formProfilo">
                        
                        <div class="datiProfilo">
                            <h3>Dati inseriti correttamente</h3>

                            <c:if test="${!empty newNome}">
                                <p><strong>nome:</strong> ${newNome}</p>
                            </c:if>
                            <c:if test="${!empty newCognome}">
                                <p><strong>cognome:</strong> ${newCognome}</p>
                            </c:if>
                             <c:if test="${!empty newDataNascita}">
                                <p><strong>data di nascita:</strong> ${newDataNascita}</p>
                            </c:if>
                             <c:if test="${!empty newPropic}">
                                <p><strong>immagine del profilo:</strong> ${newPropic}</p>
                            </c:if>
                            <c:if test="${!empty newFrase}">
                                <p><strong>stato:</strong> ${newFrase}</p>
                            </c:if>
                            <c:if test="${!empty newUsername}">
                                <p><strong>username:</strong> ${newUsername}</p>
                            </c:if>
                            <c:if test="${!empty newPassword}">
                                <p><strong>password:</strong> ${newPassword}</p>
                            </c:if>
                        </div>


                    </div>
                </c:when>
                <c:otherwise>
                    <div id="formProfilo">
                        
                        <c:if test="${click == 2}">
                            <div id="invalidDataWarning">password non valida</div>
                        </c:if>

                        <img class="propic" alt="foto profilo" src="${utenteLoggato.getUrlFotoProfilo()}"/>


                        <form action="Profilo" method="post">
                            <c:choose>
                                <c:when test="${click == 3}">
                                    <p class="center"><strong>Sei veramente sicuro?</strong></p>
                                    <input class="hidden" type="text" name="userp" id="userp"
                                           value="${userp2}" />
                                    <button type="submit" name="cancellaProfilo" value="deleteOk">Cancella Profilo</button>
                                </c:when>
                                
                                <c:otherwise>
                                    <label for="name">Nome</label>
                                    <input type="text" name="name" id="name"
                                           value="${utenteLoggato.getNome()}" />

                                    <label for="surname">Cognome</label>
                                    <input type="text" name="surname" id="surname"
                                           value="${utenteLoggato.getCognome()}" />

                                    <label for="data">Nato il</label>
                                    <input type="date" name="data" id="data"
                                           value="${utenteLoggato.getDataNascitaString()}" />

                                    <label for="propic">Immagine del profilo</label>
                                    <input type="url" name="propic" id="propic"
                                           value="${utenteLoggato.getUrlFotoProfilo()}"/>

                                    <label for="frase">Frase di presentazione</label>
                                    <input type="text" name="frase" id="frase"
                                           value="${utenteLoggato.getFrasePresentazione()}"/>

                                    <label for="username">Username</label>
                                    <input type="text" name="username" id="surname"
                                           value="${utenteLoggato.getUsername()}" />

                                    <label for="pswd">Password</label>
                                    <input type="password" name="pswd" id="pswd"
                                           value="" />

                                    <label for="confpswd">Conferma password</label>
                                    <input type="password" name="confpswd" id="confpswd"
                                           value="" />


                                    <input class="hidden" type="text" name="userp" id="userp"
                                           value="${utenteLoggato.getId()}" />

                                    <button type="submit" name="modificaProfilo" value="needConfirm">Aggiorna</button>
                                    <p class="center">Oppure</p>
                                    <button type="submit" name="cancellaProfilo" value="deleteProfile">Cancella Profilo</button>
                                </c:otherwise>
                            </c:choose>
                            
                            
                        </form>
                        
                    </div>
                    
                </c:otherwise>
            </c:choose>
                
            
            
        </div>
        
        
    </body>
</html>

