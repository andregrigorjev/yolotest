CREATE SEQUENCE property_id ;

CREATE TABLE property
( propertyid integer NOT NULL DEFAULT nextval('property_id'),
  type varchar(20),
  rooms numeric(3,0),
  description text,
  CONSTRAINT property_pk PRIMARY KEY (propertyid)
) ;

INSERT INTO PROPERTY (type,rooms,description) VALUES ('korter',3,'Ilus, valguskyllane, remonditud, uued aknad.');
INSERT INTO PROPERTY (type,rooms,description) VALUES ('maja',7,'Kaunis rajoonis suure aiaga armas maja pisikesele perele.');
INSERT INTO PROPERTY (type,rooms,description) VALUES ('krunt',0,'Tallinna lähistel');