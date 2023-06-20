/*
Creazione di una vista di appoggio 

CREATE OR REPLACE VIEW public.view_ordini_impiegati
 AS
 SELECT o.id AS id_ordine,
    o.cliente,
    o.data_ordine,
    o.importo,
    o.x_id_impiegato,
    i.id AS id_impiegato,
    i.nome,
    i.livello
   FROM ordini o
     JOIN impiegati i ON o.x_id_impiegato = i.id;

ALTER TABLE public.view_ordini_impiegati
    OWNER TO postgres;

select * 
from view_ordini_impiegati

*/

/*
1] Elenca gli impiegati che seguono uno specifico cliente.
2] Elenca gli ordini seguiti da uno specifico impiegato.
3] Fai un elenco dei clienti indicando la loro spesa complessiva in ordine decrescente.
4] Fai un elenco dei livelli indicando per ogni livello quanti ordini sono seguiti.
5] Fai l'elenco degli ordini di febbraio e degli impiegati che li seguono.
6] Elenca gli impiegati e l'importo complessivo degli ordini che hanno gestito.
*/

-- 1] Elenca gli impiegati che seguono uno specifico cliente.
SELECT i.nome
FROM ordini o JOIN impiegati i
ON o.x_id_impiegato = i.id
WHERE o.cliente = 'Cliente 2'; 


-- VARIANTE SENZA LA JOIN ESPLICITA 
SELECT i.nome
FROM ordini o, impiegati i
WHERE o.cliente = 'Cliente 2' and o.x_id_impiegato = i.id; 



-- 2] Elenca gli ordini seguiti da uno specifico impiegato.
SELECT o.id, o.cliente, o.data_ordine, o.importo
FROM ordini o JOIN impiegati i 
ON o.x_id_impiegato = i.id
WHERE o.x_id_impiegato = 1; 



-- 3] Fai un elenco dei clienti indicando la loro spesa complessiva in ordine decrescente.
SELECT o.cliente SUM(importo) AS somma
from ordini o
GROUP BY cliente
ORDER BY somma DESC; 



-- 4] Fai un elenco dei livelli indicando per ogni livello quanti ordini sono seguiti.
SELECT i.livello, COUNT(o.id)
FROM impiegati i INNER JOIN ordini o
ON o.x_id_impiegato = i.id 
GROUP BY i.livello; 



-- 5] Fai l'elenco degli ordini di febbraio e degli impiegati che li seguono.
SELECT ordini.id, cliente, data_ordine, importo, x_id_impiegato, impiegati.id, nome, livello
FROM impiegati INNER JOIN ordini 
ON x_id_impiegato = impiegati.id
WHERE data_ordine >= '2023-06-01' AND data_ordine <= '2023-06-30'

SELECT ordini.id, cliente, data_ordine, importo, x_id_impiegato, impiegati.id, nome, livello
FROM impiegati INNER JOIN ordini 
ON x_id_impiegato = impiegati.id
WHERE data_ordine BETWEEN '2023-06-01' AND '2023-06-30'; 



-- Seleziona tutti gli impiegati che hanno effettuato almeno un ordine con importo superiore a 100€:
SELECT nome
FROM impiegati
WHERE id IN ( SELECT x_id_impiegato FROM ordini WHERE importo > 50 ); 

SELECT nome
FROM impiegati
WHERE id IN ( 1, 2, 3, 4); 



-- 6] Elenca gli impiegati e l'importo complessivo degli ordini che hanno gestito.
SELECT id_impiegato, SUM(importo) 
FROM view_ordini_impiegati
GROUP BY id_impiegato
ORDER BY SUM(importo); 


















