DROP DATABASE IF EXISTS grn;

CREATE DATABASE grn DEFAULT CHARACTER SET 'utf8';

USE grn;

CREATE TABLE person_grn
(
  person_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 surName TEXT,
 givenName TEXT,
 patronymic TEXT,
 dateOfBirth DATE,
 passportSeria TEXT,
 passportNumber TEXT,
 passportDateIssue DATE,
 passportDateExpire DATE,
 postalCode TEXT,
 oblast TEXT,
city TEXT,
 street TEXT,
 numberOfBuilding INT,
 literaOfBuilding TEXT,
 numberOfApartament INT,
 literaOfApartament TEXT
  );
