--
-- PostgreSQL database dump
--

SET client_encoding = 'SQL_ASCII';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1799 (class 0 OID 0)
-- Name: DUMP TIMESTAMP; Type: DUMP TIMESTAMP; Schema: -; Owner: 
--

-- Started on 2004-11-03 11:04:01 GTB Standard Time


--
-- TOC entry 1802 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


SET search_path = public, pg_catalog;

--
-- TOC entry 1302 (class 1259 OID 17994)
-- Dependencies: 4
-- Name: seq_accounting_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_accounts
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1303 (class 1259 OID 17996)
-- Dependencies: 4
-- Name: seq_accounting_journal; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_journal
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1340 (class 1259 OID 18177)
-- Dependencies: 4
-- Name: seq_accounting_transaction_columns; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transaction_columns
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1304 (class 1259 OID 17998)
-- Dependencies: 4
-- Name: seq_accounting_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transaction_types
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1305 (class 1259 OID 18000)
-- Dependencies: 4
-- Name: seq_accounting_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transactions
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1306 (class 1259 OID 18072)
-- Dependencies: 4
-- Name: seq_bank_cards_secondary_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bank_cards_secondary_accounts
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1308 (class 1259 OID 18076)
-- Dependencies: 4
-- Name: seq_bank_secondary_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bank_secondary_accounts
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1307 (class 1259 OID 18074)
-- Dependencies: 4
-- Name: seq_banks_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_cards
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1309 (class 1259 OID 18078)
-- Dependencies: 4
-- Name: seq_banks_transaction_bills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transaction_bills
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1310 (class 1259 OID 18080)
-- Dependencies: 4
-- Name: seq_banks_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1311 (class 1259 OID 18082)
-- Dependencies: 4
-- Name: seq_banks_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transactions
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1312 (class 1259 OID 18084)
-- Dependencies: 4
-- Name: seq_bill_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bill_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1313 (class 1259 OID 18086)
-- Dependencies: 4
-- Name: seq_bill_in_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bill_in_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1314 (class 1259 OID 18088)
-- Dependencies: 4
-- Name: seq_bills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bills
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1315 (class 1259 OID 18090)
-- Dependencies: 4
-- Name: seq_cheque_cheques; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_cheques
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1316 (class 1259 OID 18092)
-- Dependencies: 4
-- Name: seq_cheque_cheques_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_cheques_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1317 (class 1259 OID 18094)
-- Dependencies: 4
-- Name: seq_cheque_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1318 (class 1259 OID 18096)
-- Dependencies: 4
-- Name: seq_cheque_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1250 (class 1259 OID 17313)
-- Dependencies: 4
-- Name: seq_companies; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_companies
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1319 (class 1259 OID 18098)
-- Dependencies: 4
-- Name: seq_consignment_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignment_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1320 (class 1259 OID 18100)
-- Dependencies: 4
-- Name: seq_consignments; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignments
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1321 (class 1259 OID 18102)
-- Dependencies: 4
-- Name: seq_consignments_in_group; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignments_in_group
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1322 (class 1259 OID 18104)
-- Dependencies: 4
-- Name: seq_currencies; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_currencies
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1323 (class 1259 OID 18106)
-- Dependencies: 4
-- Name: seq_current_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1324 (class 1259 OID 18108)
-- Dependencies: 4
-- Name: seq_current_cards_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1325 (class 1259 OID 18110)
-- Dependencies: 4
-- Name: seq_current_cards_phones; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards_phones
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1326 (class 1259 OID 18112)
-- Dependencies: 4
-- Name: seq_current_contacts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_contacts
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1337 (class 1259 OID 18134)
-- Dependencies: 4
-- Name: seq_current_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1327 (class 1259 OID 18114)
-- Dependencies: 4
-- Name: seq_current_transaction_bill; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transaction_bill
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1328 (class 1259 OID 18116)
-- Dependencies: 4
-- Name: seq_current_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transaction_types
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1329 (class 1259 OID 18118)
-- Dependencies: 4
-- Name: seq_current_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transactions
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1254 (class 1259 OID 17509)
-- Dependencies: 4
-- Name: seq_group_permissions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_group_permissions
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1253 (class 1259 OID 17507)
-- Dependencies: 4
-- Name: seq_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_groups
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1339 (class 1259 OID 18156)
-- Dependencies: 4
-- Name: seq_inventory_card_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_card_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1255 (class 1259 OID 17511)
-- Dependencies: 4
-- Name: seq_inventory_card_units; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_card_units
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1256 (class 1259 OID 17513)
-- Dependencies: 4
-- Name: seq_inventory_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_cards
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1257 (class 1259 OID 17515)
-- Dependencies: 4
-- Name: seq_inventory_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_groups
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1258 (class 1259 OID 17517)
-- Dependencies: 4
-- Name: seq_inventory_prices; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_prices
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1259 (class 1259 OID 17519)
-- Dependencies: 4
-- Name: seq_inventory_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_transactions
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1260 (class 1259 OID 17521)
-- Dependencies: 4
-- Name: seq_inventory_units; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_units
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1261 (class 1259 OID 17523)
-- Dependencies: 4
-- Name: seq_inventory_warehouses; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_warehouses
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1262 (class 1259 OID 17525)
-- Dependencies: 4
-- Name: seq_module_components; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_module_components
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1263 (class 1259 OID 17527)
-- Dependencies: 4
-- Name: seq_modules; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_modules
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1330 (class 1259 OID 18120)
-- Dependencies: 4
-- Name: seq_order_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_order_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1331 (class 1259 OID 18122)
-- Dependencies: 4
-- Name: seq_order_in_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_order_in_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1332 (class 1259 OID 18124)
-- Dependencies: 4
-- Name: seq_orders; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_orders
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1333 (class 1259 OID 18126)
-- Dependencies: 4
-- Name: seq_tradebill_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1334 (class 1259 OID 18128)
-- Dependencies: 4
-- Name: seq_tradebill_tradebills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_tradebills
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1336 (class 1259 OID 18132)
-- Dependencies: 4
-- Name: seq_tradebill_tradebills_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_tradebills_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1335 (class 1259 OID 18130)
-- Dependencies: 4
-- Name: seq_tradebill_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 1264 (class 1259 OID 17529)
-- Dependencies: 4
-- Name: seq_user_group; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_user_group
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1265 (class 1259 OID 17531)
-- Dependencies: 4
-- Name: seq_user_permissions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_user_permissions
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 1251 (class 1259 OID 17320)
-- Dependencies: 4
-- Name: seq_users; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_users
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;
--
-- TOC entry 1268 (class 1259 OID 17550)
-- Dependencies: 4
-- Name: turq_accounting_accounts; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_accounts (
    accounting_accounts_id integer NOT NULL,
    companies_id integer NOT NULL,
    account_name character varying(100) NOT NULL,
    account_code character varying(50) NOT NULL,
    parent_account integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    update_date date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1270 (class 1259 OID 17571)
-- Dependencies: 4
-- Name: turq_accounting_journal; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_journal (
    accounting_journal_id integer NOT NULL,
    journal_date date NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1341 (class 1259 OID 18183)
-- Dependencies: 4
-- Name: turq_accounting_transaction_columns; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_transaction_columns (
    accounting_transaction_columns_id integer NOT NULL,
    accounting_accounts_id integer NOT NULL,
    dept_amount numeric NOT NULL,
    credit_amount numeric NOT NULL,
    accounting_transactions_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1271 (class 1259 OID 17573)
-- Dependencies: 4
-- Name: turq_accounting_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_transaction_types (
    accounting_transaction_types_id integer NOT NULL,
    types_name character varying NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1269 (class 1259 OID 17564)
-- Dependencies: 4
-- Name: turq_accounting_transactions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_transactions (
    accounting_transactions_id integer NOT NULL,
    accounting_journal_id integer NOT NULL,
    accounting_transaction_types_id integer NOT NULL,
    transactions_date date NOT NULL,
    module_id integer NOT NULL,
    transaction_document_no character varying(50) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1281 (class 1259 OID 17700)
-- Dependencies: 4
-- Name: turq_bank_cards_secondary_accounts; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bank_cards_secondary_accounts (
    bank_cards_secondary_accounts_id integer NOT NULL,
    bank_cards_id integer NOT NULL,
    bank_secondary_accounts_id integer NOT NULL,
    accounting_accounts_id integer NOT NULL,
    creation_date date,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1280 (class 1259 OID 17686)
-- Dependencies: 4
-- Name: turq_bank_secondary_accounts; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bank_secondary_accounts (
    bank_secondary_accounts_id integer NOT NULL,
    companies_id integer NOT NULL,
    account_name character varying(50) NOT NULL,
    account_code character varying(5) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1279 (class 1259 OID 17684)
-- Dependencies: 4
-- Name: turq_banks_cards; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_banks_cards (
    banks_cards_id integer NOT NULL,
    companies_id integer NOT NULL,
    bank_name character varying(50) NOT NULL,
    bank_branch_name character varying(50) NOT NULL,
    bank_account_no character varying(50) NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    currencies_id integer NOT NULL
);


--
-- TOC entry 1282 (class 1259 OID 17716)
-- Dependencies: 4
-- Name: turq_banks_transaction_bills; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_banks_transaction_bills (
    banks_transaction_bills_id integer NOT NULL,
    banks_cards_id integer NOT NULL,
    transaction_bill_no integer NOT NULL,
    transaction_bill_date date NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1284 (class 1259 OID 17729)
-- Dependencies: 4
-- Name: turq_banks_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_banks_transaction_types (
    bank_transaction_types_id integer NOT NULL,
    transaction_type_name character varying(50) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1283 (class 1259 OID 17724)
-- Dependencies: 4
-- Name: turq_banks_transactions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_banks_transactions (
    bank_transactions_id integer NOT NULL,
    bank_transactions_bills_id integer NOT NULL,
    banks_secondary_accounts_id integer NOT NULL,
    accounting_accounts_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    transaction_types_id integer NOT NULL,
    transaction_amount numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1294 (class 1259 OID 17876)
-- Dependencies: 4
-- Name: turq_bill_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bill_groups (
    bill_groups_id integer NOT NULL,
    companies_id integer NOT NULL,
    groups_name character varying(50) NOT NULL,
    group_description character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1295 (class 1259 OID 17894)
-- Dependencies: 4
-- Name: turq_bill_in_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bill_in_groups (
    bill_in_groups_id integer NOT NULL,
    bills_id integer NOT NULL,
    bill_groups_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1293 (class 1259 OID 17871)
-- Dependencies: 4
-- Name: turq_bills; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bills (
    bills_id integer NOT NULL,
    companies_id integer NOT NULL,
    bills_type integer NOT NULL,
    bill_document_no character varying(50) NOT NULL,
    bills_date date NOT NULL,
    current_cards_id integer NOT NULL,
    bills_definition character varying(250) NOT NULL,
    bills_printed smallint NOT NULL,
    bills_discount_rate integer NOT NULL,
    bills_discount_amount numeric NOT NULL,
    bills_charges numeric NOT NULL,
    bills_vat integer NOT NULL,
    bills_vat_amount numeric NOT NULL,
    bills_total_amount numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1285 (class 1259 OID 17755)
-- Dependencies: 4
-- Name: turq_cheque_cheques; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_cheque_cheques (
    cheque_cheques_id integer NOT NULL,
    companies_id integer NOT NULL,
    cheques_portfolio_no character varying(30) NOT NULL,
    cheques_no character varying(50) NOT NULL,
    banks_id integer NOT NULL,
    cheques_due_date date NOT NULL,
    cheques_debtor character varying(100) NOT NULL,
    cheques_payment_place character varying(50),
    cheques_value_date date NOT NULL,
    cheques_amount numeric NOT NULL,
    currencies_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1288 (class 1259 OID 17802)
-- Dependencies: 4
-- Name: turq_cheque_cheques_rolls; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_cheque_cheques_rolls (
    cheque_cheques_rolls_id integer NOT NULL,
    cheque_rolls_id integer NOT NULL,
    cheque_cheques_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1286 (class 1259 OID 17774)
-- Dependencies: 4
-- Name: turq_cheque_rolls; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_cheque_rolls (
    cheque_rolls_id integer NOT NULL,
    companies_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    banks_cards_id integer NOT NULL,
    cheque_transaction_types_id integer NOT NULL,
    cheque_rolls_date date NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1287 (class 1259 OID 17776)
-- Dependencies: 4
-- Name: turq_cheque_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_cheque_transaction_types (
    cheque_transaction_types_id integer NOT NULL,
    transaction_typs_name character varying(50) NOT NULL,
    transaction_types_parent smallint NOT NULL,
    accounting_accounts_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by date NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1236 (class 1259 OID 17143)
-- Dependencies: 1580 4
-- Name: turq_companies; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_companies (
    companies_id integer DEFAULT nextval('seq_companies'::text) NOT NULL,
    company_name character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1297 (class 1259 OID 17921)
-- Dependencies: 4
-- Name: turq_consignment_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_consignment_groups (
    consignment_groups_id integer NOT NULL,
    companies_id integer NOT NULL,
    groups_name character varying(50) NOT NULL,
    groups_description character varying(250) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1296 (class 1259 OID 17906)
-- Dependencies: 4
-- Name: turq_consignments; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_consignments (
    consignments_id integer NOT NULL,
    companies_id integer NOT NULL,
    consignments_document_no integer NOT NULL,
    bills_id integer NOT NULL,
    consignments_bill_document_no character varying(50) NOT NULL,
    consignments_date date NOT NULL,
    current_cards_id integer NOT NULL,
    consignments_definition character varying(250) NOT NULL,
    consignments_printed smallint NOT NULL,
    condignments_discount_rate integer NOT NULL,
    consignments_vat integer NOT NULL,
    consignments_discount_amount numeric NOT NULL,
    consignments_charges numeric NOT NULL,
    consignments_vat_amount numeric NOT NULL,
    consignments_total_amount numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL,
    consignments_type integer NOT NULL
);


--
-- TOC entry 1298 (class 1259 OID 17929)
-- Dependencies: 4
-- Name: turq_consignments_in_group; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_consignments_in_group (
    consignments_in_group_id integer NOT NULL,
    consignment_id integer NOT NULL,
    consignments_groups_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1266 (class 1259 OID 17533)
-- Dependencies: 1582 4
-- Name: turq_currencies; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_currencies (
    currencies_id integer NOT NULL,
    companies_id integer NOT NULL,
    currencies_name character varying(30) NOT NULL,
    currencies_abbreviation character varying(5) NOT NULL,
    currencies_country character varying(50) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    exchange_rate numeric DEFAULT 1
);


--
-- TOC entry 1267 (class 1259 OID 17545)
-- Dependencies: 4
-- Name: turq_current_cards; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_cards (
    current_cards_id integer NOT NULL,
    companies_id integer NOT NULL,
    cards_current_code character varying(25) NOT NULL,
    cards_name character varying(250) NOT NULL,
    cards_definition character varying(250) NOT NULL,
    cards_address character varying(250) NOT NULL,
    cards_discount_rate numeric NOT NULL,
    cards_discount_payment numeric NOT NULL,
    cards_credit_limit numeric NOT NULL,
    cards_risk_limit numeric NOT NULL,
    cards_tax_department character varying(50) NOT NULL,
    cards_tax_number character varying(50) NOT NULL,
    accounting_code_id_customer integer NOT NULL,
    accounting_code_id_supplier integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1274 (class 1259 OID 17635)
-- Dependencies: 4
-- Name: turq_current_cards_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_cards_groups (
    current_cards_groups_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    current_groups_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1272 (class 1259 OID 17616)
-- Dependencies: 4
-- Name: turq_current_cards_phones; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_cards_phones (
    current_cards_phones_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    phones_country_code integer NOT NULL,
    phones_city_code integer NOT NULL,
    phones_number integer NOT NULL,
    phones_type character varying(50) NOT NULL,
    creation_date date,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying NOT NULL
);


--
-- TOC entry 1275 (class 1259 OID 17647)
-- Dependencies: 4
-- Name: turq_current_contacts; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_contacts (
    current_contacts_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    contacts_name character varying(100) NOT NULL,
    contact_address character varying(250) NOT NULL,
    contacts_phone1 character varying(30) NOT NULL,
    contacts_phone2 character varying(30) NOT NULL,
    contacts_fax_number character varying(30) NOT NULL,
    contacts_email character varying(100) NOT NULL,
    contacts_web_site character varying(250),
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1273 (class 1259 OID 17627)
-- Dependencies: 4
-- Name: turq_current_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_groups (
    current_groups_id integer NOT NULL,
    groups_name character varying(50) NOT NULL,
    groups_description character varying(250) NOT NULL,
    companies_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1278 (class 1259 OID 17672)
-- Dependencies: 4
-- Name: turq_current_transaction_bill; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_transaction_bill (
    current_transaction_bill_id integer NOT NULL,
    current_transactions_id_close integer NOT NULL,
    current_transactions_id_open integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1277 (class 1259 OID 17670)
-- Dependencies: 4
-- Name: turq_current_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_transaction_types (
    current_transaction_types_id integer NOT NULL,
    companies_id integer NOT NULL,
    transaction_type_name character varying(50) NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1276 (class 1259 OID 17655)
-- Dependencies: 4
-- Name: turq_current_transactions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_current_transactions (
    current_transactions_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    transactions_date date NOT NULL,
    transactions_document_no character varying NOT NULL,
    current_transaction_types_id integer NOT NULL,
    transactions_total_credit numeric NOT NULL,
    transactions_total_discount numeric NOT NULL,
    currencies_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL,
    created_by character varying(50) NOT NULL,
    transactions_total_dept numeric NOT NULL,
    accounting_transaction_id integer NOT NULL
);


--
-- TOC entry 1242 (class 1259 OID 17209)
-- Dependencies: 4
-- Name: turq_group_permissions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_group_permissions (
    group_permissions_id integer NOT NULL,
    groups_id integer NOT NULL,
    modules_id integer NOT NULL,
    module_components_id integer NOT NULL,
    group_permissions_level integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1237 (class 1259 OID 17147)
-- Dependencies: 4
-- Name: turq_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_groups (
    groups_id integer NOT NULL,
    groups_name character varying(100) NOT NULL,
    groups_description character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1338 (class 1259 OID 18144)
-- Dependencies: 4
-- Name: turq_inventory_card_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_card_groups (
    inventory_card_groups_id integer NOT NULL,
    inventory_cards_id integer NOT NULL,
    inventory_groups_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1247 (class 1259 OID 17272)
-- Dependencies: 4
-- Name: turq_inventory_card_units; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_card_units (
    inventory_card_units_id integer NOT NULL,
    inventory_cards_id integer NOT NULL,
    card_units_factor integer NOT NULL,
    inventory_units_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1243 (class 1259 OID 17225)
-- Dependencies: 4
-- Name: turq_inventory_cards; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_cards (
    inventory_cards_id integer NOT NULL,
    companies_id integer NOT NULL,
    card_inventory_code character varying(25) NOT NULL,
    card_special_code character varying(25) NOT NULL,
    card_name character varying(50) NOT NULL,
    card_definition character varying(50) NOT NULL,
    card_minimum_amount integer NOT NULL,
    card_maximum_amount integer NOT NULL,
    card_vat integer NOT NULL,
    card_discount integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL,
    accounting_accounts_id_buy integer NOT NULL,
    accounting_accounts_id_sell integer NOT NULL
);


--
-- TOC entry 1245 (class 1259 OID 17235)
-- Dependencies: 4
-- Name: turq_inventory_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_groups (
    inventory_groups_id integer NOT NULL,
    groups_name character varying(50) NOT NULL,
    companies_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    groups_description character varying(250) NOT NULL
);


--
-- TOC entry 1246 (class 1259 OID 17257)
-- Dependencies: 4
-- Name: turq_inventory_prices; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_prices (
    inventory_prices_id integer NOT NULL,
    inventory_cards_id integer NOT NULL,
    prices_type boolean NOT NULL,
    currencies_id integer NOT NULL,
    prices_amount numeric NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1249 (class 1259 OID 17292)
-- Dependencies: 4
-- Name: turq_inventory_transactions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_transactions (
    inventory_transactions_id integer NOT NULL,
    inventory_cards_id integer NOT NULL,
    inventory_warehouses_id integer NOT NULL,
    consignments_id integer NOT NULL,
    transactions_amount_in bigint NOT NULL,
    inventory_units_id integer NOT NULL,
    transactions_unit_price numeric NOT NULL,
    transactions_total_price numeric NOT NULL,
    transactions_discount numeric NOT NULL,
    transactions_discount_amount numeric NOT NULL,
    transactions_vat integer NOT NULL,
    transactions_vat_amount numeric NOT NULL,
    transactions_vat_special_each numeric NOT NULL,
    transactions_vat_special numeric NOT NULL,
    transactions_vat_special_amount numeric NOT NULL,
    transactions_cumilative_price numeric NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    transactions_total_amount_out bigint NOT NULL
);


--
-- TOC entry 1244 (class 1259 OID 17227)
-- Dependencies: 4
-- Name: turq_inventory_units; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_units (
    inventory_units_id integer NOT NULL,
    units_name character varying(50) NOT NULL,
    companies_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL
);


--
-- TOC entry 1248 (class 1259 OID 17284)
-- Dependencies: 4
-- Name: turq_inventory_warehouses; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_warehouses (
    inventory_warehouses_id integer NOT NULL,
    warehouses_name character varying(50) NOT NULL,
    companies_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    warehouses_address character varying(250),
    warehouses_description character varying(250),
    warehouses_city character varying(25),
    warehouses_telephone character varying(25)
);


--
-- TOC entry 1238 (class 1259 OID 17149)
-- Dependencies: 4
-- Name: turq_module_components; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_module_components (
    module_components_id integer NOT NULL,
    modules_id integer NOT NULL,
    components_name character varying(100) NOT NULL,
    components_description character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1239 (class 1259 OID 17151)
-- Dependencies: 4
-- Name: turq_modules; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_modules (
    modules_id integer NOT NULL,
    modules_name character varying(100) NOT NULL,
    module_description character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1300 (class 1259 OID 17960)
-- Dependencies: 4
-- Name: turq_order_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_order_groups (
    order_groups_id integer NOT NULL,
    companies_id integer NOT NULL,
    groups_name character varying(50) NOT NULL,
    groups_description character varying(250) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1301 (class 1259 OID 17968)
-- Dependencies: 4
-- Name: turq_order_in_groups; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_order_in_groups (
    order_in_groups_id integer NOT NULL,
    orders_id integer NOT NULL,
    order_groups_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1299 (class 1259 OID 17941)
-- Dependencies: 4
-- Name: turq_orders; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_orders (
    orders_id integer NOT NULL,
    companies_id integer NOT NULL,
    orders_document_no integer NOT NULL,
    bills_id integer NOT NULL,
    orders_date date NOT NULL,
    current_cards_id integer NOT NULL,
    orders_definition character varying(250) NOT NULL,
    orders_discount_rate integer NOT NULL,
    orders_vat integer NOT NULL,
    orders_discount_amount numeric NOT NULL,
    orders_charges numeric NOT NULL,
    orders_vat_amount numeric NOT NULL,
    orders_total_amount numeric NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL,
    orders_due_date date NOT NULL,
    orders_deliver_date date NOT NULL,
    orders_delivered integer NOT NULL,
    orders_type integer NOT NULL
);


--
-- TOC entry 1290 (class 1259 OID 17829)
-- Dependencies: 4
-- Name: turq_tradebill_rolls; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_tradebill_rolls (
    tradebill_rolls_id integer NOT NULL,
    companies_id integer NOT NULL,
    current_cards_id integer NOT NULL,
    banks_cards_id integer NOT NULL,
    tradebill_transaction_types_id integer NOT NULL,
    tradebill_rolls_date date NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1289 (class 1259 OID 17814)
-- Dependencies: 4
-- Name: turq_tradebill_tradebills; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_tradebill_tradebills (
    tradebill_tradebills_id integer NOT NULL,
    companies_id integer NOT NULL,
    tradebills_portfolio_no character varying(50) NOT NULL,
    tradebill_due_date date NOT NULL,
    tradebill_debtor character varying(100) NOT NULL,
    tradebill_guarantor character varying(100) NOT NULL,
    tradebill_payment_place character varying(100) NOT NULL,
    tradebill_value_date integer NOT NULL,
    tradebill_amount numeric NOT NULL,
    currencies_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1292 (class 1259 OID 17859)
-- Dependencies: 4
-- Name: turq_tradebill_tradebills_rolls; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_tradebill_tradebills_rolls (
    tradebill_tradebills_rolls_id integer NOT NULL,
    tradebill_rolls_id integer NOT NULL,
    tradebill_tradebills_id integer NOT NULL,
    creation_date date NOT NULL,
    last_modified date NOT NULL,
    created_by character varying(50) NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1291 (class 1259 OID 17847)
-- Dependencies: 4
-- Name: turq_tradebill_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_tradebill_transaction_types (
    tradebill_transaction_types_id integer NOT NULL,
    transaction_types_name character varying(50) NOT NULL,
    transaction_types_parent smallint NOT NULL,
    accounting_accounts_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by date NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
);


--
-- TOC entry 1252 (class 1259 OID 17335)
-- Dependencies: 4
-- Name: turq_user_group; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_user_group (
    user_group_id integer NOT NULL,
    groups_id integer NOT NULL,
    users_id integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1240 (class 1259 OID 17155)
-- Dependencies: 4
-- Name: turq_user_permissions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_user_permissions (
    user_permissions_id integer NOT NULL,
    users_id integer NOT NULL,
    modules_id integer NOT NULL,
    module_components_id integer NOT NULL,
    user_permissions_level integer NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1241 (class 1259 OID 17157)
-- Dependencies: 1581 4
-- Name: turq_users; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_users (
    users_id integer DEFAULT nextval('seq_users'::text) NOT NULL,
    username character varying(30) NOT NULL,
    users_password character varying(250) NOT NULL,
    users_real_name character varying(250) NOT NULL,
    users_description character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
);


--
-- TOC entry 1342 (class 1259 OID 18216)
-- Dependencies: 1404 4
-- Name: view_inventory_levels; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW view_inventory_levels AS
    SELECT turq_inventory_transactions.inventory_cards_id, sum(turq_inventory_transactions.transactions_amount_in) AS amount FROM turq_inventory_transactions GROUP BY turq_inventory_transactions.inventory_cards_id;


--
-- TOC entry 1670 (class 16386 OID 17779)
-- Dependencies: 1287 1287
-- Name: cheque_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_transaction_types
    ADD CONSTRAINT cheque_transaction_types_pkey PRIMARY KEY (cheque_transaction_types_id);


--
-- TOC entry 1678 (class 16386 OID 17850)
-- Dependencies: 1291 1291
-- Name: tradebill_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_transaction_types
    ADD CONSTRAINT tradebill_transaction_types_pkey PRIMARY KEY (tradebill_transaction_types_id);


--
-- TOC entry 1628 (class 16386 OID 17553)
-- Dependencies: 1268 1268
-- Name: turq_accounting_accounts_account_code_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT turq_accounting_accounts_account_code_key UNIQUE (account_code);


--
-- TOC entry 1630 (class 16386 OID 17555)
-- Dependencies: 1268 1268
-- Name: turq_accounting_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT turq_accounting_accounts_pkey PRIMARY KEY (accounting_accounts_id);


--
-- TOC entry 1634 (class 16386 OID 17581)
-- Dependencies: 1270 1270
-- Name: turq_accounting_journal_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_journal
    ADD CONSTRAINT turq_accounting_journal_pkey PRIMARY KEY (accounting_journal_id);


--
-- TOC entry 1702 (class 16386 OID 18189)
-- Dependencies: 1341 1341
-- Name: turq_accounting_transaction_columns_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT turq_accounting_transaction_columns_pkey PRIMARY KEY (accounting_transaction_columns_id);


--
-- TOC entry 1636 (class 16386 OID 17579)
-- Dependencies: 1271 1271
-- Name: turq_accounting_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_types
    ADD CONSTRAINT turq_accounting_transaction_types_pkey PRIMARY KEY (accounting_transaction_types_id);


--
-- TOC entry 1632 (class 16386 OID 17570)
-- Dependencies: 1269 1269
-- Name: turq_accounting_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT turq_accounting_transactions_pkey PRIMARY KEY (accounting_transactions_id);


--
-- TOC entry 1658 (class 16386 OID 17703)
-- Dependencies: 1281 1281
-- Name: turq_bank_cards_secondary_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT turq_bank_cards_secondary_accounts_pkey PRIMARY KEY (bank_cards_secondary_accounts_id);


--
-- TOC entry 1656 (class 16386 OID 17695)
-- Dependencies: 1280 1280
-- Name: turq_bank_secondary_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_secondary_accounts
    ADD CONSTRAINT turq_bank_secondary_accounts_pkey PRIMARY KEY (bank_secondary_accounts_id);


--
-- TOC entry 1654 (class 16386 OID 17689)
-- Dependencies: 1279 1279
-- Name: turq_banks_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT turq_banks_cards_pkey PRIMARY KEY (banks_cards_id);


--
-- TOC entry 1660 (class 16386 OID 17719)
-- Dependencies: 1282 1282
-- Name: turq_banks_transaction_bills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_bills
    ADD CONSTRAINT turq_banks_transaction_bills_pkey PRIMARY KEY (banks_transaction_bills_id);


--
-- TOC entry 1664 (class 16386 OID 17732)
-- Dependencies: 1284 1284
-- Name: turq_banks_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_types
    ADD CONSTRAINT turq_banks_transaction_types_pkey PRIMARY KEY (bank_transaction_types_id);


--
-- TOC entry 1662 (class 16386 OID 17734)
-- Dependencies: 1283 1283
-- Name: turq_banks_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT turq_banks_transactions_pkey PRIMARY KEY (bank_transactions_id);


--
-- TOC entry 1684 (class 16386 OID 17879)
-- Dependencies: 1294 1294
-- Name: turq_bill_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_groups
    ADD CONSTRAINT turq_bill_groups_pkey PRIMARY KEY (bill_groups_id);


--
-- TOC entry 1686 (class 16386 OID 17897)
-- Dependencies: 1295 1295
-- Name: turq_bill_in_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT turq_bill_in_groups_pkey PRIMARY KEY (bill_in_groups_id);


--
-- TOC entry 1682 (class 16386 OID 17885)
-- Dependencies: 1293 1293
-- Name: turq_bills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT turq_bills_pkey PRIMARY KEY (bills_id);


--
-- TOC entry 1666 (class 16386 OID 17761)
-- Dependencies: 1285 1285
-- Name: turq_cheque_cheques_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT turq_cheque_cheques_pkey PRIMARY KEY (cheque_cheques_id);


--
-- TOC entry 1672 (class 16386 OID 17805)
-- Dependencies: 1288 1288
-- Name: turq_cheque_cheques_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT turq_cheque_cheques_rolls_pkey PRIMARY KEY (cheque_cheques_rolls_id);


--
-- TOC entry 1668 (class 16386 OID 17785)
-- Dependencies: 1286 1286
-- Name: turq_cheque_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT turq_cheque_rolls_pkey PRIMARY KEY (cheque_rolls_id);


--
-- TOC entry 1584 (class 16386 OID 17316)
-- Dependencies: 1236 1236
-- Name: turq_companies_companies_id_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_companies
    ADD CONSTRAINT turq_companies_companies_id_key UNIQUE (companies_id);


--
-- TOC entry 1586 (class 16386 OID 17208)
-- Dependencies: 1236 1236
-- Name: turq_companies_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_companies
    ADD CONSTRAINT turq_companies_pkey PRIMARY KEY (companies_id);


--
-- TOC entry 1690 (class 16386 OID 17924)
-- Dependencies: 1297 1297
-- Name: turq_consignment_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignment_groups
    ADD CONSTRAINT turq_consignment_groups_pkey PRIMARY KEY (consignment_groups_id);


--
-- TOC entry 1692 (class 16386 OID 17932)
-- Dependencies: 1298 1298
-- Name: turq_consignments_in_group_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT turq_consignments_in_group_pkey PRIMARY KEY (consignments_in_group_id);


--
-- TOC entry 1688 (class 16386 OID 17912)
-- Dependencies: 1296 1296
-- Name: turq_consignments_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT turq_consignments_pkey PRIMARY KEY (consignments_id);


--
-- TOC entry 1622 (class 16386 OID 17536)
-- Dependencies: 1266 1266
-- Name: turq_currencies_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_currencies
    ADD CONSTRAINT turq_currencies_pkey PRIMARY KEY (currencies_id);


--
-- TOC entry 1624 (class 16386 OID 18226)
-- Dependencies: 1267 1267
-- Name: turq_current_cards_cards_current_code_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT turq_current_cards_cards_current_code_key UNIQUE (cards_current_code);


--
-- TOC entry 1642 (class 16386 OID 17638)
-- Dependencies: 1274 1274
-- Name: turq_current_cards_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT turq_current_cards_groups_pkey PRIMARY KEY (current_cards_groups_id);


--
-- TOC entry 1638 (class 16386 OID 17622)
-- Dependencies: 1272 1272
-- Name: turq_current_cards_phones_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_phones
    ADD CONSTRAINT turq_current_cards_phones_pkey PRIMARY KEY (current_cards_phones_id);


--
-- TOC entry 1626 (class 16386 OID 17603)
-- Dependencies: 1267 1267
-- Name: turq_current_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT turq_current_cards_pkey PRIMARY KEY (current_cards_id);


--
-- TOC entry 1644 (class 16386 OID 17650)
-- Dependencies: 1275 1275
-- Name: turq_current_contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_contacts
    ADD CONSTRAINT turq_current_contacts_pkey PRIMARY KEY (current_contacts_id);


--
-- TOC entry 1640 (class 16386 OID 17630)
-- Dependencies: 1273 1273
-- Name: turq_current_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_groups
    ADD CONSTRAINT turq_current_groups_pkey PRIMARY KEY (current_groups_id);


--
-- TOC entry 1652 (class 16386 OID 17675)
-- Dependencies: 1278 1278
-- Name: turq_current_transaction_bill_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT turq_current_transaction_bill_pkey PRIMARY KEY (current_transaction_bill_id);


--
-- TOC entry 1650 (class 16386 OID 17985)
-- Dependencies: 1277 1277
-- Name: turq_current_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_types
    ADD CONSTRAINT turq_current_transaction_types_pkey PRIMARY KEY (current_transaction_types_id);


--
-- TOC entry 1646 (class 16386 OID 17661)
-- Dependencies: 1276 1276
-- Name: turq_current_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT turq_current_transactions_pkey PRIMARY KEY (current_transactions_id);


--
-- TOC entry 1648 (class 16386 OID 18234)
-- Dependencies: 1276 1276
-- Name: turq_current_transactions_transactions_document_no_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT turq_current_transactions_transactions_document_no_key UNIQUE (transactions_document_no);


--
-- TOC entry 1598 (class 16386 OID 17212)
-- Dependencies: 1242 1242
-- Name: turq_group_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT turq_group_permissions_pkey PRIMARY KEY (group_permissions_id);


--
-- TOC entry 1588 (class 16386 OID 17170)
-- Dependencies: 1237 1237
-- Name: turq_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_groups
    ADD CONSTRAINT turq_groups_pkey PRIMARY KEY (groups_id);


--
-- TOC entry 1700 (class 16386 OID 18147)
-- Dependencies: 1338 1338
-- Name: turq_inventory_card_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT turq_inventory_card_groups_pkey PRIMARY KEY (inventory_card_groups_id);


--
-- TOC entry 1600 (class 16386 OID 17244)
-- Dependencies: 1243 1243
-- Name: turq_inventory_card_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_card_pkey PRIMARY KEY (inventory_cards_id);


--
-- TOC entry 1614 (class 16386 OID 17275)
-- Dependencies: 1247 1247
-- Name: turq_inventory_card_units_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT turq_inventory_card_units_pkey PRIMARY KEY (inventory_card_units_id);


--
-- TOC entry 1602 (class 16386 OID 18137)
-- Dependencies: 1243 1243
-- Name: turq_inventory_cards_card_inventory_code_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_cards_card_inventory_code_key UNIQUE (card_inventory_code);


--
-- TOC entry 1604 (class 16386 OID 18141)
-- Dependencies: 1243 1243
-- Name: turq_inventory_cards_card_name_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_cards_card_name_key UNIQUE (card_name);


--
-- TOC entry 1608 (class 16386 OID 18143)
-- Dependencies: 1245 1245
-- Name: turq_inventory_groups_groups_name_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT turq_inventory_groups_groups_name_key UNIQUE (groups_name);


--
-- TOC entry 1610 (class 16386 OID 17238)
-- Dependencies: 1245 1245
-- Name: turq_inventory_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT turq_inventory_groups_pkey PRIMARY KEY (inventory_groups_id);


--
-- TOC entry 1612 (class 16386 OID 17263)
-- Dependencies: 1246 1246
-- Name: turq_inventory_prices_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT turq_inventory_prices_pkey PRIMARY KEY (inventory_prices_id);


--
-- TOC entry 1618 (class 16386 OID 17298)
-- Dependencies: 1249 1249
-- Name: turq_inventory_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT turq_inventory_transactions_pkey PRIMARY KEY (inventory_transactions_id);


--
-- TOC entry 1606 (class 16386 OID 17230)
-- Dependencies: 1244 1244
-- Name: turq_inventory_units_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_units
    ADD CONSTRAINT turq_inventory_units_pkey PRIMARY KEY (inventory_units_id);


--
-- TOC entry 1616 (class 16386 OID 17287)
-- Dependencies: 1248 1248
-- Name: turq_inventory_warehouses_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_warehouses
    ADD CONSTRAINT turq_inventory_warehouses_pkey PRIMARY KEY (inventory_warehouses_id);


--
-- TOC entry 1590 (class 16386 OID 17164)
-- Dependencies: 1238 1238
-- Name: turq_module_components_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_module_components
    ADD CONSTRAINT turq_module_components_pkey PRIMARY KEY (module_components_id);


--
-- TOC entry 1592 (class 16386 OID 17162)
-- Dependencies: 1239 1239
-- Name: turq_modules_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_modules
    ADD CONSTRAINT turq_modules_pkey PRIMARY KEY (modules_id);


--
-- TOC entry 1696 (class 16386 OID 17963)
-- Dependencies: 1300 1300
-- Name: turq_order_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_groups
    ADD CONSTRAINT turq_order_groups_pkey PRIMARY KEY (order_groups_id);


--
-- TOC entry 1698 (class 16386 OID 17971)
-- Dependencies: 1301 1301
-- Name: turq_order_in_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT turq_order_in_groups_pkey PRIMARY KEY (order_in_groups_id);


--
-- TOC entry 1694 (class 16386 OID 17947)
-- Dependencies: 1299 1299
-- Name: turq_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT turq_orders_pkey PRIMARY KEY (orders_id);


--
-- TOC entry 1676 (class 16386 OID 17832)
-- Dependencies: 1290 1290
-- Name: turq_tradebill_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT turq_tradebill_rolls_pkey PRIMARY KEY (tradebill_rolls_id);


--
-- TOC entry 1674 (class 16386 OID 17820)
-- Dependencies: 1289 1289
-- Name: turq_tradebill_tradebills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT turq_tradebill_tradebills_pkey PRIMARY KEY (tradebill_tradebills_id);


--
-- TOC entry 1680 (class 16386 OID 17862)
-- Dependencies: 1292 1292
-- Name: turq_tradebill_tradebills_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT turq_tradebill_tradebills_rolls_pkey PRIMARY KEY (tradebill_tradebills_rolls_id);


--
-- TOC entry 1620 (class 16386 OID 17338)
-- Dependencies: 1252 1252
-- Name: turq_user_group_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT turq_user_group_pkey PRIMARY KEY (user_group_id);


--
-- TOC entry 1594 (class 16386 OID 17194)
-- Dependencies: 1240 1240
-- Name: turq_user_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT turq_user_permissions_pkey PRIMARY KEY (user_permissions_id);


--
-- TOC entry 1596 (class 16386 OID 17184)
-- Dependencies: 1241 1241
-- Name: turq_users_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_users
    ADD CONSTRAINT turq_users_pkey PRIMARY KEY (users_id);


--
-- TOC entry 1703 (class 16386 OID 17165)
-- Dependencies: 1238 1239 1591
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_module_components
    ADD CONSTRAINT "$1" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1704 (class 16386 OID 17195)
-- Dependencies: 1240 1241 1595
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$1" FOREIGN KEY (users_id) REFERENCES turq_users(users_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1707 (class 16386 OID 17213)
-- Dependencies: 1242 1239 1591
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$1" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1713 (class 16386 OID 17231)
-- Dependencies: 1244 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_units
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1714 (class 16386 OID 17239)
-- Dependencies: 1245 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1710 (class 16386 OID 17245)
-- Dependencies: 1243 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1717 (class 16386 OID 17276)
-- Dependencies: 1247 1243 1599
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1719 (class 16386 OID 17288)
-- Dependencies: 1248 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_warehouses
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1720 (class 16386 OID 17299)
-- Dependencies: 1249 1248 1615
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_warehouses_id) REFERENCES turq_inventory_warehouses(inventory_warehouses_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1724 (class 16386 OID 17339)
-- Dependencies: 1252 1237 1587
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT "$1" FOREIGN KEY (groups_id) REFERENCES turq_groups(groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1726 (class 16386 OID 17537)
-- Dependencies: 1266 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_currencies
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1716 (class 16386 OID 17541)
-- Dependencies: 1246 1266 1621
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT "$1" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1730 (class 16386 OID 17556)
-- Dependencies: 1268 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1732 (class 16386 OID 17582)
-- Dependencies: 1269 1271 1635
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_transaction_types_id) REFERENCES turq_accounting_transaction_types(accounting_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1727 (class 16386 OID 17604)
-- Dependencies: 1267 1268 1629
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_code_id_customer) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1735 (class 16386 OID 17623)
-- Dependencies: 1272 1267 1625
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_phones
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1736 (class 16386 OID 17631)
-- Dependencies: 1273 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1737 (class 16386 OID 17639)
-- Dependencies: 1274 1267 1625
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1739 (class 16386 OID 17651)
-- Dependencies: 1275 1267 1625
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_contacts
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1740 (class 16386 OID 17662)
-- Dependencies: 1276 1267 1625
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1745 (class 16386 OID 17676)
-- Dependencies: 1278 1276 1645
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT "$1" FOREIGN KEY (current_transactions_id_close) REFERENCES turq_current_transactions(current_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1747 (class 16386 OID 17690)
-- Dependencies: 1279 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1749 (class 16386 OID 17696)
-- Dependencies: 1280 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_secondary_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1750 (class 16386 OID 17704)
-- Dependencies: 1281 1279 1653
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (bank_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1753 (class 16386 OID 17720)
-- Dependencies: 1282 1279 1653
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_bills
    ADD CONSTRAINT "$1" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1754 (class 16386 OID 17735)
-- Dependencies: 1283 1282 1659
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (bank_transactions_bills_id) REFERENCES turq_banks_transaction_bills(banks_transaction_bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1759 (class 16386 OID 17762)
-- Dependencies: 1285 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1766 (class 16386 OID 17780)
-- Dependencies: 1287 1268 1629
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1762 (class 16386 OID 17786)
-- Dependencies: 1286 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1767 (class 16386 OID 17806)
-- Dependencies: 1288 1286 1667
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (cheque_rolls_id) REFERENCES turq_cheque_rolls(cheque_rolls_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1769 (class 16386 OID 17821)
-- Dependencies: 1289 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1771 (class 16386 OID 17833)
-- Dependencies: 1290 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1775 (class 16386 OID 17851)
-- Dependencies: 1291 1268 1629
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1776 (class 16386 OID 17863)
-- Dependencies: 1292 1290 1675
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (tradebill_rolls_id) REFERENCES turq_tradebill_rolls(tradebill_rolls_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1780 (class 16386 OID 17880)
-- Dependencies: 1294 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1778 (class 16386 OID 17886)
-- Dependencies: 1293 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1781 (class 16386 OID 17898)
-- Dependencies: 1295 1294 1683
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (bill_groups_id) REFERENCES turq_bill_groups(bill_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1783 (class 16386 OID 17913)
-- Dependencies: 1296 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1786 (class 16386 OID 17925)
-- Dependencies: 1297 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignment_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1787 (class 16386 OID 17933)
-- Dependencies: 1298 1296 1687
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT "$1" FOREIGN KEY (consignment_id) REFERENCES turq_consignments(consignments_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1789 (class 16386 OID 17948)
-- Dependencies: 1299 1293 1681
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$1" FOREIGN KEY (bills_id) REFERENCES turq_bills(bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1792 (class 16386 OID 17964)
-- Dependencies: 1300 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1793 (class 16386 OID 17972)
-- Dependencies: 1301 1299 1693
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (orders_id) REFERENCES turq_orders(orders_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1744 (class 16386 OID 17986)
-- Dependencies: 1277 1236 1585
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1795 (class 16386 OID 18148)
-- Dependencies: 1338 1243 1599
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1798 (class 16386 OID 18206)
-- Dependencies: 1341 1268 1629
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1705 (class 16386 OID 17199)
-- Dependencies: 1240 1239 1591
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$2" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1708 (class 16386 OID 17217)
-- Dependencies: 1242 1238 1589
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$2" FOREIGN KEY (module_components_id) REFERENCES turq_module_components(module_components_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1715 (class 16386 OID 17268)
-- Dependencies: 1246 1243 1599
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1718 (class 16386 OID 17280)
-- Dependencies: 1247 1244 1605
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_units_id) REFERENCES turq_inventory_units(inventory_units_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1721 (class 16386 OID 17303)
-- Dependencies: 1249 1243 1599
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1725 (class 16386 OID 17343)
-- Dependencies: 1252 1241 1595
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT "$2" FOREIGN KEY (users_id) REFERENCES turq_users(users_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1731 (class 16386 OID 17560)
-- Dependencies: 1268 1268 1629
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT "$2" FOREIGN KEY (parent_account) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1733 (class 16386 OID 17586)
-- Dependencies: 1269 1270 1633
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (accounting_journal_id) REFERENCES turq_accounting_journal(accounting_journal_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1728 (class 16386 OID 17608)
-- Dependencies: 1267 1268 1629
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT "$2" FOREIGN KEY (accounting_code_id_supplier) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1738 (class 16386 OID 17643)
-- Dependencies: 1274 1273 1639
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (current_groups_id) REFERENCES turq_current_groups(current_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1741 (class 16386 OID 17666)
-- Dependencies: 1276 1266 1621
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1746 (class 16386 OID 17680)
-- Dependencies: 1278 1276 1645
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT "$2" FOREIGN KEY (current_transactions_id_open) REFERENCES turq_current_transactions(current_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1751 (class 16386 OID 17708)
-- Dependencies: 1281 1280 1655
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$2" FOREIGN KEY (bank_secondary_accounts_id) REFERENCES turq_bank_secondary_accounts(bank_secondary_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1755 (class 16386 OID 17739)
-- Dependencies: 1283 1281 1657
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (banks_secondary_accounts_id) REFERENCES turq_bank_cards_secondary_accounts(bank_cards_secondary_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1760 (class 16386 OID 17766)
-- Dependencies: 1285 1279 1653
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$2" FOREIGN KEY (banks_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1763 (class 16386 OID 17790)
-- Dependencies: 1286 1267 1625
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1768 (class 16386 OID 17810)
-- Dependencies: 1288 1285 1665
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (cheque_cheques_id) REFERENCES turq_cheque_cheques(cheque_cheques_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1770 (class 16386 OID 17825)
-- Dependencies: 1289 1266 1621
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1772 (class 16386 OID 17837)
-- Dependencies: 1290 1267 1625
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1777 (class 16386 OID 17867)
-- Dependencies: 1292 1289 1673
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (tradebill_tradebills_id) REFERENCES turq_tradebill_tradebills(tradebill_tradebills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1779 (class 16386 OID 17890)
-- Dependencies: 1293 1267 1625
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1782 (class 16386 OID 17902)
-- Dependencies: 1295 1293 1681
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (bills_id) REFERENCES turq_bills(bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1784 (class 16386 OID 17917)
-- Dependencies: 1296 1267 1625
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1788 (class 16386 OID 17937)
-- Dependencies: 1298 1297 1689
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT "$2" FOREIGN KEY (consignments_groups_id) REFERENCES turq_consignment_groups(consignment_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1790 (class 16386 OID 17952)
-- Dependencies: 1299 1236 1585
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$2" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1794 (class 16386 OID 17976)
-- Dependencies: 1301 1300 1695
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (order_groups_id) REFERENCES turq_order_groups(order_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1796 (class 16386 OID 18152)
-- Dependencies: 1338 1245 1609
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_groups_id) REFERENCES turq_inventory_groups(inventory_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1748 (class 16386 OID 18158)
-- Dependencies: 1279 1266 1621
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1706 (class 16386 OID 17203)
-- Dependencies: 1240 1238 1589
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$3" FOREIGN KEY (module_components_id) REFERENCES turq_module_components(module_components_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1709 (class 16386 OID 17221)
-- Dependencies: 1242 1237 1587
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$3" FOREIGN KEY (groups_id) REFERENCES turq_groups(groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1722 (class 16386 OID 17307)
-- Dependencies: 1249 1244 1605
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (inventory_units_id) REFERENCES turq_inventory_units(inventory_units_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1729 (class 16386 OID 17612)
-- Dependencies: 1267 1236 1585
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT "$3" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1752 (class 16386 OID 17712)
-- Dependencies: 1281 1268 1629
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1756 (class 16386 OID 17743)
-- Dependencies: 1283 1268 1629
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1761 (class 16386 OID 17770)
-- Dependencies: 1285 1266 1621
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$3" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1764 (class 16386 OID 17794)
-- Dependencies: 1286 1279 1653
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$3" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1773 (class 16386 OID 17841)
-- Dependencies: 1290 1279 1653
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$3" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1791 (class 16386 OID 17956)
-- Dependencies: 1299 1267 1625
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$3" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1785 (class 16386 OID 17980)
-- Dependencies: 1296 1293 1681
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$3" FOREIGN KEY (bills_id) REFERENCES turq_bills(bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1797 (class 16386 OID 18198)
-- Dependencies: 1341 1269 1631
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_transactions_id) REFERENCES turq_accounting_transactions(accounting_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1742 (class 16386 OID 18219)
-- Dependencies: 1276 1277 1649
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (current_transaction_types_id) REFERENCES turq_current_transaction_types(current_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1757 (class 16386 OID 17747)
-- Dependencies: 1283 1267 1625
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$4" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1765 (class 16386 OID 17798)
-- Dependencies: 1286 1287 1669
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$4" FOREIGN KEY (cheque_transaction_types_id) REFERENCES turq_cheque_transaction_types(cheque_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1774 (class 16386 OID 17855)
-- Dependencies: 1290 1291 1677
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$4" FOREIGN KEY (tradebill_transaction_types_id) REFERENCES turq_tradebill_transaction_types(tradebill_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1723 (class 16386 OID 17990)
-- Dependencies: 1249 1296 1687
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$4" FOREIGN KEY (consignments_id) REFERENCES turq_consignments(consignments_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1711 (class 16386 OID 18002)
-- Dependencies: 1243 1268 1629
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$4" FOREIGN KEY (accounting_accounts_id_buy) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1743 (class 16386 OID 18235)
-- Dependencies: 1276 1269 1631
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$4" FOREIGN KEY (accounting_transaction_id) REFERENCES turq_accounting_transactions(accounting_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1734 (class 16386 OID 17598)
-- Dependencies: 1269 1239 1591
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$5" FOREIGN KEY (module_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1758 (class 16386 OID 17751)
-- Dependencies: 1283 1284 1663
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$5" FOREIGN KEY (transaction_types_id) REFERENCES turq_banks_transaction_types(bank_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1712 (class 16386 OID 18006)
-- Dependencies: 1243 1268 1629
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$5" FOREIGN KEY (accounting_accounts_id_sell) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 1804 (class 0 OID 0)
-- Name: DUMP TIMESTAMP; Type: DUMP TIMESTAMP; Schema: -; Owner: 
--

-- Completed on 2004-11-03 11:04:01 GTB Standard Time


--
-- TOC entry 1803 (class 0 OID 0)
-- Dependencies: 4
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


