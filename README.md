COMANDOS
----------------------------------------------------------

1. mvn compile
2. mvn test
3. mvn datanucleus:enhance
4. mvn datanucleus:schema-create
5. mvn jetty:run
6. mvn exec:java -PinsertarEjemplos
7. mvn exec:java -Pclient
8. mvn datanucleus:schema-delete


Creación del usuario y el esquema en el servidor MYSQL

```
DROP SCHEMA IF EXISTS p2parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';
CREATE SCHEMA p2parkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON p2parkingDB.* TO 'spq'@'localhost';
```





