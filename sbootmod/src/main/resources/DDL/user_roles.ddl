-- Table: user_roles

-- DROP TABLE user_roles;

CREATE TABLE user_roles
(
  uro_id serial NOT NULL,
  uro_usr_id integer,
  uro_role character varying(15),
  CONSTRAINT user_roles_pkey PRIMARY KEY (uro_id),
  CONSTRAINT uro_usr_id_fk FOREIGN KEY (uro_usr_id)
      REFERENCES users (usr_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_roles
  OWNER TO postgres;

-- Index: fki_uro_usr_id_fk

-- DROP INDEX fki_uro_usr_id_fk;

CREATE INDEX fki_uro_usr_id_fk
  ON user_roles
  USING btree
  (uro_usr_id);

