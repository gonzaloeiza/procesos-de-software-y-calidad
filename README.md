COMANDOS
----------------------------------------------------------

1. mvn compile
2. mvn jetty:run 
3. mvn datanucleus:schema-create
4. mvn datanucleus:schema-delete
5. mvn exec:java -PinsertarEjemplos
6. mvn exec:java -Pclient

Creación del usuario y el esquema en el servidor MYSQL

```
DROP SCHEMA IF EXISTS p2parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';
CREATE SCHEMA p2parkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON p2parkingDB.* TO 'spq'@'localhost';
```





