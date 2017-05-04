<%-- 
    Document   : sidebar
    Created on : 4-mag-2017, 2.21.07
    Author     : Stefano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar">
    <div id="persone">
        <h2>Persone</h2>
        <div id="personeList">
            <ul>
                <c:forEach var="usr" items="${utenti}">    
                    <li>
                        <img class="propic" alt="immagine profilo" src="${usr.getUrlFotoProfilo()}"/>
                        <p><a href="bacheca.html?user=0${usr.getId()}">${usr.getUsername()}</a></p>
                    </li>
                </c:forEach>    
                
            </ul>
        </div>
    </div>

    <div id="gruppi">
        <h2>Gruppi</h2>
        <div id="gruppiList">
            <ul>
                <c:forEach var="grp" items="${gruppi}">
                    <li><p><a href="bacheca.html?group=0${grp.getId()}">${grp.getNomeGruppo()}</a></p></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
