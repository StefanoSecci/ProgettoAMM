<%-- 
    Document   : login
    Created on : 4-mag-2017, 12.11.32
    Author     : Stefano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="keywords" content="login, nerdbook, password, username">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="pagina di login di nerdbook">
        <meta name="author" content="Stefano Secci">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <link href='//fonts.googleapis.com/css?family=Tauri' rel='stylesheet'>
    </head>
    <body>
        <header>
            <div id="title">
                <h1>NerdBook</h1>
            </div>
        </header>
        
        
        
        <div id="formLogin">
            
            
            <c:if test="${invalidData == -1}">
                    <div id="invalidDataWarning">Username o password non inseriti correttamente</div>
            </c:if>
            
            
            <form action="Login" method="post">
                <label for="user">Nome Utente</label>
                <input type="text" name="userLogin" id="user"
                       placeholder="username" />
                
                <label for="pswd">Password</label>
                <input type="password" name="pswdLogin" id="pswd"
                       placeholder="password" />
                
                <button type="submit">Accedi</button>
            </form>
        </div>
        
        
    </body>
</html>

