import model.Interest;
import model.User;

import java.util.*;

public class TinderLike {

    Map<User, Set<Interest>> usersByInterest = new HashMap<>();
    Map<String, User> usersById = new HashMap<>(); // string--> id come chiave


    public void insertUserWithInterests(User user, Set<Interest> interests) {
        usersById.put(user.getId(), user); // aggiorno la mappa usersById

        // Se non faccio controllo vado a sovrascrivere il SET di interessi
        if(usersByInterest.containsKey(user)) //add if present
            usersByInterest.get(user).addAll(interests);
        else
            //User non presente, inizializzo una nuova collection
            usersByInterest.put(user, new HashSet<>(interests));
    }

    public void removeUser(String userId) {
        User u = usersById.get(userId);
        usersByInterest.remove(u);
        usersById.remove(userId);
    }

    //TODO: variante rimozione solo di un interesse
    // Scorro il SET di interessi, quando trovo interesse da cancellare lo rimuovo
    public void removeInterestsForUser(String userId, Set<Interest> interests) {
        User user = usersById.get(userId);
        if(usersByInterest.containsKey(user))
            usersByInterest.get(user).removeAll(interests);
    }

    //Map<String, User> usersById
    public User getMostSimilarUser(String userId) {
        User user = usersById.get(userId);

        //User che non esiste oppure che non ha interessi
        if(user == null || !usersByInterest.containsKey(user))
            return null;

        //Prendo tutti gli interessi dell'utente in questione
        Set<Interest> userInterests = usersByInterest.get(user);

        User mostSimilarUser = null;
        int interestsInCommonCount = 0;

        //.keySet() torna elenco delle chiavi su cui itero
        for(User u : usersByInterest.keySet()) {
            //Se è lo stesso utente, salta
            if(u.equals(user))
                continue;

            //Mi prendo gli interessi associati ad utente i-esimo
            Set<Interest> interestsInCommon = new HashSet<>(usersByInterest.get(u));

            interestsInCommon.retainAll(userInterests); //retainAll intersezione degli utenti

            // Questo if conta quanti interessi in comune ho rispetto al precedente
            if(mostSimilarUser == null || interestsInCommon.size() > interestsInCommonCount) {
                mostSimilarUser = u; //utente u i-esimo è quello più simile
                interestsInCommonCount = interestsInCommon.size();
            }
        }
        return mostSimilarUser;
    }

    //TODO: controllo se ho un solo utente e gestire con una eccezione custom
    public User[] getMostSimilarUsers() {
        User mostSimilarUser1 = null;
        User mostSimilarUser2 = null;
        int interestsInCommonCount = 0;
        // u1, u2, u3
        //Itero su tutte le chiavi della mia mappa
        for(User user : usersByInterest.keySet()){
            User mostSimilarUser = getMostSimilarUser(user.getId()); //sfrutto metodo scritto in precedenza
            Set<Interest> interestsInCommon = new HashSet<>(usersByInterest.get(user));
            interestsInCommon.retainAll(usersByInterest.get(mostSimilarUser));

            if(interestsInCommon.size() > interestsInCommonCount) {
                mostSimilarUser1 = user;
                mostSimilarUser2 = mostSimilarUser;
                interestsInCommonCount = interestsInCommon.size();
            }
        }
        User[] mostSimilarUsers = {mostSimilarUser1, mostSimilarUser2};
        return mostSimilarUsers;
    }

    public static void main(String[] args) {

        TinderLike tinderLike = new TinderLike();

        Interest iTennis = new Interest("tennis");
        Interest iDance = new Interest("dance");
        Interest iGym = new Interest("gym");
        Interest iJogging = new Interest("jogging");
        Interest iSwimming = new Interest("swimming");

        User uAndrea = new User("1", "Andrea");
        User uMarco = new User("2", "Marco");
        User uAnna = new User("3", "Anna");

        Set<Interest> interestsAndrea = new HashSet<>();
        interestsAndrea.add(iTennis);
        interestsAndrea.add(iDance);
        interestsAndrea.add(iGym);

        Set<Interest> interestsAnna = new HashSet<>();
        interestsAnna.add(iTennis);
        interestsAnna.add(iSwimming);
        interestsAnna.add(iJogging);

        Set<Interest> interestsMarco = new HashSet<>();
        interestsMarco.add(iTennis);
        interestsMarco.add(iJogging);

        tinderLike.insertUserWithInterests(uAndrea, interestsAndrea);
        tinderLike.insertUserWithInterests(uMarco, interestsMarco);
        tinderLike.insertUserWithInterests(uAnna, interestsAnna);

        for(User u : tinderLike.getMostSimilarUsers() ){
            System.out.print(u.getName() + " ");
        }

        System.out.println(tinderLike.getMostSimilarUser("2"));


        /* CODICE EXTRA SOLUZIONE (ITERAZIONE SU SET) */
        // For each dove scorro gli elementi
        for(Interest i : interestsAndrea){
            System.out.println(i);
        }

        // Con Iterator se voglio cancellare un elemento
        Iterator<Interest> iterator = interestsAndrea.iterator();
        while(iterator.hasNext()){
            Interest iTmp = iterator.next();

            if(iTmp.getText().equals("tennis")){
                iterator.remove();
            }
        }

    }
}