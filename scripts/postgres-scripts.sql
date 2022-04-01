-- public.pessoa_destino definition

-- Drop table

-- DROP TABLE public.pessoa_destino;

CREATE TABLE public.pessoa_destino (
  id int4 NOT NULL,
  nome varchar NULL,
CONSTRAINT pessoad_pk PRIMARY KEY (id)
);

-- public.seguradora definition

-- Drop table

-- DROP TABLE public.seguradora;

CREATE TABLE public.seguradora (
  id int4 NOT NULL,
  nome_fantasia varchar NOT NULL,
  cidade varchar NOT NULL,
  estado varchar NOT NULL,
  matriz_id int4 NOT NULL,
CONSTRAINT seguradora_pk PRIMARY KEY (id)
);

-- public.produto definition

-- Drop table

-- DROP TABLE public.produto;

CREATE TABLE public.produto (
  id int4 NOT NULL,
  descricao varchar NOT NULL,
  valor int4 NOT NULL,
  id_seguradora int4 NOT NULL,
CONSTRAINT produto_pk PRIMARY KEY (id)
);


-- public.produto foreign keys

ALTER TABLE public.produto ADD CONSTRAINT produto_fk FOREIGN KEY (id_seguradora) REFERENCES public.seguradora(id);

-- public.corretor definition

-- Drop table

-- DROP TABLE public.corretor;

CREATE TABLE public.corretor (
  id int4 NOT NULL,
  nome varchar NOT NULL,
  cpf varchar NOT NULL,
CONSTRAINT corretor_pk PRIMARY KEY (id)
);


-- public.corretor_seguradora definition

-- Drop table

-- DROP TABLE public.corretor_seguradora;

CREATE TABLE public.corretor_seguradora (
  id_corretor int4 NOT NULL,
  id_seguradora int4 NOT NULL
);


-- public.corretor_seguradora foreign keys

ALTER TABLE public.corretor_seguradora ADD CONSTRAINT corretor_seguradora_fk FOREIGN KEY (id_corretor) REFERENCES public.corretor(id);
ALTER TABLE public.corretor_seguradora ADD CONSTRAINT corretor_seguradora_fk_1 FOREIGN KEY (id_seguradora) REFERENCES public.seguradora(id);