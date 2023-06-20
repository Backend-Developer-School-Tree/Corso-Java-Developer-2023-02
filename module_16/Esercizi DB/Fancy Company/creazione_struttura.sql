*
* Lascio la DROP TABLE per essere sicuro che resetto le mie tabelle
*/
DROP TABLE ordini; 
DROP TABLE impiegati; 

CREATE TABLE public.impiegati
(
    id serial,
    nome text,
    livello character varying(1),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.impiegati
    OWNER to postgres;
	
CREATE TABLE public.ordini
(
    id serial,
    cliente text,
    data_ordine date,
    importo double precision,
    x_id_impiegato integer,
    PRIMARY KEY (id),
    CONSTRAINT fk_impiegato FOREIGN KEY (x_id_impiegato)
        REFERENCES public.impiegati (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS public.ordini OWNER to postgres;


-- INSERIMENTO DATI (DML -> Data Manipulation Language )
INSERT INTO public.impiegati(nome, livello) VALUES ('Simona', 'B');
INSERT INTO public.impiegati(nome, livello) VALUES ('Davide', 'B');
INSERT INTO public.impiegati(nome, livello) VALUES ('Alfredo', 'C');
INSERT INTO public.impiegati(nome, livello) VALUES ('Michela', 'A');


INSERT INTO public.ordini( cliente, data_ordine, importo, x_id_impiegato) VALUES ('Cliente 1', '2023-06-19', 50.8, 1);
INSERT INTO public.ordini( cliente, data_ordine, importo, x_id_impiegato) VALUES ('Cliente 2', '2023-06-18', 30.4, 2);
INSERT INTO public.ordini( cliente, data_ordine, importo, x_id_impiegato) VALUES ('Cliente 2', '2023-05-19', 5, 3);
INSERT INTO public.ordini( cliente, data_ordine, importo, x_id_impiegato) VALUES ('Cliente 3', '2023-06-29', 189.8, 2);


UPDATE public.impiegati SET nome='Simone' WHERE id = 1;