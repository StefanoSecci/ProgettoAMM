-- user: ammdb 
-- psw: 123

create table utente(
    id_utente integer generated by default as identity primary key,
    nome varchar(32),
    cognome varchar(32),
    dataNascita date,
    frasePresentazione varchar(140),
    password varchar(16) not null,
    urlFotoProfilo varchar(256),
    superUtente boolean not null,
    username varchar(64) not null unique
    
);

create table postType(
    id_postType integer generated by default as identity primary key,
    nome varchar(16) unique
);

create table gruppo(
    id_gruppo integer generated by default as identity primary key,
    nome varchar(256),
    admin integer references utente
);

create table post(
    id_post integer generated by default as identity primary key,
    content varchar(2048),
    urlAllegato varchar(256),
    tipo integer references postType not null,
    autore integer references utente,
    utenteDestinatario integer references utente,
    gruppoDestinatario integer references gruppo,
    check ((utenteDestinatario is null and gruppoDestinatario is not null)
            or (gruppoDestinatario is null and utenteDestinatario is not null))
);

create table amicizia(
    utente integer references utente,
    amico integer references utente,
    primary key (utente, amico)
);

create table appartenenzaGruppo(
    utente integer references utente,
    gruppo integer references gruppo,
    primary key (utente, gruppo)
);

-- popolazione tabelle

insert into utente(id_utente, username, nome, cognome, dataNascita, frasePresentazione, password, urlFotoProfilo, superUtente)
values 	(default, 'Lester','Lester', 'Crest', '1960-09-17', 'Welcome to paradise.', 'password', 'http://media.gtanet.com/gta-5/images/characters/lester-crest_t.jpg', true),
	(default, 'Aldo', 'Aldo', 'Baglio', '1958-09-28', 'ora non posso ne scendere ne salire, ne scendere ne salire!', 'qwerty', 'http://scontent.cdninstagram.com/t51.2885-19/s150x150/14033682_1638964053080704_540705153_a.jpg', false),
        (default, 'Giovanni', 'Giovanni', 'Storti', '1957-02-20', 'l''arte è un lavoro sporco, qualcuno deve pur farlo', 'qwerty', 'http://www.milanodavedere.it/wp-content/uploads/giovanni-storti-150x150.jpg', false),
        (default, 'Giacomo', 'Giacomo', 'Poretti', '1956-04-26', 'chiedimi se sono felice!', 'qwerty', 'http://www.farodiroma.it/wp-content/uploads/2017/03/Giacomo-Poretti-1%C2%BA-piano1-150x150.jpg', false),
        (default, 'Steve_Jobs', 'Steve', 'Jobs', '1955-02-24', 'think different, Finkbrau', 'qwerty', 'img/steve.jpg', false),
        (default, 'Bill_Gates', 'Bill', 'Gates', '1955-10-28', 'il successo porta cattivi consigli', 'qwerty', 'img/bill.jpg', false),
        (default, 'Mark_Zuckerberg', 'Mark', 'Zuckerberg', '1984-05-14', 'quanto costa questo sito?', 'qwerty', 'img/mark.jpg', false),
        (default, 'utenteIncompleto', null, 'Incompleto', '1000-10-10', null, 'qwerty', 'http://www.gssi.infn.it/images/studenti-ritratti/no-utente.jpg', false);
		
insert into postType(id_postType, nome)
values 	(default, 'text'), -- 1
	(default, 'image'), -- 2
	(default, 'link'); -- 3
		
insert into gruppo(id_gruppo, nome, admin)
values 	(default, 'AppleFag', 5),
	(default, 'Commodore Zone', 1);
		
insert into post(id_post, autore, utenteDestinatario, gruppoDestinatario, tipo, content, urlAllegato)
values	(default, 5, null, 1, 1, 'sto cercando uno smartphone, budget 200 euro. Qual è il migliore?', ''),
        (default, 6, 1, null, 2, 'mi è apparsa questa schermata, che faccio? :-O', 'img/Schermata-blu.jpg'),
        (default, 7, 1, null, 3, 'mi sono stancato di questo sito!!11!!1!!1!!1!! da ora in poi mi trovate qui', 'https://www.facebook.com/zuck?fref=ts'),
        (default, 6, 6, null, 1, 'Stiamo lavorando a un''app di NerdBook per windows phone, saremo i primi ad averla! peccato che nessuno compri più i nostro smartphone :''( poi parole a caso perchè voglio vedere come si comporta un testo lungo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla id aliquet diam. Sed a venenatis leo, in gravida neque. Sed eu molestie ipsum. Sed ut metus sit amet odio efficitur scelerisque. Sed aliquet pulvinar nisi, at eleifend elit hendrerit sit amet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae), Duis augue diam, tincidunt eu congue vel, pulvinar sit amet ex. Nam rutrum orci vel magna luctus tristique. Fusce ipsum lectus, sollicitudin a suscipit eu, pulvinar vestibulum metus. Vivamus eleifend turpis eget risus gravida gravida. Vivamus diam ante, eleifend dignissim volutpat eu, interdum blandit neque. Sed in finibus massa, in consequat elit. Cras dignissim nunc massa, id tincidunt nibh placerat id. Maecenas sapien lectus, consectetur sit amet mauris at, consectetur suscipit turpis. Pellentesque quis lacinia mauris. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', ''),
        (default, 7, 1, null, 2, 'grande è questa imagine? mi che grande ched''è!', 'img/grande.jpg'),
        (default, 5, 1, null, 1, 'Ciao mitico!', ''),
        (default, 3, 4, null, 1, 'Abbassa lo sguardo', ''),
        (default, 2, null, 1, 3, 'iscritto, ricambi?', 'https://www.youtube.com/user/aggcanaleufficiale');
		
insert into amicizia(utente, amico)
values 	(1, 5),
        (1, 6),
        (1, 8),
        (2, 3),
        (2, 4),
        (3, 2),
        (3, 4),
        (4, 3),
        (4, 2),
        (5, 1),
        (6, 1),
        (7, 1);
		
insert into appartenenzaGruppo( utente, gruppo)
values 	(5, 1),
        (2, 1),
        (3, 1),
        (7, 1),
        (1, 2),
        (4, 2),
        (3, 2);
		