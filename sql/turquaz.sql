--
-- PostgreSQL database dump
--

SET client_encoding = 'SQL_ASCII';
SET check_function_bodies = false;

SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 4 (OID 2200)
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


SET SESSION AUTHORIZATION 'turquaz';

SET search_path = public, pg_catalog;

--
-- TOC entry 115 (OID 17143)
-- Name: turq_companies; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_companies (
    companies_id integer DEFAULT nextval('seq_companies'::text) NOT NULL,
    company_name character varying(250) NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    update_date date NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 116 (OID 17147)
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
) WITHOUT OIDS;


--
-- TOC entry 117 (OID 17149)
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
) WITHOUT OIDS;


--
-- TOC entry 118 (OID 17151)
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
) WITHOUT OIDS;


--
-- TOC entry 119 (OID 17155)
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
) WITHOUT OIDS;


--
-- TOC entry 120 (OID 17157)
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
) WITHOUT OIDS;


--
-- TOC entry 121 (OID 17209)
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
) WITHOUT OIDS;


--
-- TOC entry 122 (OID 17225)
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
    accounting_accounts_id_sell integer NOT NULL,
    card_special_vat integer NOT NULL,
    card_special_vat_each numeric NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 123 (OID 17227)
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
) WITHOUT OIDS;


--
-- TOC entry 124 (OID 17235)
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
) WITHOUT OIDS;


--
-- TOC entry 125 (OID 17257)
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
) WITHOUT OIDS;


--
-- TOC entry 126 (OID 17272)
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
) WITHOUT OIDS;


--
-- TOC entry 127 (OID 17284)
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
) WITHOUT OIDS;


--
-- TOC entry 128 (OID 17292)
-- Name: turq_inventory_transactions; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_inventory_transactions (
    inventory_transactions_id integer NOT NULL,
    inventory_cards_id integer NOT NULL,
    inventory_warehouses_id integer NOT NULL,
    engine_sequences_id integer NOT NULL,
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
) WITHOUT OIDS;


--
-- TOC entry 5 (OID 17313)
-- Name: seq_companies; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_companies
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 7 (OID 17320)
-- Name: seq_users; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_users
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 129 (OID 17335)
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
) WITHOUT OIDS;


--
-- TOC entry 9 (OID 17507)
-- Name: seq_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_groups
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 11 (OID 17509)
-- Name: seq_group_permissions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_group_permissions
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 13 (OID 17511)
-- Name: seq_inventory_card_units; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_card_units
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 15 (OID 17513)
-- Name: seq_inventory_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_cards
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 17 (OID 17515)
-- Name: seq_inventory_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_groups
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 19 (OID 17517)
-- Name: seq_inventory_prices; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_prices
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 21 (OID 17519)
-- Name: seq_inventory_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_transactions
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 23 (OID 17521)
-- Name: seq_inventory_units; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_units
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 25 (OID 17523)
-- Name: seq_inventory_warehouses; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_warehouses
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 27 (OID 17525)
-- Name: seq_module_components; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_module_components
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 29 (OID 17527)
-- Name: seq_modules; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_modules
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 31 (OID 17529)
-- Name: seq_user_group; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_user_group
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 33 (OID 17531)
-- Name: seq_user_permissions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_user_permissions
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 130 (OID 17533)
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
) WITHOUT OIDS;


--
-- TOC entry 131 (OID 17545)
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
    accounting_code_id integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 132 (OID 17550)
-- Name: turq_accounting_accounts; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_accounts (
    accounting_accounts_id integer NOT NULL,
    companies_id integer NOT NULL,
    account_name character varying(250) NOT NULL,
    account_code character varying(50) NOT NULL,
    parent_account integer NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    update_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    top_account integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 133 (OID 17564)
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
    updated_by character varying(50) NOT NULL,
    engine_sequences_id integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 134 (OID 17571)
-- Name: turq_accounting_journal; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_journal (
    accounting_journal_id integer NOT NULL,
    journal_date date NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 135 (OID 17573)
-- Name: turq_accounting_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_accounting_transaction_types (
    accounting_transaction_types_id integer NOT NULL,
    types_name character varying NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 136 (OID 17616)
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
) WITHOUT OIDS;


--
-- TOC entry 137 (OID 17627)
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
) WITHOUT OIDS;


--
-- TOC entry 138 (OID 17635)
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
) WITHOUT OIDS;


--
-- TOC entry 139 (OID 17647)
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
) WITHOUT OIDS;


--
-- TOC entry 140 (OID 17655)
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
    engine_sequences_id integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 141 (OID 17670)
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
) WITHOUT OIDS;


--
-- TOC entry 142 (OID 17672)
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
) WITHOUT OIDS;


--
-- TOC entry 143 (OID 17684)
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
) WITHOUT OIDS;


--
-- TOC entry 144 (OID 17686)
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
) WITHOUT OIDS;


--
-- TOC entry 145 (OID 17700)
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
) WITHOUT OIDS;


--
-- TOC entry 146 (OID 17716)
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
) WITHOUT OIDS;


--
-- TOC entry 147 (OID 17724)
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
) WITHOUT OIDS;


--
-- TOC entry 148 (OID 17729)
-- Name: turq_banks_transaction_types; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_banks_transaction_types (
    bank_transaction_types_id integer NOT NULL,
    transaction_type_name character varying(50) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 149 (OID 17755)
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
) WITHOUT OIDS;


--
-- TOC entry 150 (OID 17774)
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
) WITHOUT OIDS;


--
-- TOC entry 151 (OID 17776)
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
) WITHOUT OIDS;


--
-- TOC entry 152 (OID 17802)
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
) WITHOUT OIDS;


--
-- TOC entry 153 (OID 17814)
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
) WITHOUT OIDS;


--
-- TOC entry 154 (OID 17829)
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
) WITHOUT OIDS;


--
-- TOC entry 155 (OID 17847)
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
) WITHOUT OIDS;


--
-- TOC entry 156 (OID 17859)
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
) WITHOUT OIDS;


--
-- TOC entry 157 (OID 17871)
-- Name: turq_bills; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_bills (
    bills_id integer NOT NULL,
    companies_id integer NOT NULL,
    bills_type integer NOT NULL,
    bills_date date NOT NULL,
    bills_definition character varying(250) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL,
    consignments_id integer NOT NULL,
    bills_printed boolean NOT NULL,
    is_open boolean NOT NULL,
    engine_sequences_id integer NOT NULL,
    bill_consignment_commons_id integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 158 (OID 17876)
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
) WITHOUT OIDS;


--
-- TOC entry 159 (OID 17894)
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
) WITHOUT OIDS;


--
-- TOC entry 160 (OID 17906)
-- Name: turq_consignments; Type: TABLE; Schema: public; Owner: turquaz
--

CREATE TABLE turq_consignments (
    consignments_id integer NOT NULL,
    companies_id integer NOT NULL,
    consignments_date date NOT NULL,
    consignments_definition character varying(250) NOT NULL,
    creation_date date NOT NULL,
    created_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    updated_by character varying(50) NOT NULL,
    consignments_type integer NOT NULL,
    consignments_printed boolean NOT NULL,
    bill_consignment_common_id integer NOT NULL,
    engine_sequences_id integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 161 (OID 17921)
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
) WITHOUT OIDS;


--
-- TOC entry 162 (OID 17929)
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
) WITHOUT OIDS;


--
-- TOC entry 163 (OID 17941)
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
) WITHOUT OIDS;


--
-- TOC entry 164 (OID 17960)
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
) WITHOUT OIDS;


--
-- TOC entry 165 (OID 17968)
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
) WITHOUT OIDS;


--
-- TOC entry 35 (OID 17994)
-- Name: seq_accounting_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_accounts
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 37 (OID 17996)
-- Name: seq_accounting_journal; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_journal
    START WITH 0
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 39 (OID 17998)
-- Name: seq_accounting_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transaction_types
    INCREMENT BY 1
    NO MAXVALUE
    MINVALUE 0
    CACHE 1;


--
-- TOC entry 41 (OID 18000)
-- Name: seq_accounting_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transactions
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 43 (OID 18072)
-- Name: seq_bank_cards_secondary_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bank_cards_secondary_accounts
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 45 (OID 18074)
-- Name: seq_banks_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_cards
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 47 (OID 18076)
-- Name: seq_bank_secondary_accounts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bank_secondary_accounts
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 49 (OID 18078)
-- Name: seq_banks_transaction_bills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transaction_bills
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 51 (OID 18080)
-- Name: seq_banks_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 53 (OID 18082)
-- Name: seq_banks_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_banks_transactions
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 55 (OID 18084)
-- Name: seq_bill_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bill_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 57 (OID 18086)
-- Name: seq_bill_in_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bill_in_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 59 (OID 18088)
-- Name: seq_bills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_bills
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 61 (OID 18090)
-- Name: seq_cheque_cheques; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_cheques
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 63 (OID 18092)
-- Name: seq_cheque_cheques_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_cheques_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 65 (OID 18094)
-- Name: seq_cheque_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 67 (OID 18096)
-- Name: seq_cheque_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_cheque_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 69 (OID 18098)
-- Name: seq_consignment_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignment_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 71 (OID 18100)
-- Name: seq_consignments; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignments
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 73 (OID 18102)
-- Name: seq_consignments_in_group; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_consignments_in_group
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 75 (OID 18104)
-- Name: seq_currencies; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_currencies
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 77 (OID 18106)
-- Name: seq_current_cards; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 79 (OID 18108)
-- Name: seq_current_cards_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 81 (OID 18110)
-- Name: seq_current_cards_phones; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_cards_phones
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 83 (OID 18112)
-- Name: seq_current_contacts; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_contacts
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 85 (OID 18114)
-- Name: seq_current_transaction_bill; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transaction_bill
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 87 (OID 18116)
-- Name: seq_current_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transaction_types
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 89 (OID 18118)
-- Name: seq_current_transactions; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_transactions
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 91 (OID 18120)
-- Name: seq_order_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_order_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 93 (OID 18122)
-- Name: seq_order_in_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_order_in_groups
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 95 (OID 18124)
-- Name: seq_orders; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_orders
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 97 (OID 18126)
-- Name: seq_tradebill_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 99 (OID 18128)
-- Name: seq_tradebill_tradebills; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_tradebills
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 101 (OID 18130)
-- Name: seq_tradebill_transaction_types; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_transaction_types
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 103 (OID 18132)
-- Name: seq_tradebill_tradebills_rolls; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_tradebill_tradebills_rolls
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 105 (OID 18134)
-- Name: seq_current_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_current_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 166 (OID 18144)
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
) WITHOUT OIDS;


--
-- TOC entry 107 (OID 18156)
-- Name: seq_inventory_card_groups; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_inventory_card_groups
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 109 (OID 18177)
-- Name: seq_accounting_transaction_columns; Type: SEQUENCE; Schema: public; Owner: turquaz
--

CREATE SEQUENCE seq_accounting_transaction_columns
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 167 (OID 18183)
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
) WITHOUT OIDS;


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 168 (OID 18218)
-- Name: view_inventory_levels; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW view_inventory_levels AS
    SELECT turq_inventory_transactions.inventory_cards_id, sum(turq_inventory_transactions.transactions_amount_in) AS amount FROM turq_inventory_transactions GROUP BY turq_inventory_transactions.inventory_cards_id;


