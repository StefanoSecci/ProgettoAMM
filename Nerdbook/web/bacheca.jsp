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
                
                
                
                <div id="formPost" class="post">
                    
                    
                    <c:if test="${proprietario != null}">
                        <c:set var="urlAction" value="Bacheca?user=${proprietario.getId()}"/> 
                    </c:if>
                    <c:if test="${gruppo != null}">
                        <c:set var="urlAction" value="Bacheca?group=${gruppo.getId()}"/>
                    </c:if>
                    <form action="${urlAction}" method="post">
                        
                        <input type="text" name="testo" id="testo"
                               value="Testo nuovo Post" />

                        
                        <input type="url" name="allegato" id="allegato"
                               value="URL allegato (opzionale)" />
                        
                        
                        <label for="foto">immagine</label>
                        <input type="radio" name="tipo" id="foto"
                               value="foto"/>
                        
                        <label for="foto">link</label>
                        <input type="radio" name="tipo" id="link"
                               value="link"/>
                     

                        
                        <!-- variabili per capire bacheca e autore -->
                       
                        <input class="hidden" type="text" name="userp" id="userp"
                               value="${utenteLoggato.getId()}" />
                        
                        <input class="hidden" type="text" name="userd" id="userd"
                               value="${proprietario.getId()}" />
                        
                        <input class="hidden" type="text" name="groupd" id="groupd"
                               value="${gruppo.getId()}" />

                        <button type="submit">Crea post</button>
                    </form>
                    
                </div>
                               
                <c:if test="${click == 1}">
                    <div id="formPost" class="post">
                        <c:if test="${proprietario != null}">
                            <c:set var="urlAction2" value="Bacheca?user=${proprietario.getId()}&click=2"/> 
                        </c:if>
                        <c:if test="${gruppo != null}">
                            <c:set var="urlAction2" value="Bacheca?group=${gruppo.getId()}&click=2"/>
                        </c:if>
                        <form action="${urlAction2}" method="post">
                            <h3>Riepilogo </h3>

                            <p><strong>autore:</strong> ${utenteLoggato.getUsername()}</h2>

                            <c:if test="${!empty proprietario}">
                                <p><strong>destinatario:</strong> ${proprietario.getUsername()}</p>
                                    <!-- proprietario bacheca -->
                            </c:if>
                            <c:if test="${!empty gruppo}">
                                <p><strong>gruppo:</strong> ${gruppo.getNomeGruppo()}</p>
                            </c:if>

                            <c:if test="${!empty testo}">
                                <p><strong>messaggio:</strong> ${testo}</p>
                            </c:if>

                            <c:if test="${!empty tipo}">
                                <p><strong>tipo:</strong> ${tipo}</p>
                                <c:if test="${!empty allegato}">
                                    <p><strong>url:</strong>${allegato}</p>
                                </c:if>
                            </c:if>

                            


                            <button type="submit">conferma</button>
                        </form>
                    </div>        
                </c:if>
                               
                <c:if test="${click == 2}">
                    
                    <c:if test="${!empty proprietario}">
                        <h3>Hai scritto sulla bacheca di <a href="bacheca.html?user=0${proprietario.getId()}">${proprietario.getUsername()}</a></h3>
                            <!-- proprietario bacheca -->
                    </c:if>
                            
                            
                    <c:if test="${!empty gruppo}">
                        <h3>Hai scritto sulla bacheca di <a href="bacheca.html?group=0${gruppo.getId()}">${gruppo.getNomeGruppo()}</a></h3>
                    </c:if>
                    
                        
                    <!--
                    <div class="post">
                        
                        
                        
                        <img class="propic" alt="foto profilo" src="${utenteLoggato.getUrlFotoProfilo()}">
                        <h3><a href="bacheca.html?user=0${utenteLoggato.getId()}">${utenteLoggato.getUsername()}</a></h3>
                        
                        <p>${testo}</p>
                        <c:if test="${tipo == 'link'}">
                            <a class="allegato" href="${allegato}">${allegato}</a>
                        </c:if>
                        <c:if test="${tipo == 'foto'}">
                            <img class="allegato" alt="immagine allegato" src="${allegato}">
                        </c:if>
                        
                        
                    </div>
                    -->
                </c:if>
                
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

