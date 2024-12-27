--
-- PostgreSQL database dump
--

-- Dumped from database version 15.10
-- Dumped by pg_dump version 15.10

-- Started on 2024-12-27 21:40:27

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 16474)
-- Name: groups; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.groups (
    group_id integer NOT NULL,
    group_name character varying(40) NOT NULL,
    pass character varying(200) NOT NULL,
    mail character varying(100) NOT NULL,
    role character varying(10) NOT NULL,
    created_at timestamp without time zone NOT NULL
);


ALTER TABLE public.groups OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16473)
-- Name: groups_group_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.groups ALTER COLUMN group_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.groups_group_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 16490)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    product_id integer NOT NULL,
    product_name character varying(40) NOT NULL,
    product_value integer NOT NULL,
    group_id integer NOT NULL,
    group_name character varying(40) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    is_deleted boolean DEFAULT false
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16489)
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_product_id_seq OWNER TO postgres;

--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 216
-- Name: products_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_product_id_seq OWNED BY public.products.product_id;


--
-- TOC entry 219 (class 1259 OID 16518)
-- Name: sales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sales (
    sale_id integer NOT NULL,
    group_id integer NOT NULL,
    total_price integer NOT NULL,
    received_price integer NOT NULL,
    change_price integer NOT NULL,
    sale_at timestamp without time zone NOT NULL
);


ALTER TABLE public.sales OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16525)
-- Name: sales_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sales_details (
    sale_details_id integer NOT NULL,
    sale_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL
);


ALTER TABLE public.sales_details OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16517)
-- Name: sales_sale_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sales_sale_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sales_sale_id_seq OWNER TO postgres;

--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 218
-- Name: sales_sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sales_sale_id_seq OWNED BY public.sales.sale_id;


--
-- TOC entry 220 (class 1259 OID 16524)
-- Name: salesdetails_sale_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.salesdetails_sale_details_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.salesdetails_sale_details_id_seq OWNER TO postgres;

--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 220
-- Name: salesdetails_sale_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.salesdetails_sale_details_id_seq OWNED BY public.sales_details.sale_details_id;


--
-- TOC entry 3188 (class 2604 OID 16493)
-- Name: products product_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN product_id SET DEFAULT nextval('public.products_product_id_seq'::regclass);


--
-- TOC entry 3190 (class 2604 OID 16521)
-- Name: sales sale_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales ALTER COLUMN sale_id SET DEFAULT nextval('public.sales_sale_id_seq'::regclass);


--
-- TOC entry 3191 (class 2604 OID 16528)
-- Name: sales_details sale_details_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales_details ALTER COLUMN sale_details_id SET DEFAULT nextval('public.salesdetails_sale_details_id_seq'::regclass);


--
-- TOC entry 3343 (class 0 OID 16474)
-- Dependencies: 215
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.groups (group_id, group_name, pass, mail, role, created_at) FROM stdin;
11	master	$2a$12$wZDUDzv0vm5LgcUyeiYbD.Z3YSk3gWLBnZL1FKZX2hQMagGUJEsq.	j2200152@gunma-u.ac.jp	ADMIN	2024-12-16 09:14:25.130735
6	ipon	$2a$12$x4hrRj0mPqDDh7iTPeC5.eHSFZbGlPMJoz1GZ2OnRCUffenQZnqRO	ipon_1207@yahoo.co.jp	USER	2024-12-16 09:15:38.748837
\.


--
-- TOC entry 3345 (class 0 OID 16490)
-- Dependencies: 217
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (product_id, product_name, product_value, group_id, group_name, created_at, is_deleted) FROM stdin;
1	Smartphone	50000	1	Electronics	2024-12-11 10:00:00	f
2	Laptop	120000	1	Electronics	2024-12-11 10:05:00	f
4	Milk	200	2	Groceries	2024-12-11 10:15:00	f
13	Jeans	5000	6	ipon	2024-12-17 15:20:29.415514	t
15	たこ焼き	200	6	ipon	2024-12-17 21:08:44.025447	t
11	リンゴ	200	6	ipon	2024-12-18 09:22:03.72905	t
16	たこ焼き	400	6	ipon	2024-12-18 16:47:44.125194	f
17	アイス	600	6	ipon	2024-12-18 16:47:58.190752	f
\.


--
-- TOC entry 3347 (class 0 OID 16518)
-- Dependencies: 219
-- Data for Name: sales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sales (sale_id, group_id, total_price, received_price, change_price, sale_at) FROM stdin;
13	6	5000	5000	0	2024-12-17 20:02:50.216045
14	6	5000	8000	3000	2024-12-17 20:18:04.007717
15	6	550	1000	450	2024-12-17 21:09:23.522901
16	6	1000	1000	0	2024-12-18 09:29:56.830198
17	6	600	600	0	2024-12-18 09:45:13.243811
18	6	400	400	0	2024-12-18 09:45:24.600539
19	6	1600	1600	0	2024-12-18 16:48:37.553793
\.


--
-- TOC entry 3349 (class 0 OID 16525)
-- Dependencies: 221
-- Data for Name: sales_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sales_details (sale_details_id, sale_id, product_id, quantity) FROM stdin;
21	13	13	1
22	14	13	1
23	15	11	1
24	15	15	2
25	16	16	2
26	16	11	2
27	17	11	3
28	18	11	2
29	19	16	1
30	19	17	2
\.


--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 214
-- Name: groups_group_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.groups_group_id_seq', 11, true);


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 216
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_product_id_seq', 17, true);


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 218
-- Name: sales_sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sales_sale_id_seq', 19, true);


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 220
-- Name: salesdetails_sale_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.salesdetails_sale_details_id_seq', 30, true);


--
-- TOC entry 3193 (class 2606 OID 16478)
-- Name: groups groups_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.groups
    ADD CONSTRAINT groups_pkey PRIMARY KEY (group_id);


--
-- TOC entry 3195 (class 2606 OID 16495)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- TOC entry 3197 (class 2606 OID 16523)
-- Name: sales sales_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_pkey PRIMARY KEY (sale_id);


--
-- TOC entry 3199 (class 2606 OID 16530)
-- Name: sales_details salesdetails_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales_details
    ADD CONSTRAINT salesdetails_pkey PRIMARY KEY (sale_details_id);


-- Completed on 2024-12-27 21:40:27

--
-- PostgreSQL database dump complete
--

