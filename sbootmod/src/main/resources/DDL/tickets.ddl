-- Table: tickets

-- DROP TABLE tickets;

CREATE TABLE tickets
(
  tic_id integer NOT NULL DEFAULT nextval('tickers_tic_id_seq'::regclass),
  tic_name character varying(30),
  tic_surname character varying(40),
  tic_email character varying(40),
  tic_event_id integer,
  tic_city character varying(40),
  tic_street character varying(40),
  tic_flat_nr character varying(10),
  tic_sex character(1),
  tic_birth_date date,
  tic_phone integer,
  tic_seat_nr character varying(10),
  tic_code character varying(20),
  CONSTRAINT tickers_pkey PRIMARY KEY (tic_id),
  CONSTRAINT tickets_tic_code_key UNIQUE (tic_code)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tickets
  OWNER TO postgres;
