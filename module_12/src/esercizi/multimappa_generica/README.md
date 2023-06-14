# Multimappa generica 🛵
Una multimappa è una mappa che ammette più valori a fronte di una data
chiave. Creare una classe MultiMappa generica sul tipo di chiavi e valori.

La classe implementa i seguenti metodi:
- `put(k, v)` che associa il valore alla chiave specificata
- `putAll(MultiMappa m)` che aggiunge tutti gli elementi della multimappa in input alla mappa corrente
- `removeAll(MultiMappa m)` che rimuove tutte le chiavi della multimappa in input dalla mappa corrente
- `get(k)` che restituisce l'insieme dei valori associati alla chiave
- `get(k, p)`, come sopra ma restituisce solo i valori che soddisfano il predicato p
- `values()` che restituisce l'elenco (con duplicati) dei valori contenuti nella multimappa
- `valueSet()` che restituisce l'insieme dei valori contenuti nella multimappa
- `transformToMultiMappa(f)` che restituisce una multimappa in cui le coppie (k, v) sono trasformate in (k, z) secondo una funzione (k, v) -> z (z può essere di tipo diverso rispetto a quello di v)
- `mapEach(f)` che sostituisce ciascun valore v con un valore dello stesso tipo secondo una funzione (k, v) -> v'
- la classe è iterabile sulle coppie (k, v) mediante una classe interna Elemento

Utilizzare Stream, lambda **e riferimenti a metodo** dove possibile.
