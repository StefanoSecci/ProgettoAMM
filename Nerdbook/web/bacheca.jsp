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
        <title>Bacheca</title>
        <meta charset="UTF-8">
        <meta name="keywords" content="bacheca, nerdbook, post, notizie">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="bacheca personale">
        <meta name="author" content="Stefano Secci">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <link href='//fonts.googleapis.com/css?family=Tauri' rel='stylesheet'>
    </head>
    <body>
        
        <!-- include navbar -->
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="navbar.jsp"/>
        
        
        <div id="divBody">
            
            <jsp:include page="sidebar.jsp"/>
            
                
            
            
            
            <c:if test="${proprietario != null}">
                <div id="stato">
                    <img class="propic" alt="foto profilo" src="${proprietario.getUrlFotoProfilo()}"/>
                    <p><strong>${proprietario.getUsername()}: </strong></p>
                    <p>${proprietario.getFrasePresentazione()}</p>
                </div>
            </c:if>
            <c:if test="${gruppo != null}">
                <div id="stato">
                    
                    <p><strong>${gruppo.getNomeGruppo()}</strong></p>
                    
                </div>
            </c:if>
            



            <div id="bacheca">
                <c:forEach var="post" items="${posts}">
                    <div class="post">
                        <img class="propic" alt="foto profilo" src="${post.getAutore().getUrlFotoProfilo()}">
                        <h3><a href="bacheca.html?user=0${post.getAutore().getId()}">${post.getAutore().getUsername()}</a></h3>
                        <p>${post.getContent()}</p>
                        <c:if test="${post.postType == 'LINK'}">
                            <a class="allegato" href="${post.getUrlAllegato()}">${post.getUrlAllegato()}</a>
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                            <img class="allegato" alt="immagine allegato" src="${post.getUrlAllegato()}">
                        </c:if>
                        
                    </div>
                </c:forEach>
                
            </div>
            
            
            
        </div>
        
        
        
        
    </body>
</html>

