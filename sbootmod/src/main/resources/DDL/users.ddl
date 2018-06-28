-- Table: users

-- DROP TABLE users;

CREATE TABLE users
(
  usr_id serial NOT NULL,
  usr_name character varying(20),
  usr_surname character varying(30),
  usr_login character varying(20), -- Max 20
  usr_email character varying(30),
  usr_password character varying(61),
  usr_device_id integer,
  CONSTRAINT users_pkey PRIMARY KEY (usr_id),
  CONSTRAINT usr_dev_fk FOREIGN KEY (usr_device_id)
      REFERENCES devices (dev_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;
COMMENT ON COLUMN users.usr_login IS 'Max 20';


-- Index: fki_usr_dev_fk

-- DROP INDEX fki_usr_dev_fk;

CREATE INDEX fki_usr_dev_fk
  ON users
  USING btree
  (usr_device_id);

