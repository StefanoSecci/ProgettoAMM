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
            
            
        
            <div id="formProfilo">
                <img class="propic" alt="Lester Crest" src="http://media.gtanet.com/gta-5/images/characters/lester-crest_t.jpg"/>
                
                <form action="servlet.java" method="post">
                    <label for="name">Nome</label>
                    <input type="text" name="name" id="name"
                           value="Mario" />

                    <label for="surname">Cognome</label>
                    <input type="text" name="surname" id="surname"
                           value="Rossi" />

                    <label for="data">Nato il</label>
                    <input type="date" name="data" id="data"
                           value="1980-01-01" />

                    <label for="propic">Immagine del profilo</label>
                    <input type="url" name="propic" id="propic"/>

                    <label for="frase">Frase di presentazione</label>
                    <input type="text" name="frase" id="frase"
                           value="hey there! i am using nerdbook"/>

                    <label for="pswd">Password</label>
                    <input type="password" name="pswd" id="pswd"
                           value="password" />

                    <label for="confpswd">Conferma password</label>
                    <input type="password" name="confpswd" id="confpswd"
                           value="password" />

                    <button type="submit">Aggiorna</button>
                </form>
            </div>
            
        </div>
        
        
    </body>
</html>

