# Tripleton 🛴

Realizzare una classe `Tripleton` che può avere fino a 3 istanze in memoria.

Definire una politica di assegnazione delle istanze a piacere, ad esempio ad ogni chiamata del metodo `getIstance()`
possiamo semplicemente ritornare una diversa istanza nell'ordine 1, 2, 3, 1, 2, 3, 1, ...

Testare il codice, verificando che non possano esistere più di 3 istanze diverse di quella classe
e che la politica di assegnazione sia sempre rispettata.

_Fun fact_: senza l'utilizzo del multi-threading (che però non abbiamo trattato) è impossibile garantire veramente quest'ultima condizione :-) 