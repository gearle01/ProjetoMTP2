PGDMP         #            
    w        
   mtpproject    9.6.10    9.6.10                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    17996 
   mtpproject    DATABASE     |   CREATE DATABASE mtpproject WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
    DROP DATABASE mtpproject;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12427    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            Ό            1259    18044 	   like_post    TABLE     ¨   CREATE TABLE public.like_post (
    id integer NOT NULL,
    pessoa_id integer NOT NULL,
    post_id integer NOT NULL,
    data timestamp without time zone NOT NULL
);
    DROP TABLE public.like_post;
       public         postgres    false    3            »            1259    18042    like_post_id_seq    SEQUENCE     y   CREATE SEQUENCE public.like_post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.like_post_id_seq;
       public       postgres    false    3    188                       0    0    like_post_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.like_post_id_seq OWNED BY public.like_post.id;
            public       postgres    false    187            Ί            1259    17999    pessoa    TABLE     Ϋ   CREATE TABLE public.pessoa (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    email character varying(80) NOT NULL,
    senha character varying(80) NOT NULL,
    cidade_estado character varying
);
    DROP TABLE public.pessoa;
       public         postgres    false    3            Ή            1259    17997    pessoa_id_seq    SEQUENCE     v   CREATE SEQUENCE public.pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.pessoa_id_seq;
       public       postgres    false    3    186                       0    0    pessoa_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.id;
            public       postgres    false    185            Ύ            1259    18052    post    TABLE     §   CREATE TABLE public.post (
    id integer NOT NULL,
    texto text NOT NULL,
    imagem bytea,
    pessoa_id integer NOT NULL,
    data timestamp without time zone
);
    DROP TABLE public.post;
       public         postgres    false    3            ½            1259    18050    post_id_seq    SEQUENCE     t   CREATE SEQUENCE public.post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.post_id_seq;
       public       postgres    false    190    3                       0    0    post_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.post_id_seq OWNED BY public.post.id;
            public       postgres    false    189                       2604    18047    like_post id    DEFAULT     l   ALTER TABLE ONLY public.like_post ALTER COLUMN id SET DEFAULT nextval('public.like_post_id_seq'::regclass);
 ;   ALTER TABLE public.like_post ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    187    188    188                       2604    18002 	   pessoa id    DEFAULT     f   ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.pessoa_id_seq'::regclass);
 8   ALTER TABLE public.pessoa ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    186    185    186                       2604    18055    post id    DEFAULT     b   ALTER TABLE ONLY public.post ALTER COLUMN id SET DEFAULT nextval('public.post_id_seq'::regclass);
 6   ALTER TABLE public.post ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    189    190    190                      0    18044 	   like_post 
   TABLE DATA               A   COPY public.like_post (id, pessoa_id, post_id, data) FROM stdin;
    public       postgres    false    188   ϋ                  0    0    like_post_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.like_post_id_seq', 1, false);
            public       postgres    false    187                      0    17999    pessoa 
   TABLE DATA               G   COPY public.pessoa (id, nome, email, senha, cidade_estado) FROM stdin;
    public       postgres    false    186                     0    0    pessoa_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pessoa_id_seq', 7, true);
            public       postgres    false    185                      0    18052    post 
   TABLE DATA               B   COPY public.post (id, texto, imagem, pessoa_id, data) FROM stdin;
    public       postgres    false    190   Y                  0    0    post_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.post_id_seq', 10, true);
            public       postgres    false    189                       2606    18049    like_post like_post_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.like_post
    ADD CONSTRAINT like_post_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.like_post DROP CONSTRAINT like_post_pkey;
       public         postgres    false    188    188            	           2606    18010    pessoa pessoa_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id, email);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public         postgres    false    186    186    186                       2606    18060    post post_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.post DROP CONSTRAINT post_pkey;
       public         postgres    false    190    190                       2606    18008    pessoa uq_email 
   CONSTRAINT     K   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT uq_email UNIQUE (email);
 9   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT uq_email;
       public         postgres    false    186    186                  xΡγββ Ε ©         1   x3β,ΚΟ/pgZ~Qn"	§c°§‘1(.sNCδΡγββ `         =   x³δ,I-.Iεργ4\FVFζ#CK]CC]3°¨Ή1W ¨T     