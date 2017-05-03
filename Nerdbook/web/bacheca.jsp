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
            
            
            
                
            <div id="sidebar">
            
                <div id="persone">
                    <h2>Persone</h2>
                    <div id="personeList">
                        <ul>
                            <li>
                                <img class="propic" alt="aldo" src="http://scontent.cdninstagram.com/t51.2885-19/s150x150/14033682_1638964053080704_540705153_a.jpg"/>
                                <p><a href="profilo.html">Aldo Baglio</a></p>
                            </li>
                            <li>
                                <img class="propic" alt="giovanni" src="http://www.milanodavedere.it/wp-content/uploads/giovanni-storti-150x150.jpg"/>
                                <p><a href="profilo.html">Giovanni Storti</a></p>
                            </li>
                            <li>
                                <img class="propic" alt="giacomo" src="http://www.farodiroma.it/wp-content/uploads/2017/03/Giacomo-Poretti-1%C2%BA-piano1-150x150.jpg"/>
                                <p><a href="profilo.html">Giacomo Poretti</a></p>
                            </li>
                        </ul>
                    </div>
                </div>

                <div id="gruppi">
                    <h2>Gruppi</h2>
                    <div id="gruppiList">
                        <ul>
                            <li><p><a href="bacheca.html">Commodore Zone</a></p></li>
                            <li><p><a href="bacheca.html">AppleFag</a></p></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            
            
            <div id="stato">
                <img class="propic" alt="Lester Crest" src="http://media.gtanet.com/gta-5/images/characters/lester-crest_t.jpg"/>
                <p><strong>Lester Crest: </strong></p>
                <p>we did it! ...well, you did it</p>
            </div>



            <div id="bacheca">
                <div class="post">
                    <img class="propic" alt="foto profilo di steve" src="img/steve.jpg">
                    <h3><a href="profilo.html">$teve Jobs</a></h3>
                    <p>sto cercando uno smartphone, budget 200 euro. Qual è il migliore?</p>
                </div>

                <div class="post">
                    <img class="propic" alt="foto profilo di bill" src="img/bill.jpg">
                    <h3><a href="profilo.html">Bill Gates</a></h3>
                    <p>mi è apparsa questa schermata, che faccio? :-O</p>
                    <img class="allegato" alt="schermata blu" src="img/Schermata-blu.jpg">
                </div>

                <div class="post">
                    <img class="propic" alt="foto profilo di mark" src="img/mark.jpg">
                    <h3><a href="profilo.html">Mark Zuckerberg</a></h3>
                    <p>mi sono stancato di questo sito!!11!!1!!1!!1!! da ora in poi mi trovate qui</p>
                    <a class="allegato" href="https://www.facebook.com/zuck?fref=ts">facebook.com/zuck</a>
                </div>
                
                <div class="post">
                    <img class="propic" alt="foto profilo di bill" src="img/bill.jpg">
                    <h3><a href="profilo.html">Bill Gates</a></h3>
                    <p>Stiamo lavorando a un'app di NerdBook per windows phone,
                    saremo i primi ad averla! peccato che nessuno compri più i nostro smartphone :'(
                    poi parole a caso perchè voglio vedere come si comporta un testo lungo.
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla id aliquet diam. Sed a venenatis leo, in gravida neque. Sed eu molestie ipsum. Sed ut metus sit amet odio efficitur scelerisque. Sed aliquet pulvinar nisi, at eleifend elit hendrerit sit amet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis augue diam, tincidunt eu congue vel, pulvinar sit amet ex. Nam rutrum orci vel magna luctus tristique. Fusce ipsum lectus, sollicitudin a suscipit eu, pulvinar vestibulum metus. Vivamus eleifend turpis eget risus gravida gravida. Vivamus diam ante, eleifend dignissim volutpat eu, interdum blandit neque. Sed in finibus massa, in consequat elit. Cras dignissim nunc massa, id tincidunt nibh placerat id. Maecenas sapien lectus, consectetur sit amet mauris at, consectetur suscipit turpis. Pellentesque quis lacinia mauris. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </div>
                
                <div class="post">
                    <img class="propic" alt="foto profilo di mark" src="img/mark.jpg">
                    <h3><a href="profilo.html">Mark Zuckerberg</a></h3>
                    <p>grande è questa imagine? mi che grande ched'è!</p>
                    <img class="allegato" alt="sfondo nerd" src="img/grande.jpg">
                </div>
            </div>
            
            
            
        </div>
        
        
        
        
    </body>
</html>

