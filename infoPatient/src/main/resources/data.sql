BEGIN TRANSACTION;   -- Ouverture de la transaction

-- ------------------------------------------------------------------
--	SUPPRESION TABLES AVANT CREATION ET INSERTION
-- ------------------------------------------------------------------
DROP TABLE IF EXISTS public.infopatient;

-- ------------------------------------------------------------------
--	CREATION BDD ET TABLES
-- ------------------------------------------------------------------

CREATE EXTENSION IF NOT EXISTS "uuid-ossp"; 

CREATE TABLE public.infopatient
(
    id UUID DEFAULT gen_random_uuid () NOT NULL,
    family character varying(30)  NOT NULL,
    given character varying(30)  NOT NULL,
    dob date NOT NULL,
    sex "char" NOT NULL, 
    address character varying(60) ,
    phone character varying(30) ,
    CONSTRAINT infopatient_pkey PRIMARY KEY (id)
);
    
ALTER TABLE public.infopatient
    OWNER to postgres;
    
 INSERT INTO public.infopatient(
	id, family, given, dob, sex, address, phone)
	VALUES 
	--('f6acefba-8fbf-45e7-b93a-faef2c61b218', 'TestNone', 'Test', '1966-12-31', 'F', '1 Brookside St', '100-222-3333'),
	--('637b3fff-290c-4bf5-ac6e-12b11cf12cc8', 'TestBorderline', 'Test', '1945-06-24', 'M', '2 High St', '200-333-4444'),
	--('255cbb6e-a28d-449e-b017-0f9d7c3b9564', 'TestInDanger', 'Test', '2004-06-18', 'M', '3 Club Road', '300-444-5555'),
	--('ec6e8d79-e612-4c18-ae78-c3384139cb7f', 'TestEarlyOnset', 'Test', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666');
	 
	('bee3168f-dae3-40b2-8641-86684c384692', 'Ferguson', 'Lucas', '1968-06-22', 'M', '2 Warren Street', '387-866-1399'),
	('1b75bc5f-647e-463b-92e8-fc3405330eb2', 'Rees', 'Pippa', '1952-09-27', 'F', '745 West Valley Farms Drive', '628-423-0993'),
	('d0ce1967-89be-4e44-ad6f-d9725dfe9e9e', 'Arnold', 'Edward', '1952-11-11', 'M', '599 East Garden Ave', '123-727-2779'),
	('b07476eb-123d-464c-a26f-d0ac76efc4df', 'Sharp', 'Anthony', '1946-11-26', 'M', '894 Hall Street', '451-761-8383'),
	('5671862f-36a1-49c8-8003-0e7cae420bbf', 'Ince', 'Wendy', '1958-06-29', 'F', '4 Southampton Road', '802-911-9975'),
	('d4c3df6e-2df3-4c42-a0a9-2c6e662d4372', 'Ross', 'Tracey', '1949-12-07', 'F', '40 Sulphur Springs Dr', '131-396-5049'),
	('fcb2b7bc-034f-496c-8ad1-d78d15688391', 'Wilson', 'Claire', '1966-12-31', 'f', '12 Cobblestone St', '300-452-1091'),
	('6ed38280-ce5d-4266-8c55-ace2e70cb3cf', 'Buckland', 'Max', '1945-06-24', 'M', '193 Vale St ', '833-534-0864'),
	('eef94901-e915-4dfe-a06d-49873f8811ad', 'Clark', 'Natalie', '1964-06-18', 'F', '12 Beechwood Road', '241-467-9197'), 
	('f6acefba-8fbf-45e7-b93a-faef2c61b218', 'Bailey', 'Piers', '1959-06-28', 'M', '1202 Bumble Dr', '747-815-0557');
	
COMMIT;   -- Validation de la transaction