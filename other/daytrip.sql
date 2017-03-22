PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;

DROP TABLE if exists Trip;
DROP TABLE if exists Booking;
DROP TABLE if exists TourCompany;
DROP TABLE if exists Customer;
DROP TABLE if exists Area;
DROP TABLE if exists Location;
DROP TABLE if exists Type;

CREATE TABLE TourCompany (
  id int PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

INSERT INTO "TourCompany" VALUES(1,'Hallóferðir',236346,'Sæmnundargata 25',asdf@adsf.com);
INSERT INTO "TourCompany" VALUES(2,'Bæjóferðir',2364364346,'Suðurgata 125',asdf3546@adsf.com);
INSERT INTO "TourCompany" VALUES(3,'Háskólaferðir',23631111146,'Hjarðarhagi 625',asdf5743s@adsf.com);

CREATE TABLE Area (
  id int PRIMARY KEY,
  name varchar(50)
);

CREATE TABLE Location (
  id int PRIMARY KEY,
  areaId REFERENCES Area.id,
  name varchar(50)
);

CREATE TABLE Type (
  id int PRIMARY KEY,
  name varchar(50)
);

CREATE TABLE Trip (
  id int PRIMARY KEY,
  name varchar(50),
  date DATE,
  startTime TIME, 
  endTime TIME,
  description varchar(200),
  familyFriendly int,
  accessible int,
  price int,
  typeId REFERENCES Type.id,
  locationId REFERENCES Location.id,
  maxTravelers int,
  availablePlaces int,
  tourCompanyId REFERENCES TourCompany.id
);

INSERT INTO "Trip" VALUES(1,'Hestaferðin','2017-06-22','10:00','13:00','Skemmtileg hestaferð',0,0,15000,'Hestar','Suðurland','Selfoss',10,10,1);
INSERT INTO "Trip" VALUES(2,'Hestaferðin','2017-06-22','10:00','13:00','Skemmtileg hestaferð',0,0,15000,'Hestar','Suðurland','Selfoss',10,10,1);

CREATE TABLE Customer (
  id int PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

CREATE TABLE Booking (
  id int PRIMARY KEY,
  customerId REFERENCES Customer.id,
  tripId REFERENCES Trip.id,
  numTravelers int,
  hotelPickup int,
  active int
);

COMMIT;
