CREATE TABLE IF NOT EXISTS Location(
  id INT PRIMARY KEY,
  country VARCHAR2(50),
  region VARCHAR2(50),
  city VARCHAR2(50),
  street VARCHAR2(50),
  house_number VARCHAR2(50),
  zipcode VARCHAR2(50),
);

DELETE FROM Location;

INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (1,'Hungary','SzSzBM','Nyiregyhaza','Bodrogi','19','4551');
INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (2,'Hungary','SzSzBM','Nyiregyhaza','Filler','62/A','4400');
INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (3,'Hungary','SzSzBM','Nyiregyhaza','Tornacos','42','4551');