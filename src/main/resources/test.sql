CREATE TABLE IF NOT EXISTS Location(
  id INT PRIMARY KEY,
  country VARCHAR2(50),
  region VARCHAR2(50),
  city VARCHAR2(50),
  street VARCHAR2(50),
  house_number VARCHAR2(50),
  zipcode VARCHAR2(50)
);
CREATE TABLE IF NOT EXISTS Employee(
  id INT PRIMARY KEY,
  first_name VARCHAR2(50),
  last_name VARCHAR2(50),
  date_of_birth DATE,
  place_of_birth INT REFERENCES Location(id),
  social_insurance_no VARCHAR2(50),
  mothers_name VARCHAR2(50),
  tax_no VARCHAR2(50),
  drivers_card_no VARCHAR2(50),
  place_of_living INT REFERENCES Location(id),
  employment_date DATE,
  end_of_employment_date DATE
);
DELETE FROM Location;
DELETE FROM Employee;

INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (1,'Hungary','SzSzBM','Nyiregyhaza','Bodrogi','19','4551');
INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (2,'Hungary','SzSzBM','Nyiregyhaza','Filler','62/A','4400');
INSERT INTO Location(id, country, region, city, street, house_number, zipcode)
    VALUES (3,'Hungary','SzSzBM','Nyiregyhaza','Tornacos','42','4551');

INSERT INTO Employee(id, first_name, last_name, date_of_birth, place_of_birth, social_insurance_no, mothers_name, tax_no, drivers_card_no, place_of_living, employment_date, end_of_employment_date)
VALUES (1,'John','Doe',NULL,1,'000','Jane Doe','111','22222',1,NULL,NULL );
