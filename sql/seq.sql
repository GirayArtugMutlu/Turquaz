--
-- TOC entry 6 (OID 17313)
-- Name: seq_companies; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_companies', 0, true);


--
-- TOC entry 8 (OID 17320)
-- Name: seq_users; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_users', 6, true);


--
-- TOC entry 10 (OID 17507)
-- Name: seq_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_groups', 3, true);


--
-- TOC entry 12 (OID 17509)
-- Name: seq_group_permissions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_group_permissions', 7, true);


--
-- TOC entry 14 (OID 17511)
-- Name: seq_inventory_card_units; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_card_units', 83, true);


--
-- TOC entry 16 (OID 17513)
-- Name: seq_inventory_cards; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_cards', 40, true);


--
-- TOC entry 18 (OID 17515)
-- Name: seq_inventory_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_groups', 15, true);


--
-- TOC entry 20 (OID 17517)
-- Name: seq_inventory_prices; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_prices', 59, true);


--
-- TOC entry 22 (OID 17519)
-- Name: seq_inventory_transactions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_transactions', 50, true);


--
-- TOC entry 24 (OID 17521)
-- Name: seq_inventory_units; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_units', 8, true);


--
-- TOC entry 26 (OID 17523)
-- Name: seq_inventory_warehouses; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_warehouses', 3, true);


--
-- TOC entry 28 (OID 17525)
-- Name: seq_module_components; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_module_components', 28, true);


--
-- TOC entry 30 (OID 17527)
-- Name: seq_modules; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_modules', 7, true);


--
-- TOC entry 32 (OID 17529)
-- Name: seq_user_group; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_user_group', 27, true);


--
-- TOC entry 34 (OID 17531)
-- Name: seq_user_permissions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_user_permissions', 7, true);


--
-- TOC entry 36 (OID 17994)
-- Name: seq_accounting_accounts; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_accounting_accounts', 450, true);


--
-- TOC entry 38 (OID 17996)
-- Name: seq_accounting_journal; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_accounting_journal', 0, false);


--
-- TOC entry 40 (OID 17998)
-- Name: seq_accounting_transaction_types; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_accounting_transaction_types', 2, true);


--
-- TOC entry 42 (OID 18000)
-- Name: seq_accounting_transactions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_accounting_transactions', 83, true);


--
-- TOC entry 44 (OID 18072)
-- Name: seq_bank_cards_secondary_accounts; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_bank_cards_secondary_accounts', 1, false);


--
-- TOC entry 46 (OID 18074)
-- Name: seq_banks_cards; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_banks_cards', 12, true);


--
-- TOC entry 48 (OID 18076)
-- Name: seq_bank_secondary_accounts; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_bank_secondary_accounts', 1, false);


--
-- TOC entry 50 (OID 18078)
-- Name: seq_banks_transaction_bills; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_banks_transaction_bills', 1, false);


--
-- TOC entry 52 (OID 18080)
-- Name: seq_banks_transaction_types; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_banks_transaction_types', 1, false);


--
-- TOC entry 54 (OID 18082)
-- Name: seq_banks_transactions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_banks_transactions', 1, false);


--
-- TOC entry 56 (OID 18084)
-- Name: seq_bill_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_bill_groups', 2, true);


--
-- TOC entry 58 (OID 18086)
-- Name: seq_bill_in_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_bill_in_groups', 2, true);


--
-- TOC entry 60 (OID 18088)
-- Name: seq_bills; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_bills', 37, true);


--
-- TOC entry 62 (OID 18090)
-- Name: seq_cheque_cheques; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_cheque_cheques', 1, false);


--
-- TOC entry 64 (OID 18092)
-- Name: seq_cheque_cheques_rolls; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_cheque_cheques_rolls', 1, false);


--
-- TOC entry 66 (OID 18094)
-- Name: seq_cheque_rolls; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_cheque_rolls', 1, false);


--
-- TOC entry 68 (OID 18096)
-- Name: seq_cheque_transaction_types; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_cheque_transaction_types', 1, false);


--
-- TOC entry 70 (OID 18098)
-- Name: seq_consignment_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_consignment_groups', 3, true);


--
-- TOC entry 72 (OID 18100)
-- Name: seq_consignments; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_consignments', 21, true);


--
-- TOC entry 74 (OID 18102)
-- Name: seq_consignments_in_group; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_consignments_in_group', 15, true);


--
-- TOC entry 76 (OID 18104)
-- Name: seq_currencies; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_currencies', 2, true);


--
-- TOC entry 78 (OID 18106)
-- Name: seq_current_cards; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_cards', 24, true);


--
-- TOC entry 80 (OID 18108)
-- Name: seq_current_cards_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_cards_groups', 62, true);


--
-- TOC entry 82 (OID 18110)
-- Name: seq_current_cards_phones; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_cards_phones', 99, true);


--
-- TOC entry 84 (OID 18112)
-- Name: seq_current_contacts; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_contacts', 46, true);


--
-- TOC entry 86 (OID 18114)
-- Name: seq_current_transaction_bill; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_transaction_bill', 1, false);


--
-- TOC entry 88 (OID 18116)
-- Name: seq_current_transaction_types; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_transaction_types', 7, true);


--
-- TOC entry 90 (OID 18118)
-- Name: seq_current_transactions; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_transactions', 84, true);


--
-- TOC entry 92 (OID 18120)
-- Name: seq_order_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_order_groups', 1, false);


--
-- TOC entry 94 (OID 18122)
-- Name: seq_order_in_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_order_in_groups', 1, false);


--
-- TOC entry 96 (OID 18124)
-- Name: seq_orders; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_orders', 1, false);


--
-- TOC entry 98 (OID 18126)
-- Name: seq_tradebill_rolls; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_tradebill_rolls', 1, false);


--
-- TOC entry 100 (OID 18128)
-- Name: seq_tradebill_tradebills; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_tradebill_tradebills', 1, false);


--
-- TOC entry 102 (OID 18130)
-- Name: seq_tradebill_transaction_types; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_tradebill_transaction_types', 1, false);


--
-- TOC entry 104 (OID 18132)
-- Name: seq_tradebill_tradebills_rolls; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_tradebill_tradebills_rolls', 1, false);


--
-- TOC entry 106 (OID 18134)
-- Name: seq_current_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_current_groups', 6, true);


--
-- TOC entry 108 (OID 18156)
-- Name: seq_inventory_card_groups; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_inventory_card_groups', 79, true);


--
-- TOC entry 110 (OID 18177)
-- Name: seq_accounting_transaction_columns; Type: SEQUENCE SET; Schema: public; Owner: turquaz
--

SELECT pg_catalog.setval('seq_accounting_transaction_columns', 349, true);


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 112 (OID 21143)
-- Name: seq_engine_sequences; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_engine_sequences', 42, true);


--
-- TOC entry 114 (OID 21188)
-- Name: seq_bill_consignment_commons; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seq_bill_consignment_commons', 9, true);


--
-- TOC entry 3 (OID 2200)
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--