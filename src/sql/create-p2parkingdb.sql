DROP SCHEMA IF EXISTS p2parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA p2parkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON p2parkingDB.* TO 'spq'@'localhost';
