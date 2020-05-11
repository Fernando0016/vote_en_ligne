/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Antoine
 */
@Document(collection = "User")
public class User {
    // private static final Logger LOG = LoggerFactory.getLogger(User.class);

    @Id
    private long id;
    private String email;
    private String pseudo;
    private String password;

    public User(long id, String email, String pseudo, String password) {
        this.id = id; 
        this.email = email;
        this.pseudo = pseudo;
        this.password = password;
    }

    //Constructor of user class
    public User(String e, String p, String psw) {
        id=(Long) (new Date().getTime());
        email = e;
        pseudo = p;
        password = psw;
    }

    /////////////// ACCESSEURS ////////////////
    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    //////////////////////////////////////////
    ///////////////  MUTATEURS  //////////////
    public void setPseudo(String p) {
        pseudo = p;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setId(int i) {
        id = i;
    }

    public void setPassword(String psw) {
        password = psw;
    }

    ///////    Function testing authentification with an input string //////////////
    public boolean authentification(String input_psw) {
        return input_psw.equals(password);
    }

}

/* Idées de tests : 
-Authentification avec une chaine vide
-Constructeurs avec des arguments vides
 */