--
-- TOC entry 169 (OID 21141)
-- Name: turq_engine_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE turq_engine_sequences (
    engine_sequences_id integer NOT NULL,
    modules_id integer NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 111 (OID 21143)
-- Name: seq_engine_sequences; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_engine_sequences
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


--
-- TOC entry 170 (OID 21163)
-- Name: turq_bill_consignment_commons; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE turq_bill_consignment_commons (
    bill_consignment_common_id integer NOT NULL,
    discount_rate integer NOT NULL,
    discount_amount numeric NOT NULL,
    vat_amount numeric NOT NULL,
    charges numeric NOT NULL,
    total_amount numeric NOT NULL,
    created_by character varying(50) NOT NULL,
    creation_date date NOT NULL,
    updated_by character varying(50) NOT NULL,
    last_modified date NOT NULL,
    special_vat_amount numeric NOT NULL,
    current_cards_id integer NOT NULL,
    bill_document_no character varying(50) NOT NULL,
    consignment_document_no character varying(50) NOT NULL
) WITHOUT OIDS;


--
-- TOC entry 113 (OID 21188)
-- Name: seq_bill_consignment_commons; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seq_bill_consignment_commons
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


SET SESSION AUTHORIZATION 'turquaz';

--
-- Data for TOC entry 231 (OID 17143)
-- Name: turq_companies; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_companies VALUES (0, 'Vatoz', 'onsel', '2004-09-27', 'onsel', '2004-09-27');


--
-- Data for TOC entry 232 (OID 17147)
-- Name: turq_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_groups VALUES (0, 'Admin', 'adminler', 'onsel', '2004-09-25', 'onsel', '2004-09-25');


--
-- Data for TOC entry 233 (OID 17149)
-- Name: turq_module_components; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_module_components VALUES (1, 0, 'com.turquaz.inventory.ui.InvUICardSearch', 'Stok arama', 'onsel', '2004-09-24', 'onsel', '2004-09-24');
INSERT INTO turq_module_components VALUES (2, 0, 'com.turquaz.inventory.ui.InvUITransactionAdd', 'Hareket Ekle', 'onsel', '2004-09-24', 'onsel', '2004-09-24');
INSERT INTO turq_module_components VALUES (3, 1, 'com.turquaz.accounting.ui.AccUIAddAccounts', 'Muhasebe Hesap Ekle', 'onsel', '2004-09-28', 'onsel', '2004-09-28');
INSERT INTO turq_module_components VALUES (4, 0, 'com.turquaz.inventory.ui.InvUIWarehouseAdd', 'Depo Ekle', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_module_components VALUES (5, 0, 'com.turquaz.inventory.ui.InvUIWarehouseSearch', 'depo Arama', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_module_components VALUES (6, 3, 'com.turquaz.bank.ui.BankUIBankCardAdd', 'Banka karti ekleme', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_module_components VALUES (8, 1, 'com.turquaz.accounting.ui.AccUITransactionAdd', 'Muhasebe fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (9, 1, 'com.turquaz.accounting.ui.AccUITransactionCollect', 'Tahsil Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (10, 1, 'com.turquaz.accounting.ui.AccUITransactionPayment', 'Tediye Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (11, 1, 'com.turquaz.accounting.ui.AccUITransactionSearch', 'Muhasebe Fisi Arama', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (13, 4, 'com.turquaz.current.ui.CurUICurrentCardSearch', 'Cari Kart Arama', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (14, 4, 'com.turquaz.current.ui.CurUITransactionAdd', 'Nakit Hareketi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (15, 4, 'com.turquaz.current.ui.CurUITransactionSearch', 'Cari Hareket Arama', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (18, 5, 'com.turquaz.admin.ui.AdmUIGroupAdd', 'Group Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (19, 5, 'com.turquaz.admin.ui.AdmUIGroups', 'Grouplar', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (-1, -1, '*', '*', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_module_components VALUES (21, 5, 'com.turquaz.admin.ui.AdmUIGroupPermissions', 'Group Izinleri', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (23, 6, 'com.turquaz.consignment.ui.ConUIConsignmentSearch', 'irsaliye arama', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (24, 0, 'com.turquaz.inventory.ui.InvUITransactionSearch', 'Stok Hareketi Arama', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (0, 0, 'com.turquaz.inventory.ui.InvUICardAdd', 'Stok giris karti', 'onsel', '2004-09-24', 'onsel', '2004-09-24');
INSERT INTO turq_module_components VALUES (7, 3, 'com.turquaz.bank.ui.BankUIBankCardSearch', 'Banka Karti Arama', 'cem', '2004-10-10', 'cem', '2004-10-10');
INSERT INTO turq_module_components VALUES (12, 4, 'com.turquaz.current.ui.CurUICurrentCardAdd', 'Cari Kart Ekleme', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (16, 5, 'com.turquaz.admin.ui.AdmUIUserAdd', 'Kullanici Ekleme', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (17, 5, 'com.turquaz.admin.ui.AdmUIUsers', 'Kullanicilar', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (20, 5, 'com.turquaz.admin.ui.AdmUIUserPermissions', 'Kullanici Haklari', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (22, 6, 'com.turquaz.consignment.ui.ConUIAddConsignment', 'Irsaliye Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (25, 7, 'com.turquaz.bill.ui.BillUIBillFromConsignment', 'Irsaliyeden Fatura', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_module_components VALUES (26, 1, 'com.turquaz.accounting.ui.AccUIAccountingPlan', 'Muhasebe Plani', 'admin', '2004-10-18', 'admin', '2004-10-18');
INSERT INTO turq_module_components VALUES (27, 7, 'com.turquaz.bill.ui.BillUIBillSearch', 'Fatura Arama', 'admin', '2004-10-18', 'admin', '2004-10-18');
INSERT INTO turq_module_components VALUES (28, 7, 'com.turquaz.bill.ui.BillUIAddBill', 'Yeni Fatura Girisi', 'admin', '2004-10-18', 'admin', '2004-10-18');


--
-- Data for TOC entry 234 (OID 17151)
-- Name: turq_modules; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_modules VALUES (1, 'Accounting', 'Muhasebe', 'onsel', '2004-09-28', 'onsel', '2004-09-28');
INSERT INTO turq_modules VALUES (3, 'Banks', 'bankalar', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_modules VALUES (4, 'Current', 'Cari Hesaplar', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_modules VALUES (5, 'Administrator', 'Y&#246;netici', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_modules VALUES (0, 'Inventory', 'Stok Filan i?te', 'onsel', '2004-09-24', 'onsel', '2004-09-24');
INSERT INTO turq_modules VALUES (-1, '*', 'butun moduller', 'onsel', '2004-09-25', 'onsel', '2004-09-25');
INSERT INTO turq_modules VALUES (6, 'Consignments', '�rsaliye', 'onsel', '2004-10-18', 'onsel', '2004-10-18');
INSERT INTO turq_modules VALUES (7, 'Bill', 'Fatura', 'onsel', '2004-10-18', 'onsel', '2004-10-18');


--
-- Data for TOC entry 235 (OID 17155)
-- Name: turq_user_permissions; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_user_permissions VALUES (-1, -1, -1, -1, 3, 'admin', '2004-10-10', 'admin', '2004-10-10');


--
-- Data for TOC entry 236 (OID 17157)
-- Name: turq_users; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_users VALUES (-1, 'admin', 'admin', 'admin', 'admin', 'onsel', '2004-10-10', 'admin', '2004-11-18');


--
-- Data for TOC entry 237 (OID 17209)
-- Name: turq_group_permissions; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_group_permissions VALUES (1, 0, -1, -1, 3, 'onsel', '2004-09-25', 'onsel', '2004-09-25');


--
-- Data for TOC entry 238 (OID 17225)
-- Name: turq_inventory_cards; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 239 (OID 17227)
-- Name: turq_inventory_units; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_inventory_units VALUES (8, 'adet', 0, 'admin', '2004-11-17', 'admin', '2004-11-17');


--
-- Data for TOC entry 240 (OID 17235)
-- Name: turq_inventory_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_inventory_groups VALUES (15, 'deneme', 0, 'admin', '2004-11-17', 'admin', '2004-11-17', '');


--
-- Data for TOC entry 241 (OID 17257)
-- Name: turq_inventory_prices; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 242 (OID 17272)
-- Name: turq_inventory_card_units; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 243 (OID 17284)
-- Name: turq_inventory_warehouses; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_inventory_warehouses VALUES (3, 'Merkez', 0, 'admin', '2004-10-29', 'admin', '2004-11-18', 'wfwefwe', 'qefqefqef', 'wefew', 'wefefw');


--
-- Data for TOC entry 244 (OID 17292)
-- Name: turq_inventory_transactions; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 245 (OID 17335)
-- Name: turq_user_group; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 246 (OID 17533)
-- Name: turq_currencies; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_currencies VALUES (2, 0, 'Yeni T&#252;rk Lirasi', 'YTL', 'Turkey', 'onsel', '2004-09-27', 'onsel', '2004-09-27', NULL);
INSERT INTO turq_currencies VALUES (1, 0, 'T&#252;rk Lirasi', 'TL', 'Turkey', 'onsel', '2004-09-27', 'onsel', '2004-09-27', 1);


--
-- Data for TOC entry 247 (OID 17545)
-- Name: turq_current_cards; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_current_cards VALUES (-1, 0, 'kjj', 'kjk', 'kjk', 'kjkj', 12, 1143, 131, 1313, 'kjkjj', 'kjkj', -1, '2004-10-18', 'onsel', '2004-11-17', 'admin');
INSERT INTO turq_current_cards VALUES (21, 0, 'a001', 'fanatik', '', '', 13, 134, 134134, 134134, '134134', '134134', 3, '2004-11-18', 'admin', '2004-11-18', 'admin');
INSERT INTO turq_current_cards VALUES (22, 0, 'deess', 'sdasd', '', '', 0, 0, 0, 0, '', '', 11, '2004-11-18', 'admin', '2004-11-18', 'admin');
INSERT INTO turq_current_cards VALUES (24, 0, 'sdf', 'sadfasdf', '', '', 0, 0, 0, 0, '', '', 11, '2004-11-18', 'admin', '2004-11-18', 'admin');


--
-- Data for TOC entry 248 (OID 17550)
-- Name: turq_accounting_accounts; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_accounting_accounts VALUES (2, 0, 'KASA', '100', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 2);
INSERT INTO turq_accounting_accounts VALUES (-1, 0, 'Hesap Plan&#305;', ' ', -1, '2004-09-27', 'onsel', '2004-09-27', 'onsel', -1);
INSERT INTO turq_accounting_accounts VALUES (3, 0, 'ALINAN ÇEKLER', '101', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 3);
INSERT INTO turq_accounting_accounts VALUES (5, 0, 'BANKALAR', '102', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 5);
INSERT INTO turq_accounting_accounts VALUES (6, 0, 'VERİLEN ÇEKLER VE ÖDEME EMİRLERİ(-)', '103', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 6);
INSERT INTO turq_accounting_accounts VALUES (7, 0, '', '104', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 7);
INSERT INTO turq_accounting_accounts VALUES (8, 0, '', '105', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 8);
INSERT INTO turq_accounting_accounts VALUES (9, 0, '', '106', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 9);
INSERT INTO turq_accounting_accounts VALUES (10, 0, '', '107', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 10);
INSERT INTO turq_accounting_accounts VALUES (11, 0, 'DİĞER HAZIR DEĞERLER', '108', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 11);
INSERT INTO turq_accounting_accounts VALUES (12, 0, '', '109', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 12);
INSERT INTO turq_accounting_accounts VALUES (13, 0, 'HİSSE SENETLERİ', '110', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 13);
INSERT INTO turq_accounting_accounts VALUES (14, 0, 'ÖZEL KESİM TAHVİL,SENET VE BONOLARI', '111', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 14);
INSERT INTO turq_accounting_accounts VALUES (15, 0, 'KAMU KESİMİ, TAHVİL, SENET VE BONOLARI', '112', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 15);
INSERT INTO turq_accounting_accounts VALUES (16, 0, '', '113', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 16);
INSERT INTO turq_accounting_accounts VALUES (17, 0, '', '114', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 17);
INSERT INTO turq_accounting_accounts VALUES (18, 0, '', '115', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 18);
INSERT INTO turq_accounting_accounts VALUES (19, 0, '', '116', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 19);
INSERT INTO turq_accounting_accounts VALUES (20, 0, '', '117', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 20);
INSERT INTO turq_accounting_accounts VALUES (21, 0, 'DİĞER MENKUL KIYMETLER', '118', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 21);
INSERT INTO turq_accounting_accounts VALUES (22, 0, 'MENKUL KIYMETLER DEĞER DÜŞÜKLÜĞÜ KARŞILIĞI', '119', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 22);
INSERT INTO turq_accounting_accounts VALUES (23, 0, 'ALICILAR', '120', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 23);
INSERT INTO turq_accounting_accounts VALUES (24, 0, 'ALACAK SENETLERİ', '121', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 24);
INSERT INTO turq_accounting_accounts VALUES (25, 0, 'ALACAK SENETLERİ REESKONTU(-)', '122', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 25);
INSERT INTO turq_accounting_accounts VALUES (26, 0, '', '123', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 26);
INSERT INTO turq_accounting_accounts VALUES (27, 0, '', '124', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 27);
INSERT INTO turq_accounting_accounts VALUES (28, 0, '', '125', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 28);
INSERT INTO turq_accounting_accounts VALUES (29, 0, 'VERİLEN DEPOZİTO VE TEMİNATLAR', '126', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 29);
INSERT INTO turq_accounting_accounts VALUES (30, 0, 'DİĞER TİCARİ ALACAKLAR', '127', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 30);
INSERT INTO turq_accounting_accounts VALUES (31, 0, 'ŞÜPHELİ TİCARİ ALACAKLAR', '128', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 31);
INSERT INTO turq_accounting_accounts VALUES (32, 0, 'ŞÜPHELİ TİCARİ ALACAKLAR KARŞILIĞI(-)', '129', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 32);
INSERT INTO turq_accounting_accounts VALUES (33, 0, '', '130', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 33);
INSERT INTO turq_accounting_accounts VALUES (34, 0, 'ORTAKLARDAN ALACAKLAR', '131', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 34);
INSERT INTO turq_accounting_accounts VALUES (35, 0, 'İŞTİRAKLERDEN ALACAKLAR', '132', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 35);
INSERT INTO turq_accounting_accounts VALUES (36, 0, 'BĞLI ORTAKLARDAN ALACAKLAR', '133', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 36);
INSERT INTO turq_accounting_accounts VALUES (37, 0, '', '134', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 37);
INSERT INTO turq_accounting_accounts VALUES (38, 0, 'PERSONELDEN ALACAKLAR', '135', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 38);
INSERT INTO turq_accounting_accounts VALUES (39, 0, 'DİĞER ÇEŞİTLİ ALACAKLAR', '136', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 39);
INSERT INTO turq_accounting_accounts VALUES (40, 0, 'DİĞER ALACAK SENETLERİ REESKONTO(-)', '137', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 40);
INSERT INTO turq_accounting_accounts VALUES (41, 0, 'ŞÜPHELİ DİĞER ALACAKLAR', '138', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 41);
INSERT INTO turq_accounting_accounts VALUES (42, 0, 'SÜPHELİ DİĞER ALACAKLAR KARŞILIĞI', '139', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 42);
INSERT INTO turq_accounting_accounts VALUES (43, 0, 'İLK MADDE VE MALZEME', '150', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 43);
INSERT INTO turq_accounting_accounts VALUES (44, 0, 'YARI MAMÜLLER-ÜRETİM', '151', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 44);
INSERT INTO turq_accounting_accounts VALUES (45, 0, 'MAMÜLLER', '152', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 45);
INSERT INTO turq_accounting_accounts VALUES (46, 0, 'TİCARİ MALLAR', '153', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 46);
INSERT INTO turq_accounting_accounts VALUES (47, 0, '', '154', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 47);
INSERT INTO turq_accounting_accounts VALUES (48, 0, '', '155', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 48);
INSERT INTO turq_accounting_accounts VALUES (49, 0, '', '156', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 49);
INSERT INTO turq_accounting_accounts VALUES (50, 0, 'DİĞER STOKLAR', '157', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 50);
INSERT INTO turq_accounting_accounts VALUES (51, 0, 'STOK DEĞER DÜŞÜKLÜĞÜ KARŞILIĞI', '158', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 51);
INSERT INTO turq_accounting_accounts VALUES (52, 0, 'VERİLEN SİPARİŞ AVANSLAR', '159', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 52);
INSERT INTO turq_accounting_accounts VALUES (53, 0, 'YILLARA YAYGIN İNŞAAT VE ONARIM MALİYETLERİ', '170-178', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 53);
INSERT INTO turq_accounting_accounts VALUES (54, 0, 'TAŞERONLARA VERİLEN AVANSLAR', '179', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 54);
INSERT INTO turq_accounting_accounts VALUES (55, 0, 'GELECEK AYLARA AİT GİDERLER', '180', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 55);
INSERT INTO turq_accounting_accounts VALUES (56, 0, 'GELİR TAHAKKUKLARI', '181', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 56);
INSERT INTO turq_accounting_accounts VALUES (57, 0, '', '182', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 57);
INSERT INTO turq_accounting_accounts VALUES (58, 0, '', '183', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 58);
INSERT INTO turq_accounting_accounts VALUES (59, 0, '', '184', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 59);
INSERT INTO turq_accounting_accounts VALUES (60, 0, '', '185', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 60);
INSERT INTO turq_accounting_accounts VALUES (61, 0, '', '186', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 61);
INSERT INTO turq_accounting_accounts VALUES (62, 0, '', '187', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 62);
INSERT INTO turq_accounting_accounts VALUES (63, 0, '', '188', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 63);
INSERT INTO turq_accounting_accounts VALUES (64, 0, '', '189', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 64);
INSERT INTO turq_accounting_accounts VALUES (65, 0, 'DEVREDEN KATMA DEĞER VERGİSİ', '190', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 65);
INSERT INTO turq_accounting_accounts VALUES (66, 0, 'İNDİRİLECEK KATMA DEĞER VERGİSİ', '191', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 66);
INSERT INTO turq_accounting_accounts VALUES (67, 0, 'DİĞER KATMA DEĞER VERGİSİ', '192', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 67);
INSERT INTO turq_accounting_accounts VALUES (68, 0, 'PEŞİN ÖDENEN VERGİLER VE FONLAR', '193', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 68);
INSERT INTO turq_accounting_accounts VALUES (69, 0, '', '194', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 69);
INSERT INTO turq_accounting_accounts VALUES (70, 0, 'İŞ AVANSLARI', '195', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 70);
INSERT INTO turq_accounting_accounts VALUES (71, 0, 'PERSONEL AVANSLARI', '196', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 71);
INSERT INTO turq_accounting_accounts VALUES (72, 0, 'SAYIM VE TESELLÜM NOKSANLARI', '197', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 72);
INSERT INTO turq_accounting_accounts VALUES (73, 0, 'DİĞER ÇEŞİTLİ DÖNEN VARLIKLAR', '198', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 73);
INSERT INTO turq_accounting_accounts VALUES (74, 0, 'DİĞER DÖNEN VARLIKLAR KARŞILIĞI(-)', '199', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 74);
INSERT INTO turq_accounting_accounts VALUES (75, 0, 'ALICILAR', '220', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 75);
INSERT INTO turq_accounting_accounts VALUES (76, 0, 'ALACAK SENETLERİ', '221', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 76);
INSERT INTO turq_accounting_accounts VALUES (77, 0, 'ALACAK SENETLERİ REESKONTU(-)', '222', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 77);
INSERT INTO turq_accounting_accounts VALUES (78, 0, '', '223', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 78);
INSERT INTO turq_accounting_accounts VALUES (79, 0, '', '224', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 79);
INSERT INTO turq_accounting_accounts VALUES (80, 0, '', '225', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 80);
INSERT INTO turq_accounting_accounts VALUES (81, 0, 'VERİLEN DEPOZİTO VE TEMİNATLAR', '226', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 81);
INSERT INTO turq_accounting_accounts VALUES (82, 0, '', '227', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 82);
INSERT INTO turq_accounting_accounts VALUES (83, 0, '', '228', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 83);
INSERT INTO turq_accounting_accounts VALUES (84, 0, 'ŞÜPHELİ ALACAKLAR KARŞILIĞI(-)', '229', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 84);
INSERT INTO turq_accounting_accounts VALUES (85, 0, '', '230', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 85);
INSERT INTO turq_accounting_accounts VALUES (86, 0, 'ORTAKLARDAN ALACAKLAR', '231', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 86);
INSERT INTO turq_accounting_accounts VALUES (87, 0, 'İŞTİRAKLERDEN ALACAKLAR', '232', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 87);
INSERT INTO turq_accounting_accounts VALUES (88, 0, 'BAĞLI ORTAKLIKLARDAN ALACAKLAR', '233', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 88);
INSERT INTO turq_accounting_accounts VALUES (89, 0, '', '234', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 89);
INSERT INTO turq_accounting_accounts VALUES (90, 0, 'PERSONELDEN ALACAKLAR', '235', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 90);
INSERT INTO turq_accounting_accounts VALUES (91, 0, 'DİĞER ÇEŞİTLİ ALACAKLAR', '236', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 91);
INSERT INTO turq_accounting_accounts VALUES (92, 0, 'DİĞER ALACAK SENETLERİ REESKONTU(-)', '237', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 92);
INSERT INTO turq_accounting_accounts VALUES (93, 0, '', '238', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 93);
INSERT INTO turq_accounting_accounts VALUES (94, 0, 'ŞÜPHELİ DİĞER ALACAKLAR KARŞILIĞI(-)', '239', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 94);
INSERT INTO turq_accounting_accounts VALUES (95, 0, 'BAĞLI MENKUL KIYMETLER', '240', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 95);
INSERT INTO turq_accounting_accounts VALUES (96, 0, 'BAĞLI MENKUL KIYMETLER DEĞER DÜŞÜKLÜĞÜ KARŞILIĞI(-)', '241', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 96);
INSERT INTO turq_accounting_accounts VALUES (97, 0, 'İŞTİRAKLER', '242', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 97);
INSERT INTO turq_accounting_accounts VALUES (98, 0, 'İŞTİRAKLERE SERMAYE TAAHHÜTLERİ(-)', '243', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 98);
INSERT INTO turq_accounting_accounts VALUES (99, 0, 'İŞTİRAKLER SERMAYE PAYLARI DEĞER DÜŞÜKLÜĞÜ KARŞILIKLARI(-)', '244', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 99);
INSERT INTO turq_accounting_accounts VALUES (100, 0, 'BAĞLI ORTAKLIKLAR', '245', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 100);
INSERT INTO turq_accounting_accounts VALUES (101, 0, 'BAĞLI ORTAKLIKLARA SERMAYE TAAHHÜTLERİ(-)', '246', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 101);
INSERT INTO turq_accounting_accounts VALUES (102, 0, 'BAĞLI ORTAKLIKLAR SERMAYE PAYLARI DEĞER DÜŞÜKLÜĞÜ KARŞILIĞI(-)', '247', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 102);
INSERT INTO turq_accounting_accounts VALUES (103, 0, 'DİĞER MALİ DURAN VARLIKLAR', '248', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 103);
INSERT INTO turq_accounting_accounts VALUES (104, 0, 'DİĞER MALİ DURAN VARLIKLAR KARŞILIĞI(-)', '249', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 104);
INSERT INTO turq_accounting_accounts VALUES (105, 0, 'ARAZİ VE ARSALAR', '250', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 105);
INSERT INTO turq_accounting_accounts VALUES (106, 0, 'YERALTI VE YERÜSTÜ DÜZENLERİ', '251', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 106);
INSERT INTO turq_accounting_accounts VALUES (107, 0, 'BİNALAR', '252', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 107);
INSERT INTO turq_accounting_accounts VALUES (108, 0, 'TESİS, MAKİNE VE CİHAZLAR', '253', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 108);
INSERT INTO turq_accounting_accounts VALUES (109, 0, 'TAŞITLAR', '254', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 109);
INSERT INTO turq_accounting_accounts VALUES (110, 0, 'DEMİRBAŞLAR', '255', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 110);
INSERT INTO turq_accounting_accounts VALUES (111, 0, 'DİĞER MADDİ DURAN VARLIKLAR', '256', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 111);
INSERT INTO turq_accounting_accounts VALUES (112, 0, 'BİRİKMİŞ AMORTİSMANLAR(-)', '257', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 112);
INSERT INTO turq_accounting_accounts VALUES (113, 0, 'YAPILMAKTA OLAN YATIRIMLAR', '258', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 113);
INSERT INTO turq_accounting_accounts VALUES (114, 0, 'VERİLEN AVANSLAR', '259', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 114);
INSERT INTO turq_accounting_accounts VALUES (115, 0, 'HAKLAR', '260', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 115);
INSERT INTO turq_accounting_accounts VALUES (116, 0, 'ŞEREFİYE', '261', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 116);
INSERT INTO turq_accounting_accounts VALUES (117, 0, 'KURULUŞ VE ÖRGÜTLENME GİDERLERİ', '262', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 117);
INSERT INTO turq_accounting_accounts VALUES (118, 0, 'ARAŞTIRMA VE GELİŞTİRME GİDERLERİ', '263', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 118);
INSERT INTO turq_accounting_accounts VALUES (119, 0, 'ÖZEL MALİYETLER', '264', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 119);
INSERT INTO turq_accounting_accounts VALUES (120, 0, '', '265', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 120);
INSERT INTO turq_accounting_accounts VALUES (121, 0, '', '266', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 121);
INSERT INTO turq_accounting_accounts VALUES (122, 0, 'DİĞER MADDİ OLMAYAN DURAN VARLIKLAR', '267', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 122);
INSERT INTO turq_accounting_accounts VALUES (123, 0, 'BİRİKMİŞ AMORTİSMANLAR(-)', '268', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 123);
INSERT INTO turq_accounting_accounts VALUES (124, 0, 'VERİLEN AVANSLAR', '269', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 124);
INSERT INTO turq_accounting_accounts VALUES (125, 0, '', '270', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 125);
INSERT INTO turq_accounting_accounts VALUES (126, 0, 'ARAMA GİDERLERİ', '271', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 126);
INSERT INTO turq_accounting_accounts VALUES (127, 0, 'HAZIRLIK VE GELİŞTİRME GİDERLERİ', '272', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 127);
INSERT INTO turq_accounting_accounts VALUES (128, 0, '', '273', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 128);
INSERT INTO turq_accounting_accounts VALUES (129, 0, '', '274', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 129);
INSERT INTO turq_accounting_accounts VALUES (130, 0, '', '275', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 130);
INSERT INTO turq_accounting_accounts VALUES (131, 0, '', '276', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 131);
INSERT INTO turq_accounting_accounts VALUES (132, 0, 'DİĞER ÖZEL TÜKENMEYE TABİ VARLIKLAR', '277', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 132);
INSERT INTO turq_accounting_accounts VALUES (133, 0, 'BİRİKMİŞ TÜKENME PAYLARI(-)', '278', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 133);
INSERT INTO turq_accounting_accounts VALUES (134, 0, 'VERİLEN AVANSLAR', '279', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 134);
INSERT INTO turq_accounting_accounts VALUES (135, 0, 'GELECEK YILLARA AİT GİDERLER', '280', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 135);
INSERT INTO turq_accounting_accounts VALUES (137, 0, '', '282', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 137);
INSERT INTO turq_accounting_accounts VALUES (138, 0, '', '283', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 138);
INSERT INTO turq_accounting_accounts VALUES (139, 0, '', '284', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 139);
INSERT INTO turq_accounting_accounts VALUES (140, 0, '', '285', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 140);
INSERT INTO turq_accounting_accounts VALUES (141, 0, '', '286', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 141);
INSERT INTO turq_accounting_accounts VALUES (142, 0, '', '287', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 142);
INSERT INTO turq_accounting_accounts VALUES (143, 0, '', '288', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 143);
INSERT INTO turq_accounting_accounts VALUES (144, 0, '', '289', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 144);
INSERT INTO turq_accounting_accounts VALUES (145, 0, '', '290', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 145);
INSERT INTO turq_accounting_accounts VALUES (146, 0, 'GELECEK YILLARDA İNDİRİLECEK KATMA DEĞER VERGİSİ', '291', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 146);
INSERT INTO turq_accounting_accounts VALUES (147, 0, 'DİĞER KATMA DEĞER VERGİSİ', '292', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 147);
INSERT INTO turq_accounting_accounts VALUES (148, 0, 'GELECEK YILLAR İHTİYACI STOKLAR', '293', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 148);
INSERT INTO turq_accounting_accounts VALUES (149, 0, 'ELDEN ÇIKARILACAK STOKLAR VE MADDİ DURAN VARLIKLAR', '294', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 149);
INSERT INTO turq_accounting_accounts VALUES (150, 0, 'PEŞİN ÖDENEN VERGİLER VE FONLAR', '295', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 150);
INSERT INTO turq_accounting_accounts VALUES (151, 0, '', '296', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 151);
INSERT INTO turq_accounting_accounts VALUES (152, 0, 'DİĞER ÇEŞİTLİ DURAN VARLIKLAR', '297', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 152);
INSERT INTO turq_accounting_accounts VALUES (153, 0, 'STOK DEĞER DÜŞÜKLÜĞÜ KARŞILIĞI(-)', '298', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 153);
INSERT INTO turq_accounting_accounts VALUES (154, 0, 'BİRİKMİŞ AMORTİSMANLAR(-)', '299', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 154);
INSERT INTO turq_accounting_accounts VALUES (155, 0, 'BANKA KREDİLERİ', '300', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 155);
INSERT INTO turq_accounting_accounts VALUES (156, 0, '', '301', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 156);
INSERT INTO turq_accounting_accounts VALUES (157, 0, '', '302', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 157);
INSERT INTO turq_accounting_accounts VALUES (158, 0, 'UZUN VADELİ KREDİLERİN ANAPARA TAKSİTLERİ VE FAİZLERİ', '303', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 158);
INSERT INTO turq_accounting_accounts VALUES (159, 0, 'TAHVİL ANAPARA BORÇ TAKSİT VE FAİZLERİ', '304', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 159);
INSERT INTO turq_accounting_accounts VALUES (160, 0, 'ÇIKARILMIŞ BONOLAR VE SENETLER', '305', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 160);
INSERT INTO turq_accounting_accounts VALUES (161, 0, 'ÇIKARILMIŞ DİĞER MENKUL KIYMETLER', '306', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 161);
INSERT INTO turq_accounting_accounts VALUES (162, 0, '', '307', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 162);
INSERT INTO turq_accounting_accounts VALUES (163, 0, 'MENKUL KIYMETLER İHRAÇ FARKI(-)', '308', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 163);
INSERT INTO turq_accounting_accounts VALUES (164, 0, 'DİĞER MALİ BORÇLAR', '309', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 164);
INSERT INTO turq_accounting_accounts VALUES (165, 0, 'SATICILAR', '320', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 165);
INSERT INTO turq_accounting_accounts VALUES (166, 0, 'BORÇ SENETLERİ', '321', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 166);
INSERT INTO turq_accounting_accounts VALUES (167, 0, 'BORÇ SENETLERİ REESKONTU(-)', '322', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 167);
INSERT INTO turq_accounting_accounts VALUES (168, 0, '', '323', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 168);
INSERT INTO turq_accounting_accounts VALUES (169, 0, '', '324', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 169);
INSERT INTO turq_accounting_accounts VALUES (170, 0, '', '325', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 170);
INSERT INTO turq_accounting_accounts VALUES (171, 0, 'ALINAN DEPOZİTO VE TEMİNATLAR', '326', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 171);
INSERT INTO turq_accounting_accounts VALUES (172, 0, '', '327', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 172);
INSERT INTO turq_accounting_accounts VALUES (173, 0, '', '328', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 173);
INSERT INTO turq_accounting_accounts VALUES (174, 0, 'DİĞER TİCARİ BORÇLAR', '329', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 174);
INSERT INTO turq_accounting_accounts VALUES (175, 0, '', '330', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 175);
INSERT INTO turq_accounting_accounts VALUES (176, 0, 'ORTAKLARA BORÇLAR', '331', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 176);
INSERT INTO turq_accounting_accounts VALUES (177, 0, 'İŞTİRAKLERE BORÇLAR', '332', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 177);
INSERT INTO turq_accounting_accounts VALUES (178, 0, 'BAĞLI ORTAKLIKLARA BORÇLAR', '333', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 178);
INSERT INTO turq_accounting_accounts VALUES (179, 0, '', '334', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 179);
INSERT INTO turq_accounting_accounts VALUES (180, 0, 'PERSONELE BORÇLAR', '335', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 180);
INSERT INTO turq_accounting_accounts VALUES (181, 0, 'DİĞER ÇEŞİTLİ BORÇLAR', '336', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 181);
INSERT INTO turq_accounting_accounts VALUES (182, 0, 'DİĞER BORÇ SENETLERİ REESKONTU(-)', '337', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 182);
INSERT INTO turq_accounting_accounts VALUES (183, 0, '', '338', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 183);
INSERT INTO turq_accounting_accounts VALUES (184, 0, '', '339', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 184);
INSERT INTO turq_accounting_accounts VALUES (185, 0, 'ALINAN SİPARİŞ AVANSLARI', '340', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 185);
INSERT INTO turq_accounting_accounts VALUES (186, 0, '', '341', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 186);
INSERT INTO turq_accounting_accounts VALUES (187, 0, '', '342', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 187);
INSERT INTO turq_accounting_accounts VALUES (188, 0, '', '343', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 188);
INSERT INTO turq_accounting_accounts VALUES (189, 0, '', '344', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 189);
INSERT INTO turq_accounting_accounts VALUES (190, 0, '', '345', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 190);
INSERT INTO turq_accounting_accounts VALUES (191, 0, '', '346', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 191);
INSERT INTO turq_accounting_accounts VALUES (192, 0, '', '347', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 192);
INSERT INTO turq_accounting_accounts VALUES (193, 0, '', '348', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 193);
INSERT INTO turq_accounting_accounts VALUES (194, 0, 'ALINAN DİĞER AVANSLAR', '349', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 194);
INSERT INTO turq_accounting_accounts VALUES (195, 0, 'YILLARA YAYGIN İNŞAAT VE ONARIM HAKEDİŞ BEDELLERİ', '350-358', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 195);
INSERT INTO turq_accounting_accounts VALUES (196, 0, 'ÖDENECEK VERGİ VE FONLAR', '360', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 196);
INSERT INTO turq_accounting_accounts VALUES (197, 0, 'ÖDENECEK SOSYAL GÜVENLİK KESİNTİLERİ', '361', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 197);
INSERT INTO turq_accounting_accounts VALUES (198, 0, '', '362', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 198);
INSERT INTO turq_accounting_accounts VALUES (199, 0, '', '363', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 199);
INSERT INTO turq_accounting_accounts VALUES (200, 0, '', '364', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 200);
INSERT INTO turq_accounting_accounts VALUES (201, 0, '', '365', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 201);
INSERT INTO turq_accounting_accounts VALUES (202, 0, '', '366', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 202);
INSERT INTO turq_accounting_accounts VALUES (203, 0, '', '367', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 203);
INSERT INTO turq_accounting_accounts VALUES (204, 0, 'VADESİ GEÇMİŞ, ERTELENMİŞ VEYA TAKSİTLENDİRİLMİŞ VERGİ VE DİĞER YÜKÜMLÜLÜKLER', '368', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 204);
INSERT INTO turq_accounting_accounts VALUES (205, 0, 'ÖDENECEK DİĞER YÜKÜMLÜLÜKLER', '369', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 205);
INSERT INTO turq_accounting_accounts VALUES (206, 0, 'DÖNEM KÂRI VERGİ VE DİĞER YASAL YÜKÜMLÜLÜK KARŞILIKLARI', '370', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 206);
INSERT INTO turq_accounting_accounts VALUES (207, 0, 'DÖNEM KÂRININ PEŞİN ÖDENEN VERGİ VE DİĞER YÜKÜMLÜLÜKLERİ(-)', '371', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 207);
INSERT INTO turq_accounting_accounts VALUES (208, 0, 'KIDEM TAZMİNATI KARŞILIĞI', '372', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 208);
INSERT INTO turq_accounting_accounts VALUES (209, 0, 'MALİYET GİDERLERİ KARŞILIĞI', '373', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 209);
INSERT INTO turq_accounting_accounts VALUES (210, 0, '', '374', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 210);
INSERT INTO turq_accounting_accounts VALUES (211, 0, '', '375', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 211);
INSERT INTO turq_accounting_accounts VALUES (212, 0, '', '376', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 212);
INSERT INTO turq_accounting_accounts VALUES (213, 0, '', '377', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 213);
INSERT INTO turq_accounting_accounts VALUES (214, 0, '', '378', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 214);
INSERT INTO turq_accounting_accounts VALUES (215, 0, 'DİĞER BORÇ VE GİDER KARŞILIKLARI', '379', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 215);
INSERT INTO turq_accounting_accounts VALUES (216, 0, 'GELECEK AYLARA AİT GELİRLER', '380', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 216);
INSERT INTO turq_accounting_accounts VALUES (217, 0, 'GİDER TAHAKKUKLARI', '381', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 217);
INSERT INTO turq_accounting_accounts VALUES (218, 0, '', '382', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 218);
INSERT INTO turq_accounting_accounts VALUES (219, 0, '', '383', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 219);
INSERT INTO turq_accounting_accounts VALUES (220, 0, '', '384', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 220);
INSERT INTO turq_accounting_accounts VALUES (221, 0, '', '385', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 221);
INSERT INTO turq_accounting_accounts VALUES (222, 0, '', '386', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 222);
INSERT INTO turq_accounting_accounts VALUES (223, 0, '', '387', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 223);
INSERT INTO turq_accounting_accounts VALUES (224, 0, '', '388', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 224);
INSERT INTO turq_accounting_accounts VALUES (225, 0, '', '389', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 225);
INSERT INTO turq_accounting_accounts VALUES (226, 0, '', '390', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 226);
INSERT INTO turq_accounting_accounts VALUES (227, 0, 'HESAPLANAN KDV', '391', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 227);
INSERT INTO turq_accounting_accounts VALUES (228, 0, 'DİĞER KDV', '392', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 228);
INSERT INTO turq_accounting_accounts VALUES (229, 0, 'MERKEZ VE ŞUBELER CARİ HESABI', '393', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 229);
INSERT INTO turq_accounting_accounts VALUES (230, 0, '', '394', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 230);
INSERT INTO turq_accounting_accounts VALUES (231, 0, '', '395', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 231);
INSERT INTO turq_accounting_accounts VALUES (232, 0, '', '396', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 232);
INSERT INTO turq_accounting_accounts VALUES (233, 0, 'SAYIM VE TESELLÜM FAZLALARI', '397', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 233);
INSERT INTO turq_accounting_accounts VALUES (234, 0, '', '398', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 234);
INSERT INTO turq_accounting_accounts VALUES (235, 0, 'DİĞER ÇEŞİTLİ YABANCI KAYNAKLAR', '399', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 235);
INSERT INTO turq_accounting_accounts VALUES (236, 0, 'BANKA KREDİLERİ', '400', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 236);
INSERT INTO turq_accounting_accounts VALUES (237, 0, '', '401', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 237);
INSERT INTO turq_accounting_accounts VALUES (238, 0, '', '402', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 238);
INSERT INTO turq_accounting_accounts VALUES (239, 0, '', '403', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 239);
INSERT INTO turq_accounting_accounts VALUES (240, 0, '', '404', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 240);
INSERT INTO turq_accounting_accounts VALUES (241, 0, 'ÇIKARILMIŞ TAHVİLLER', '405', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 241);
INSERT INTO turq_accounting_accounts VALUES (242, 0, '', '406', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 242);
INSERT INTO turq_accounting_accounts VALUES (243, 0, 'ÇIKARILMIŞ DİĞER MENKUL KIYMETLER', '407', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 243);
INSERT INTO turq_accounting_accounts VALUES (244, 0, 'MENKUL KIYMETLER İHRAÇ FARKI(-)', '408', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 244);
INSERT INTO turq_accounting_accounts VALUES (245, 0, 'DİĞER MALİ BORÇLAR', '409', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 245);
INSERT INTO turq_accounting_accounts VALUES (246, 0, 'SATICILAR', '420', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 246);
INSERT INTO turq_accounting_accounts VALUES (247, 0, 'BORÇ SENETLERİ', '421', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 247);
INSERT INTO turq_accounting_accounts VALUES (248, 0, 'BORÇ SENETLERİ REESKONTU(-)', '422', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 248);
INSERT INTO turq_accounting_accounts VALUES (249, 0, '', '423', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 249);
INSERT INTO turq_accounting_accounts VALUES (250, 0, '', '424', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 250);
INSERT INTO turq_accounting_accounts VALUES (251, 0, '', '425', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 251);
INSERT INTO turq_accounting_accounts VALUES (252, 0, 'ALINAN DEPOZİTO VE TEMİNATLAR', '426', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 252);
INSERT INTO turq_accounting_accounts VALUES (253, 0, '', '427', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 253);
INSERT INTO turq_accounting_accounts VALUES (254, 0, '', '428', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 254);
INSERT INTO turq_accounting_accounts VALUES (255, 0, 'DİĞER TİCARİ BORÇLAR', '429', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 255);
INSERT INTO turq_accounting_accounts VALUES (256, 0, '', '430', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 256);
INSERT INTO turq_accounting_accounts VALUES (257, 0, 'ORTAKLARA BORÇLAR', '431', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 257);
INSERT INTO turq_accounting_accounts VALUES (258, 0, 'İŞTİRAKLERE BORÇLAR', '432', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 258);
INSERT INTO turq_accounting_accounts VALUES (259, 0, 'BAĞLI ORTAKLIKLARA BORÇLAR', '433', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 259);
INSERT INTO turq_accounting_accounts VALUES (260, 0, '', '434', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 260);
INSERT INTO turq_accounting_accounts VALUES (261, 0, '', '435', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 261);
INSERT INTO turq_accounting_accounts VALUES (262, 0, 'DİĞER ÇEŞİTLİ BORÇLAR', '436', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 262);
INSERT INTO turq_accounting_accounts VALUES (263, 0, 'DİĞER BORÇ SENETLERİ REESKONTU', '437', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 263);
INSERT INTO turq_accounting_accounts VALUES (264, 0, 'KAMUYA OLAN ERTELENMİŞ VE TAKSİTLENDİRİLMİŞ BORÇLAR', '438', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 264);
INSERT INTO turq_accounting_accounts VALUES (265, 0, '', '439', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 265);
INSERT INTO turq_accounting_accounts VALUES (266, 0, 'ALINAN SİPARİŞ AVANSLARI', '440', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 266);
INSERT INTO turq_accounting_accounts VALUES (267, 0, '', '441', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 267);
INSERT INTO turq_accounting_accounts VALUES (268, 0, '', '442', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 268);
INSERT INTO turq_accounting_accounts VALUES (269, 0, '', '443', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 269);
INSERT INTO turq_accounting_accounts VALUES (270, 0, '', '444', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 270);
INSERT INTO turq_accounting_accounts VALUES (271, 0, '', '445', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 271);
INSERT INTO turq_accounting_accounts VALUES (272, 0, '', '446', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 272);
INSERT INTO turq_accounting_accounts VALUES (273, 0, '', '447', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 273);
INSERT INTO turq_accounting_accounts VALUES (274, 0, '', '448', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 274);
INSERT INTO turq_accounting_accounts VALUES (275, 0, 'ALINAN DİĞER AVANSLAR', '449', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 275);
INSERT INTO turq_accounting_accounts VALUES (276, 0, '', '470', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 276);
INSERT INTO turq_accounting_accounts VALUES (277, 0, '', '471', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 277);
INSERT INTO turq_accounting_accounts VALUES (278, 0, 'KIDEM TAZMİNATI KARŞILIĞI', '472', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 278);
INSERT INTO turq_accounting_accounts VALUES (279, 0, '', '473', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 279);
INSERT INTO turq_accounting_accounts VALUES (280, 0, '', '474', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 280);
INSERT INTO turq_accounting_accounts VALUES (281, 0, '', '475', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 281);
INSERT INTO turq_accounting_accounts VALUES (282, 0, '', '476', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 282);
INSERT INTO turq_accounting_accounts VALUES (283, 0, '', '477', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 283);
INSERT INTO turq_accounting_accounts VALUES (284, 0, '', '478', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 284);
INSERT INTO turq_accounting_accounts VALUES (285, 0, 'DİĞER BORÇ VE GİDER KARŞILIKLARI', '479', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 285);
INSERT INTO turq_accounting_accounts VALUES (286, 0, 'GELECEK YILLARA AİT GELİRLER', '480', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 286);
INSERT INTO turq_accounting_accounts VALUES (287, 0, 'GİDER TAHAKKUKLARI', '481', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 287);
INSERT INTO turq_accounting_accounts VALUES (288, 0, '', '482', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 288);
INSERT INTO turq_accounting_accounts VALUES (289, 0, '', '483', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 289);
INSERT INTO turq_accounting_accounts VALUES (290, 0, '', '484', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 290);
INSERT INTO turq_accounting_accounts VALUES (291, 0, '', '485', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 291);
INSERT INTO turq_accounting_accounts VALUES (292, 0, '', '486', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 292);
INSERT INTO turq_accounting_accounts VALUES (293, 0, '', '487', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 293);
INSERT INTO turq_accounting_accounts VALUES (294, 0, '', '488', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 294);
INSERT INTO turq_accounting_accounts VALUES (295, 0, '', '489', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 295);
INSERT INTO turq_accounting_accounts VALUES (296, 0, '', '490', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 296);
INSERT INTO turq_accounting_accounts VALUES (297, 0, '', '491', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 297);
INSERT INTO turq_accounting_accounts VALUES (298, 0, 'GELECEK YILLARA ERTELENEN VEYA TERKİN EDİLEN KATMA DEĞER VERGİSİ', '492', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 298);
INSERT INTO turq_accounting_accounts VALUES (299, 0, 'TESİSE KATILMA PAYLARI', '493', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 299);
INSERT INTO turq_accounting_accounts VALUES (300, 0, '', '494', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 300);
INSERT INTO turq_accounting_accounts VALUES (301, 0, '', '495', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 301);
INSERT INTO turq_accounting_accounts VALUES (302, 0, '', '496', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 302);
INSERT INTO turq_accounting_accounts VALUES (303, 0, '', '497', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 303);
INSERT INTO turq_accounting_accounts VALUES (304, 0, '', '498', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 304);
INSERT INTO turq_accounting_accounts VALUES (305, 0, 'DİĞER ÇEŞİTLİ UZUN VADELİ YABANCI KAYNAKLAR', '499', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 305);
INSERT INTO turq_accounting_accounts VALUES (306, 0, 'SERMAYE', '500', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 306);
INSERT INTO turq_accounting_accounts VALUES (307, 0, 'ÖDENMEMİŞ SERMAYE(-)', '501', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 307);
INSERT INTO turq_accounting_accounts VALUES (308, 0, 'HİSSE SENETLERİ İHRAÇ PRİMLERİ', '520', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 308);
INSERT INTO turq_accounting_accounts VALUES (309, 0, 'HİSSE SENETLERİ İPTAL KÂRLARI', '521', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 309);
INSERT INTO turq_accounting_accounts VALUES (310, 0, 'M.D.V. YENİDEN DEĞERLENME ARTIŞLARI', '522', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 310);
INSERT INTO turq_accounting_accounts VALUES (311, 0, 'İŞTİRAKLER YENİDEN DEĞERLENME ARTIŞLARI', '523', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 311);
INSERT INTO turq_accounting_accounts VALUES (312, 0, '', '524', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 312);
INSERT INTO turq_accounting_accounts VALUES (313, 0, '', '525', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 313);
INSERT INTO turq_accounting_accounts VALUES (314, 0, '', '526', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 314);
INSERT INTO turq_accounting_accounts VALUES (315, 0, '', '527', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 315);
INSERT INTO turq_accounting_accounts VALUES (316, 0, '', '528', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 316);
INSERT INTO turq_accounting_accounts VALUES (317, 0, 'DİĞER SERMAYE YEDEKLERİ', '529', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 317);
INSERT INTO turq_accounting_accounts VALUES (318, 0, 'YASAL YEDEKLER', '540', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 318);
INSERT INTO turq_accounting_accounts VALUES (319, 0, 'STATÜ YEDEKLERİ', '541', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 319);
INSERT INTO turq_accounting_accounts VALUES (320, 0, 'OLAĞANÜSTÜ YEDEKLER', '542', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 320);
INSERT INTO turq_accounting_accounts VALUES (321, 0, '', '543', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 321);
INSERT INTO turq_accounting_accounts VALUES (322, 0, '', '544', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 322);
INSERT INTO turq_accounting_accounts VALUES (323, 0, '', '545', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 323);
INSERT INTO turq_accounting_accounts VALUES (324, 0, '', '546', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 324);
INSERT INTO turq_accounting_accounts VALUES (325, 0, '', '547', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 325);
INSERT INTO turq_accounting_accounts VALUES (326, 0, 'DİĞER KÂR YEDEKLERİ', '548', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 326);
INSERT INTO turq_accounting_accounts VALUES (327, 0, 'ÖZEL FONLAR', '549', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 327);
INSERT INTO turq_accounting_accounts VALUES (328, 0, 'GEÇMİŞ YILLAR KÂRLARI', '570', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 328);
INSERT INTO turq_accounting_accounts VALUES (329, 0, 'GEÇMİŞ YILLAR ZARARLARI(-)', '580', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 329);
INSERT INTO turq_accounting_accounts VALUES (330, 0, 'DÖNEM NET KÂRI', '590', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 330);
INSERT INTO turq_accounting_accounts VALUES (331, 0, 'DÖNEM NET ZARARI(-)', '591', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 331);
INSERT INTO turq_accounting_accounts VALUES (332, 0, 'YURTİÇİ SATIŞLAR', '600', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 332);
INSERT INTO turq_accounting_accounts VALUES (333, 0, 'YURTDIŞI SATIŞLAR', '601', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 333);
INSERT INTO turq_accounting_accounts VALUES (334, 0, 'DİĞER GELİRLER', '602', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 334);
INSERT INTO turq_accounting_accounts VALUES (335, 0, 'SATIŞTAN İADELER(-)', '610', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 335);
INSERT INTO turq_accounting_accounts VALUES (336, 0, 'SATIŞ İSKONTOLARI(-)', '611', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 336);
INSERT INTO turq_accounting_accounts VALUES (337, 0, 'DİĞER İNDİRİMLER(-)', '612', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 337);
INSERT INTO turq_accounting_accounts VALUES (338, 0, '', '613', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 338);
INSERT INTO turq_accounting_accounts VALUES (339, 0, '', '614', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 339);
INSERT INTO turq_accounting_accounts VALUES (340, 0, '', '615', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 340);
INSERT INTO turq_accounting_accounts VALUES (341, 0, '', '616', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 341);
INSERT INTO turq_accounting_accounts VALUES (342, 0, '', '617', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 342);
INSERT INTO turq_accounting_accounts VALUES (343, 0, '', '618', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 343);
INSERT INTO turq_accounting_accounts VALUES (344, 0, '', '619', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 344);
INSERT INTO turq_accounting_accounts VALUES (345, 0, 'SATILAN MAMÜLLER MALİYETİ(-)', '620', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 345);
INSERT INTO turq_accounting_accounts VALUES (346, 0, 'SATILA TİCARİ MALLAR MALİYETİ(-)', '621', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 346);
INSERT INTO turq_accounting_accounts VALUES (347, 0, 'SATILAN HİZMET MALİYETİ(-)', '622', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 347);
INSERT INTO turq_accounting_accounts VALUES (348, 0, 'DİĞER SATIŞLARIN MALİYETİ(-)', '623', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 348);
INSERT INTO turq_accounting_accounts VALUES (349, 0, '', '624', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 349);
INSERT INTO turq_accounting_accounts VALUES (350, 0, '', '625', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 350);
INSERT INTO turq_accounting_accounts VALUES (351, 0, '', '626', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 351);
INSERT INTO turq_accounting_accounts VALUES (352, 0, '', '627', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 352);
INSERT INTO turq_accounting_accounts VALUES (353, 0, '', '628', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 353);
INSERT INTO turq_accounting_accounts VALUES (354, 0, '', '629', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 354);
INSERT INTO turq_accounting_accounts VALUES (355, 0, 'ARAŞTIRMA VE GELİŞTİRME GİDERLERİ(-)', '630', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 355);
INSERT INTO turq_accounting_accounts VALUES (356, 0, 'PAZARLAMA, SATIŞ VE DAĞITIMI GİDERLERİ(-)', '631', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 356);
INSERT INTO turq_accounting_accounts VALUES (357, 0, 'GENEL YÖNETİM GİDERLERİ(-)', '632', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 357);
INSERT INTO turq_accounting_accounts VALUES (358, 0, '', '633', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 358);
INSERT INTO turq_accounting_accounts VALUES (359, 0, '', '634', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 359);
INSERT INTO turq_accounting_accounts VALUES (360, 0, '', '635', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 360);
INSERT INTO turq_accounting_accounts VALUES (361, 0, '', '636', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 361);
INSERT INTO turq_accounting_accounts VALUES (362, 0, '', '637', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 362);
INSERT INTO turq_accounting_accounts VALUES (363, 0, '', '638', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 363);
INSERT INTO turq_accounting_accounts VALUES (364, 0, '', '639', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 364);
INSERT INTO turq_accounting_accounts VALUES (365, 0, 'İŞTİRAKLERDEN TEMETTÜ GELİRLERİ', '640', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 365);
INSERT INTO turq_accounting_accounts VALUES (366, 0, 'BAĞLI ORTAKLIKLARDAN TEMETTÜ GELİRLERİ', '641', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 366);
INSERT INTO turq_accounting_accounts VALUES (367, 0, 'FAİZ GELİRLERİ', '642', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 367);
INSERT INTO turq_accounting_accounts VALUES (368, 0, 'KOMİSYON GELİRLERİ', '643', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 368);
INSERT INTO turq_accounting_accounts VALUES (369, 0, 'KONUSU KALMAYAN KARŞILIKLAR', '644', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 369);
INSERT INTO turq_accounting_accounts VALUES (370, 0, 'MENKUL KIYMET SATIŞ KÂRLARI', '645', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 370);
INSERT INTO turq_accounting_accounts VALUES (371, 0, 'KAMBİYO KÂRLARI', '646', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 371);
INSERT INTO turq_accounting_accounts VALUES (372, 0, 'REESKONT FAİZ GELİRLERİ', '647', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 372);
INSERT INTO turq_accounting_accounts VALUES (373, 0, '', '648', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 373);
INSERT INTO turq_accounting_accounts VALUES (374, 0, 'DİĞER OLAĞAN GELİR VE KÂRLAR', '649', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 374);
INSERT INTO turq_accounting_accounts VALUES (375, 0, '', '650', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 375);
INSERT INTO turq_accounting_accounts VALUES (376, 0, '', '651', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 376);
INSERT INTO turq_accounting_accounts VALUES (377, 0, '', '652', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 377);
INSERT INTO turq_accounting_accounts VALUES (378, 0, 'KOMİSYON GİDERLERİ(-)', '653', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 378);
INSERT INTO turq_accounting_accounts VALUES (379, 0, 'KARŞILIK GİDERLERİ(-)', '654', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 379);
INSERT INTO turq_accounting_accounts VALUES (380, 0, 'MENKUL KIYMET SATIŞ ZARARLARI(-)', '655', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 380);
INSERT INTO turq_accounting_accounts VALUES (381, 0, 'KAMBİYO ZARARLARI(-)', '656', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 381);
INSERT INTO turq_accounting_accounts VALUES (382, 0, 'REESKONT FAİZ GİDERLERİ(-)', '657', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 382);
INSERT INTO turq_accounting_accounts VALUES (383, 0, '', '658', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 383);
INSERT INTO turq_accounting_accounts VALUES (384, 0, 'DİĞER GİDER VE ZARARLAR(-)', '659', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 384);
INSERT INTO turq_accounting_accounts VALUES (385, 0, 'KISA VADELİ BORÇLANMA GİDERLERİ(-)', '660', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 385);
INSERT INTO turq_accounting_accounts VALUES (386, 0, 'UZUN VADELİ BORÇLANMA GİDERLERİ(-)', '661', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 386);
INSERT INTO turq_accounting_accounts VALUES (387, 0, '', '670', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 387);
INSERT INTO turq_accounting_accounts VALUES (388, 0, 'ÖNCEKİ DÖNEM GELİR VE KÂRLARI', '671', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 388);
INSERT INTO turq_accounting_accounts VALUES (389, 0, '', '672', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 389);
INSERT INTO turq_accounting_accounts VALUES (390, 0, '', '673', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 390);
INSERT INTO turq_accounting_accounts VALUES (391, 0, '', '674', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 391);
INSERT INTO turq_accounting_accounts VALUES (392, 0, '', '675', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 392);
INSERT INTO turq_accounting_accounts VALUES (393, 0, '', '676', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 393);
INSERT INTO turq_accounting_accounts VALUES (394, 0, '', '677', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 394);
INSERT INTO turq_accounting_accounts VALUES (395, 0, '', '678', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 395);
INSERT INTO turq_accounting_accounts VALUES (396, 0, 'DİĞER OLAĞAN DIŞI GELİR VE KÂRLAR', '679', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 396);
INSERT INTO turq_accounting_accounts VALUES (397, 0, 'ÇALIŞMAYAN KISIM GİDER VE ZARARLARI(-)', '680', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 397);
INSERT INTO turq_accounting_accounts VALUES (398, 0, 'ÖNCEKİ DÖNEM GİDER VE ZARARLARI(-)', '681', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 398);
INSERT INTO turq_accounting_accounts VALUES (399, 0, '', '682', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 399);
INSERT INTO turq_accounting_accounts VALUES (400, 0, '', '683', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 400);
INSERT INTO turq_accounting_accounts VALUES (401, 0, '', '684', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 401);
INSERT INTO turq_accounting_accounts VALUES (402, 0, '', '685', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 402);
INSERT INTO turq_accounting_accounts VALUES (403, 0, '', '686', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 403);
INSERT INTO turq_accounting_accounts VALUES (404, 0, '', '687', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 404);
INSERT INTO turq_accounting_accounts VALUES (405, 0, '', '688', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 405);
INSERT INTO turq_accounting_accounts VALUES (406, 0, 'DİĞER OLAĞAN DIŞI GİDER VE ZARARLARI(-)', '689', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 406);
INSERT INTO turq_accounting_accounts VALUES (407, 0, 'DÖNEM KÂRI VE ZARARI', '690', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 407);
INSERT INTO turq_accounting_accounts VALUES (408, 0, 'DÖNEM KÂRI VERGİ VE DİĞER YASAL YÜKÜMLÜLÜK KARŞILIKLARI(-)', '691', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 408);
INSERT INTO turq_accounting_accounts VALUES (409, 0, 'DÖNEM NET KÂRI VEYA ZARARI', '692', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 409);
INSERT INTO turq_accounting_accounts VALUES (410, 0, 'MALİYET MUHASEBESİ BAĞLANTI HESABI', '700', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 410);
INSERT INTO turq_accounting_accounts VALUES (411, 0, 'MALİYET MUHASEBESİ YANSITMA HESABI', '701', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 411);
INSERT INTO turq_accounting_accounts VALUES (412, 0, 'DİREKT İLK MADDE VE MALZEME GİDERLERİ', '710', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 412);
INSERT INTO turq_accounting_accounts VALUES (413, 0, 'DİREKT İLK MADDE VE MALZEME YANSITMA HESABI', '711', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 413);
INSERT INTO turq_accounting_accounts VALUES (414, 0, 'DİREKT İLK MADDE VE MALZEME FİYAT FARKI', '712', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 414);
INSERT INTO turq_accounting_accounts VALUES (415, 0, 'DİREKT İLK MADDE VE MALZEME MİKTAR FARKI', '713', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 415);
INSERT INTO turq_accounting_accounts VALUES (416, 0, 'DİREKT İŞÇİLİK GİDERLERİ', '720', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 416);
INSERT INTO turq_accounting_accounts VALUES (417, 0, 'DİREKT İŞÇİLİK GİDERLERİ YANSITMA HESABI', '721', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 417);
INSERT INTO turq_accounting_accounts VALUES (418, 0, 'DİREKT İŞÇİLİK ÜCRET FARKLARI', '722', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 418);
INSERT INTO turq_accounting_accounts VALUES (419, 0, 'DİREKT İŞÇİLİK SÜRE (ZAMAN) FARKLARI', '723', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 419);
INSERT INTO turq_accounting_accounts VALUES (420, 0, 'GENEL ÜRETİM GİDERLERİ', '730', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 420);
INSERT INTO turq_accounting_accounts VALUES (421, 0, 'GENEL ÜRETİM GİDERLERİ YANSITMA HESABI', '731', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 421);
INSERT INTO turq_accounting_accounts VALUES (422, 0, 'GENEL ÜRETİM GİDERLERİ BÜTÇE FARKLARI', '732', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 422);
INSERT INTO turq_accounting_accounts VALUES (423, 0, 'GENEL ÜRETİM GİDERLERİ VERİMLİLİK FARKLARI', '733', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 423);
INSERT INTO turq_accounting_accounts VALUES (424, 0, 'GENEL ÜRETİM GİDERLERİ KAPASİTE FARKLARI', '734', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 424);
INSERT INTO turq_accounting_accounts VALUES (425, 0, 'HİZMET ÜRETİM MALİYETİ', '740', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 425);
INSERT INTO turq_accounting_accounts VALUES (426, 0, 'HİZMET ÜRETİM MALİYETİ YANSITMA HESABI', '741', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 426);
INSERT INTO turq_accounting_accounts VALUES (427, 0, 'HİZMET ÜRETİM MALİYETİ FARK HESAPLARI', '742', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 427);
INSERT INTO turq_accounting_accounts VALUES (428, 0, 'ARAŞTIRMA GELİŞTİRME GİDERLERİ', '750', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 428);
INSERT INTO turq_accounting_accounts VALUES (429, 0, 'ARAŞTIRMA GELİŞTİRME GİDERLERİ YANSITMA HESABI', '751', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 429);
INSERT INTO turq_accounting_accounts VALUES (430, 0, 'ARAŞTIRMA GELİŞTİRME GİDER FARKLARI', '752', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 430);
INSERT INTO turq_accounting_accounts VALUES (431, 0, 'PAZARLAMA SATIŞ VE DAĞITIM GİDERLERİ', '760', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 431);
INSERT INTO turq_accounting_accounts VALUES (432, 0, 'PAZARLAMA SATIŞ VE DAĞITIM GİDERLERİ YANSITMA HESABI', '761', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 432);
INSERT INTO turq_accounting_accounts VALUES (433, 0, 'PAZARLAMA SATIŞ VE DAĞITIM GİDERLERİ FARK HESABI', '762', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 433);
INSERT INTO turq_accounting_accounts VALUES (434, 0, 'GENEL YÖNETİM GİDERLERİ', '770', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 434);
INSERT INTO turq_accounting_accounts VALUES (435, 0, 'GENEL YÖNETİM GİDERLERİ YANSITMA HESABI', '771', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 435);
INSERT INTO turq_accounting_accounts VALUES (436, 0, 'GENEL YÖNETİM GİDER FARKLARI HESABI', '772', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 436);
INSERT INTO turq_accounting_accounts VALUES (437, 0, 'FİNANSMAN GİDERLERİ', '780', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 437);
INSERT INTO turq_accounting_accounts VALUES (438, 0, 'FİNANSMAN GİDERLERİ YANSITMA HESABI', '781', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 438);
INSERT INTO turq_accounting_accounts VALUES (439, 0, 'FİNANSMAN GİDERLERİ FARK HESABI', '782', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 439);
INSERT INTO turq_accounting_accounts VALUES (440, 0, 'İLK MADDE VE MALZEME GİDERLERİ', '790', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 440);
INSERT INTO turq_accounting_accounts VALUES (441, 0, 'İŞÇİ ÜCRET GİDERLERİ', '791', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 441);
INSERT INTO turq_accounting_accounts VALUES (442, 0, 'MEMUR ÜCRET GİDERLERİ', '792', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 442);
INSERT INTO turq_accounting_accounts VALUES (443, 0, 'DIŞARDAN SAĞLANAN FAYDA VE HİZMETLER', '793', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 443);
INSERT INTO turq_accounting_accounts VALUES (444, 0, 'ÇEŞİTLİ GİDERLER', '794', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 444);
INSERT INTO turq_accounting_accounts VALUES (445, 0, 'VERGİ, RESİM VE HARÇLAR', '795', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 445);
INSERT INTO turq_accounting_accounts VALUES (446, 0, 'AMORTİSMANLAR VE TÜKENME PAYLARI', '796', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 446);
INSERT INTO turq_accounting_accounts VALUES (447, 0, 'FİNANSMAN GİDERLERİ', '797', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 447);
INSERT INTO turq_accounting_accounts VALUES (448, 0, 'GİDER ÇEŞİTLERİ YANSITMA HESABI', '798', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 448);
INSERT INTO turq_accounting_accounts VALUES (449, 0, 'ÜRETİM MALİYET HESABI', '799', -1, '2004-11-18', 'admin', '2004-11-18', 'admin', 449);
INSERT INTO turq_accounting_accounts VALUES (450, 0, '242134', 'wqertwrt', 131, '2004-11-19', 'admin', '2004-11-19', 'admin', 131);


--
-- Data for TOC entry 249 (OID 17564)
-- Name: turq_accounting_transactions; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 250 (OID 17571)
-- Name: turq_accounting_journal; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_accounting_journal VALUES (-1, '2004-10-18', '2004-10-18', 'onsel', '2004-10-18', 'onsel');


--
-- Data for TOC entry 251 (OID 17573)
-- Name: turq_accounting_transaction_types; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_accounting_transaction_types VALUES (0, 'Tahsil', '2004-10-18', 'onsel', '2004-10-18', 'onsel');
INSERT INTO turq_accounting_transaction_types VALUES (1, 'Tediye', '2004-10-18', 'onsel', '2004-10-18', 'onsel');
INSERT INTO turq_accounting_transaction_types VALUES (2, 'Mahsup', '2004-10-18', 'onsel', '2004-10-18', 'onsel');


--
-- Data for TOC entry 252 (OID 17616)
-- Name: turq_current_cards_phones; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_current_cards_phones VALUES (90, -1, 0, 0, 0, '', '2004-11-17', '2004-11-17', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (91, -1, 0, 0, 0, '', '2004-11-17', '2004-11-17', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (94, 21, 31, 134, 134134, '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (95, 21, 134, 134, 134134, '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (96, 22, 0, 0, 0, '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (97, 22, 0, 0, 0, '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (98, 24, 0, 0, 0, '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_cards_phones VALUES (99, 24, 0, 0, 0, '', '2004-11-18', '2004-11-18', 'admin', 'admin');


--
-- Data for TOC entry 253 (OID 17627)
-- Name: turq_current_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 254 (OID 17635)
-- Name: turq_current_cards_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 255 (OID 17647)
-- Name: turq_current_contacts; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_current_contacts VALUES (42, -1, '', '', '', '', '', '', '', '2004-11-17', '2004-11-17', 'admin', 'admin');
INSERT INTO turq_current_contacts VALUES (44, 21, '13413', 'sfdgsfg', 'sfgsfg', 'sfgsfg', 'sfg', '', '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_contacts VALUES (45, 22, '', '', '', '', '', '', '', '2004-11-18', '2004-11-18', 'admin', 'admin');
INSERT INTO turq_current_contacts VALUES (46, 24, '', '', '', '', '', '', '', '2004-11-18', '2004-11-18', 'admin', 'admin');


--
-- Data for TOC entry 256 (OID 17655)
-- Name: turq_current_transactions; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 257 (OID 17670)
-- Name: turq_current_transaction_types; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_current_transaction_types VALUES (1, 0, 'Fatura', 'onsel', 'onsel', '2004-10-18', '2004-10-18');
INSERT INTO turq_current_transaction_types VALUES (3, 0, 'Senet', 'onsel', 'onsel', '2004-10-18', '2004-10-18');
INSERT INTO turq_current_transaction_types VALUES (4, 0, 'Nakit', 'onsel', 'onsel', '2004-10-18', '2004-10-18');
INSERT INTO turq_current_transaction_types VALUES (5, 0, 'Dekont', 'onsel', 'onsel', '2004-10-18', '2004-10-18');
INSERT INTO turq_current_transaction_types VALUES (2, 0, 'Çek', 'onsel', 'onsel', '2004-10-18', '2004-10-18');


--
-- Data for TOC entry 258 (OID 17672)
-- Name: turq_current_transaction_bill; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 259 (OID 17684)
-- Name: turq_banks_cards; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 260 (OID 17686)
-- Name: turq_bank_secondary_accounts; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 261 (OID 17700)
-- Name: turq_bank_cards_secondary_accounts; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 262 (OID 17716)
-- Name: turq_banks_transaction_bills; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 263 (OID 17724)
-- Name: turq_banks_transactions; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 264 (OID 17729)
-- Name: turq_banks_transaction_types; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 265 (OID 17755)
-- Name: turq_cheque_cheques; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 266 (OID 17774)
-- Name: turq_cheque_rolls; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 267 (OID 17776)
-- Name: turq_cheque_transaction_types; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 268 (OID 17802)
-- Name: turq_cheque_cheques_rolls; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 269 (OID 17814)
-- Name: turq_tradebill_tradebills; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 270 (OID 17829)
-- Name: turq_tradebill_rolls; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 271 (OID 17847)
-- Name: turq_tradebill_transaction_types; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 272 (OID 17859)
-- Name: turq_tradebill_tradebills_rolls; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 273 (OID 17871)
-- Name: turq_bills; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_bills VALUES (-1, 0, 1, '2004-10-18', 'wrgrgrg', '2004-10-18', 'onsel', '2004-10-18', 'onsel', -1, false, true, -1, -1);


--
-- Data for TOC entry 274 (OID 17876)
-- Name: turq_bill_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 275 (OID 17894)
-- Name: turq_bill_in_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 276 (OID 17906)
-- Name: turq_consignments; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_consignments VALUES (-1, 0, '2004-10-10', '3134', '2004-10-18', 'onsel', '2004-10-18', 'onsel', 0, false, -1, -1);


--
-- Data for TOC entry 277 (OID 17921)
-- Name: turq_consignment_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--

INSERT INTO turq_consignment_groups VALUES (3, 0, 'deneme', '', '2004-11-18', 'admin', '2004-11-18', 'admin');


--
-- Data for TOC entry 278 (OID 17929)
-- Name: turq_consignments_in_group; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 279 (OID 17941)
-- Name: turq_orders; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 280 (OID 17960)
-- Name: turq_order_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 281 (OID 17968)
-- Name: turq_order_in_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 282 (OID 18144)
-- Name: turq_inventory_card_groups; Type: TABLE DATA; Schema: public; Owner: turquaz
--



--
-- Data for TOC entry 283 (OID 18183)
-- Name: turq_accounting_transaction_columns; Type: TABLE DATA; Schema: public; Owner: turquaz
--



SET SESSION AUTHORIZATION 'postgres';

--
-- Data for TOC entry 284 (OID 21141)
-- Name: turq_engine_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO turq_engine_sequences VALUES (-1, 0);


--
-- Data for TOC entry 285 (OID 21163)
-- Name: turq_bill_consignment_commons; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO turq_bill_consignment_commons VALUES (-1, 0, 0, 0, 0, 0, 'admin', '2004-10-18', 'admin', '2004-10-18', 0, -1, 'qwert', 'c');


SET SESSION AUTHORIZATION 'turquaz';

--
-- TOC entry 175 (OID 17161)
-- Name: turq_modules_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_modules
    ADD CONSTRAINT turq_modules_pkey PRIMARY KEY (modules_id);


--
-- TOC entry 174 (OID 17163)
-- Name: turq_module_components_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_module_components
    ADD CONSTRAINT turq_module_components_pkey PRIMARY KEY (module_components_id);


--
-- TOC entry 173 (OID 17169)
-- Name: turq_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_groups
    ADD CONSTRAINT turq_groups_pkey PRIMARY KEY (groups_id);


--
-- TOC entry 177 (OID 17183)
-- Name: turq_users_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_users
    ADD CONSTRAINT turq_users_pkey PRIMARY KEY (users_id);


--
-- TOC entry 176 (OID 17193)
-- Name: turq_user_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT turq_user_permissions_pkey PRIMARY KEY (user_permissions_id);


--
-- TOC entry 172 (OID 17207)
-- Name: turq_companies_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_companies
    ADD CONSTRAINT turq_companies_pkey PRIMARY KEY (companies_id);


--
-- TOC entry 178 (OID 17211)
-- Name: turq_group_permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT turq_group_permissions_pkey PRIMARY KEY (group_permissions_id);


--
-- TOC entry 182 (OID 17229)
-- Name: turq_inventory_units_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_units
    ADD CONSTRAINT turq_inventory_units_pkey PRIMARY KEY (inventory_units_id);


--
-- TOC entry 184 (OID 17237)
-- Name: turq_inventory_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT turq_inventory_groups_pkey PRIMARY KEY (inventory_groups_id);


--
-- TOC entry 179 (OID 17243)
-- Name: turq_inventory_card_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_card_pkey PRIMARY KEY (inventory_cards_id);


--
-- TOC entry 185 (OID 17262)
-- Name: turq_inventory_prices_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT turq_inventory_prices_pkey PRIMARY KEY (inventory_prices_id);


--
-- TOC entry 186 (OID 17274)
-- Name: turq_inventory_card_units_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT turq_inventory_card_units_pkey PRIMARY KEY (inventory_card_units_id);


--
-- TOC entry 187 (OID 17286)
-- Name: turq_inventory_warehouses_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_warehouses
    ADD CONSTRAINT turq_inventory_warehouses_pkey PRIMARY KEY (inventory_warehouses_id);


--
-- TOC entry 188 (OID 17297)
-- Name: turq_inventory_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT turq_inventory_transactions_pkey PRIMARY KEY (inventory_transactions_id);


--
-- TOC entry 171 (OID 17315)
-- Name: turq_companies_companies_id_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_companies
    ADD CONSTRAINT turq_companies_companies_id_key UNIQUE (companies_id);


--
-- TOC entry 189 (OID 17337)
-- Name: turq_user_group_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT turq_user_group_pkey PRIMARY KEY (user_group_id);


--
-- TOC entry 190 (OID 17535)
-- Name: turq_currencies_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_currencies
    ADD CONSTRAINT turq_currencies_pkey PRIMARY KEY (currencies_id);


--
-- TOC entry 193 (OID 17554)
-- Name: turq_accounting_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT turq_accounting_accounts_pkey PRIMARY KEY (accounting_accounts_id);


--
-- TOC entry 194 (OID 17569)
-- Name: turq_accounting_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT turq_accounting_transactions_pkey PRIMARY KEY (accounting_transactions_id);


--
-- TOC entry 196 (OID 17578)
-- Name: turq_accounting_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_types
    ADD CONSTRAINT turq_accounting_transaction_types_pkey PRIMARY KEY (accounting_transaction_types_id);


--
-- TOC entry 195 (OID 17580)
-- Name: turq_accounting_journal_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_journal
    ADD CONSTRAINT turq_accounting_journal_pkey PRIMARY KEY (accounting_journal_id);


--
-- TOC entry 192 (OID 17602)
-- Name: turq_current_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT turq_current_cards_pkey PRIMARY KEY (current_cards_id);


--
-- TOC entry 197 (OID 17621)
-- Name: turq_current_cards_phones_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_phones
    ADD CONSTRAINT turq_current_cards_phones_pkey PRIMARY KEY (current_cards_phones_id);


--
-- TOC entry 198 (OID 17629)
-- Name: turq_current_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_groups
    ADD CONSTRAINT turq_current_groups_pkey PRIMARY KEY (current_groups_id);


--
-- TOC entry 199 (OID 17637)
-- Name: turq_current_cards_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT turq_current_cards_groups_pkey PRIMARY KEY (current_cards_groups_id);


--
-- TOC entry 200 (OID 17649)
-- Name: turq_current_contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_contacts
    ADD CONSTRAINT turq_current_contacts_pkey PRIMARY KEY (current_contacts_id);


--
-- TOC entry 201 (OID 17660)
-- Name: turq_current_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT turq_current_transactions_pkey PRIMARY KEY (current_transactions_id);


--
-- TOC entry 203 (OID 17674)
-- Name: turq_current_transaction_bill_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT turq_current_transaction_bill_pkey PRIMARY KEY (current_transaction_bill_id);


--
-- TOC entry 204 (OID 17688)
-- Name: turq_banks_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT turq_banks_cards_pkey PRIMARY KEY (banks_cards_id);


--
-- TOC entry 205 (OID 17694)
-- Name: turq_bank_secondary_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_secondary_accounts
    ADD CONSTRAINT turq_bank_secondary_accounts_pkey PRIMARY KEY (bank_secondary_accounts_id);


--
-- TOC entry 206 (OID 17702)
-- Name: turq_bank_cards_secondary_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT turq_bank_cards_secondary_accounts_pkey PRIMARY KEY (bank_cards_secondary_accounts_id);


--
-- TOC entry 207 (OID 17718)
-- Name: turq_banks_transaction_bills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_bills
    ADD CONSTRAINT turq_banks_transaction_bills_pkey PRIMARY KEY (banks_transaction_bills_id);


--
-- TOC entry 209 (OID 17731)
-- Name: turq_banks_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_types
    ADD CONSTRAINT turq_banks_transaction_types_pkey PRIMARY KEY (bank_transaction_types_id);


--
-- TOC entry 208 (OID 17733)
-- Name: turq_banks_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT turq_banks_transactions_pkey PRIMARY KEY (bank_transactions_id);


--
-- TOC entry 210 (OID 17760)
-- Name: turq_cheque_cheques_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT turq_cheque_cheques_pkey PRIMARY KEY (cheque_cheques_id);


--
-- TOC entry 212 (OID 17778)
-- Name: cheque_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_transaction_types
    ADD CONSTRAINT cheque_transaction_types_pkey PRIMARY KEY (cheque_transaction_types_id);


--
-- TOC entry 211 (OID 17784)
-- Name: turq_cheque_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT turq_cheque_rolls_pkey PRIMARY KEY (cheque_rolls_id);


--
-- TOC entry 213 (OID 17804)
-- Name: turq_cheque_cheques_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT turq_cheque_cheques_rolls_pkey PRIMARY KEY (cheque_cheques_rolls_id);


--
-- TOC entry 214 (OID 17819)
-- Name: turq_tradebill_tradebills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT turq_tradebill_tradebills_pkey PRIMARY KEY (tradebill_tradebills_id);


--
-- TOC entry 215 (OID 17831)
-- Name: turq_tradebill_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT turq_tradebill_rolls_pkey PRIMARY KEY (tradebill_rolls_id);


--
-- TOC entry 216 (OID 17849)
-- Name: tradebill_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_transaction_types
    ADD CONSTRAINT tradebill_transaction_types_pkey PRIMARY KEY (tradebill_transaction_types_id);


--
-- TOC entry 217 (OID 17861)
-- Name: turq_tradebill_tradebills_rolls_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT turq_tradebill_tradebills_rolls_pkey PRIMARY KEY (tradebill_tradebills_rolls_id);


--
-- TOC entry 219 (OID 17878)
-- Name: turq_bill_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_groups
    ADD CONSTRAINT turq_bill_groups_pkey PRIMARY KEY (bill_groups_id);


--
-- TOC entry 218 (OID 17884)
-- Name: turq_bills_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT turq_bills_pkey PRIMARY KEY (bills_id);


--
-- TOC entry 220 (OID 17896)
-- Name: turq_bill_in_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT turq_bill_in_groups_pkey PRIMARY KEY (bill_in_groups_id);


--
-- TOC entry 222 (OID 17923)
-- Name: turq_consignment_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignment_groups
    ADD CONSTRAINT turq_consignment_groups_pkey PRIMARY KEY (consignment_groups_id);


--
-- TOC entry 223 (OID 17931)
-- Name: turq_consignments_in_group_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT turq_consignments_in_group_pkey PRIMARY KEY (consignments_in_group_id);


--
-- TOC entry 224 (OID 17946)
-- Name: turq_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT turq_orders_pkey PRIMARY KEY (orders_id);


--
-- TOC entry 225 (OID 17962)
-- Name: turq_order_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_groups
    ADD CONSTRAINT turq_order_groups_pkey PRIMARY KEY (order_groups_id);


--
-- TOC entry 226 (OID 17970)
-- Name: turq_order_in_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT turq_order_in_groups_pkey PRIMARY KEY (order_in_groups_id);


--
-- TOC entry 202 (OID 17984)
-- Name: turq_current_transaction_types_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_types
    ADD CONSTRAINT turq_current_transaction_types_pkey PRIMARY KEY (current_transaction_types_id);


--
-- TOC entry 180 (OID 18136)
-- Name: turq_inventory_cards_card_inventory_code_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_cards_card_inventory_code_key UNIQUE (card_inventory_code);


--
-- TOC entry 181 (OID 18140)
-- Name: turq_inventory_cards_card_name_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT turq_inventory_cards_card_name_key UNIQUE (card_name);


--
-- TOC entry 183 (OID 18142)
-- Name: turq_inventory_groups_groups_name_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT turq_inventory_groups_groups_name_key UNIQUE (groups_name);


--
-- TOC entry 227 (OID 18146)
-- Name: turq_inventory_card_groups_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT turq_inventory_card_groups_pkey PRIMARY KEY (inventory_card_groups_id);


--
-- TOC entry 228 (OID 18188)
-- Name: turq_accounting_transaction_columns_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT turq_accounting_transaction_columns_pkey PRIMARY KEY (accounting_transaction_columns_id);


--
-- TOC entry 191 (OID 18225)
-- Name: turq_current_cards_cards_current_code_key; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT turq_current_cards_cards_current_code_key UNIQUE (cards_current_code);


--
-- TOC entry 221 (OID 21123)
-- Name: turq_consignments_pkey; Type: CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT turq_consignments_pkey PRIMARY KEY (consignments_id);


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 229 (OID 21145)
-- Name: turq_engine_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turq_engine_sequences
    ADD CONSTRAINT turq_engine_sequences_pkey PRIMARY KEY (engine_sequences_id);


--
-- TOC entry 230 (OID 21170)
-- Name: turq_bill_consignment_common_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turq_bill_consignment_commons
    ADD CONSTRAINT turq_bill_consignment_common_pkey PRIMARY KEY (bill_consignment_common_id);


SET SESSION AUTHORIZATION 'turquaz';

--
-- TOC entry 286 (OID 17165)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_module_components
    ADD CONSTRAINT "$1" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 287 (OID 17195)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$1" FOREIGN KEY (users_id) REFERENCES turq_users(users_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 288 (OID 17199)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$2" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 289 (OID 17203)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_permissions
    ADD CONSTRAINT "$3" FOREIGN KEY (module_components_id) REFERENCES turq_module_components(module_components_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 290 (OID 17213)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$1" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 291 (OID 17217)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$2" FOREIGN KEY (module_components_id) REFERENCES turq_module_components(module_components_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 292 (OID 17221)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_group_permissions
    ADD CONSTRAINT "$3" FOREIGN KEY (groups_id) REFERENCES turq_groups(groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 296 (OID 17231)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_units
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 297 (OID 17239)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 293 (OID 17245)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 298 (OID 17268)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 300 (OID 17276)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 301 (OID 17280)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_units
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_units_id) REFERENCES turq_inventory_units(inventory_units_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 302 (OID 17288)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_warehouses
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 303 (OID 17299)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_warehouses_id) REFERENCES turq_inventory_warehouses(inventory_warehouses_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 304 (OID 17303)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 305 (OID 17307)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (inventory_units_id) REFERENCES turq_inventory_units(inventory_units_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 307 (OID 17339)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT "$1" FOREIGN KEY (groups_id) REFERENCES turq_groups(groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 308 (OID 17343)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_user_group
    ADD CONSTRAINT "$2" FOREIGN KEY (users_id) REFERENCES turq_users(users_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 309 (OID 17537)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_currencies
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 299 (OID 17541)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_prices
    ADD CONSTRAINT "$1" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 312 (OID 17556)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 313 (OID 17560)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT "$2" FOREIGN KEY (parent_account) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 315 (OID 17582)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_transaction_types_id) REFERENCES turq_accounting_transaction_types(accounting_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 316 (OID 17586)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (accounting_journal_id) REFERENCES turq_accounting_journal(accounting_journal_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 317 (OID 17598)
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$5" FOREIGN KEY (module_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 310 (OID 17604)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_code_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 311 (OID 17612)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards
    ADD CONSTRAINT "$3" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 319 (OID 17623)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_phones
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 320 (OID 17631)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 321 (OID 17639)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 322 (OID 17643)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_cards_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (current_groups_id) REFERENCES turq_current_groups(current_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 323 (OID 17651)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_contacts
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 324 (OID 17662)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 325 (OID 17666)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 329 (OID 17676)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT "$1" FOREIGN KEY (current_transactions_id_close) REFERENCES turq_current_transactions(current_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 330 (OID 17680)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_bill
    ADD CONSTRAINT "$2" FOREIGN KEY (current_transactions_id_open) REFERENCES turq_current_transactions(current_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 331 (OID 17690)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 333 (OID 17696)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_secondary_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 334 (OID 17704)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$1" FOREIGN KEY (bank_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 335 (OID 17708)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$2" FOREIGN KEY (bank_secondary_accounts_id) REFERENCES turq_bank_secondary_accounts(bank_secondary_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 336 (OID 17712)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bank_cards_secondary_accounts
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 337 (OID 17720)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transaction_bills
    ADD CONSTRAINT "$1" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 338 (OID 17735)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$1" FOREIGN KEY (bank_transactions_bills_id) REFERENCES turq_banks_transaction_bills(banks_transaction_bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 339 (OID 17739)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$2" FOREIGN KEY (banks_secondary_accounts_id) REFERENCES turq_bank_cards_secondary_accounts(bank_cards_secondary_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 340 (OID 17743)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 341 (OID 17747)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$4" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 342 (OID 17751)
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_transactions
    ADD CONSTRAINT "$5" FOREIGN KEY (transaction_types_id) REFERENCES turq_banks_transaction_types(bank_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 343 (OID 17762)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 344 (OID 17766)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$2" FOREIGN KEY (banks_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 345 (OID 17770)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques
    ADD CONSTRAINT "$3" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 350 (OID 17780)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 346 (OID 17786)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 347 (OID 17790)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 348 (OID 17794)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$3" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 349 (OID 17798)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_rolls
    ADD CONSTRAINT "$4" FOREIGN KEY (cheque_transaction_types_id) REFERENCES turq_cheque_transaction_types(cheque_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 351 (OID 17806)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (cheque_rolls_id) REFERENCES turq_cheque_rolls(cheque_rolls_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 352 (OID 17810)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_cheque_cheques_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (cheque_cheques_id) REFERENCES turq_cheque_cheques(cheque_cheques_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 353 (OID 17821)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 354 (OID 17825)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 355 (OID 17833)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 356 (OID 17837)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 357 (OID 17841)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$3" FOREIGN KEY (banks_cards_id) REFERENCES turq_banks_cards(banks_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 359 (OID 17851)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 358 (OID 17855)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_rolls
    ADD CONSTRAINT "$4" FOREIGN KEY (tradebill_transaction_types_id) REFERENCES turq_tradebill_transaction_types(tradebill_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 360 (OID 17863)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT "$1" FOREIGN KEY (tradebill_rolls_id) REFERENCES turq_tradebill_rolls(tradebill_rolls_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 361 (OID 17867)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_tradebill_tradebills_rolls
    ADD CONSTRAINT "$2" FOREIGN KEY (tradebill_tradebills_id) REFERENCES turq_tradebill_tradebills(tradebill_tradebills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 365 (OID 17880)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 362 (OID 17886)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 366 (OID 17898)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (bill_groups_id) REFERENCES turq_bill_groups(bill_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 367 (OID 17902)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bill_in_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (bills_id) REFERENCES turq_bills(bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 371 (OID 17925)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignment_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 374 (OID 17948)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$1" FOREIGN KEY (bills_id) REFERENCES turq_bills(bills_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 375 (OID 17952)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$2" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 376 (OID 17956)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_orders
    ADD CONSTRAINT "$3" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 377 (OID 17964)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 378 (OID 17972)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (orders_id) REFERENCES turq_orders(orders_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 379 (OID 17976)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_order_in_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (order_groups_id) REFERENCES turq_order_groups(order_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 328 (OID 17986)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transaction_types
    ADD CONSTRAINT "$1" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 294 (OID 18002)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$4" FOREIGN KEY (accounting_accounts_id_buy) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 295 (OID 18006)
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_cards
    ADD CONSTRAINT "$5" FOREIGN KEY (accounting_accounts_id_sell) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 380 (OID 18148)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT "$1" FOREIGN KEY (inventory_cards_id) REFERENCES turq_inventory_cards(inventory_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 381 (OID 18152)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_card_groups
    ADD CONSTRAINT "$2" FOREIGN KEY (inventory_groups_id) REFERENCES turq_inventory_groups(inventory_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 332 (OID 18158)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_banks_cards
    ADD CONSTRAINT "$2" FOREIGN KEY (currencies_id) REFERENCES turq_currencies(currencies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 382 (OID 18198)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT "$3" FOREIGN KEY (accounting_transactions_id) REFERENCES turq_accounting_transactions(accounting_transactions_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 383 (OID 18206)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transaction_columns
    ADD CONSTRAINT "$1" FOREIGN KEY (accounting_accounts_id) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 326 (OID 18219)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (current_transaction_types_id) REFERENCES turq_current_transaction_types(current_transaction_types_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 314 (OID 19225)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_accounts
    ADD CONSTRAINT "$3" FOREIGN KEY (top_account) REFERENCES turq_accounting_accounts(accounting_accounts_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 372 (OID 21105)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT "$2" FOREIGN KEY (consignments_groups_id) REFERENCES turq_consignment_groups(consignment_groups_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 368 (OID 21113)
-- Name: $2; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$2" FOREIGN KEY (companies_id) REFERENCES turq_companies(companies_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 373 (OID 21129)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments_in_group
    ADD CONSTRAINT "$1" FOREIGN KEY (consignment_id) REFERENCES turq_consignments(consignments_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 363 (OID 21147)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT "$4" FOREIGN KEY (engine_sequences_id) REFERENCES turq_engine_sequences(engine_sequences_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 327 (OID 21151)
-- Name: $4; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_current_transactions
    ADD CONSTRAINT "$4" FOREIGN KEY (engine_sequences_id) REFERENCES turq_engine_sequences(engine_sequences_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 318 (OID 21155)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_accounting_transactions
    ADD CONSTRAINT "$3" FOREIGN KEY (engine_sequences_id) REFERENCES turq_engine_sequences(engine_sequences_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 384 (OID 21159)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turq_engine_sequences
    ADD CONSTRAINT "$1" FOREIGN KEY (modules_id) REFERENCES turq_modules(modules_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


SET SESSION AUTHORIZATION 'turquaz';

--
-- TOC entry 364 (OID 21180)
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_bills
    ADD CONSTRAINT "$5" FOREIGN KEY (bill_consignment_commons_id) REFERENCES turq_bill_consignment_commons(bill_consignment_common_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 369 (OID 21184)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$1" FOREIGN KEY (bill_consignment_common_id) REFERENCES turq_bill_consignment_commons(bill_consignment_common_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 385 (OID 21190)
-- Name: $1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY turq_bill_consignment_commons
    ADD CONSTRAINT "$1" FOREIGN KEY (current_cards_id) REFERENCES turq_current_cards(current_cards_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


SET SESSION AUTHORIZATION 'turquaz';

--
-- TOC entry 306 (OID 21194)
-- Name: $5; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_inventory_transactions
    ADD CONSTRAINT "$5" FOREIGN KEY (engine_sequences_id) REFERENCES turq_engine_sequences(engine_sequences_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 370 (OID 21198)
-- Name: $3; Type: FK CONSTRAINT; Schema: public; Owner: turquaz
--

ALTER TABLE ONLY turq_consignments
    ADD CONSTRAINT "$3" FOREIGN KEY (engine_sequences_id) REFERENCES turq_engine_sequences(engine_sequences_id) ON UPDATE RESTRICT ON DELETE RESTRICT;




COMMENT ON SCHEMA public IS 'Standard public schema';


