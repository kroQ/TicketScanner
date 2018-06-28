-- Table: history

-- DROP TABLE history;

CREATE TABLE history
(
  his_id serial NOT NULL,
  his_ticket_id integer,
  his_user_id integer,
  his_is_inside boolean DEFAULT false,
  his_event_id integer,
  his_date date,
  his_time time without time zone,
  CONSTRAINT history_pkey PRIMARY KEY (his_id),
  CONSTRAINT his_eve_id FOREIGN KEY (his_event_id)
      REFERENCES events (eve_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT his_tic_fk FOREIGN KEY (his_ticket_id)
      REFERENCES tickets (tic_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT his_usr_fk FOREIGN KEY (his_user_id)
      REFERENCES users (usr_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE history
  OWNER TO postgres;

-- Index: fki_his_eve_id

-- DROP INDEX fki_his_eve_id;

CREATE INDEX fki_his_eve_id
  ON history
  USING btree
  (his_event_id);

-- Index: fki_his_tic_fk

-- DROP INDEX fki_his_tic_fk;

CREATE INDEX fki_his_tic_fk
  ON history
  USING btree
  (his_ticket_id);

-- Index: fki_his_usr_fk

-- DROP INDEX fki_his_usr_fk;

CREATE INDEX fki_his_usr_fk
  ON history
  USING btree
  (his_user_id);

