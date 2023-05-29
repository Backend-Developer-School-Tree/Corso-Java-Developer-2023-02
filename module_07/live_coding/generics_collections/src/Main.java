import java.util.*;

public class Main {
    public static void main(String[] args) {
        Contenitore<Integer> c1 = new Contenitore<>(42); //occhio al tipo
        Contenitore<String> c2 = new Contenitore<>("42");

        /* **** FRAMEWORK COLLECTION *** */
        List myCollectionNoGeneric = new ArrayList();
        myCollectionNoGeneric.add(42);
        myCollectionNoGeneric.add("42");
        myCollectionNoGeneric.add(true);

        // Senza generics
        for (Object obj : myCollectionNoGeneric) {
            //Integer myNewInt = (Integer) obj;

            //Senza il generic non ho modo di sapere il tipo della collezione
            if (obj instanceof Integer) {
                Integer myInt = (Integer) obj;
                System.out.println(myInt);
            }
        }

        List<Integer> myCollectionGeneric = new ArrayList<>();
        myCollectionGeneric.add(42);
        //myCollectionGeneric.add("42");
        //myCollectionGeneric.add(true);

        for (Integer myInt : myCollectionGeneric) {
            System.out.println(myInt);
        }

        ArrayList<Integer> intNumbers = new ArrayList<>();
        for(int i=0; i<150; i++){
            intNumbers.add(i);
        }

        System.out.println(intNumbers.size());
        intNumbers.remove(0); // Rimuovo elemento alla pos 0
        System.out.println(intNumbers.size());

        //Accedo posizionalmente
        for(int i=0; i<intNumbers.size(); i++){
            System.out.println(intNumbers.get(i)); //.get(i) accedo ad elemento in posizione i
        }

        System.out.println(intNumbers.contains(1500));
        System.out.println(intNumbers.contains(100));
        System.out.println(intNumbers.indexOf(100)); //ricorda che si parte a contare da 0, quindi indice è 99

        System.out.println("**** SET ****");

        /*
        * SET
        * */
        Set<String> strings = new HashSet<>();
        strings.add("s1");
        strings.add("s2");

        System.out.println(strings.size());
        System.out.println(strings.isEmpty());

        for(String s : strings){
            System.out.println(s);
        }

        /*
         * MAP
         * */
        Map<Integer, String> maps = new HashMap<>();

        maps.put(1, "Java");
        maps.put(2, "Javascript");
        maps.put(3, "SQL");

        // Con il .get accedo al valore corrispondende quella chiave
        for(Integer k : maps.keySet()){
            System.out.println("ID: " + k + ", Language: " + maps.get(k));
        }

        for(String s : maps.values()){
            System.out.println(s);
        }




    }
}