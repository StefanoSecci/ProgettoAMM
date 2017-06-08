function createError(){
 
    return $("<div>")
        .attr("id","invalidDataWarning")
        .html("nessun utente trovato");
}

// <div id="invalidDataWarning"></div>

function createElement(usr){
    var link = $("<a>")
        .attr("href", "bacheca.html?user=0" + usr.id)
        .html(usr.nome + " " + usr.cognome);
    var userData = $("<p>")
        .append(link);
    var profilePic = $("<img>")
        .attr("class","propic")
        .attr("alt","Foto Profilo")
        .attr("src",usr.urlFotoProfilo);
    
    
    return $("<li>")
        .append(profilePic)
        .append(userData);
}

/*
<div id="personeList">
    <ul id="personeUi">
        <c:forEach var="usr" items="${utenti}">    
            <li>
                <img class="propic" alt="immagine profilo" src="${usr.getUrlFotoProfilo()}"/>
                <p><a href="bacheca.html?user=0${usr.getId()}">${usr.getNomeCognome()}</a></p>
            </li>
        </c:forEach>    

    </ul>
</div>
 */



function stateSuccess(data){
    var userListPage = $("#personeList");
    var userUl = $("<ul>").attr("id","personeUi");
    
    if(data.length === 0)
    {
        $(userListPage).empty();
        $(userListPage).append(createError());
    }else
    {
        $(userListPage).empty();
        $(userListPage).append(userUl);
        for(var instance in data){
            userUl.append(createElement(data[instance]));
        };
    }
    
}
function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function(){
    $("#searchButton").click(function(){
        
        var wantedUser = $("#searchField")[0].value;
        
        $.ajax({
            url: "Filter",
            data:{
                cmd:"search",
                nomeUtenteCercato: wantedUser
            },
            dataType:"json",
            success: function(data, state){
                stateSuccess(data)
            },
            error: function(data, state){
                stateFailure(data, state)
            }
        });
    })
});
