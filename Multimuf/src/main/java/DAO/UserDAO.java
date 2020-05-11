// fuser -k 8080/tcp
package DAO;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import model.User;
import org.bson.Document;

/**
 * @author Imed KERAGHEL
 */
public class UserDAO {

    private final Database db;
    private final MongoCollection<Document> collection;

    /**
     * Constructeur
     *
     * @param db la base de données
     */
    public UserDAO(Database db) {
        this.db = db;
        this.collection = db.getCollection("User");
    }

    /**
     * Retourne l'utilisateur correspondant à l'adresse donnée en paramètre
     *
     * @param email l'email de l'utilisateur recherché
     * @return l'user recherché
     */
    public User getUserByEmail(String email) {
        if (email == null && !"".equals(email)) {
            return null;
        }
        Document userDoc = collection.find(eq("email", email)).first();
        if (userDoc == null) {
            return null;
        }
        long resId = userDoc.getLong("_id");
        String resEmail = userDoc.getString("email");
        String resPseudo = userDoc.getString("pseudo");
        String resPassword = userDoc.getString("password");
        User resUser = new User(resId, resEmail, resPseudo, resPassword);
        return resUser;
    }

    /**
     * Permet des créer un nouvel utilisateur
     *
     * @param id l'id de l'utilisateur
     * @param email l'email de l'utilisateur
     * @param pseudo le pseudo de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return l'utilisateur créé
     */
    public User create(User user) {
        if (user == null) {
            return null;
        } else {
            Document userDoc = collection.find(eq("email", user.getEmail())).first();
            if (userDoc != null) {
                return null;
            } else {
                Document doc = new Document("_id", user.getId())
                        .append("email", user.getEmail())
                        .append("pseudo", user.getPseudo())
                        .append("password", user.getPassword());

                this.collection.insertOne(doc);

                return user;
            }
        }
    }

    /**
     * mettre à jour ces infos en fonction de son email
     *
     * @param email l'email de l'utilisateur
     * @param pseudo le pseudo de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return l'utilisateur créé ou modifié
     */
    public User update(String oldEmail, User newUser) {

        if (newUser != null && oldEmail != null && !"".equals(oldEmail)) {
            collection.updateOne(eq("email", oldEmail), new Document("$set", new Document("pseudo", newUser.getPseudo())
                    .append("password", newUser.getPassword())
                    .append("email", newUser.getEmail())));
            return newUser;
        }
        return null;
    }

    /**
     * Supprime un utilisateur
     *
     * @param email l'adreese email de l'utilisateur
     * @return l'user supprimer (je ne suis pas sure que cela est du sens)
     */
    public User Delete(String email) {
        if (email != null && !"".equals(email)) {
            User user = getUserByEmail(email);
            if (user != null) {
                collection.deleteOne(eq("email", email));
            }
            return user;
        } else {
            return null;
        }
    }

}
