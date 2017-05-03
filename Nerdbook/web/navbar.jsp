<%-- 
    Document   : navbar
    Created on : 3-mag-2017, 21.15.48
    Author     : Stefano
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="barra">
            <div id="navbar">
                <div id="logo">
                    <h1><a href="descrizione.html">NerdBook</a></h1>
                </div>

                <nav>
                    <ul>
                        
                        <li <c:if test="${page=='profilo'}">class="attuale"</c:if>><a href="profilo.html">profilo</a></li>
                        <li <c:if test="${page=='bacheca'}">class="attuale"</c:if>><a href="bacheca.html">bacheca</a></li>
                       
                    </ul>
                </nav>

                <div id="login">
                    <img class="propic" alt="immagine profilo" src="http://media.gtanet.com/gta-5/images/characters/lester-crest_t.jpg"/>
                    <p>nome da mettere</p>
                    <a href="login.html">logout</a>
                </div>
            </div>
        </header>