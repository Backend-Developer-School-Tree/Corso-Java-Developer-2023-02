# Elenco di routine 🛴

Creare una classe `ElencoDiRoutine` i cui oggetti sono costruiti con una lista di funzioni da stringa a intero da eseguire in sequenza una dopo l'altra.
Queste funzioni sono implementazioni dell'interfaccia `java.util.function.Function`.

La classe dispone inoltre del metodo `esegui` che prende in input un parametro di tipo `String` ed esegue le funzioni in sequenza stampandone l'output.

Costruire quindi un'istanza della classe con le seguenti funzioni (usando riferimenti a metodi laddove possibile):
  - data in input una stringa x, restituisce la lunghezza di x
  - data una stringa x, restituisce il numero di occorrenze del carattere 'y'
  - data una stringa x, restituisce il corrispondente intero (se x contiene solo cifre)
  - data una stringa x, restituisce la somma dei caratteri contenuti nella stringa
