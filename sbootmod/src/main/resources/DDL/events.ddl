-- Table: events

-- DROP TABLE events;

CREATE TABLE events
(
  eve_id serial NOT NULL,
  eve_start_date date,
  eve_end_date date,
  eve_owner_id integer,
  eve_ticket_pool_id integer,
  eve_name character varying(20), -- Max 20 chars
  eve_code character varying(6),
  CONSTRAINT event_pkey PRIMARY KEY (eve_id),
  CONSTRAINT eve_usr_id_fk FOREIGN KEY (eve_owner_id)
      REFERENCES users (usr_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE events
  OWNER TO postgres;
COMMENT ON COLUMN events.eve_name IS 'Max 20 chars';


-- Index: fki_eve_usr_id_fk

-- DROP INDEX fki_eve_usr_id_fk;

CREATE INDEX fki_eve_usr_id_fk
  ON events
  USING btree
  (eve_owner_id);

