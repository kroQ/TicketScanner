-- Table: devices

-- DROP TABLE devices;

CREATE TABLE devices
(
  dev_id serial NOT NULL,
  dev_type character varying(40),
  dev_name character varying(40),
  dev_android_id bigint,
  CONSTRAINT devices_pkey PRIMARY KEY (dev_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE devices
  OWNER TO postgres;
