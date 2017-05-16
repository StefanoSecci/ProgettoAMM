/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class PostFactory {
    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    //Gestione DB
    private String connectionString;
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
            return this.connectionString;
    }
    //Fine gestione DB

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        
        UtenteFactory userFactory = UtenteFactory.getInstance();
        GruppoFactory groupFactory = GruppoFactory.getInstance();

        //creazione post
        Post post0 = new Post();
        post0.setId(0);
        post0.setAutore(userFactory.getUtenteById(4));
        post0.setUser(null);
        post0.setGroup(groupFactory.getGruppoById(0));
        post0.setPostType(Post.Type.TEXT);
        post0.setContent("sto cercando uno smartphone, budget 200 euro. Qual è il migliore?");
        post0.setUrlAllegato("");
        
        Post post1 = new Post();
        post1.setId(1);
        post1.setAutore(userFactory.getUtenteById(5));
        post1.setUser(userFactory.getUtenteById(0));
        post1.setGroup(null);
        post1.setPostType(Post.Type.IMAGE);
        post1.setContent("mi è apparsa questa schermata, che faccio? :-O");
        post1.setUrlAllegato("img/Schermata-blu.jpg");
        
        Post post2 = new Post();
        post2.setId(2);
        post2.setAutore(userFactory.getUtenteById(6));
        post2.setUser(userFactory.getUtenteById(0));
        post2.setGroup(null);
        post2.setPostType(Post.Type.LINK);
        post2.setContent("mi sono stancato di questo sito!!11!!1!!1!!1!! da ora in poi mi trovate qui");
        post2.setUrlAllegato("https://www.facebook.com/zuck?fref=ts");
        
        Post post3 = new Post();
        post3.setId(3);
        post3.setAutore(userFactory.getUtenteById(5));
        post3.setUser(userFactory.getUtenteById(5));
        post3.setGroup(null);
        post3.setPostType(Post.Type.TEXT);
        post3.setContent("Stiamo lavorando a un'app di NerdBook per windows phone,"
                + "saremo i primi ad averla! peccato che nessuno compri più i nostro smartphone :'("
                + "poi parole a caso perchè voglio vedere come si comporta un testo lungo."
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla id aliquet diam. Sed a venenatis leo, in gravida neque. Sed eu molestie ipsum. Sed ut metus sit amet odio efficitur scelerisque. Sed aliquet pulvinar nisi, at eleifend elit hendrerit sit amet. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis augue diam, tincidunt eu congue vel, pulvinar sit amet ex. Nam rutrum orci vel magna luctus tristique. Fusce ipsum lectus, sollicitudin a suscipit eu, pulvinar vestibulum metus. Vivamus eleifend turpis eget risus gravida gravida. Vivamus diam ante, eleifend dignissim volutpat eu, interdum blandit neque. Sed in finibus massa, in consequat elit. Cras dignissim nunc massa, id tincidunt nibh placerat id. Maecenas sapien lectus, consectetur sit amet mauris at, consectetur suscipit turpis. Pellentesque quis lacinia mauris. Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            );
        post3.setUrlAllegato("");
        
        Post post4 = new Post();
        post4.setId(4);
        post4.setAutore(userFactory.getUtenteById(6));
        post4.setUser(userFactory.getUtenteById(0));
        post4.setGroup(null);
        post4.setPostType(Post.Type.IMAGE);
        post4.setContent("grande è questa imagine? mi che grande ched'è!");
        post4.setUrlAllegato("img/grande.jpg");
        
        Post post5 = new Post();
        post5.setId(5);
        post5.setAutore(userFactory.getUtenteById(4));
        post5.setUser(userFactory.getUtenteById(0));
        post5.setGroup(null);
        post5.setPostType(Post.Type.TEXT);
        post5.setContent("Ciao mitico!");
        post5.setUrlAllegato("");
        
        Post post6 = new Post();
        post6.setId(6);
        post6.setAutore(userFactory.getUtenteById(2));
        post6.setUser(userFactory.getUtenteById(3));
        post6.setGroup(null);
        post6.setPostType(Post.Type.TEXT);
        post6.setContent("Abbassa lo sguardo");
        post6.setUrlAllegato("");
        
        Post post7 = new Post();
        post7.setId(7);
        post7.setAutore(userFactory.getUtenteById(1));
        post7.setUser(null);
        post7.setGroup(groupFactory.getGruppoById(0));
        post7.setPostType(Post.Type.LINK);
        post7.setContent("iscritto, ricambi?");
        post7.setUrlAllegato("https://www.youtube.com/user/aggcanaleufficiale");
        
        listaPost.add(post0);
        listaPost.add(post1);
        listaPost.add(post2);
        listaPost.add(post3);
        listaPost.add(post4);
        listaPost.add(post5);
        listaPost.add(post6);
        listaPost.add(post7);
        
    }

    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

    public List getPostByUtente(Utente usr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if ( post.getUser()!= null && post.getUser().equals(usr)){
                listaPost.add(post);
            }
        }
        
        return listaPost;
    }
    
    
    
    public List getPostByGruppo(Gruppo gr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getGroup()!= null && post.getGroup().equals(gr) ) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    public List getPostByAutore(Utente usr) {

        List<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getAutore().equals(usr)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
}
