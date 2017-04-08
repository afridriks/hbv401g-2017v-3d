PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;

DROP TABLE if exists Trip;
DROP TABLE if exists Booking;
DROP TABLE if exists TourCompany;
DROP TABLE if exists Customer;
DROP TABLE if exists Location;
DROP TABLE if exists Type;
DROP TABLE if exists Area;

CREATE TABLE TourCompany (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

INSERT INTO "TourCompany" VALUES(1,'Hallóferðir',236346,'Sæmnundargata 25','asdf@adsf.com');
INSERT INTO "TourCompany" VALUES(2,'Bæjóferðir',2364364346,'Suðurgata 125','asdf3546@adsf.com');
INSERT INTO "TourCompany" VALUES(3,'Háskólaferðir',23631111146,'Hjarðarhagi 625','asdf5743s@adsf.com');

CREATE TABLE Area (
  id int PRIMARY KEY,
  name varchar(50)
);

INSERT INTO "Area" VALUES(1,"Capital area");
INSERT INTO "Area" VALUES(2,"Eastern region");
INSERT INTO "Area" VALUES(3,"Western region");
INSERT INTO "Area" VALUES(4,"Northern region");
INSERT INTO "Area" VALUES(5,"Southern region");
INSERT INTO "Area" VALUES(6,"Highlands of Iceland");


CREATE TABLE Location (
  id INTEGER PRIMARY KEY,
  areaId int REFERENCES Area(id),
  name varchar(50)
);

INSERT INTO Location VALUES(1,5,"Selfoss");

CREATE TABLE Type (
  id INTEGER PRIMARY KEY,
  name varchar(50)
);

INSERT INTO Type VALUES(1,"Golden Circle");
INSERT INTO Type VALUES(2,"Horse Trips");
INSERT INTO Type VALUES(3,"Volcano");
INSERT INTO Type VALUES(4,"Glaciers");
INSERT INTO Type VALUES(5,"Beer Trips");
INSERT INTO Type VALUES(6,"Food Trips");

CREATE TABLE Trip (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  date DATE,
  startTime TIME,
  endTime TIME,
  description varchar(200),
  familyFriendly int,
  accessible int,
  price int,
  typeId int REFERENCES Type(id),
  locationId int REFERENCES Location(id),
  maxTravelers int,
  availablePlaces int,
  tourCompanyId int REFERENCES TourCompany(id)
);

INSERT INTO "Trip" VALUES(1,'Hestaferðin','2017-06-22','10:00','13:00','Skemmtileg hestaferð',0,0,15000,2,1,10,10,1);
INSERT INTO "Trip" VALUES(2,'Bjórferðin','2017-06-22','11:00','14:00','Skemmtileg bjórferð',0,0,25000,5,1,12,12,2);
INSERT INTO "Trip" VALUES(3,'Eldfjallaferðin','2017-06-22','12:00','15:00','Skemmtileg eldfjallaferð',0,0,29990,3,1,5,5,3);
INSERT INTO "Trip" VALUES(4,'Jöklaferðin','2017-06-22','13:00','16:00','Skemmtileg jöklferð',0,0,19990,4,1,10,10,1);
INSERT INTO "Trip" VALUES(5,'Matarferðin','2017-06-22','14:00','17:00','Skemmtileg matarferð',0,0,10000,6,1,15,15,2);
INSERT INTO "Trip" VALUES(6,'Gullni Hringurinn','2017-06-22','15:00','18:00','Skemmtileg fjölskylduferð',1,0,35000,1,1,20,20,3);

CREATE TABLE Customer (
  id INTEGER PRIMARY KEY,
  name varchar(50),
  phone int,
  address varchar(50),
  email varchar(50)
);

CREATE TABLE Booking (
  id INTEGER PRIMARY KEY,
  customerId int REFERENCES Customer(id),
  tripId int REFERENCES Trip(id),
  numTravelers int,
  hotelPickup int,
  active int
);

COMMIT;
